package com.example.workflow.Camunda.GatewayEvents;

import com.example.workflow.Modals.User;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;
public class ProcessUser implements JavaDelegate {
    private final Logger LOGGER = Logger.getLogger(ProcessUser.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception
    {
        ////Getting Data

        Long    age  = (Long) delegateExecution.getVariable("age");

        boolean canEnter=false;
        ////Processing data
        if (age < 18) {
            canEnter = false;
        }
        else if (age >= 18) {
            canEnter = true;
        }
        delegateExecution.setVariable("canEnter",canEnter);

        LOGGER.info(String.valueOf(age));
        LOGGER.info(String.valueOf(canEnter));

    }
}
