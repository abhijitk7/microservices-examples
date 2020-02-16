/**
 * 
 */
package com.kpit.bfs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kpit.bfs.IService.IUserService;
import com.kpit.bfs.model.Users;
import com.kpit.bfs.repository.UsersRepository;

/**
 * @author abhi
 *
 */
@Service
public class UserService implements IUserService{
	
	@Autowired
	private UsersRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Users createUser(Users user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		return this.repo.save(user);
	}

}
