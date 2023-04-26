package com.example.checkValidate;

import javax.validation.constraints.Pattern;

public class student {
    @Pattern(regexp = "\\b([0-9]{10})\\b")
    private String mssv;
    private String name;

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public student(String mssv, String name) {
        this.mssv = mssv;
        this.name = name;
    }
}
