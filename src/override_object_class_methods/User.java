package override_object_class_methods;

import override_object_class_methods.clone_demonstration.AddressForDeepCopy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author annasavasteeva
 * @date 22.04.2026
 */
public class User implements Cloneable {

    private final long userId;
    private String userName;
    private String userEmail;
    private List<User> userFriends;
    private AddressForDeepCopy location;

    public User(String userName, String userEmail) {
        this.userId = generateUserId();
        this.userName = userName;
        this.userEmail = userEmail;
        this.userFriends = new ArrayList<>();
        this.location = new AddressForDeepCopy("London");
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<User> getUserFriends() {
        return userFriends;
    }

    public void setUserFriends(List<User> userFriends) {
        this.userFriends = userFriends;
    }

    public AddressForDeepCopy getLocation() {
        return location;
    }

    public void setLocation(AddressForDeepCopy location) {
        this.location = location;
    }

    public void addFriend(User friend) {
        this.userFriends.add(friend);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object deepClone() throws CloneNotSupportedException {
        User clonedUser = (User) this.clone();
        clonedUser.setLocation((AddressForDeepCopy) this.location.clone());
        for (int i = 0; i < userFriends.size(); i++) {
            User clonedFriend = (User) userFriends.get(i).clone();
            userFriends.set(i, clonedFriend);
        }
        return clonedUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return userId == user.userId && userName.equals(user.userName) && userEmail.equals(user.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userEmail);
    }

    private long generateUserId() {
        return (long) Math.floor(Math.random() * 900_000L) + 100_000L;
    }
}
