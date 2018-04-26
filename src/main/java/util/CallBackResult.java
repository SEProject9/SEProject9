package util;

public class CallBackResult {
	private boolean success = false;// 状态
	private String msg;// 消息
	private Object data;// 业务对象
	private String curr;// 当前页
	private String total;// 总页
	private String limit;// 每页条数

	public CallBackResult(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public CallBackResult(boolean success, Object data) {
		this.success = success;
		this.data = data;
	}

	public CallBackResult(String curr, String total, String limit) {
		this.curr = curr;
		this.total = total;
		this.limit = limit;
	}

	public String getcurr() {
		return curr;
	}

	public void setcurr(String curr) {
		this.curr = curr;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getlimit() {
		return limit;
	}

	public void setlimit(String limit) {
		this.limit = limit;
	}

	public CallBackResult() {
		// TODO Auto-generated constructor stub
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getdata() {
		return data;
	}

	public void setdata(Object data) {
		this.data = data;
	}

}
