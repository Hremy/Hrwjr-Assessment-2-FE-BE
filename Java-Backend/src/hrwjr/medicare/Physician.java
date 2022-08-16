package hrwjr.medicare;

public class Physician extends User {

    public Physician() {
        super.userType = "physician";
    }

    @Override
    public void setPassword (String password) {
        if (password != null && password.length() == 6){
            super.password = password;
        }
    }

}
