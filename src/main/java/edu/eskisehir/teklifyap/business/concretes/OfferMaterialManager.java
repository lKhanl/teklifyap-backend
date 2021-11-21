package edu.eskisehir.teklifyap.business.concretes;

import edu.eskisehir.teklifyap.business.abstracts.OfferMaterialService;
import edu.eskisehir.teklifyap.core.utilities.results.DataResult;
import edu.eskisehir.teklifyap.core.utilities.results.Result;
import edu.eskisehir.teklifyap.dataAccess.abstracts.OfferMaterialDao;
import edu.eskisehir.teklifyap.entities.concretes.OfferMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferMaterialManager implements OfferMaterialService {
    private final OfferMaterialDao offerMaterialDao;


    @Autowired
    public OfferMaterialManager(OfferMaterialDao offerMaterialDao) {
        super();
        this.offerMaterialDao = offerMaterialDao;

    }

    @Override
    public Result getAll() {
        return new DataResult<>(this.offerMaterialDao.findAll(), true);
    }

    @Override
    public Result makeOffer(OfferMaterial offerMaterial) {
        this.offerMaterialDao.save(offerMaterial);
        return new DataResult<>("ok", true);
    }
}
