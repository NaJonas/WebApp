package uk.ac.city.aczc775.services;

import uk.ac.city.aczc775.dao.BasketballRepository;
import uk.ac.city.aczc775.entities.BasketballUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private BasketballRepository basketballRepository;



    @Autowired
    public RegistrationServiceImpl(BasketballRepository basketballRepository){
        this.basketballRepository = basketballRepository;
    }



    @Override
    public void registerUser(BasketballUser user){
        basketballRepository.save(user);
    }
}
