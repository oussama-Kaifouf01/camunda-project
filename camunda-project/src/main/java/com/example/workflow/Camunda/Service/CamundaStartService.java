package com.example.workflow.Camunda.Service;

import com.example.workflow.Modals.User;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.MessageCorrelationResultWithVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamundaStartService {
    @Autowired
    RuntimeService runtimeService;

    public List<MessageCorrelationResultWithVariables> startProcessByMessage(User user)
    {
        return runtimeService.createMessageCorrelation("msgRecieveUser")
               .setVariable("name",user.getName())
               .setVariable("age",user.getAge())
               .correlateAllWithResultAndVariables(true);
    }

}
