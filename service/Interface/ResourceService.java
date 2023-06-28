package com.pennant.prodmtr.service.Interface;

import java.util.List;

import com.pennant.prodmtr.model.Dto.ResourceFilter;
import com.pennant.prodmtr.model.Dto.UserDto;
import com.pennant.prodmtr.model.Entity.User;
import com.pennant.prodmtr.model.Input.UserInput;

public interface ResourceService {
	List<UserDto> getAllResources();

	List<UserDto> filterResources(ResourceFilter resourceFilter);

	User getResourceByDisplayName(String displayName);

	void addUser(UserInput userInput);

	void save(User resource);

	List<User> getAllProjManagers();

	List<User> getUsersByProjectId(int projectId);

	User getResourceById(int userId);

	User getResourceByUserId(int userid);

	// Other methods for resource-related operations
}
