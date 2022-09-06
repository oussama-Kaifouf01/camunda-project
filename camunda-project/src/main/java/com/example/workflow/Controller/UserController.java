package com.example.workflow.Controller;

import com.example.workflow.Modals.User;
import com.example.workflow.Camunda.Service.CamundaStartService;
import com.example.workflow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CamundaStartService camundaStartService;

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public void saveAge(@RequestBody User user)
    {
        camundaStartService.startProcessByMessage(user);
        userService.addUser(user);

    }
}
