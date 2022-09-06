package com.example.workflow.Service;

import com.example.workflow.Modals.User;
import com.example.workflow.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void addUser(User user)
    {
        this.userRepo.save(user);
    }
 //   public List<User> getUsers()
 //   {
 //       return userRepo.findAll();
 //   }
 //   public User getUserById(int id)
 //   {
 //       return userRepo.getOne(id);
 //   }

}
