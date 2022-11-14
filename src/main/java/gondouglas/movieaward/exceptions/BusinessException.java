package gondouglas.movieaward.exceptions;

public class BusinessException extends Exception {
	
		
	public BusinessException(Throwable e) {
		super(e);
	}
	
	public BusinessException(String e) {
		super(e);
	}
}
