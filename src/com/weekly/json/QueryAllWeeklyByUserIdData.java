package com.weekly.json;

import java.util.List;

import com.weekly.bean.Weekly;

public class QueryAllWeeklyByUserIdData {
	List<Weekly> dataList;
	int count;

	public QueryAllWeeklyByUserIdData(List<Weekly> dataList, int count) {
		super();
		this.dataList = dataList;
		this.count = count;
	}

	public QueryAllWeeklyByUserIdData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Weekly> getDataList() {
		return dataList;
	}

	public void setDataList(List<Weekly> dataList) {
		this.dataList = dataList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
}
