package uk.ac.city.aczc775.entities;

import java.nio.file.attribute.UserPrincipal;

public class BasketballUserPrincipal implements UserPrincipal {
    private BasketballUser user;
    public BasketballUserPrincipal(BasketballUser user){
        this.user = user;
    }

    @Override
    public String getName(){
        return user.getEmail();
    }
}
