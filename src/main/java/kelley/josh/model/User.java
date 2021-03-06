package kelley.josh.model;

import javax.persistence.*;

/**
 * Created by joshuakelley on 3/9/17.
 */
@Entity
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public User(String firstName, String lastName, String email, String userName, String password, long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.id = id;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
