package com.lichkin.framework.android.volley;

import org.json.JSONException;
import org.json.JSONObject;

import com.lichkin.framework.android.R;
import com.lichkin.framework.android.lang.LKStringUtils;
import com.lichkin.framework.android.utils.LKDialogUtils;
import com.lichkin.framework.android.utils.LKResourceUtils;

import android.content.Context;

/**
 * LichKin标准接口请求成功回调处理类
 */
public class LKVolleyInvokeResponseHandlerImpl implements LKVolleyInvokeResponseHandler {

	@Override
	public void doSuccess(final Context context, final JSONObject response) throws JSONException {
		// 友好提示
		String info = response.getString("info");
		if (LKStringUtils.isNotBlank(info)) {
			if (info.contains("=>")) {
				info = info.split("=>")[1];
			}
			LKDialogUtils.alert(context, info);
		}
	}


	@Override
	public void doError(final Context context, final JSONObject response) throws JSONException {
		// 友好提示
		String info = response.getString("info");
		if (LKStringUtils.isNotBlank(info)) {
			if (info.contains("=>")) {
				info = info.split("=>")[1];
			}
			LKDialogUtils.alert(context, info);
		} else {
			LKDialogUtils.alert(context, LKResourceUtils.getString(R.string.request_server_error));
		}
	}


	@Override
	public void doConnectionError(final Context context) {
		// 友好提示
		LKDialogUtils.alert(context, LKResourceUtils.getString(R.string.request_connection_error));
	}

}
