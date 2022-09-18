package com.example.workflow.Camunda.GatewayEvents;

import com.example.workflow.Modals.User;
import com.example.workflow.Repo.UserRepoJDBC;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.function.Supplier;
import java.util.logging.Logger;

public class LoggerDelegate implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        //get all the variables and store them
        int id = (int) delegateExecution.getVariable("id");
        String name = (String) delegateExecution.getVariable("name");
        long age = (long) delegateExecution.getVariable("age");
        boolean adult = (boolean) delegateExecution.getVariable("adult");
        String videoGame = (String) delegateExecution.getVariable("videoGame");


        UserRepoJDBC userRepoJDBC = new UserRepoJDBC();
        User user =new User();

        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setVideoGame(videoGame);
        user.setAdult(adult);
        //LOGGER.info(user.toString());
        userRepoJDBC.insertUser(user);

    }
}
