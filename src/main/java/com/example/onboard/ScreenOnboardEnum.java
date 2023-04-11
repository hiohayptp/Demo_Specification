package com.example.onboard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum ScreenOnboardEnum {

    REGISTER_ACCOUNT(1),
    VERIFY_EKYC(2),
    UPDATE_CASE(3),
    CREATE_LOAN(4),
    SIGN_E_CONTRACT(5),
    UPDATE_PASSWORD_AFC(98),
    COMPLETE_ONBOARDING(99),
    LOCK_ACCOUNT(100); /* reject account */

    private static final Map<String, ScreenOnboardEnum> map = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(m -> map.put(m.name(), m));
    }

    private final int index;

    ScreenOnboardEnum(int index) {
        this.index = index;
    }

    public static ScreenOnboardEnum getScreen(String screenProcess) {
        return map.get(screenProcess);
    }

    public int getIndex() {
        return index;
    }
}
