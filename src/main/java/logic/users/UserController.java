package logic.users;

import entity.TempUserUnit;

import java.util.ArrayList;
import java.util.List;

final public class UserController {
    private static List<TempUserUnit> userList = new ArrayList<>();

    private boolean checkUser(long userId) {
        return userList.stream().anyMatch(f -> f.getUserId() == userId);
    }

    public void register(long userId) {
        if (checkUser(userId)) {
            userList.add(new TempUserUnit(userId));
        }
    }

    public void delete(long userId) {
        userList.parallelStream().filter(f -> f.getUserId() == userId).forEach(itm -> userList.remove(itm));
    }

    public TempUserUnit find(long userId) {
        return userList.stream().filter(f -> f.getUserId() == userId).findFirst().get();
    }
}