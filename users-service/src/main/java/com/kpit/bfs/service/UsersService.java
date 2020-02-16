/**
 * 
 */
package com.kpit.bfs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpit.bfs.IService.IUserService;
import com.kpit.bfs.model.Users;
import com.kpit.bfs.repository.UsersRepository;

/**
 * @author abhi
 *
 */
@Service
public class UsersService implements IUserService{
	
	@Autowired
	private UsersRepository repo;

	@Override
	public Users createUser(Users user) {
		
		return this.repo.save(user);
	}

}
