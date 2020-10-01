package com.hxy.Dao;

import com.hxy.po.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author HuXiaoYu
 * @create 2020/10/1-8:53
 */
public interface StudentDao {
    /**
     * 查询全部
     * @return
     */
    @Select("select * from student")
    @Results(id="jsonresults",value = {
            @Result(id = true,property = "id",column = "stu_id"),
            @Result(property = "name",column = "stu_name"),
            @Result(property = "sex",column = "stu_sex")

    })
    List<Student>selectAll();

    /**
     * 根据id查询
     * @return
     */
    @Select("select * from student where stu_id=#{id}")
    Student selectOne(int stu_id);

    /**
     * 增加一项数据
     * @param student
     * @return
     */
    @Insert("insert into student(stu_name,stu_sex)values (#{name},#{sex})")
    int insert(Student student);

    /**
     * 删除
     * @param stu_id
     * @return
     */
    @Delete("delete from student where stu_id=#{id}")
    int delete(int stu_id);

    /**
     * 修改
     * @param student
     * @return
     */
    @Update("update student set  stu_name=#{stu_name},stu_sex=#{sex} where stu_id=#{id}")
    int update(Student student);

}
