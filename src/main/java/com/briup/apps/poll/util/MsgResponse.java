package com.briup.apps.poll.util;

public class MsgResponse {
	private Integer status;// 状态码200成功，500代码异常
	private String message;// 错误成功信息
	private Object data;// 查询到的数据 200:data不能为空 500:数据可以为空 Object是大类型
	// 静态方法，可以通过类名直接调用（成功的返回）(返回一个成功的信息，返回一个数据)

	public static MsgResponse success(String message, Object data) {
		MsgResponse response = new MsgResponse();
		response.setStatus(200);
		response.setMessage(message);
		response.setData(data);
		return response;
	}

	// 出错只用传错误信息，不用穿数据
	public static MsgResponse error(String message) {
		MsgResponse response = new MsgResponse();
		response.setStatus(500);
		response.setMessage(message);
		response.setData(null);
		return response;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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
