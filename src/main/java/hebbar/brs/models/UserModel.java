package hebbar.brs.models;

public class UserModel {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String mobile;
    private Long role;

    public UserModel() {
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserModel setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Long getRole() {
        return role;
    }

    public UserModel setRole(Long role) {
        this.role = role;
        return this;
    }
}
