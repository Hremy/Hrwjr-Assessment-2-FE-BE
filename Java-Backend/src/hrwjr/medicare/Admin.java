package hrwjr.medicare;

public class Admin extends User {

    public Admin() {
        this.userType = "admin";
    }

    @Override
    public void setPassword (String password) {
        if (password != null && password.length() == 8) {
            this.password = password;
        }
    }

}




// behavior specific to sub child
// super