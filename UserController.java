package org.example.securityb.Controller;

import org.example.securityb.Model.User;
import org.example.securityb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rest/api/users")
public class UserController implements IuserController {

    @Autowired
    UserService service;

    @GetMapping(path = "/dashboard")
    @Override
    public String dashboard() {
        return "Bu bir umumi sehifedir";
    }

    @GetMapping(path = "/foradmin")
    @Override
    public String foradmin() {
        return "Bu sehife yanliz admin ucundur";
    }
    @GetMapping(path = "/forausers")
    @Override
    public String foruserandadmin() {
        return "Bu sehife userler ve admin ucundur";
    }

    @PostMapping(path = "/register")
    @Override
    public User register(@RequestBody User user) {
        return service.register(user);
    }


}
