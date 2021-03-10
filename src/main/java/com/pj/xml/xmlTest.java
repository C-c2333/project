package com.pj.xml;

import cn.hutool.core.util.ReUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName xmlTest
 * @Description TODO
 * @Author cdl
 * @Date 2021/2/5 14:33
 **/
@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("xmlTest")
public class xmlTest {
    XmlUtil xmlUtil;

    @GetMapping
    public void test(String xml) {
        Map<String, Class<?>> oom = new HashMap<>(1);
        oom.put("test", test.class);
        oom.put("ch", chEntity.class);
        Object o = xmlUtil.xmlStrToBean(xml, oom);
        System.err.println(o);
    }

    @GetMapping("testXmlMapper")
    public void testXmlMapper(String xml) {
        try {
            test testEntity = xmlMapper().readValue(xml, test.class);
            System.err.println(testEntity.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static XmlMapper xmlMapper(){
        System.err.println("初始化");
        return new XmlMapper();
    }


}
