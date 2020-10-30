package sakila.vo;

public class Customer {
	private int id;
	private String name;
	private String phone;
	private String notes;
	private String returnData;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getReturnData() {
		return returnData;
	}
	public void setReturnData(String returnData) {
		this.returnData = returnData;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", notes=" + notes + ", returnData="
				+ returnData + "]";
	}
	
}
