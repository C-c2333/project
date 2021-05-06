package com.pj.mybatisPlus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.pj.mybatisPlus.entity.ReUserTicket;
import com.pj.mybatisPlus.dao.ReUserTicketDao;
import com.pj.mybatisPlus.service.ReUserTicketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户体验券(ReUserTicket)表服务实现类
 *
 * @author makejava
 * @since 2021-05-02 10:16:36
 */
@Service("reUserTicketService")
public class ReUserTicketServiceImpl  implements ReUserTicketService {
    @Resource
    private ReUserTicketDao reUserTicketDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ReUserTicket queryById(Integer id) {
        ReUserTicket reUserTicket = reUserTicketDao.selectById(653);
        return this.reUserTicketDao.queryById(653);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ReUserTicket> queryAllByLimit(int offset, int limit) {
        return this.reUserTicketDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param reUserTicket 实例对象
     * @return 实例对象
     */
    @Override
    public ReUserTicket insert(ReUserTicket reUserTicket) {
        this.reUserTicketDao.insert(reUserTicket);
        return reUserTicket;
    }

    /**
     * 修改数据
     *
     * @param reUserTicket 实例对象
     * @return 实例对象
     */
    @Override
    public ReUserTicket update(ReUserTicket reUserTicket) {
        this.reUserTicketDao.update(reUserTicket);
        return this.queryById(reUserTicket.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.reUserTicketDao.deleteById(id) > 0;
    }
}