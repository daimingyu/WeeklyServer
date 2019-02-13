package com.weekly.bean;

public class Weekly {
	String weeklyId;
	String weeklyName;
	String workContent;
	String solveProblems;
	String summingUpExperience;
	String remainingProblems;
	String nextWeekPlan;
	String userId;
	public Weekly(String weeklyId, String weeklyName, String workContent, String solveProblems,
			String summingUpExperience, String remainingProblems, String nextWeekPlan, String userId) {
		super();
		this.weeklyId = weeklyId;
		this.weeklyName = weeklyName;
		this.workContent = workContent;
		this.solveProblems = solveProblems;
		this.summingUpExperience = summingUpExperience;
		this.remainingProblems = remainingProblems;
		this.nextWeekPlan = nextWeekPlan;
		this.userId = userId;
	}
	public String getNextWeekPlan() {
		return nextWeekPlan;
	}
	public void setNextWeekPlan(String nextWeekPlan) {
		this.nextWeekPlan = nextWeekPlan;
	}
	public String getWeeklyId() {
		return weeklyId;
	}
	public void setWeeklyId(String weeklyId) {
		this.weeklyId = weeklyId;
	}
	public String getWeeklyName() {
		return weeklyName;
	}
	public void setWeeklyName(String weeklyName) {
		this.weeklyName = weeklyName;
	}
	public String getWorkContent() {
		return workContent;
	}
	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}
	public String getSolveProblems() {
		return solveProblems;
	}
	public void setSolveProblems(String solveProblems) {
		this.solveProblems = solveProblems;
	}
	public String getSummingUpExperience() {
		return summingUpExperience;
	}
	public void setSummingUpExperience(String summingUpExperience) {
		this.summingUpExperience = summingUpExperience;
	}
	public String getRemainingProblems() {
		return remainingProblems;
	}
	public void setRemainingProblems(String remainingProblems) {
		this.remainingProblems = remainingProblems;
	}
	public Weekly() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.weeklyId + "-" +  this.weeklyName + "-" + this.workContent + "-" + this.solveProblems + "-" + this.summingUpExperience + "-" + this.remainingProblems + "-" + this.nextWeekPlan + "-" + this.userId;
	}
}
