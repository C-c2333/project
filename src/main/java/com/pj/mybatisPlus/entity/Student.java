package com.pj.mybatisPlus.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (Studen)表实体类
 *
 * @author cdl
 * @since 2021-06-20 10:07:03
 */
@SuppressWarnings("serial")
@Data
public class Student extends Model<Student> {

    private Integer id;

    private String name;

    private Integer tid;

    private List<Teacher> teacherList;

    private Teacher teacher;
}