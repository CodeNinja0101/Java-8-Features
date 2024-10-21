package annotations.repeting_annotations;

public class UserService {

    @Log("Login Attempt")
    @Log("Authorization Check")
    public void loginUser(String username) {
        System.out.println("User " + username + " logged in.");
    }
}
