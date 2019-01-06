package vo;

public class loginVO {

	private String uname,pass,sec_ques,sec_ans,rights;
	private String suppliername;
	private String emailid;
	
	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getSuppliername() {
		return suppliername;
	}

	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}

	private int userid;

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSec_ques() {
		return sec_ques;
	}

	public void setSec_ques(String sec_ques) {
		this.sec_ques = sec_ques;
	}

	public String getSec_ans() {
		return sec_ans;
	}

	public void setSec_ans(String sec_ans) {
		this.sec_ans = sec_ans;
	}
	
}
