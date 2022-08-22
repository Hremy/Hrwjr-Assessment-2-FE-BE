package hrwjr.medicare;

public class API {

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

    public static String signUp(String email, String password, String reTypePassword, String firstName, String lastName, String gender, String country , String userType) {

        if (DataStore.getPersistentStore().containsKey(email)) {
            return "Username Taken";
        }

        if (password.equals(reTypePassword)) {
            return "Password doesn't match";
        }

        switch (userType) {

            case "admin" -> {
                Admin admin = new Admin();
                admin.setUsername(email);
                admin.setEmail(email);
                admin.setPassword(password);
                admin.setFirstName(firstName);
                admin.setLastName(lastName);
                admin.setGender(gender);
                admin.setCountry(country);
                admin.setUserType(userType);
                if (admin.hasValidPassword()) {
                    DataStore.getPersistentStore().put(admin.getUsername(), admin);
                } else {
                    return "Password length should be 8 characters";
                }
                return "true";
            }

            case "patient" -> {
                Patient patient = new Patient();
                patient.setUsername(email);
                patient.setEmail(email);
                patient.setPassword(password);
                patient.setFirstName(firstName);
                patient.setLastName(lastName);
                patient.setGender(gender);
                patient.setCountry(country);
                patient.setUserType(userType);
                if (patient.hasValidPassword()) {
                    DataStore.getPersistentStore().put(patient.getUsername(), patient);
                } else {
                    return "Password length should be 7 characters";
                }
                return "true";
            }

            case "physician" -> {
                Physician physician = new Physician();
                physician.setUsername(email);
                physician.setEmail(email);
                physician.setPassword(password);
                physician.setFirstName(firstName);
                physician.setLastName(lastName);
                physician.setGender(gender);
                physician.setCountry(country);
                physician.setUserType(userType);

                if (physician.hasValidPassword()) {
                    DataStore.getPersistentStore().put(physician.getUsername(), physician);
                } else {
                    return "Password length should be 6 characters";
                }

                return "true";
            }
            case "pharmacist" -> {
                Pharmacist pharmacist = new Pharmacist();
                pharmacist.setUsername(email);
                pharmacist.setEmail(email);
                pharmacist.setPassword(password);
                pharmacist.setFirstName(firstName);
                pharmacist.setLastName(lastName);
                pharmacist.setGender(gender);
                pharmacist.setCountry(country);
                pharmacist.setUserType(userType);

                if (pharmacist.hasValidPassword()) {
                    DataStore.getPersistentStore().put(pharmacist.getUsername(), pharmacist);
                } else {
                    return "Password length should be 6 characters";
                }

                return "true";
            }
        }
        return "User Not Supported";
    }

}