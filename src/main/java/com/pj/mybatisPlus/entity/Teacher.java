package com.pj.mybatisPlus.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (Teacher)表实体类
 *
 * @author cdl
 * @since 2021-06-20 10:07:02
 */
@SuppressWarnings("serial")
@Data
public class Teacher extends Model<Teacher> {

    private Integer id;

    private String name;

    List<Student> studentList;

}