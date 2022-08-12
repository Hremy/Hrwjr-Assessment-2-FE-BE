package hrwjr.medicare;


public abstract class User {

    String userType;
    String username;
    String password;

    String email;
    String firstName;
    String lastName;
    String gender;
    String country;


    //getters

    public String getUserType() {
        return userType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }


    //setters
    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String country) {
        this.country = country;
    }

    public void setCountry(String gender) {
        this.gender = gender;
    }


    // API LOGIN
    public String login(String username, String password) {

        if (DataStore.getPersistentStore().containsKey(username)) {

            User user = DataStore.getPersistentStore().get(username);

            if (user.getPassword().equals(password)) {
                return "true";
            } else {
                return "Password Doesn't Match";
            }

        } else {
            return "Username Not Found";
        }
    }

    // API REGISTER
    public String register(String email, String password, String reTypePassword, String firstName, String lastName, String gender, String country , String userType) {

        if (DataStore.getPersistentStore().containsKey(email)) {
            return "Username Taken";
        }

        if (password.equals(reTypePassword)) {

            // can be replaced with "switch case"

            if (userType.equals("admin")) {

                Admin admin = new Admin();

                admin.setUsername(email);
                admin.setEmail(email);
                admin.setPassword(password);
                admin.setFirstName(firstName);
                admin.setLastName(lastName);
                admin.setGender(gender);
                admin.setCountry(country);
                admin.setUserType(userType);

                DataStore.getPersistentStore().put(admin.getUsername(), admin);

                return "true";

            } else if (userType.equals("patient")) {

                Patient patient = new Patient();

                patient.setUsername(email);
                patient.setEmail(email);
                patient.setPassword(password);
                patient.setFirstName(firstName);
                patient.setLastName(lastName);
                patient.setGender(gender);
                patient.setCountry(country);
                patient.setUserType(userType);

                DataStore.getPersistentStore().put(patient.getUsername(), patient);

                return "true";

            } else if (userType.equals("physician")) {

                Physician physician = new Physician();

                physician.setUsername(email);
                physician.setEmail(email);
                physician.setPassword(password);
                physician.setFirstName(firstName);
                physician.setLastName(lastName);
                physician.setGender(gender);
                physician.setCountry(country);
                physician.setUserType(userType);

                DataStore.getPersistentStore().put(physician.getUsername(), physician);

                return "true";

            } else if (userType.equals("pharmacist")) {

                Pharmacist pharmacist = new Pharmacist();

                pharmacist.setUsername(email);
                pharmacist.setEmail(email);
                pharmacist.setPassword(password);
                pharmacist.setFirstName(firstName);
                pharmacist.setLastName(lastName);
                pharmacist.setGender(gender);
                pharmacist.setCountry(country);
                pharmacist.setUserType(userType);

                DataStore.getPersistentStore().put(pharmacist.getUsername(), pharmacist);

                return "true";

            } else {
                return "User Not Supported";
            }

        } else {
            return "Password doesn't match";
        }

    }

}