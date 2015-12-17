package acct.rest.server;

import java.io.Serializable;

public class ResponseModelState implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Message;
	
	private ModelStateDictionary ModelState;

	public ModelStateDictionary getModelState() {
		return ModelState;
	}

	public void setModelState(ModelStateDictionary modelState) {
		ModelState = modelState;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	
}
