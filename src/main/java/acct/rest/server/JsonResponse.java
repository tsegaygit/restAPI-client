package acct.rest.server;

import java.io.Serializable;

public class JsonResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int status;
	private Object model;
	private String[] messages;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getModel() {
		return model;
	}

	public void setModel(Object model) {
		this.model = model;
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}

}
