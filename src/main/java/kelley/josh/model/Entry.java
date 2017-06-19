package kelley.josh.model;

import javax.persistence.*;

/**
 * Created by joshuakelley on 2/25/17.
 */
@Entity
public class Entry {
    private String website;
    private String identity;
    private String password;
    private long clientAccountNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Entry(String website, String identity, String password, long clientAccountNumber) {
        this.website = website;
        this.identity = identity;
        this.password = password;
        this.clientAccountNumber = clientAccountNumber;
    }

    public Entry() {
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getClientAccountNumber() {
        return clientAccountNumber;
    }

    public void setClientAccountNumber(long clientAccountNumber) {
        this.clientAccountNumber = clientAccountNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
