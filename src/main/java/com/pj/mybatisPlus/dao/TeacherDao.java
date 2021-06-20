package com.pj.mybatisPlus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pj.mybatisPlus.entity.Teacher;

import java.util.List;

/**
 * (Teacher)表数据库访问层
 *
 * @author cdl
 * @since 2021-06-20 10:07:02
 */
public interface TeacherDao extends BaseMapper<Teacher> {

    List<Teacher> teacherList();

}