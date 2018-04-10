package pojo;

public class Enterprise {
	private Integer ent_id;
	private String ent_acount;
	private String ent_password;
	private Integer admin_id;
	private Integer state;

	public Integer getEnt_id() {
		return ent_id;
	}

	public void setEnt_id(Integer ent_id) {
		this.ent_id = ent_id;
	}

	public String getEnt_acount() {
		return ent_acount;
	}

	public void setEnt_acount(String ent_acount) {
		this.ent_acount = ent_acount;
	}

	public String getEnt_password() {
		return ent_password;
	}

	public void setEnt_password(String ent_password) {
		this.ent_password = ent_password;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
