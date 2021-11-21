package edu.eskisehir.teklifyap.dataAccess.abstracts;


import edu.eskisehir.teklifyap.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {




}
