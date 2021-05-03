package com.pj.mybatisPlus.controller;

import com.pj.mybatisPlus.entity.ReUserTicket;
import com.pj.mybatisPlus.service.ReUserTicketService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户体验券(ReUserTicket)表控制层
 *
 * @author makejava
 * @since 2021-05-02 10:16:37
 */
@RestController
@RequestMapping("reUserTicket")
public class ReUserTicketController {
    /**
     * 服务对象
     */
    @Resource
    private ReUserTicketService reUserTicketService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ReUserTicket selectOne(Integer id) {
        return this.reUserTicketService.queryById(id);
    }

}