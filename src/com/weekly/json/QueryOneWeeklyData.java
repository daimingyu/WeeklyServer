package com.weekly.json;

import com.weekly.bean.Weekly;

public class QueryOneWeeklyData {
	Weekly weekly;
	public Weekly getWeekly() {
		return weekly;
	}
	public void setWeekly(Weekly weekly) {
		this.weekly = weekly;
	}
	public QueryOneWeeklyData(Weekly weekly) {
		super();
		this.weekly = weekly;
	}
	public QueryOneWeeklyData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
