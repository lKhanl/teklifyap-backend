package edu.eskisehir.teklifyap.business.concretes;

import edu.eskisehir.teklifyap.business.abstracts.OfferService;
import edu.eskisehir.teklifyap.core.utilities.results.DataResult;
import edu.eskisehir.teklifyap.core.utilities.results.Result;
import edu.eskisehir.teklifyap.core.utilities.results.SuccessDataResult;
import edu.eskisehir.teklifyap.dataAccess.abstracts.OfferDao;
import edu.eskisehir.teklifyap.entities.concretes.Offer;
import edu.eskisehir.teklifyap.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OfferManager implements OfferService {
    private final OfferDao offerDao;

    @Autowired
    public OfferManager(OfferDao offerDao) {
        this.offerDao = offerDao;
    }

    @Override
    public Result getAll() {
        return new SuccessDataResult<>(this.offerDao.findAll(), "DATA LISTELENDI");
    }

    @Override
    public Result getOffersByUser(User user) {
        return new DataResult<>(offerDao.getOffersByUser(user), true);
    }

    @Override
    public Result updateStatus(int id, String status) {
        Offer offer = offerDao.getById(id);
        offer.setOffer_status(status);
        offerDao.save(offer);
        return new Result(true, "updated");
    }

    @Override
    public Result makeOffer(Offer offer) {
        System.out.println(offer.toString());
        offerDao.save(offer);
        return new DataResult<>(offer.getOffer_id(),true);
    }
}
