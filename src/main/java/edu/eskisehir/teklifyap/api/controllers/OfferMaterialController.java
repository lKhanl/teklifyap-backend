package edu.eskisehir.teklifyap.api.controllers;

import edu.eskisehir.teklifyap.business.abstracts.OfferMaterialService;
import edu.eskisehir.teklifyap.core.utilities.results.Result;
import edu.eskisehir.teklifyap.entities.concretes.OfferMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/offerMaterial")
@CrossOrigin
public class OfferMaterialController {
    private final OfferMaterialService offerMaterialService;

    @Autowired
    public OfferMaterialController(OfferMaterialService offerMaterialService) {
        super();
        this.offerMaterialService = offerMaterialService;
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return this.offerMaterialService.getAll();
    }

    @PostMapping("/make")
    public Result makeOffer(@RequestBody OfferMaterial offerMaterial){
        return offerMaterialService.makeOffer(offerMaterial);
    }

}
