package com.weekly.json;

public class Json extends BaseJson{
	private Object data;  
	  
    public Json(Object data) {
		super();
		this.data = data;
	}

	public Json() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
