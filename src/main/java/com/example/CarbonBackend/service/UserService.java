package com.example.CarbonBackend.service;

import com.example.CarbonBackend.entity.User;
import com.example.CarbonBackend.exception.BaseException;
import com.example.CarbonBackend.exception.UserException;
import com.example.CarbonBackend.model.DonateRequest;
import com.example.CarbonBackend.model.UserData;
import com.example.CarbonBackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User create(UserData request) throws BaseException {

        if(repository.existsByEmail(request.getEmail())){
            throw UserException.emailAlreadyExist();
        }

        User newUser = new User();
        newUser.setUser_type(request.getUser_type());
        newUser.setName(request.getName());
        newUser.setSurname(request.getSurname());
        newUser.setEmail(request.getEmail());
        newUser.setTel(request.getTel());
        newUser.setPoint(0);
        newUser.setHighscore(0);

        return repository.save(newUser);
    }

    public UserData getUserData(String email) throws BaseException {
        Optional<User> opt = findByEmail(email);

        if(opt.isEmpty()){
            throw UserException.emailNotFound();
        }
        User user = opt.get();
        UserData userData = new UserData();
        userData.setUser_type(user.getUser_type());
        userData.setName(user.getName());
        userData.setSurname(user.getSurname());
        userData.setTel(user.getTel());
        userData.setEmail(user.getEmail());
        return userData;
    }

    public void donate(DonateRequest request) throws BaseException {
        System.out.println(request.getEmail());
        Optional<User> donator_opt = findByEmail(request.getEmail());
        Optional<User> reciever_opt = findByEmail(request.getReceiver_email());

        if(donator_opt.isEmpty()){
            System.out.println("here1");
            throw UserException.emailNotFound();
        }
        if(reciever_opt.isEmpty()){
            System.out.println("here2");
            throw UserException.emailNotFound();
        }

        User donator = donator_opt.get();
        User receiver = reciever_opt.get();

        if(donator.getPoint() < request.getAmount()) {
            throw UserException.notEnoughPoint();
        }

        //update donator and receiver point
        donator.setPoint(donator.getPoint() - request.getAmount());
        receiver.setPoint(receiver.getPoint() + request.getAmount());

        repository.save(donator);
        repository.save(receiver);
    }
}
