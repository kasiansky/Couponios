package spring.project.SpringCouponSystem.exceptions;

public class UniqueValueException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorValue;
	private String message;
	public UniqueValueException(String errorValue, String message) {
		
		this.errorValue = errorValue;
		this.message = message;
	}

	

}
