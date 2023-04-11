package com.example.onboard;

import org.apache.commons.lang.ObjectUtils;

public class Run {
    public static void main(String[] args) {
        int a ;
        if (ScreenOnboardEnum.REGISTER_ACCOUNT.getIndex() != 0){
            System.out.println("REGISTER_ACCOUNT: " + ScreenOnboardEnum.REGISTER_ACCOUNT.getIndex());
        }if (ScreenOnboardEnum.VERIFY_EKYC.getIndex() != 0){
            System.out.println("VERIFY_EKYC: " + ScreenOnboardEnum.VERIFY_EKYC.getIndex());
        }if (ScreenOnboardEnum.UPDATE_CASE.getIndex() != 0){
            System.out.println("UPDATE_CASE: " + ScreenOnboardEnum.UPDATE_CASE.getIndex());
        }if (ScreenOnboardEnum.CREATE_LOAN.getIndex() != 0){
            System.out.println("CREATE_LOAN: " + ScreenOnboardEnum.CREATE_LOAN.getIndex());
        }if (ScreenOnboardEnum.SIGN_E_CONTRACT.getIndex() != 0){
            System.out.println("SIGN_E_CONTRACT: " + ScreenOnboardEnum.SIGN_E_CONTRACT.getIndex());
        }if (ScreenOnboardEnum.UPDATE_PASSWORD_AFC.getIndex() != 0){
            System.out.println("UPDATE_PASSWORD_AFC: " + ScreenOnboardEnum.UPDATE_PASSWORD_AFC.getIndex());
        }if (ScreenOnboardEnum.COMPLETE_ONBOARDING.getIndex() != 0){
            System.out.println("COMPLETE_ONBOARDING: " + ScreenOnboardEnum.COMPLETE_ONBOARDING.getIndex());
        }if (ScreenOnboardEnum.LOCK_ACCOUNT.getIndex() != 0){
            System.out.println("LOCK_ACCOUNT: " + ScreenOnboardEnum.LOCK_ACCOUNT.getIndex());
        }
    }
}
