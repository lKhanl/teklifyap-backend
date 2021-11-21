package edu.eskisehir.teklifyap.business.abstracts;

import edu.eskisehir.teklifyap.core.utilities.results.DataResult;
import edu.eskisehir.teklifyap.core.utilities.results.Result;
import edu.eskisehir.teklifyap.entities.concretes.Material;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MaterialService {
    DataResult<List<Material>> getAll();
    List<Material> getMaterials(int id);
    Result delete(String deleted) throws ParseException;
    Result add(Material material);
}
