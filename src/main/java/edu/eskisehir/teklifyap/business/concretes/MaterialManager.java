package edu.eskisehir.teklifyap.business.concretes;

import edu.eskisehir.teklifyap.business.abstracts.MaterialService;
import edu.eskisehir.teklifyap.core.utilities.results.DataResult;
import edu.eskisehir.teklifyap.core.utilities.results.Result;
import edu.eskisehir.teklifyap.core.utilities.results.SuccessDataResult;
import edu.eskisehir.teklifyap.dataAccess.abstracts.MaterialDao;
import edu.eskisehir.teklifyap.entities.concretes.Material;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class MaterialManager implements MaterialService {
    private final MaterialDao materialDao;

    @Autowired
    public MaterialManager(MaterialDao materialDao) {
        super();
        this.materialDao = materialDao;

    }

    @Override
    public DataResult<List<Material>> getAll() {
        return new SuccessDataResult<>(this.materialDao.findAll(), "DATA LISTELENDI");
    }

    @Override
    public List<Material> getMaterials(int id) {
        return materialDao.takeMaterialsByUserID(id);
    }

    @Override
    public Result delete(String id) throws ParseException {
        JSONParser jsonParser = new JSONParser(id);
        BigInteger parsedID = (BigInteger) jsonParser.object().get("deleted");
        Material material = materialDao.getById(parsedID.intValue());
        material.setMaterial_is_verified((short) 0);
        materialDao.save(material);
        return new Result(true, "Malzeme silindi.");
    }

    @Override
    public Result add(Material material) {
        materialDao.save(material);
        return new Result(true,"Eklendi.");
    }


}
