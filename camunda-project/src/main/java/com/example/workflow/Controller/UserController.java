package com.example.workflow.Controller;

import com.example.workflow.Camunda.Service.CamundaFormService;
import com.example.workflow.Modals.User;
import com.example.workflow.Camunda.Service.CamundaStartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private CamundaStartService camundaStartService;


    @RequestMapping(value="/add/user",method = RequestMethod.POST)
    public void addUser(@RequestBody User user)
    {
        camundaStartService.startProcessByMessage(user);
    }

    @RequestMapping(value="/add/videogame",method = RequestMethod.POST)
    public void addVideoGame(@RequestBody Map<String, String> body)
    {
        camundaStartService.setVideoGameAndCompleteTask(body.get("taskId"),body.get("videoGame"));
    }

    //TODO:Make a helper function that finds taskId by user ID


}
