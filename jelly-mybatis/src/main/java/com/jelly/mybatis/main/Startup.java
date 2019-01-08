package com.jelly.mybatis.main;

import com.jelly.mybatis.mapper.FileMapper;
import com.jelly.mybatis.mapper.RoleMapper;
import com.jelly.mybatis.mapper.StudentMapper;
import com.jelly.mybatis.mapper.UserMapper;
import com.jelly.mybatis.pojo.*;
import com.jelly.mybatis.type.Sex;
import com.jelly.mybatis.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class Startup {
    public static void main(String[] args) {
        SqlSession sqlSession=null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
           /* Role role = new Role();
            role.setNote("testNote");
            role.setRoleName("testName");
            roleMapper.insertRole(role);
            roleMapper.deleteRole((long) 1);*/
            Role role1= roleMapper.getRole((long) 2);
            System.out.println(role1.toString());
            sqlSession.commit();
        }catch (Exception ex){
            sqlSession.rollback();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }

    }

    @Test
    public  void testEnumOrdinalTypeHandler(){
        SqlSession sqlSession=null;

        try
        {
            sqlSession=SqlSessionFactoryUtil.openSqlSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            User user =new User();
            user.setUserName("test");
            user.setCnname("老王");
            user.setMobile("13511111112");
            user.setSex(Sex.MALE);
            user.setEmail("123@12.com");
            user.setNote("aaaa");
            user.setBirthday(new Date());
            userMapper.insertUser(user);
            System.out.println(user);
            sqlSession.commit();
            System.out.println(user);

        }catch (Exception ex){
            sqlSession.rollback();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    @Test
    public  void testMap(){
        SqlSession sqlSession=null;

        try
        {
            sqlSession=SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
            Map<String,String> map=new HashMap<>();
            map.put("roleName","test");
            List<Role> roles= roleMapper.findRoleByMap(map);
            roles.forEach(s-> System.out.println(s));

            List<Role> roles1=roleMapper.findRoleByAnnotation("test");
            roles1.forEach(s-> System.out.println(s));
            Role roleParam=new Role();
            roleParam.setRoleName("test");
            List<Role> roles2=roleMapper.findByRole(roleParam);
            roles2.forEach(s-> System.out.println("role2:"+s));
        }catch (Exception ex){
            sqlSession.rollback();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    @Test
    public void testStudent(){
        SqlSession sqlSession=null;

        try
        {
            sqlSession=SqlSessionFactoryUtil.openSqlSession();
            StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
            Student stu=studentMapper.getStudent(1);

            System.out.println(stu);
            System.out.println(stu.getStudentSelfCard());
        }catch (Exception ex){
            sqlSession.rollback();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }

    }

    @Test
    public void testCollection(){
           SqlSession sqlSession=null;
           try
           {
               sqlSession=SqlSessionFactoryUtil.openSqlSession();
               StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
               Student student=studentMapper.getStudent(1);
               System.out.println(student);
               StudentLectureBean studentLectureBean=student.getStudentLectures().get(0);
               LectureBean lectureBean=studentLectureBean.getLecture();
               System.out.println(lectureBean);
               if(student.getSex()==Sex.MALE){
                   MaleStudentBean stu= (MaleStudentBean) student;

                   System.out.println(stu.getStudentHealthMaleBeanList().get(0));
               }



           }catch(Exception ex){
               sqlSession.rollback();
           }finally {
               if(sqlSession!=null){
                   sqlSession.close();
               }
           }

    }

    @Test
    public  void testFile() throws IOException {
       FileInputStream in=null;
       SqlSession sqlSession=null;
       try {
           File f=new File("/home/wu/桌面/跟我学shiro.pdf");
           in=new FileInputStream(f);
           byte [] bytes=new byte[(int) f.length()];
           in.read(bytes);
           FileBean fileBean=new FileBean();
           fileBean.setFile(bytes);
           sqlSession=SqlSessionFactoryUtil.openSqlSession();
           FileMapper fileMapper= sqlSession.getMapper(FileMapper.class);
           fileMapper.insertFile(fileBean);
           System.out.println(fileBean);
           sqlSession.commit();
           FileBean fileBean1= fileMapper.getFile(fileBean.getId());
           System.out.println(fileBean1);
       }catch (Exception e) {
           sqlSession.rollback();
           e.printStackTrace();

       }finally {
           in.close();
           if(sqlSession!=null){
               sqlSession.close();
           }
       }



    }

    @Test
    public  void testCallABLE(){
        SqlSession sqlSession=null;
        try
        {
            sqlSession=SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
            int result=0;
            Map<String,Object> map=new HashMap<>();
            map.put("roleName","test");
            map.put("total",0);
            map.put("exec_date","");
            roleMapper.count(map);
            System.out.println(map.get("total"));
            System.out.println(map.get("exec_date"));

        }catch(Exception ex){
            sqlSession.rollback();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    @Test
    public  void testInsertList(){
        SqlSession sqlSession=null;

        try
        {
            sqlSession=SqlSessionFactoryUtil.openSqlSession(true);
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            List<User> users=new ArrayList<>();
            for (int i=0;i<10;i++){
                User user=new User();
                user.setUserName("卡卡"+i);
                user.setCnname("aaa"+i);
                user.setBirthday(new Date());
                user.setNote("testNote"+i);
                user.setEmail("email"+i);
                user.setMobile("1351817181"+i);
                users.add(user);
            }
            userMapper.insertUserList(users);
            sqlSession.commit();

        }catch (Exception ex){
            sqlSession.rollback();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
