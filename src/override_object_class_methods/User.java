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

//    GETTERS AND SETTERS

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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private long generateUserId() {
        return (long) Math.floor(Math.random() * 900_000L) + 100_000L;
    }
}
