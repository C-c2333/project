package com.pj.mybatisPlus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pj.mybatisPlus.entity.Teacher;

import java.util.List;

/**
 * (Teacher)表服务接口
 *
 * @author cdl
 * @since 2021-06-20 10:07:02
 */
public interface TeacherService extends IService<Teacher> {

    List<Teacher> teacherList();

}