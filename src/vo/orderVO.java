package vo;

import java.util.Date;


public class orderVO {
	
	private int id,quantity;
	private Double total_cost;
	
	
	private String supplier,shipping,iname,note,rights;
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	private Date expected;
	private Date issue;
	private int userid;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Double getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(Double total_cost) {
		this.total_cost = total_cost;
	}
	public Date getIssue() {
		return issue;
	}
	public void setIssue(Date issue) {
		this.issue = issue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getExpected() {
		return expected;
	}
	public void setExpected(Date expected) {
		this.expected = expected;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	
}
	