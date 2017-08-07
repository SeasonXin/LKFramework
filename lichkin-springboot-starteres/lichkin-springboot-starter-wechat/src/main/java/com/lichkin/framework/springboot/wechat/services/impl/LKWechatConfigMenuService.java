package com.lichkin.framework.springboot.wechat.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lichkin.framework.bases.db.vo.LKSqlVo;
import com.lichkin.framework.http.request.LKRequestUtils;
import com.lichkin.framework.springboot.services.LKDBService;
import com.lichkin.framework.springframework.entities.sys.wechat.SysWechatMenuEntity;
import com.lichkin.framework.utils.lang.json.LKJSONUtils;
import com.lichkin.framework.wechat.LKWechatApiUrls;
import com.lichkin.framework.wechat.vo.config.ClickButton;
import com.lichkin.framework.wechat.vo.config.ListButton;
import com.lichkin.framework.wechat.vo.config.Menu;
import com.lichkin.framework.wechat.vo.config.ViewButton;

/**
 * 微信菜单配置服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class LKWechatConfigMenuService extends LKDBService {

	/** 获得微信access_token服务类 */
	@Autowired
	private LKWechatAccessTokenServie accessTokenServie;


	/**
	 * 获取微信菜单
	 * @param list 微信菜单列表
	 * @return 菜单对象
	 */
	public Menu getMenu(final List<SysWechatMenuEntity> list) {
		// 抽取一级菜单
		final List<SysWechatMenuEntity> firstList = new ArrayList<>(3);
		for (int i = list.size() - 1; i >= 0; i--) {
			final SysWechatMenuEntity entity = list.get(i);
			if (entity.getY() == 0) {
				firstList.add(entity);
				list.remove(i);
			}
		}

		// 创建菜单对象
		final Menu menu = new Menu();
		for (final SysWechatMenuEntity first : firstList) {
			// 抽取二级菜单
			final List<SysWechatMenuEntity> secondList = new ArrayList<>(5);
			for (int i = list.size() - 1; i >= 0; i--) {
				final SysWechatMenuEntity entity = list.get(i);
				if (first.getX() == entity.getX()) {
					secondList.add(entity);
					list.remove(i);
				}
			}

			// 创建按钮对象
			final String btnName = first.getBtnName();
			if (secondList.isEmpty()) {// 没有二级菜单，则判断类型初始化。
				final String btnType = first.getBtnType();
				switch (btnType) {
					case "view":
						menu.addButton(new ViewButton(btnName));
					break;
					case "click":
						menu.addButton(new ClickButton(btnName));
					break;
				}
			} else {// 有二级菜单，则一级菜单为列表类型。
				final ListButton listButton = new ListButton(btnName);
				for (final SysWechatMenuEntity second : secondList) {
					final String btnType = second.getBtnType();
					switch (btnType) {
						case "view":
							listButton.addSubButton(new ViewButton(second.getBtnName()));
						break;
						case "click":
							listButton.addSubButton(new ClickButton(second.getBtnName()));
						break;
					}
				}
				menu.addButton(listButton);
			}
		}
		return menu;
	}


	/**
	 * 保存微信菜单
	 * @param list 微信菜单列表
	 */
	@Transactional
	public Menu saveMenu(final List<SysWechatMenuEntity> list) {
		final List<SysWechatMenuEntity> exist = findListSysWechatMenu();
		dao.remove(exist);
		dao.save(list);
		return getMenu(list);
	}


	/**
	 * 查询微信菜单列表
	 * @return 微信菜单列表
	 */
	public List<SysWechatMenuEntity> findListSysWechatMenu() {
		return dao.findListByHql(new LKSqlVo("from SysWechatMenuEntity order by x desc, y desc"), SysWechatMenuEntity.class);
	}


	/**
	 * 发布微信菜单
	 * @throws Exception
	 */
	public String publishMenu(final Menu menu) throws Exception {
		final String json = LKJSONUtils.toJson(menu, false, false);
		logger.info(json);
		return LKRequestUtils.doRequestStream(LKWechatApiUrls.MENU_CREATE + accessTokenServie.getAccessToken(), json);
	}

}
