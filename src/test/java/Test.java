import com.hxy.Dao.StudentDao;
import com.hxy.po.Student;
import com.sun.org.apache.bcel.internal.generic.NEW;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author HuXiaoYu
 * @create 2020/10/1-9:03
 */
public class Test {
    private  InputStream is;
    private  SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private StudentDao studentDao;
    @Before
    public void before() throws IOException {
        //1.记载mybatis的配置文件
         is= Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建SqlSessionFactory工厂
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.生产sqlSession  数据会话对象
         sqlSession = sqlSessionFactory.openSession(true);
        //4.操作数据库的各种  增删改查工作
       studentDao=sqlSession.getMapper(StudentDao.class);
    }
        @org.junit.Test
    public void TestALL() throws IOException {
            studentDao.selectAll().forEach(System.out::println);
          /*  //4.1查询全部操作
       List<Student>list=sqlSession.selectList("selectAll");
        for (Student student : list) {
            System.out.println(student);
        }*/
      //4.2根据id查询
    }
    @org.junit.Test
    public void TestOne(){
        Student student = studentDao.selectOne(7);
        System.out.println("Student:"+student);
    }
    //增加
    @org.junit.Test
    public void insertTest(){
        Student student=new Student();
        student.setName("李四");
        student.setSex("男");
        int insert = studentDao.insert(student);
        System.out.println("insert = " + insert);
    }
    //删除
    @org.junit.Test
    public void deleteTest(){
        int delete = studentDao.delete(8);
        System.out.println("delete = " + delete);

    }
    //修改
    @org.junit.Test
    public void updateTest(){
        Student student= new Student();
        student.setSex("男");
        student.setId(2);
        student.setName("aay");
        int update = studentDao.update(student);
        System.out.println("update = " + update);
    }
}
