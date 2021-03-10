package com.pj.xml;

import lombok.Data;

import java.util.List;

/**
 *@ClassName testEnti
 *@Description TODO
 *@Author cdl
 *@Date 2021/2/5 14:32
 **/
@Data
public class test {
    private String name;
    private Integer age;
    private String phone;

    List<child> childs;
}
