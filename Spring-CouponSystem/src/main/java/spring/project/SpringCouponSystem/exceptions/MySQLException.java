package spring.project.SpringCouponSystem.exceptions;

public class MySQLException extends Exception {
private String source;
	
	public MySQLException(String message, String source) {
		super(message);
		this.source = source;
	}

	public String getSource() {
		return source;
	}
}
