package com.lichkin.framework.wechat.utils;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.springboot.utils.LKPropertiesUtils;
import com.lichkin.framework.wechat.statics.LKWechatConfigStatics;
import com.lichkin.framework.wechat.vo.TemplateMsg;

/**
 * 模板消息创建工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKWechatTemplateMsgCreater {

	/**
	 * 创建模板消息
	 * @param openid 接收人openid
	 * @param configKey 配置键，需按照规则在配置文件中配置先关信息。
	 *
	 *            <pre>
	wechat.msg.configKey.url=/xxx/yyy.html
	wechat.msg.configKey.templateId=1234567890
	 *            </pre>
	 *
	 * @param templateDatas 模板内容数据
	 * @return 消息
	 */
	public static TemplateMsg createMeasureResultMsg(final String openid, final String configKey, final LKDatas templateDatas) {
		final String templateId = LKPropertiesUtils.getProperty("lichkin.framework.wechat.msg." + configKey + ".url");
		if (templateId == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.msg." + configKey + ".url is null.");
		}

		final String msgUrl = LKPropertiesUtils.getProperty("lichkin.framework.wechat.msg." + configKey + ".templateId");
		if (msgUrl == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.msg." + configKey + ".templateId is null.");
		}

		final TemplateMsg msg = new TemplateMsg();
		msg.setTouser(openid);
		msg.setTemplate_id(templateId);
		msg.setUrl(LKWechatConfigStatics.projectUrl + msgUrl);
		msg.setData(templateDatas);
		return msg;
	}

}
