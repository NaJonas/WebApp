package uk.ac.city.aczc775.services;

import uk.ac.city.aczc775.dao.BasketballRepository;
import uk.ac.city.aczc775.dao.HistoryRepository;
import uk.ac.city.aczc775.entities.BasketballUser;
import uk.ac.city.aczc775.entities.LoginHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class BasketballUserDetails implements UserDetailsService {

    private BasketballRepository basketballRepository;
    private HistoryRepository historyRepository;

    @Autowired
    public BasketballUserDetails(BasketballRepository basketballRepository, HistoryRepository historyRepository){
        this.basketballRepository = basketballRepository;
        this.historyRepository = historyRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{
        BasketballUser user = basketballRepository.findById(s).orElseThrow(()-> new UsernameNotFoundException("No matching user."));

        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setEmail(user.getEmail());
        loginHistory.setTime(LocalDateTime.now());
        historyRepository.save(loginHistory);

        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getAuthority()));
        return new User
                (user.getEmail(), user.getPassword(), user.getEnabled(),
                        true, true, true, authorities);
    }
}
