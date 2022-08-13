package hrwjr.medicare;

public class Pharmacist extends User {

    public Pharmacist() {
        this.userType = "pharmacist";
    }

    @Override
    public void setPassword(String password) {
        if (password != null && password.length() == 6) {
            this.password = password;
        }
    }

}
