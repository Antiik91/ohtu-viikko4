package ohtu.authentication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;
import java.util.*;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
        
        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }

        if (username.length()<3 ) {
            status.addError("username should have at least 3 characters");
        }
        HashMap<Boolean, String> validate = invalid(username, password);
        if(validate.containsKey(true)) {
            status.addError(validate.get(true));
        }

        if (status.isOk()) {
            userDao.add(new User(username, password));
        }
        
        return status;
    }
    private HashMap<Boolean, String> invalid(String username, String password) {
        HashMap<Boolean, String> validate = new HashMap<>();
        Pattern p = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        boolean specials = m.find();
        boolean foundDigit = false;
        // validity check of username and password
        if(username.length() < 4 ) {
            validate.put(true, "username should have at least 3 characters");
            return validate;
        }
        if(password.length() < 8) {
            validate.put(true, "password should have at least 8 characters");
            return validate;
        }
        char[] uChars = username.toCharArray();
        char[] pChars = password.toCharArray();
//        for (int i = 0; i < uChars.length; i++) {
//            if(!Character.isLetter(uChars[i])) {
//                //true
//                return validate;
//            }
//        }
        for (int i = 0; i < pChars.length; i++) {
            if(Character.isDigit(pChars[i])) {
                foundDigit = true;
                validate.put(false, "");
                return validate;
            }
        }
        if(!foundDigit) {
            validate.put(true, "password can not contain only letters");
        }
        validate.put(false,"");
        return validate;
    }
}
