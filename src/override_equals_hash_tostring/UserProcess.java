package override_equals_hash_tostring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author annasavasteeva
 * @date 22.04.2026
 */
public class UserProcess {

    public void processUserTasks() {
        List<User> usersList = getUsersList();
        compareUsers(usersList);
    }

    private void compareUsers(List<User> usersList) {
        System.out.println("----------");
        System.out.println("Сравниваем пользователей: ");
        for (int i = 0; i < usersList.size() - 1; i++) {
            var currentUser = usersList.get(i);
            var nextUser = usersList.get(i + 1);
            String areEqual = currentUser.equals(nextUser) ?
                    "Это один и тот же пользователь." :
                    "Это разные пользователи.";
            System.out.println(currentUser);
            System.out.println(nextUser);
            System.out.println(areEqual);
            if (i != usersList.size() - 2) System.out.println("---");
        }
        System.out.println("----------");
    }

    private List<User> getUsersList() {
        long idForTom = generateUserId();
        User tom1 = new User(idForTom, "Tom", "tom@mail.com");
        User tom2 = new User(idForTom, "Tom", "tom@mail.com");
        User jerry = new User(generateUserId(), "Jerry", "jerry@mail.com");
        User tomAndJerry = new User(generateUserId(), "Tom", "jerry@mail.com");
        User jerryAndTom = new User(generateUserId(), "Jerry", "tom@mail.com");
        long idForBulldog = generateUserId();
        User tomEnemy = new User(idForBulldog, "Bulldog", "bulldog@mail.com");
        User housewife = new User(idForBulldog, "Housewife", "housewife@mail.com");
        addFriendsToUser(tom1, jerry, housewife);
        addFriendsToUser(jerry, tom1, tomEnemy);
        addFriendsToUser(housewife, tomEnemy);
        return new ArrayList<>(Arrays.asList(tom1, tom2, jerry, tomAndJerry, jerryAndTom, tomEnemy, housewife));
    }

    private void addFriendsToUser(User user, User... friends) {
        for (User friend : friends) {
            user.addFriend(friend);
        }
    }

    private long generateUserId() {
        return (long) Math.floor(Math.random() * 900_000L) + 100_000L;
    }
}
