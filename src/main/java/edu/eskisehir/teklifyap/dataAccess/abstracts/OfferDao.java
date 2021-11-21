package edu.eskisehir.teklifyap.dataAccess.abstracts;

import edu.eskisehir.teklifyap.entities.concretes.Offer;
import edu.eskisehir.teklifyap.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferDao extends JpaRepository<Offer,Integer> {
    List<Offer> getOffersByUser(User user);
}
