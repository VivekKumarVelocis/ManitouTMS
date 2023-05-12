package com.manitou.dispatch.entity;
 

public class ResponseModel {

	private int status;
	private String message;
	private Object data;
	
	private ResponseModel(int status,String message,Object data) {
		this.status=status;
		this.message=message;
		this.data=data;
	}
	

	public static ResponseModel ok() {
		return new ResponseModel(200,null,null);
	}
	public static ResponseModel ok(Object data) {
		return new ResponseModel(200,null,data);
	}
	public static ResponseModel ok(String msg) {
		return new ResponseModel(200,msg,null);
	}
	
	public static ResponseModel error() {
		return new ResponseModel(500,null,null);
	}
	public static ResponseModel error(Exception ex) {
		return new ResponseModel(500,ex.getMessage(),ex);
	}
	public static ResponseModel error(int status , String msg) {
		return new ResponseModel(status,msg,null);
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
