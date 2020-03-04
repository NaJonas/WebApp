package uk.ac.city.aczc775.services;


import uk.ac.city.aczc775.dao.BasketballRepository;
import uk.ac.city.aczc775.dao.HistoryRepository;
import uk.ac.city.aczc775.entities.CollatedUser;
import uk.ac.city.aczc775.entities.LoginHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {


    private BasketballRepository basketballRepository;

    private HistoryRepository historyRepository;

    @Autowired
    public ProfileServiceImpl(BasketballRepository basketballRepository, HistoryRepository historyRepository){
        this.basketballRepository = basketballRepository;
        this.historyRepository = historyRepository;
    }


    @Override
    public CollatedUser getProfile(String email){
        CollatedUser user = new CollatedUser();
        user.setUser(basketballRepository.findById(email).orElseThrow(()-> new UsernameNotFoundException("No matching user found.")));
        List<LoginHistory> history = historyRepository.findAll().
                stream().filter(loginHistory -> loginHistory.getEmail().equals(email)).
                collect(Collectors.toList());
        user.setLogins(history);


        return user;
    }
}
