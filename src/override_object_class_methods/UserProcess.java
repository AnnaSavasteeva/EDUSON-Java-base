package override_object_class_methods;

import java.util.*;

/**
 * @author annasavasteeva
 * @date 22.04.2026
 */
public class UserProcess {

    public void processUserTasks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Сравнить пользователей?");
        if (sc.nextBoolean()) {
            List<User> usersForCompare = createUsersListForCompare();
            compareUsers(usersForCompare);
            System.out.println("----------");
            System.out.println("----------");
        }
        System.out.println("Вполнить копирование?");
        if (sc.nextBoolean()) {
            List<User> usersForCopy = createUsersListForCopy();
            List<Long> ids = usersForCopy.stream().map(User::getUserId).toList();
            long id = ids.get(new Random().nextInt(ids.size()));
            System.out.println("Реализовать глубокое копирование?");
            processUserCopy(usersForCopy, id, sc.nextBoolean());
        }
        sc.close();
    }

    private void processUserCopy(List<User> usersList, long userId, boolean isDeep) {
        System.out.println(isDeep ? "DEEP COPY" : "SHALLOW COPY");

        User original = getUserById(usersList, userId);
        printOriginalUserData(original);

        User cloned = copyUserById(usersList, userId, isDeep);
        printClonedUserData(cloned);

        String newLocation = "NEW LOCATION";
        System.out.println("Поменяли локацию у копии на " + newLocation);
        cloned.getLocation().setCity(newLocation);

        var clonedFriend = cloned.getUserFriends().get(0);
        String newName = "NEW NAME";
        System.out.printf("Поменяли имя у друга копии с '%s' на '%s'%n", clonedFriend.getUserName(), newName);
        clonedFriend.setUserName(newName);

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

    private User copyUserById(List<User> usersList, long id, boolean isDeepCopy) {
        User userById = getUserById(usersList, id);
        if (!isDeepCopy) return cloneUser(userById);
        return deepCloneUser(userById);
    }

    private User getUserById(List<User> usersList, long id) {
        return usersList.stream()
                .filter(user -> user.getUserId() == id)
                .findFirst()
                .orElseThrow(() -> new AssertionError("User wasn't found with id: " + id));
    }

    private List<User> createUsersListForCopy() {
        User tom = new User("Tom", "tom@mail.com");
        User jerry = new User("Jerry", "jerry@mail.com");
        User tomEnemy = new User("Bulldog", "bulldog@mail.com");
        User housewife = new User("Housewife", "housewife@mail.com");
        addFriendsToUser(tom, jerry, housewife);
        addFriendsToUser(jerry, tom, tomEnemy);
        addFriendsToUser(tomEnemy, housewife);
        addFriendsToUser(housewife, tomEnemy);
        return new ArrayList<>(Arrays.asList(tom, jerry, tomEnemy, housewife));
    }

    private void addFriendsToUser(User user, User... friends) {
        for (User friend : friends) {
            user.addFriend(friend);
        }
    }

    private void compareUsers(List<User> usersList) {
        System.out.println("----------");
        System.out.println("Сравниваем пользователей: ");
        for (int i = 0; i < usersList.size() - 1; i++) {
            var currentUser = usersList.get(i);
            var nextUser = usersList.get(i + 1);
            String infoAboutEquality = currentUser.equals(nextUser) ?
                    "Это один и тот же пользователь." :
                    "Это разные пользователи.";
            System.out.println(currentUser);
            System.out.println(nextUser);
            System.out.println(infoAboutEquality);
            if (i != usersList.size() - 2) System.out.println("---");
        }
        System.out.println("----------");
    }

    private List<User> createUsersListForCompare() {
        User tom1 = new User("Tom", "tom@mail.com");
        User tom2 = cloneUser(tom1);
        User jerry = new User("Jerry", "jerry@mail.com");
        User tomAndJerry = new User("Tom", "jerry@mail.com");
        User jerryAndTom = new User("Jerry", "tom@mail.com");
        User tomEnemy = new User("Bulldog", "bulldog@mail.com");
        User housewife = deepCloneUser(tomEnemy);
        housewife.setUserName("Housewife");
        housewife.setUserEmail("housewife@mail.com");
        return new ArrayList<>(Arrays.asList(tom1, tom2, jerry, tomAndJerry, jerryAndTom, tomEnemy, housewife));
    }

    private User deepCloneUser(User user) {
            return new User(user);
    }

    private User cloneUser(User user) {
        try {
            return (User) user.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

}
