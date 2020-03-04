package uk.ac.city.aczc775.services;

import uk.ac.city.aczc775.entities.CollatedUser;

public interface ProfileService {

    CollatedUser getProfile(String email);
}
