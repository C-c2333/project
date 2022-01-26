package com.pj.stream;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Test
public class testTree {
    public void test() {
        Date s = null;
        String createdOn1 = DateUtil.format(s, "yyyy-MM-dd");
        String commitTime1 = DateUtil.format(new Date(), "yyyy-MM-dd");
        if (createdOn1.equals(commitTime1)) {
            System.err.println(111);
        }
    /*    String result2 = HttpRequest.post("https://app2.gxgentle.com:28888/common/service-om/online-marketing/api/wx/userPortrait/userPortrait")
                .body("{\n" +
                        "    \"encrypt\": \"131355b67b77b7b660712518610b13c7d70384b69b55fe020\",\n" +
                        "    \"params\": {\n" +
                        "        \"city\": \"beihai\",\n" +
                        "        \"commitTime\": 1620912649000,\n" +
                        "        \"unitId\": \"5637462352\",\n" +
                        "        \"solutionType\": \"信息流推广\",\n" +
                        "        \"unitName\": \"ocpc二阶-意图词\",\n" +
                        "        \"url\": \"https://qianhu.wejianzhan.com/site/qianhu.wejianzhan.com/7a321fdb-0fd8-4cfb-ab11-40b36cee2fe4\",\n" +
                        "        \"cluePhoneNumber\": \"17731343392\",\n" +
                        "        \"groupName\": \"冠山海\",\n" +
                        "        \"phone\": \"17731343392\",\n" +
                        "        \"name\": \"北部湾\",\n" +
                        "        \"flowChannelName\": \"信息流推广\"\n" +
                        "    }\n" +
                        "}")
                .execute().body();
        System.err.println(result2);*/
        /*
        //模拟从数据库查询出来
        List<Menu> menus = Arrays.asList(
                new Menu(1, "根节点", 0),
                new Menu(13, "根节点13", 0),
                new Menu(14, "根节点14", 13),
                new Menu(15, "根节点15", 14),
                new Menu(2, "子节点1", 1),
                new Menu(3, "子节点1.1", 2),
                new Menu(4, "子节点1.2", 2),
                new Menu(5, "根节点1.3", 2),
                new Menu(6, "根节点2", 1),
                new Menu(7, "根节点2.1", 6),
                new Menu(8, "根节点2.2", 6),
                new Menu(9, "根节点2.2.1", 7),
                new Menu(10, "根节点2.2.2", 7),
                new Menu(11, "根节点3", 1),
                new Menu(12, "根节点3.1", 11)
        );

        //获取父节点
        List<Menu> collect = menus.stream().filter(m -> m.getParentId() == 0).map(
                (m) -> {
                    m.setChildList(getChildrens(m, menus));
                    return m;
                }
        ).collect(Collectors.toList());
        System.out.println("-------转json输出结果-------");
        System.out.println(JSON.toJSON(collect));*/
    }

    /**
     * 递归查询子节点
     *
     * @param root 根节点
     * @param all  所有节点
     * @return 根节点信息
     */
    private List<Menu> getChildrens(Menu root, List<Menu> all) {
        List<Menu> children = all.stream().filter(m -> {
            return Objects.equals(m.getParentId(), root.getId());
        }).map(
                (m) -> {
                    m.setChildList(getChildrens(m, all));
                    return m;
                }
        ).collect(Collectors.toList());
        return children;
    }


}
