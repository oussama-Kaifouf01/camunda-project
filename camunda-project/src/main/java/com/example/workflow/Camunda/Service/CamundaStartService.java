package com.example.workflow.Camunda.Service;

import com.example.workflow.Modals.User;
import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.MessageCorrelationResultWithVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CamundaStartService {
    @Autowired
    RuntimeService runtimeService;

    @Autowired
    FormService formService;

    public List<MessageCorrelationResultWithVariables> startProcessByMessage(User user)
    {
        return runtimeService.createMessageCorrelation("msgRecieveUser")
               .setVariable("id",user.getId())
               .setVariable("name",user.getName())
               .setVariable("age",user.getAge())
               .correlateAllWithResultAndVariables(true);
    }

    public String setVideoGameAndCompleteTask(String id,String videoGame)
    {
        Map<String, Object> variables = new HashMap<>() ;
        variables.put("videoGame", videoGame);

        formService.submitTaskForm(id,variables ); ;

        return "task Complete";
    }

}
