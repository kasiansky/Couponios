package spring.project.SpringCouponSystem.entities;

public class LoggedUser {
	
	private int id;
	private String name, password;
	private ClientType type;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoggedUser(int id, String name, String password, ClientType type) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
	}
	@Override
	public String toString() {
		return "LoggedUser [id=" + id + ", name=" + name + ", password=" + password + ", type=" + type + "]";
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the type
	 */
	public ClientType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(ClientType type) {
		this.type = type;
	}
	
	
}
