package com.pj.mybatisPlus.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.pj.mybatisPlus.entity.Teacher;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * (Teacher)表数据库访问层
 *
 * @author cdl
 * @since 2021-06-20 10:07:02
 */
public interface TeacherDao extends BaseMapper<Teacher> {

    List<Teacher> teacherList();


    /**
     * 注释：
     *
     * @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = 1000
     * ResultSetType.FORWARD_ONLY 表示游标只向前滚动
     * fetchSize 每次获取量
     *
     * @ResultType(Teacher.class) 转换成返回实体类型
     *
     */
    @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = 1)
    @ResultType(Teacher.class)
    void geTeacherListBigData(ResultHandler<Teacher> handler);

}