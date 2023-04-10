package com.example.validate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum LocationTypeEnum {
    PROVINCE(new String[]{"tỉnh", "tỉnh.", "t.", "thành phố", "thành phố.", "tp.", ", việt nam", "\\`", "\\'"}),
    DISTRICT(new String[]{"quận 0", "quận", "q.", "thị xã", "tx.", "thị xã.", "huyện", "huyện.", "cư ",
            "thành phố", "thành phố.", "tp.", "h.", "\\`", "\\'"}),
    WARD(new String[]{"phường 0", "phường.", "xã", "xã.", "thị trấn", "thị trấn.", "cư ",
            "tt.", "f", "f.", "x.", "p.", "\\`", "\\'"});
    private static final Map<String, com.example.validate.LocationTypeEnum> map = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(m -> map.put(m.name(), m));
    }

    private final String[] value;

    LocationTypeEnum(String[] value) {
        this.value = value;
    }

    public static com.example.validate.LocationTypeEnum getRegexLocation(String name) {
        return map.get(name);
    }

    public String[] getvalue() {
        return value;
    }
}
