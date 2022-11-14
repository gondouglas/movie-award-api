package gondouglas.movieaward.exceptions;

public class BusinessRuntimeException extends RuntimeException {
	
	public BusinessRuntimeException(Throwable e) {
		super(e);
	}
	
	public BusinessRuntimeException(String e) {
		super(e);
	}
}
