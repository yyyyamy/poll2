package com.briup.apps.poll.util;


public class MsgRespose {
private Integer stauts;
private String message;
private Object data;
public MsgRespose(){}
public static MsgRespose success(String message,Object data){
	MsgRespose response =new MsgRespose();
	response.setStauts(200);
	response.setMessage(message);
	response.setData(data);
	return response;	
}
public static MsgRespose error(String message){
	MsgRespose response =new MsgRespose();
	response.setStauts(500);
	response.setMessage(message);
	response.setData(null);
	return response;	
}
public Integer getStauts() {
	return stauts;
}
public void setStauts(Integer stauts) {
	this.stauts = stauts;
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
