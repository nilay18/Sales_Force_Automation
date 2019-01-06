package vo;

import java.io.Serializable;

public class categoryVO implements Serializable {
	
	private int id;
	private String catname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	
}
	
