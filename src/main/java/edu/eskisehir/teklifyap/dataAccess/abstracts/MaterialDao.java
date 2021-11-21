package edu.eskisehir.teklifyap.dataAccess.abstracts;

import edu.eskisehir.teklifyap.entities.concretes.Material;
import edu.eskisehir.teklifyap.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MaterialDao extends JpaRepository<Material, Integer> {
    @Query(value = "select * from material where user_id = :id and material_is_verified = 1", nativeQuery = true)
    List<Material> takeMaterialsByUserID(@Param("id") Integer id);
}
