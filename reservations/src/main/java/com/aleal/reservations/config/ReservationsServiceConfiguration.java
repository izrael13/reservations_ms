package com.aleal.reservations.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "reservations")
public class ReservationsServiceConfiguration {
	private String msg;
	private String buildVersion;
	private Map<String,String> mailDetails;
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
		return "HotelsServiceConfiguration [msg=" + msg + ", buildVersion=" + buildVersion + ", mailDetails="
				+ mailDetails + "]";
	}
}
