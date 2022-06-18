package kr.cat.exception;

public class IdPasswordNotMatchingException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdPasswordNotMatchingException(String message) {
		super(message);
	}
}
