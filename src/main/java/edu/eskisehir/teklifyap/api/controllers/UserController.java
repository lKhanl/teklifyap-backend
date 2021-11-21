package edu.eskisehir.teklifyap.api.controllers;

import edu.eskisehir.teklifyap.business.abstracts.UserService;
import edu.eskisehir.teklifyap.core.utilities.results.DataResult;
import edu.eskisehir.teklifyap.core.utilities.results.Result;
import edu.eskisehir.teklifyap.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }

    @PostMapping("/getByEmailAndPassword")
    public Result getByEmailAndPassword(@RequestBody User user){
        return this.userService.getByEmailAndPassword(user);
    }

    @PostMapping("/add")
    public Result add(@RequestBody User user){
        return this.userService.add(user);
    }

    @PostMapping("/userInfo")
    public DataResult<List<User>> userInfo(@RequestBody int userInfo){
        return this.userService.userInfo(userInfo);
    }

    @PostMapping("/userProfile")
    public Result getUserProfile(@RequestBody User user){

        return this.userService.getUserProfile(user);
    }

    @PostMapping("/updateInformation")
    public Result save(@RequestBody User user){

        return this.userService.save(user);
    }

    @PostMapping("/assignList")
    public Result assignList(@RequestBody User user){

        return this.userService.getUserProfile(user);
    }

    @GetMapping("/getAll/{id}")
    public User getByUserID(@PathVariable int id) {
        return userService.getByid(id);
    }

    @PostMapping("/getFullName")
    public DataResult<String> getFullName(@RequestBody User user){
        User a = userService.getByid(user.getUser_id());
        return new DataResult<>(a.FullName(),true);
    }
}
