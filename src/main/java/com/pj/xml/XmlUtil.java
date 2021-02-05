package com.pj.xml;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @ClassName XmlUtil
 * @Author cdl
 * @Date 2021/1/22 11:33
 **/
@Slf4j
@Component
public class XmlUtil {

    /**
     * xml字符串转换成bean对象
     * root
     *  +
     *  + children1
     *     +
     *     + children2
     * 调用方式 xmlStrToBean(rootXmlStt | children1XmlStr | children2XmlStr , map<Xml节点名， rootBean | children1Bean | children2Bean>)
     * @param xmlStr   xml字符串
     * @param clazzMap 待转换的class包括对象属性的class
     * @return 转换后的对象
     */
    public Object xmlStrToBean(String xmlStr, Map<String, Class<?>> clazzMap) {
        Object obj = null;
        try {
            //将xml格式的字符串转换成Document对象
            Document doc = DocumentHelper.parseText(xmlStr);
            //获取根节点
            Element root = doc.getRootElement();
            //将map对象的数据转换成Bean对象
            obj = mapToBean(root, clazzMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 将Map对象通过反射机制转换成Bean对象
     *
     * @param clazzMap 待转换的class包括对象属性的class
     * @return 转换后的Bean对象
     * @throws Exception 异常
     */
    public Object mapToBean(Element root, Map<String, Class<?>> clazzMap) throws Exception {
        //获取根节点下的所有元素
        val children = root.elements();

        Map<String, Object> map = new HashMap<>(16);
        if (children != null && children.size() > 0) {
            for (int i = 0; i < children.size(); i++) {
                Element child = (Element) children.get(i);
                if (child.isTextOnly()) {
                    map.put(child.getName(), child.getTextTrim());
                }
            }
        }

        val clazz = clazzMap.get(root.getName());
        Object obj = clazz.newInstance();
        if (!map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String propertyName = entry.getKey();
                Object value = entry.getValue();
                String setMethodName = "set"
                        + propertyName.substring(0, 1).toUpperCase()
                        + propertyName.substring(1);
                log.debug("propertyName:{}", propertyName.substring(1));
                Field field = getClassField(clazz, propertyName);
                if (field == null) {
                    continue;
                }
                val fieldTypeClass = field.getType();
                value = convertValType(value, fieldTypeClass);
                clazz.getMethod(setMethodName, field.getType()).invoke(obj, value);
            }
        }
        return obj;

    }

    /**
     * 将Object类型的值，转换成bean对象属性里对应的类型值
     *
     * @param value          Object对象值
     * @param fieldTypeClass 属性的类型
     * @return 转换后的值
     */
    private static Object convertValType(Object value, Class fieldTypeClass) {
        Object retVal = null;
        if (Long.class.getName().equals(fieldTypeClass.getName())
                || long.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Long.parseLong(value.toString());
        } else if (Integer.class.getName().equals(fieldTypeClass.getName())
                || int.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Integer.parseInt(value.toString());
        } else if (Float.class.getName().equals(fieldTypeClass.getName())
                || float.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Float.parseFloat(value.toString());
        } else if (Double.class.getName().equals(fieldTypeClass.getName())
                || double.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Double.parseDouble(value.toString());
        } else {
            retVal = value;
        }
        return retVal;
    }

    /**
     * 获取指定字段名称查找在class中的对应的Field对象(包括查找父类)
     *
     * @param clazz     指定的class
     * @param fieldName 字段名称
     * @return Field对象
     */
    private static Field getClassField(Class<?> clazz, String fieldName) {
        if (Object.class.getName().equals(clazz.getName())) {
            return null;
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        return null;
    }
}
