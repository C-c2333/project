package com.pj.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pj.mybatisPlus.dao.StudentDao;
import com.pj.mybatisPlus.dao.StudentDao;
import com.pj.mybatisPlus.entity.Student;
import com.pj.mybatisPlus.entity.Student;
import com.pj.mybatisPlus.service.StudenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Studen)表服务实现类
 *
 * @author cdl
 * @since 2021-06-20 10:07:03
 */
@Service("studenService")
public class StdentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudenService {

    @Autowired
    StudentDao studenDao;

    @Override
    public List<Student> oneStuden() {
        List<Student> studens = studenDao.oneStuden();
        for (Student studen : studens) {
            System.err.println(studen);
        }
        System.err.println("---------------------------");
        List<Student> studenAndTeacher = studenDao.studenAndTeacher();
        for (Student studen : studenAndTeacher) {
            System.err.println(studen);
        }
        return null;
    }
}