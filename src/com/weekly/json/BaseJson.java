package com.weekly.json;

import java.util.Map;

public class BaseJson {
	private Number code;
	private String msg;
	public Number getCode() {
		return code;
	}
	public void setCode(Number code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void set(Map<String, Object> statusOk) {
		this.code = (Number) statusOk.get("code");
		this.msg = (String) statusOk.get("msg");
	}
}
