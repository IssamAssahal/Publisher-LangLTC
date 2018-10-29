package pl.com.lang.support.exception;

/**
 * <b>API Error Message</b><br>
 */
public class ErrorMessage {
	private Integer code;
	private String status;
	private String message;

	public ErrorMessage() {

	}

	public ErrorMessage(Integer code, String status, String message) {
		this.code = code;
		this.status = status;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
