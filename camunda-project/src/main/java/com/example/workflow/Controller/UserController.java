package com.example.workflow.Controller;

import com.example.workflow.Modals.User;
import com.example.workflow.Camunda.Service.CamundaStartService;
import com.example.workflow.Service.UserService;
import org.camunda.bpm.engine.runtime.MessageCorrelationResultWithVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CamundaStartService camundaStartService;

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public void saveAge(@RequestBody User user)
    {
     //   msgResult.get(0).getVariables().get("canEnter")
        List<MessageCorrelationResultWithVariables> msgResult = camundaStartService.startProcessByMessage(user);
        User finalUser = new User();
        finalUser.setName(String.valueOf(msgResult.get(0).getVariables().get("name")));
        finalUser.setAge((Long) msgResult.get(0).getVariables().get("age"));
        finalUser.setCanEnter((Boolean) msgResult.get(0).getVariables().get("canEnter"));
        userService.addUser(finalUser);

    }
}
