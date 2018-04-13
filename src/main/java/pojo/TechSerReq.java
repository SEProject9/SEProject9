package pojo;

public class TechSerReq {
	private Integer req_id;
	private Integer ent_id;// 似乎需要加上对应企业名字好前端list的显示
	private Integer ind_id;
	private String req_date;
	private String req_title;
	private String req_text;
	private Integer state;

	public Integer getReq_id() {
		return req_id;
	}

	public void setReq_id(Integer req_id) {
		this.req_id = req_id;
	}

	public Integer getEnt_id() {
		return ent_id;
	}

	public void setEnt_id(Integer ent_id) {
		this.ent_id = ent_id;
	}

	public Integer getInd_id() {
		return ind_id;
	}

	public void setInd_id(Integer ind_id) {
		this.ind_id = ind_id;
	}

	public String getReq_date() {
		return req_date;
	}

	public void setReq_date(String req_date) {
		this.req_date = req_date;
	}

	public String getReq_title() {
		return req_title;
	}

	public void setReq_title(String req_title) {
		this.req_title = req_title;
	}

	public String getReq_text() {
		return req_text;
	}

	public void setReq_text(String req_text) {
		this.req_text = req_text;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
