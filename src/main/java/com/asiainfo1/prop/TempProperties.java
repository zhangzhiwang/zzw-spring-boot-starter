package com.asiainfo1.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "zzw")// 在编辑器里面配置的时候要想有提示，必须在本工程的classpath:META-INF下面创建一个名称为“additional-spring-configuration-metadata.json”的文件，以json的方式把属性配置进去
public class TempProperties {
	private int uid;
	private String userName;
	private boolean isMale;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
}
