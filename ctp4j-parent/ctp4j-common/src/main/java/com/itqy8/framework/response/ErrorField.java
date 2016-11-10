package com.itqy8.framework.response;

import java.io.Serializable;

public class ErrorField implements Serializable{

	private static final long serialVersionUID = 787100815491093371L;

	/**字段名称*/
	private String name;
	
	/**错误消息*/
	private String errorMsg;

	public String getName() {
		return name;
	}


	public String getErrorMsg() {
		return errorMsg;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((errorMsg == null) ? 0 : errorMsg.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorField other = (ErrorField) obj;
		if (errorMsg == null) {
			if (other.errorMsg != null)
				return false;
		} else if (!errorMsg.equals(other.errorMsg))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
