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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    // API LOGIN
    public static String signIn(String username, String password) {

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
    public static String signUp(String email, String password, String reTypePassword, String firstName, String lastName, String gender, String country , String userType) {

        if (DataStore.getPersistentStore().containsKey(email)) {
            return "Username Taken";
        }

        if (!password.equals(reTypePassword)) {
            return "Password doesn't match";
        } else {

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

                if (admin.getPassword() != null) {
                    DataStore.getPersistentStore().put(admin.getUsername(), admin);
                } else {
                    return "Password length should be 8 characters";
                }

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

                if (patient.getPassword() != null) {
                    DataStore.getPersistentStore().put(patient.getUsername(), patient);
                } else {
                    return "Password length should be 7 characters";
                }

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

                if (physician.getPassword() != null) {
                    DataStore.getPersistentStore().put(physician.getUsername(), physician);
                } else {
                    return "Password length should be 6 characters";
                }

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

                if (pharmacist.getPassword() != null) {
                    DataStore.getPersistentStore().put(pharmacist.getUsername(), pharmacist);
                } else {
                    return "Password length should be 6 characters";
                }

                return "true";
            }
            return "User Not Supported";

        }

    }

}