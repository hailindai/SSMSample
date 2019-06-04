package com.dreamguard.service;

import org.springframework.stereotype.Service;

import com.dreamguard.anno.Priv;
import com.dreamguard.anno.PrivEnum;
import com.dreamguard.anno.Trans;
import com.dreamguard.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Override
	@Priv({ PrivEnum.OTHER, PrivEnum.USER, PrivEnum.ADMIN })
	@Trans
	public void registerUser(User user) {
		if (queryUser(user.getId()) != null) {//判断不存在
			System.out.println("UserService register " + user);//创建用户
//			int i=1/0;
		}else{
			throw new RuntimeException("用户已经存在");
		}
	}

	@Override
	@Priv({ PrivEnum.USER, PrivEnum.ADMIN })
	public void updateUser(User user) {
		System.out.println("UserService updateUser " + user);

	}

	@Override
	@Priv({ PrivEnum.ADMIN })
	public void deleteUser(int id) {
		System.out.println("UserService deleteUser " + id);

	}

	@Override
	@Priv({ PrivEnum.USER, PrivEnum.ADMIN })
	public User queryUser(int id) {
		// TODO Auto-generated method stub
		System.out.println("UserService queryUser " + id);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// int a = 1/0;
		return new User(1, "zs", "123", "123@qq.com");
	}

}
