package com.example.demo.service.Impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.specifition.ProductSpecification;
import com.example.demo.repository.specifition.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserMapper mapper;
    public List<User> findByName(String name){
        List<User> users = userRepository.findAll(UserSpecification.findUserByName(name));
        return users;
    }
    public List<User> findByNameLikeAndAge(String name, Integer age){
        List<User> users = userRepository.findAll(UserSpecification.findByNameLikeAndAge(name,age));
        return users;
    }
    public List<User> findByIdAndName(Integer id, String name){
        List<User> users = userRepository.findAll(UserSpecification.findByIdAndName(id,name));
        return users;
    }

    public UserDTO findUserAndProductByIdUser(Integer id){
        User user = null;
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()){
            user = optional.get();
        }
        UserDTO dto;
        dto = mapper.userToUserDto(user);
        List<Product> products =productRepository.findAll(ProductSpecification.findOrder(id));

        dto.setOrderProducts(user.getOrderProducts());
        dto.setProducts(products);
        return mapper.userToUserDto(user);
    }
    public List<UserDTO> findAll(){
        List<User> users = userRepository.findAll();
        return mapper.listUserToListUserDto(users);
     }

    public List<User> findByNameLike1(String name){
        Specification<User> nameLike = ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"),"%" + name + "%"));
        List<User> users = userRepository.findAll(nameLike);
        return users;
    }
    public User findByAccountId(Integer id){
        User user = userRepository.findByAccountId(id);
        return user;
    }
}
