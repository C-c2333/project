package com.pj.mybatisPlus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pj.mybatisPlus.entity.Student;
import com.pj.mybatisPlus.entity.Student;

import java.util.List;

/**
 * (Studen)表数据库访问层
 *
 * @author cdl
 * @since 2021-06-20 10:07:03
 */
public interface StudentDao extends BaseMapper<Student> {
    List<Student> oneStuden();
    List<Student> studenAndTeacher();
}