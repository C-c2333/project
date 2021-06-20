package com.pj;

import com.pj.mybatisPlus.entity.Teacher;
import com.pj.mybatisPlus.service.StudenService;
import com.pj.mybatisPlus.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectApplicationTests {

    @Autowired
    StudenService studenService;
    @Autowired
    TeacherService teacherService;

    @Test
    void contextLoads() {
        studenService.oneStuden();
        teacherService.teacherList();
    }

}
