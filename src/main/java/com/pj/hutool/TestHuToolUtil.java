package com.pj.hutool;

import cn.hutool.*;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.StrFormatter;
import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.security.krb5.internal.crypto.Des;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Test
public class TestHuToolUtil {


    public void test() {
        List<String> names = EnumUtil.getNames(HuToolEnum.class);
        System.err.println(names.toString());

        List<Object> types = EnumUtil.getFieldValues(HuToolEnum.class, "type");
        System.err.println(types.toString());
        Map<String,HuToolEnum> enumMap = EnumUtil.getEnumMap(HuToolEnum.class);
        System.err.println(enumMap);

//        DesensitizedUtil.mobilePhone("18049531999");
        String hide = StrUtil.hide("18049531999", 4, 8);
        System.err.println(hide);

        String str = "我的{}，{}";

        String result1 = StrFormatter.format(str, "a", "b");
        System.err.println(result1);

        HashMap<Object, Object> objectObjectHashMap = MapUtil.newHashMap();
    }
}
