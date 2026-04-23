package override_object_class_methods;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.format.DateTimeFormatter.ofPattern;

/**
 * @author annasavasteeva
 * @date 22.04.2026
 */
public class User {

    private final long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private List<User> userFriends;

    public User(long userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = generateDefaultPassword();
        this.userFriends = new ArrayList<>();
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

    private String generateDefaultPassword() {
        String dateTimePart = LocalDateTime.now().format(ofPattern("yyMMddhhmmss"));
        var randSixDigitNumber = (long) Math.floor(Math.random() * 900_000L) + 100_000L;
        return dateTimePart + randSixDigitNumber;
    }
}
