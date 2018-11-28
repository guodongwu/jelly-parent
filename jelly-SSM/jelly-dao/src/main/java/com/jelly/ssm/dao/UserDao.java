package com.jelly.ssm.dao;

import com.jelly.ssm.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 管理员用户 Mapper 接口
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
public interface UserDao extends BaseMapper<User,Integer> {

    public  User findUserByUserNameAndPassword(@Param(value = "userName") String userName,
                                               @Param(value = "password") String password);
    public  User findUserByUserName(@Param(value = "userName")String userName);

}
