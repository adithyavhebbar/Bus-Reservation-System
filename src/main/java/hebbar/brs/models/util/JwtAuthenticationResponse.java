package hebbar.brs.models.util;

public class JwtAuthenticationResponse {
	private String jwtToken;

	public JwtAuthenticationResponse() {
	}

	public JwtAuthenticationResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

}
