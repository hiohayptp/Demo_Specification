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
@Table(name = "bnpl_account_code")
public class AccountCode {
    @Column(name = "partner_account_id")
    private String partnerAccountId;
    @Column(name = "random_code_id")
    private String randomCodeId;
}
