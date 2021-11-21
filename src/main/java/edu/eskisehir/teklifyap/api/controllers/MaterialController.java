package edu.eskisehir.teklifyap.api.controllers;

import edu.eskisehir.teklifyap.business.abstracts.MaterialService;
import edu.eskisehir.teklifyap.core.utilities.results.DataResult;
import edu.eskisehir.teklifyap.core.utilities.results.Result;
import edu.eskisehir.teklifyap.entities.concretes.Material;
import edu.eskisehir.teklifyap.entities.concretes.User;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/material")
@CrossOrigin
public class MaterialController {
    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        super();
        this.materialService = materialService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Material>> getAll() {
        return this.materialService.getAll();
    }

    @PostMapping("/getMaterialByUser")
    public List<Material> getMaterials(@RequestBody User user) {
        return materialService.getMaterials(user.getUser_id());
    }

    @PostMapping("/add")
    public Result add(@RequestBody Material material){
        return materialService.add(material);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody String deleted) {
        try {
            return materialService.delete(deleted);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Result(false, "Malzeme silinirken bir hatayla karşılaşıldı. Lütfen yetkiliyle görüşünüz.");
        }
    }

}
