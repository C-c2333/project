package com.pj.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pj.mybatisPlus.dao.TeacherDao;
import com.pj.mybatisPlus.entity.Teacher;
import com.pj.mybatisPlus.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Teacher)表服务实现类
 *
 * @author cdl
 * @since 2021-06-20 10:07:02
 */
@Service("teacherService")
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, Teacher> implements TeacherService {

    @Autowired
    TeacherDao teacherDao;
    @Override
    public List<Teacher> teacherList() {
        List<Teacher> teachers = teacherDao.teacherList();
        for (Teacher teacher : teachers) {
            System.err.println(teacher);
        }

        return null;
    }
}