/* ============================================================
 * http://www.itqy8.com
 * ============================================================
 * Copyright 2012 www.itqy8.com , meixinbin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============================================================ */
package com.itqy8.framework.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ajax 请求响应
 * @author meixinbin 2015-5-9 上午10:15:51
 * @since 2.0
 * @version $Id: AjaxResponse.java 2427 2015-05-10 23:26:24Z meixinbin $
 */
public class AjaxResponse implements Serializable{

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8315131032675802582L;

	/**引用页面*/
	private String referer="";
	
	/**是否需要刷新页面*/
	private boolean refresh=false;
	
	/**状态*/
	private ResponseState state=ResponseState.fail;
	
	/**HTML文本*/
	private String html="";
	
	/**消息数组*/
	private List<String> message=new ArrayList<String>();

	/**系统异常*/
	private String error="";
	
	/**错误字段*/
	private List<ErrorField> errorFields=new ArrayList<ErrorField>();
	
	/**
	 * 添加错误字段
	 * @param name
	 * @param errorMsg
	 */
	public void addErrorField(String name,String errorMsg){
		if(errorFields==null){
			errorFields = new ArrayList<ErrorField>();
		}
		ErrorField error = new ErrorField();
		error.setName(name);
		error.setErrorMsg(errorMsg);
		if(!errorFields.contains(error)){
			errorFields.add(error);
		}
	}
	public void addMsg(String msg){
		if(message==null){
			message = new ArrayList<String>();
		}
		if(!message.contains(msg)){
			message.add(msg);
		}
	}
	public String getReferer() {
		return referer;
	}

	public boolean isRefresh() {
		return refresh;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public void setRefresh(boolean refresh) {
		this.refresh = refresh;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	public ResponseState getState() {
		return state;
	}
	public void setState(ResponseState state) {
		this.state = state;
	}
	public List<ErrorField> getErrorFields() {
		return errorFields;
	}
	public void setErrorFields(List<ErrorField> errorFields) {
		this.errorFields = errorFields;
	}
	
	
}
