package hebbar.brs.entities;

import hebbar.brs.models.UserModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users", catalog = "brs")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_pk_sequence")
	@SequenceGenerator(sequenceName = "users_id_seq", name = "user_pk_sequence", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false, updatable = false)
	private Long id;

	@Column(name = "\"emailId\"", unique = true)
	private String email;

	@Column(name = "\"firstName\"")
	private String firstName;

	@Column(name = "\"lastName\"")
	private String lastName;

	@Column(name = "\"password\"")
	private String password;

	@Column(name = "\"mobile\"", unique = true)
	private String mobileNumber;

	@Column(name = "\"role\"")
	private Long role;

	public User() {
		super();
	}

	public User(User user) {
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.id = user.getId();
		this.mobileNumber = user.getMobileNumber();
		this.password = user.getPassword();
		this.role = user.getRole();
	}
	public User(UserModel userModel) {
		this.firstName = userModel.getFirstName();
		this.lastName = userModel.getLastName();
		this.mobileNumber = userModel.getMobile();
		this.email = userModel.getEmail();
		this.role = userModel.getRole();
		this.password = userModel.getPassword();
	}
	public Long getId() {
		return id;
	}

	public User setId(Long id) {
		this.id = id;
		return this;
	}

	public String getEmail() {
		return this.email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return this.lastName;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public User setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	public Long getRole() {
		return this.role;
	}

	public String getPassword() {
		return this.password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public User setRole(Long role) {
		this.role = role;
		return this;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", roles=" + ", mobileNumber=" + mobileNumber + "]";
	}
}
