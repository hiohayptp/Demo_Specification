package com.example.randomToken;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor

public class GetOtpNotificationServiceImpl{
    private final OtpHistoryRepository otpHistoryRepository;

    private final String URL = "jdbc:postgresql://uat-rds-postgres-common-apps-db.ccjec86kuais.ap-southeast-1.rds.amazonaws.com:5432/ekyc_notification_service";
    private final String SYSTEM = "onboarding-bnpl";
    private final String OTP = "otp";


    public String getOtp(String phoneNumber) throws SQLException {
        String user = "devops";
        String pwd = getPassword();
        Connection conn = null;
        String otp = "";
            try {
                conn = DriverManager.getConnection(URL + "?user=" + user + "&password=" + pwd);
                otp = query(conn, phoneNumber);
            } catch (Exception e) {
                log.error("OtpPartnerService.getOtpPartner error: " + e.getMessage());
            } finally {
                if (!Objects.isNull(conn)) {
                    conn.close();
                }
            }
            return otp;
    }

    public String getOtpV2(String phoneNumber, OtpTypeEnum type) {
        PageRequest pageRequest = PageRequest.of(0, 1, Sort.by("createdDate").descending());
        List<OtpHistory> otpHistories = otpHistoryRepository.findAll(OtpHistorySpecification.findByPhoneNumberOrTransactionId(phoneNumber, type), pageRequest).getContent();
        if (!otpHistories.isEmpty() &&   otpHistories.get(0) == null) {
            return otpHistories.get(0).getCode();
        }
        return null;
    }

    private String query(Connection connection, String phoneNumber) throws SQLException {
        PreparedStatement preparedStatement = null;
        String query = "SELECT otp FROM OTP WHERE PHONE_NUMBER = ? AND CREATED_BY = ? ORDER BY CREATED_DATE DESC LIMIT 1";
        String otp = "";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setString(2, SYSTEM);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                otp = rs.getString(OTP);
            }
        } catch (Exception e) {
            log.error("OtpPartnerService.query error: " + e.getMessage());
        } finally {
            if (!Objects.isNull(preparedStatement)) {
                preparedStatement.close();
            }
        }
        return otp;
    }


    private String getPassword() {
        return "9pzMQ96jUaw2";
    }
}
