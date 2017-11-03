package dreamstarter.com.dreamstarter.defaultDataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dreamstarter.com.dreamstarter.model.User;

/**
 * Created by q on 5/25/17.
 */

public class DefaultUserDataProvider {

    public static List<User> defaultUserList;
    public static Map<String, User> defaultUserMap;




    static {

        /**
         *  Adding a Users
         */
        defaultUserList = new ArrayList<>();
        defaultUserMap = new HashMap<>();

        addUser(new User(null, "Gregory", "Goraj", "greg@gmail.com", "greg", "greg.jpg"));
        addUser(new User(null, "Peter", "Wieconkowski", "peter@gmail.com", "peter", "peter.jpeg"));
        addUser(new User(null, "Lucia", "Bodega", "lucia@gmail.com", "lucia", "lucia.jpeg"));
        addUser(new User(null, "Herman", "Zimmerman", "herman@gmail.com", "herman", "herman.jpeg"));
        addUser(new User(null, "Kasia", "Shultz", "kasia@gmail.com", "kasia", "kasia.jpeg"));
        addUser(new User(null, "Lars", "Hojer", "lars@gmail.com", "lars", "Lars.jpeg"));
    }

    private static void addUser(User user){
        defaultUserList.add(user);
        defaultUserMap.put(user.getUserId(), user);
    }
}
