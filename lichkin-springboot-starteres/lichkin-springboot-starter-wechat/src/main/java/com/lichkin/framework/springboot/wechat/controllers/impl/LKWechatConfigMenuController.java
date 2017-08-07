package com.lichkin.framework.springboot.wechat.controllers.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.springboot.web.controllers.LKController;
import com.lichkin.framework.springboot.wechat.services.impl.LKWechatConfigMenuService;
import com.lichkin.framework.springframework.entities.sys.wechat.SysWechatMenuEntity;
import com.lichkin.framework.wechat.vo.config.Menu;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 微信菜单配置控制器类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Controller
@RequestMapping(value = "/lichkin/wechat/config")
public final class LKWechatConfigMenuController extends LKController {

	/** 日志记录对象 */
	public final Log LOGGER = LogFactory.getLog(getClass());

	/** 微信Token验证服务类 */
	@Autowired
	private LKWechatConfigMenuService service;


	/**
	 * 跳转到菜单配置页面
	 * @param requestDatas 请求参数
	 */
	@RequestMapping(value = "/menu.html", method = RequestMethod.GET)
	public ModelAndView toConfigMenu(final LKDatas requestDatas) {
		final ModelAndView mav = getModelAndView(requestDatas);
		final List<SysWechatMenuEntity> list = service.findListSysWechatMenu();
		mav.addObject("tdArray", service.getMenu(list).toTDArray());
		return mav;
	}


	/**
	 * 保存菜单
	 * @param requestDatas 请求参数
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/saveMenu.do", method = RequestMethod.POST)
	public void saveMenu(final LKDatas requestDatas) throws Exception {
		final String menuDatas = requestDatas.getString("menuDatas", null);
		final JSONArray tdArray = JSONArray.fromObject(menuDatas);
		final List<SysWechatMenuEntity> list = new ArrayList<>(18);
		for (byte i = (byte) (tdArray.size() - 1); i >= 0; i--) {
			final JSONArray array = tdArray.getJSONArray(i);
			for (byte j = (byte) (array.size() - 1); j >= 0; j--) {
				final JSONObject obj = array.getJSONObject(j);
				if ((obj != null) && !obj.isEmpty()) {
					final SysWechatMenuEntity entity = new SysWechatMenuEntity();
					entity.setX(i);
					entity.setY(j);
					entity.setBtnName(obj.getString("btnName"));
					entity.setBtnType(obj.getString("btnType"));
					list.add(entity);
				}
			}
		}
		final Menu menu = service.saveMenu(list);
		// 发布菜单
		if (requestDatas.getBoolean("flag", false)) {
			final String wechatResult = service.publishMenu(menu);
			LOGGER.warn(wechatResult);
		}
	}

}
