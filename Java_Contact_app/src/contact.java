
public class contact {

	private Integer cid;
	private String fname;
	private String lname;
	private String groupc;
	private String phone;
	private String email;
	private String address;
	private int uid;
	
	public  contact() {}
	
	public contact(Integer cid, String fname, String lname, String groupc, String phone, String email,String address, int uid) {
		super();
		this.cid = cid;
		this.fname = fname;
		this.lname = lname;
		this.groupc = groupc;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.uid = uid;
	}

	
	public int getCid() {
		return cid;
	}

	
	public void setCid(int cid) {
		this.cid = cid;
	}

	
	public String getFname() {
		return fname;
	}

	
	public void setFname(String fname) {
		this.fname = fname;
	}

	
	public String getLname() {
		return lname;
	}

	
	public void setLname(String lname) {
		this.lname = lname;
	}

	
	public String getGroupc() {
		return groupc;
	}

	
	public void setGroupc(String groupc) {
		this.groupc = groupc;
	}

	
	public String getPhone() {
		return phone;
	}

	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getAddress() {
		return address;
	}

	
	public void setAddress(String address) {
		this.address = address;
	}

	
	public int getUid() {
		return uid;
	}

	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	
	
}
