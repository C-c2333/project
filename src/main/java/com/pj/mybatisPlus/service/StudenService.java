package com.pj.mybatisPlus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pj.mybatisPlus.entity.Student;

import java.util.List;

/**
 * (Studen)表服务接口
 *
 * @author cdl
 * @since 2021-06-20 10:07:03
 */
public interface StudenService extends IService<Student> {

    List<Student> oneStuden();
}