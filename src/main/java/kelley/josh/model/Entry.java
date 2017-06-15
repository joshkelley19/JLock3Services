package kelley.josh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by joshuakelley on 2/25/17.
 */
@Entity
@Table(name = "entries")
public class Entry {
    public String website;
    public String identity;
    public String password;
    public long clientAccountNumber;

    @Id
    @GeneratedValue
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

    public long getId() {
        return id;
    }
}
