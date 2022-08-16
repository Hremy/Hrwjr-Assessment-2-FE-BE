package hrwjr.medicare;

public class Pharmacist extends User {

    public Pharmacist() {
        super.userType = "pharmacist";
    }

    @Override
    public void setPassword(String password) {
        if (password != null && password.length() == 5) {
            super.password = password;
        }
    }

}
