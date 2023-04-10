package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account implements Serializable{
    @Id
    @Column(name = "account_id")
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "pass_word")
    private String passWord;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "account_id")
    private User user;

}
