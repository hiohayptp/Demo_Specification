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
@Table(name = "bnpl_partner_account")
public class PartnerAccount {

    private String id;
    @Column(name = "bnpl_user_id")
    private String bnplUserId;
    @Column(name = "tokenization")
    private String tokenization;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "partner_name")
    private String partnerName;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "client_secret")
    private String clientSecret;
    @Column(name = "locked")
    private String locked;
    @Column(name = "created_date")
    private String createdDate;
    @Column(name = "last_modified_date")
    private String lastModifiedDate;

}
