package hrwjr.medicare;

import java.util.HashMap;

public class DataStore {

    private static HashMap<String,User> persistentStore;

    public static HashMap<String,User> getPersistentStore() {
        if(persistentStore == null){
            persistentStore = new HashMap<>();
        }
        return persistentStore;
    }

}
