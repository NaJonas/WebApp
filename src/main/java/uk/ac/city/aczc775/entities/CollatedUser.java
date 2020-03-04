package uk.ac.city.aczc775.entities;


import java.util.List;

public class CollatedUser {

    private BasketballUser user;

    private List<LoginHistory> logins;

    public List<LoginHistory> getLogins() {
        return logins;
    }

    public void setLogins(List<LoginHistory> logins) {
        this.logins = logins;
    }

    public BasketballUser getUser() {
        return user;
    }

    public void setUser(BasketballUser user) {
        this.user = user;
    }
}
