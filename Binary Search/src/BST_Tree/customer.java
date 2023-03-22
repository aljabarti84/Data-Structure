package BST_Tree;

public class customer {
	/*Private variables*/
	private int id;
	private String name;
	private String phone;
	private String email;
	customer left;
	customer right;
	
	/*customer class constructor*/
	public customer(int id, String name, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.left = null;
		this.right = null;			
	}
	
	/*Setter and getter methods for the fields*/
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
