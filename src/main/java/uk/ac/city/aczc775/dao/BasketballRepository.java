package uk.ac.city.aczc775.dao;


import uk.ac.city.aczc775.entities.BasketballUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketballRepository extends JpaRepository<BasketballUser, String> {
}
