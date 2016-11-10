package com.itqy8.framework.response;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;


/**
 * 服务接口响应,无返回值
 * @author meixinbin
 *
 */
public class VoidResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 198459495354508445L;

	/**是否成功*/
	private boolean success;
	
	/**错误代码*/
	private String errorCode;
	
	/**错误信息*/
	private String errorMsg;
	
	public boolean isSuccess() {
		//如果错误码和错误消息全部为空则就认为成功
		if(StringUtils.isBlank(errorCode) && StringUtils.isBlank(errorMsg)){
			this.success = true;
			return true;
		}
		//如果错误码和错误消息全部不为空，则判断success字段是否为true，如果为true则返回true，否则就返回false
		if(this.success){
			return true;
		}
		return success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
