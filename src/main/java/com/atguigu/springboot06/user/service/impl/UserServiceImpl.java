package com.atguigu.springboot06.user.service.impl;

import com.atguigu.springboot06.user.beans.User;
import com.atguigu.springboot06.user.mapper.UserDao;
import com.atguigu.springboot06.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Dn
 * @since 2019-03-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
