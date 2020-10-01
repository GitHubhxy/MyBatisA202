package com.hxy.Dao;

import com.hxy.po.Student;

import java.util.List;

/**
 * @author HuXiaoYu
 * @create 2020/10/1-11:27
 */
public interface JsonDao {
    /**
     * 查询
     * @return
     */
    List<Student>selectAll();

    /**
     * 删除
     * @param stu_id
     * @return
     */
    int delete(int stu_id);
}
