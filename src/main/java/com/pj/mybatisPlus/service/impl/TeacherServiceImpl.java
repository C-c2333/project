package com.pj.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pj.mybatisPlus.dao.TeacherDao;
import com.pj.mybatisPlus.entity.Teacher;
import com.pj.mybatisPlus.service.TeacherService;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    @Override
    public List<Teacher> geTeacherListBigData() {
        List<Teacher> appUserEntities = new ArrayList<>();
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id,name");
        queryWrapper.eq("id", 1);
        //流式条件查询
        this.baseMapper.geTeacherListBigData(
                resultContext -> {
                    System.err.println(new Date() +""+resultContext.getResultObject());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Optional.ofNullable(resultContext.getResultObject()).ifPresent(appUserEntities::add);
                });
        return appUserEntities;

    }
}