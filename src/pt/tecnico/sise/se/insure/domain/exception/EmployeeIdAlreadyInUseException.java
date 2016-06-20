
package pt.tecnico.sise.se.insure.domain.exception;
public class EmployeeIdAlreadyInUseException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EmployeeIdAlreadyInUseException(String message){
		super(message);
	}

}