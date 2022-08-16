package hrwjr.medicare;

public class Admin extends User {

    public Admin() {
        super.userType = "admin";
    }

    @Override
    public void setPassword (String password) {
        if (password != null && password.length() == 8) {
            super.password = password;
        }
    }

}