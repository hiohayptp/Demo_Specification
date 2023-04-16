package com.example.randomToken;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OtpHistoryRepository extends JpaRepository<OtpHistory, String> , JpaSpecificationExecutor<OtpHistory> {

}
