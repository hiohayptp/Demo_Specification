package com.example.relattionship;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="bnpl_random_code")
public class RandomCode {
    @Column(name = "id")
    private String id;
    @Column(name = "code")
    private String code;
}
