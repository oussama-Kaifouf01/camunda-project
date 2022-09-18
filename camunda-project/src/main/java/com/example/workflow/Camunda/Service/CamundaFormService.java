package com.example.workflow.Camunda.Service;


import org.camunda.bpm.engine.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CamundaFormService {


    @Autowired
    FormService formService;
    public String setVideoGameAndCompleteTask(String id,String videoGame)
    {
        Map<String, Object> variables = new HashMap<>() ;
        variables.put("videoGame", videoGame);

        formService.submitTaskForm(id,variables ); ;

        return "task Complete";
    }
}
