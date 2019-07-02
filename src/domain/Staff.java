package domain;

public class Staff {
	private int workid;
	private String staffpw;
	public Staff(int workid, String staffpw) {
		super();
		this.workid = workid;
		this.staffpw = staffpw;
	}
	public int getWorkid() {
		return workid;
	}
	public void setWorkid(int workid) {
		this.workid = workid;
	}
	public String getStaffpw() {
		return staffpw;
	}
	public void setStaffpw(String staffpw) {
		this.staffpw = staffpw;
	}

	

}
