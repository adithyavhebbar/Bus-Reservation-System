package hebbar.brs.DTO;


import hebbar.brs.entities.User;

import java.util.List;

public class UserDto {
    private String status;
    private String description;
    private List<User> userDetails;

    public String getStatus() {
        return status;
    }

    public UserDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UserDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<User> getUserDetails() {
        return userDetails;
    }

    public UserDto setUserDetails(List<User> userDetails) {
        this.userDetails = userDetails;
        return this;
    }
}
