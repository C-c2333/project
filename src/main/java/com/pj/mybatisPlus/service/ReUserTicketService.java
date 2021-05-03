package com.pj.mybatisPlus.service;

import com.pj.mybatisPlus.entity.ReUserTicket;
import java.util.List;

/**
 * 用户体验券(ReUserTicket)表服务接口
 *
 * @author makejava
 * @since 2021-05-02 10:16:36
 */
public interface ReUserTicketService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReUserTicket queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ReUserTicket> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param reUserTicket 实例对象
     * @return 实例对象
     */
    ReUserTicket insert(ReUserTicket reUserTicket);

    /**
     * 修改数据
     *
     * @param reUserTicket 实例对象
     * @return 实例对象
     */
    ReUserTicket update(ReUserTicket reUserTicket);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}