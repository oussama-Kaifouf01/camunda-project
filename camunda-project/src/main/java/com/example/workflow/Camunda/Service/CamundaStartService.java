package com.example.workflow.Camunda.Service;

import com.example.workflow.Modals.User;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamundaStartService {
    @Autowired
    RuntimeService runtimeService;

    public void startProcessByMessage(User user)
    {
        runtimeService.createMessageCorrelation("msgRecieveUser")
                .setVariable("name",user.getName())
                .setVariable("age",user.getAge())
                .setVariable("can_enter",user.isCanEnter())
                .correlate();
    }

}
