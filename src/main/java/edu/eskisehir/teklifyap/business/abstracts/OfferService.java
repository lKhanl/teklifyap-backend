package edu.eskisehir.teklifyap.business.abstracts;

import edu.eskisehir.teklifyap.core.utilities.results.Result;
import edu.eskisehir.teklifyap.entities.concretes.Offer;
import edu.eskisehir.teklifyap.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OfferService {
    Result getAll();
    Result getOffersByUser(User user);
    Result updateStatus(int id, String status);
    Result makeOffer(Offer offer);
}
