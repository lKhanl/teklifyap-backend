package edu.eskisehir.teklifyap.business.abstracts;

import edu.eskisehir.teklifyap.core.utilities.results.DataResult;
import edu.eskisehir.teklifyap.core.utilities.results.Result;
import edu.eskisehir.teklifyap.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    DataResult<List<User>> getAll();
    Result add(User user);
    Result getByEmailAndPassword(User user);
    Result getUserProfile(User user);
    DataResult<List<User>> userInfo(int userID);
    User getByid(int id);
    Result save(User user);
}
