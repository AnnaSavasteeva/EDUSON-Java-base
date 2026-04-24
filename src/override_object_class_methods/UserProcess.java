package override_object_class_methods;

import override_object_class_methods.clone_demonstration.Address;

import java.util.*;

/**
 * @author annasavasteeva
 * @date 22.04.2026
 */
public class UserProcess {

    private List<User> usersList = new ArrayList<>();

    public void processUserTasks() {
        usersList = fillUsersList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Сравнить пользователей?");
        if (sc.nextBoolean()) {
            compareUsers(usersList);
            System.out.println("----------");
            System.out.println("----------");
        }
        List<Long> userIdsList = usersList.stream()
                .filter(user -> !user.getUserFriends().isEmpty())
                .map(User::getUserId)
                .toList();
        System.out.println("Выполнить deep copy?");
        processUserCopy(userIdsList, sc.nextBoolean());
        sc.close();
    }

    private void processUserCopy(List<Long> ids, boolean isDeep) {
        System.out.println(isDeep ? "DEEP COPY" : "SHALLOW COPY");
        long id = ids.get(new Random().nextInt(ids.size()));

        User original = getUserById(id);
        printOriginalUserData(original);

        User cloned = copyUserById(id, isDeep);
        printClonedUserData(cloned);

        Address newLocation = new Address("NEW LOCATION");
        cloned.setLocation(newLocation);
        System.out.println("Поменяли локацию у копии на " + newLocation.getCity());

        var clonedFriend = cloned.getUserFriends().get(0);
        System.out.printf("Поменяли имя у друга копии '%s' на '%s'%n", clonedFriend.getUserName(), "NEW NAME");
        clonedFriend.setUserName("NEW NAME");

        System.out.println("---");
        printOriginalUserData(original);
        printClonedUserData(cloned);
    }

    private void printClonedUserData(User user) {
        System.out.println("Копия: " + user);
        System.out.println("Друзья копии: ");
        user.getUserFriends().forEach(System.out::println);
        System.out.println("---");
    }

    private void printOriginalUserData(User user) {
        System.out.println("Оригинал: " + user);
        System.out.println("Друзья оригинала: ");
        user.getUserFriends().forEach(System.out::println);
        System.out.println("---");
    }

    private User copyUserById(long id, boolean isDeepCopy) {
        User userById = getUserById(id);
        if (!isDeepCopy) return cloneUser(userById);
        return deepCloneUser(userById);
    }

    private User getUserById(long id) {
        return usersList.stream()
                .filter(user -> user.getUserId() == id)
                .findFirst()
                .orElseThrow(() -> new AssertionError("User wasn't found with id: " + id));
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

    private List<User> fillUsersList() {
        User tom1 = new User("Tom", "tom@mail.com");
        User tom2 = cloneUser(tom1);
        User jerry = new User("Jerry", "jerry@mail.com");
        User tomAndJerry = new User("Tom", "jerry@mail.com");
        User jerryAndTom = new User("Jerry", "tom@mail.com");
        User tomEnemy = new User("Bulldog", "bulldog@mail.com");
        User housewife = deepCloneUser(tomEnemy);
        housewife.setUserName("Housewife");
        housewife.setUserEmail("housewife@mail.com");
        addFriendsToUser(tom1, jerry, housewife);
        addFriendsToUser(jerry, tom1, tomEnemy);
        addFriendsToUser(housewife, tomEnemy);
        return new ArrayList<>(Arrays.asList(tom1, tom2, jerry, tomAndJerry, jerryAndTom, tomEnemy, housewife));
    }

    private User deepCloneUser(User user) {
        try {
            return (User) user.deepClone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private User cloneUser(User user) {
        try {
            return (User) user.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private void addFriendsToUser(User user, User... friends) {
        for (User friend : friends) {
            user.addFriend(friend);
        }
    }
}
