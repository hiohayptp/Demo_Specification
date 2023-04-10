package com.example.demo.api;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServiceImpl service;

    @PostMapping("/find-user/{name}")
    public ResponseEntity<List<User>> findByNameLike(@PathVariable("name") String name){
        List<User> users = service.findByName(name);
        if (users == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/find-user/{id}/{name}")
    public ResponseEntity<List<User>> findByIdAndName(@PathVariable("id") Integer id,
                                                           @PathVariable("name") String name){
        List<User> users = service.findByIdAndName(id, name);
        if (users == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @GetMapping("/{name}/{age}")
    public ResponseEntity<List<User>> findByNameLikeAndAge(@PathVariable("name") String name,
                                                      @PathVariable("age") Integer age){
        List<User> users = service.findByNameLikeAndAge(name, age);
        if (users == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    //ok
    @PostMapping("/find")
    public ResponseEntity<List<User>> findByNameLikeAndAge1(@RequestParam(name = "name") String name, Integer age){
        List<User> users = service.findByNameLikeAndAge(name, age);
        if (users == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Integer id){
        UserDTO userDTO = service.findUserAndProductByIdUser(id);
        if (userDTO == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> userDTOs = service.findAll();
        if (userDTOs == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDTOs,HttpStatus.OK);
    }

    ///////
    @GetMapping("/find/accountId")
    public ResponseEntity<User> findByAccountId(@PathVariable("id")Integer id){
        User user = service.findByAccountId( id);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
