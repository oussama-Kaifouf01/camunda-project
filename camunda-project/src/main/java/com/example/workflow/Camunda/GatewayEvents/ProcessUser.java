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
        Long age = (Long) delegateExecution.getVariable("age");
        boolean adult=false;
        ////Processing data
        if (age >= 18) {
            adult = true;
        }
        else if (age < 18) {
            adult = false;
        }

        delegateExecution.setVariable("adult",adult);

    }
}
