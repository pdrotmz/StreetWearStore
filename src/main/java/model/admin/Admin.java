package model.admin;

import java.util.Random;
import java.util.UUID;

public class Admin {

    private long id;
    private String username;
    private String email;
    private String password;
    private String domain;

    public Admin() {
    }

    public Admin(long id, String username, String email, String password, String domain) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.domain = domain;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
