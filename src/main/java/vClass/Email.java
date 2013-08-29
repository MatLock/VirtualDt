package vClass;

public class Email {

	private String subject;
	private String to;
	private String from;
	private String body;
	
	
	public Email(String subject, String to, String from, String body) {
		super();
		this.subject = subject;
		this.to = to;
		this.from = from;
		this.body = body;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	
}
