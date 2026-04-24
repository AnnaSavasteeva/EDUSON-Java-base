package override_object_class_methods;

import override_object_class_methods.clone_demonstration.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author annasavasteeva
 * @date 22.04.2026
 */
public class User implements Cloneable {

    private long userId;
    private String userName;
    private String userEmail;
    private List<User> userFriends;
    private Address location;

    public User(String userName, String userEmail) {
        this.userId = generateUserId();
        this.userName = userName;
        this.userEmail = userEmail;
        this.userFriends = new ArrayList<>();
        this.location = new Address("London");
    }

    public User(User other) {
        this.userId = other.getUserId();
        this.userName = other.getUserName();
        this.userEmail = other.getUserEmail();
        this.userFriends = getDeepCopyOfUserFriends(other.getUserFriends());
        this.location = new Address(other.getLocation());
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<User> getUserFriends() {
        return userFriends;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public void addFriend(User friend) {
        this.userFriends.add(friend);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", location='" + location + '\'' +
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

    private List<User> getDeepCopyOfUserFriends(List<User> userFriends) {
        List<User> friendsCopy = userFriends.stream()
                .map(user -> new User(user.getUserName(), user.getUserEmail()))
                .collect(Collectors.toList());
        for (int i = 0; i < userFriends.size(); i++) {
            friendsCopy.get(i).setUserId(userFriends.get(i).getUserId());
        }
        return friendsCopy;
    }

    private void setUserId(long userId) {
        this.userId = userId;
    }

    private long generateUserId() {
        return (long) Math.floor(Math.random() * 900_000L) + 100_000L;
    }
}
