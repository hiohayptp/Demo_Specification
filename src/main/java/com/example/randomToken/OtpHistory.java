package com.example.randomToken;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "otp_history")
public class OtpHistory extends AbstractAuditingEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private OtpTypeEnum type;

    @Column(name = "code")
    private String code;
}
