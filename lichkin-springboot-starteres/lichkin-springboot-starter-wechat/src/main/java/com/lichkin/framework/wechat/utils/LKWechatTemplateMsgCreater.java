package com.lichkin.framework.wechat.utils;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.springboot.utils.LKPropertiesUtils;
import com.lichkin.framework.wechat.LKWechatConfigKeys;
import com.lichkin.framework.wechat.statics.LKWechatStatics;
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
		final TemplateMsg msg = new TemplateMsg();
		msg.setTouser(openid);
		msg.setTemplate_id(LKPropertiesUtils.getProperty(LKWechatConfigKeys.CONFIG_WECHAT_MSG_PREFIX + configKey + LKWechatConfigKeys.CONFIG_WECHAT_MSG_SUFFIX_URL));
		msg.setUrl(LKWechatStatics.PROJECT_URL + LKPropertiesUtils.getProperty(LKWechatConfigKeys.CONFIG_WECHAT_MSG_PREFIX + configKey + LKWechatConfigKeys.CONFIG_WECHAT_MSG_SUFFIX_TEMPLATE_ID));
		msg.setData(templateDatas);
		return msg;
	}

}
