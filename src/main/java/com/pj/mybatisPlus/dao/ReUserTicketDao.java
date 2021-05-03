package com.pj.mybatisPlus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pj.mybatisPlus.entity.ReUserTicket;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户体验券(ReUserTicket)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-02 10:16:35
 */
@Repository
public interface ReUserTicketDao extends BaseMapper<ReUserTicket> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReUserTicket queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ReUserTicket> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param reUserTicket 实例对象
     * @return 对象列表
     */
    List<ReUserTicket> queryAll(ReUserTicket reUserTicket);

    /**
     * 新增数据
     *
     * @param reUserTicket 实例对象
     * @return 影响行数
     */
    int insert(ReUserTicket reUserTicket);

    /**
     * 修改数据
     *
     * @param reUserTicket 实例对象
     * @return 影响行数
     */
    int update(ReUserTicket reUserTicket);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}