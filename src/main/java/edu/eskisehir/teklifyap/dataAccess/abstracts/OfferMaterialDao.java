package edu.eskisehir.teklifyap.dataAccess.abstracts;

import edu.eskisehir.teklifyap.entities.concretes.OfferMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferMaterialDao extends JpaRepository<OfferMaterial,Integer> {
}
