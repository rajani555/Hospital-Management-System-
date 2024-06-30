package com.vgnit.medical.service;

import com.vgnit.medical.dto.UserDto;
import com.vgnit.medical.entity.User;

public interface UserService 
{
	User save(UserDto userDto);

	boolean checkEmail(String email);

}
