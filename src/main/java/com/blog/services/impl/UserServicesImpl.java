package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.playloads.UserDto;
import com.blog.repositories.UserRepos;
import com.blog.services.UserService;

@Service
public class UserServicesImpl implements UserService {
	@Autowired
	private UserRepos userRepos;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.userDtoToUser(userDto);
		User saveUser=this.userRepos.save(user);
		
		return this.userToUserDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
	User user=this.userRepos.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
	user.setName(userDto.getName());
	user.setEmail(userDto.getEmail());
	user.setPasswords(userDto.getPassword());
	user.setAbout(userDto.getAbout());
	
	User updatedUser=this.userRepos.save(user);
	UserDto userDto1=this.userToUserDto(updatedUser);
	
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user=this.userRepos.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		

		return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users=this.userRepos.findAll();
		List<UserDto> userDto=users.stream().map(user->this.userToUserDto(user)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepos.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		this.userRepos.delete(user);

	}
	public User userDtoToUser(UserDto userDto) {
		//mapping tha class
		User user=this.modelMapper.map(userDto,User.class);
		
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return user;
	}
	public UserDto userToUserDto(User user) {
		//mapping tha class
		UserDto userDto=this.modelMapper.map(user,UserDto.class);

		return userDto;
	}

}
