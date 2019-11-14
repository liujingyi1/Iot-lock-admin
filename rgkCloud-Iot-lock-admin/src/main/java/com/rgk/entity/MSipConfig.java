package com.rgk.entity;

public class MSipConfig {
    private String domain;  //sip服务器地址
    
    private String user;  //sip账号
    
    private String password;  //sip密码
    
    private String outbund;  //本地pbx地址

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOutbund() {
		return outbund;
	}

	public void setOutbund(String outbund) {
		this.outbund = outbund;
	}
    
    
}
