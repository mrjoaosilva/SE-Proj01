package pt.tecnico.sise.se.insure.domain.exception;

public class NIFAlreadyInUseException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public NIFAlreadyInUseException(String message){
		super(message);
	}

}
