package com.itrjp.common.result;

import com.itrjp.common.constant.CodeMsg;

/**
 *  返回结果bean
 * @param <T>
 */
public class Result<T> {
	
	private int code;
	private String msg;
	private T data;
	
	/**
	 *  成功时候的调用
	 * */
	public static  <T> Result<T> success(T data){

		return new Result<T>(data, CodeMsg.SUCCESS);
	}
	
	/**
	 *  失败时候的调用
	 * */
	public static  <T> Result<T> error(CodeMsg codeMsg){
		return new Result<T>(codeMsg);
	}
	public static <T> Result<T> error(String msg){
		return new Result<T>(0,msg);
	}
	
	private Result(T data) {
		this.data = data;
	}
	private Result(T data,CodeMsg codeMsg){
		this.data = data;
		this.code = codeMsg.getCode();
		this.msg = codeMsg.getMsg();
	}
	private Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	private Result(CodeMsg codeMsg) {
		if(codeMsg != null) {
			this.code = codeMsg.getCode();
			this.msg = codeMsg.getMsg();
		}
	}
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				", data=" + data +
				'}';
	}
}
