package hrwjr.medicare;

public class Patient extends User {

    public Patient() {
        this.userType = "patient";
    }
    @Override
    public void setPassword (String password){
        if (password != null && password.length() == 7) {
            this.password = password;
        }
    }

}
