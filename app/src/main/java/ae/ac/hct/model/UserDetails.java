package ae.ac.hct.model;

public class UserDetails {

    private String userId;
    private static UserDetails userInfo;

    private UserDetails() {
    }

    public static UserDetails instance() {
        if (userInfo == null)
            userInfo = new UserDetails();
        return userInfo;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
