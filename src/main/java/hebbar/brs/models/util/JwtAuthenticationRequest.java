package hebbar.brs.models.util;

public class JwtAuthenticationRequest {
	private String email;
	private String password;

	public JwtAuthenticationRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public JwtAuthenticationRequest() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
