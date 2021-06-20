package com.pj.mybatisPlus.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pj.mybatisPlus.entity.Teacher;
import com.pj.mybatisPlus.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Teacher)表控制层
 *
 * @author cdl
 * @since 2021-06-20 10:07:03
 */
@RestController
@RequestMapping("teacher")
public class TeacherController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param teacher 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Teacher> page, Teacher teacher) {
        return success(this.teacherService.page(page, new QueryWrapper<>(teacher)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.teacherService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param teacher 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Teacher teacher) {
        return success(this.teacherService.save(teacher));
    }

    /**
     * 修改数据
     *
     * @param teacher 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Teacher teacher) {
        return success(this.teacherService.updateById(teacher));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.teacherService.removeByIds(idList));
    }
}