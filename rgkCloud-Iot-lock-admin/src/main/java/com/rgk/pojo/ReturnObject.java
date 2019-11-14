package com.rgk.pojo;

/**
 * 统一响应结果 格式
 */
public class ReturnObject {
	private int code = 1; // 编码
	private String message = "success"; // 提示消息
	private Object result; // 数据
	private long timestamp;
	
	public ReturnObject() {
		super();
	}

	public ReturnObject(int code, Object result, String message) {
		super();
		this.code = code;
		this.message = message;
		this.result = result;
	}
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ReturnObject [code=" + code + ", message=" + message + ", result=" + result + ", timestamp=" + timestamp
				+ "]";
	}
}
