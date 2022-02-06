package com.data;

import java.io.Serializable;

public class Response  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Response [result=" + result + "]";
	}
	
}
