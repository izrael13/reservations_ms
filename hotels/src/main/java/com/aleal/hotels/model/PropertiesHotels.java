package com.aleal.hotels.model;

import java.util.Map;

public class PropertiesHotels {
	private String msg;
	private String buildVersion;
	private Map<String,String> mailDetails;
	
	public PropertiesHotels(String msg, String buildVersion, Map<String, String> mailDetails) {
		this.msg = msg;
		this.buildVersion = buildVersion;
		this.mailDetails = mailDetails;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getBuildVersion() {
		return buildVersion;
	}
	public void setBuildVersion(String buildVersion) {
		this.buildVersion = buildVersion;
	}
	public Map<String, String> getMailDetails() {
		return mailDetails;
	}
	public void setMailDetails(Map<String, String> mailDetails) {
		this.mailDetails = mailDetails;
	}
	@Override
	public String toString() {
		return "PropertiesHotels [msg=" + msg + ", buildVersion=" + buildVersion + ", mailDetails=" + mailDetails + "]";
	}
	
	
}
