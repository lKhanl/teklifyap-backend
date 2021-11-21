package edu.eskisehir.teklifyap.business.concretes;

import edu.eskisehir.teklifyap.business.abstracts.UserService;
import edu.eskisehir.teklifyap.dataAccess.abstracts.UserDao;
import edu.eskisehir.teklifyap.core.utilities.results.*;
import edu.eskisehir.teklifyap.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }
    @Override
    public DataResult<List<User>> getAll() {
        return new DataResult<>(userDao.findAll(),true);
    }

    @Override
    public Result add(User user) {
        int count = 0;
        for (int i = 0; i < userDao.findAll().size(); i++) {
            if (userDao.findAll().get(i).getUser_email().trim().equals(user.getUser_email())) {
                count++;
                break;
            }
        }

        if (count == 1) {

            return new ErrorDataResult<>("USER NOT ADDED");

        } else {
            this.userDao.save(user);
            return new SuccessDataResult<>("USER ADDED");
        }
    }

    @Override
    public Result getByEmailAndPassword(User user) {
        int user_id = -1;

        for (int i = 0; i < userDao.findAll().size(); i++) {
            if (userDao.findAll().get(i).getUser_email().trim().equals(user.getUser_email()) && userDao.findAll().get(i).getUser_password().trim().equals(user.getUser_password())) {
                user_id = userDao.findAll().get(i).getUser_id();

                break;
            }
        }

        if (userDao.getById(user_id).getUser_id() != -1) {

            return new SuccessDataResult<>(user_id, "USER EXIST");

        } else {

            return new ErrorDataResult<>("USER DOES NOT EXIST");
        }
    }

    @Override
    public Result getUserProfile(User user) {
        User userInfos = new User(userDao.getById(user.getUser_id()).getUser_id(), userDao.getById(user.getUser_id()).getUser_name(), userDao.getById(user.getUser_id()).getUser_surname(), userDao.getById(user.getUser_id()).getUser_email(), userDao.getById(user.getUser_id()).getUser_password(), userDao.getById(user.getUser_id()).getUser_creation_date());
        return new SuccessDataResult<>(userInfos, "infos sent");
    }

    @Override
    public DataResult<List<User>> userInfo(int userID) {
        return new SuccessDataResult<>(userInfo(userID).getData());
    }

    @Override
    public User getByid(int id) {
        return this.userDao.getById(id);
    }

    @Override
    public Result save(User user) {
        User updated = userDao.save(user);
        return new DataResult<User>(updated, true, "updated " + user.getUser_id());
    }

}
