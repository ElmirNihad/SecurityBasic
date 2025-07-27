package org.example.securityb.Controller;

import org.example.securityb.Model.User;

public interface IuserController {

    public String  dashboard();
    public String  foradmin();
    public String  foruserandadmin();
    public User register(User user);
}
