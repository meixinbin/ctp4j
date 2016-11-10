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


/**
 * 
 * @author <a href="http://www.itqy8.com">meixinbin</a> 2015-5-9 上午10:25:57
 * @since 2.0
 * @version $Id: AjaxDataResponse.java 2427 2015-05-10 23:26:24Z meixinbin $
 */
public class AjaxDataResponse<T> extends AjaxResponse{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6630271023477733359L;

	/**ajax 请求对象数据*/
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
