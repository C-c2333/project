package com.pj.hutool;

public enum HuToolEnum {
    TEST1("type1"), TEST2("type2"), TEST3("type3");

    private HuToolEnum(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return this.type;
    }
}
