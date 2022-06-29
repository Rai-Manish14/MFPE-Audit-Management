package com.mfpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mfpe.exception.ProjectManagerNotFoundException;
import com.mfpe.model.ProjectManagerDetails;
import com.mfpe.repository.ProjectManagerRepo;

@Service
public class ProjectManagerDetailsService implements UserDetailsService {

	@Autowired
	private ProjectManagerRepo projectManagerRepo;
	
	//This method is used to get the project manager details from the database
	public ProjectManagerDetails getProjectManagerByUserName(String username) throws ProjectManagerNotFoundException {
		//Here it is sending the username to the repository
		//and finding the data based on the username
		//If the user is found, It'll return the data
		//If the user is not found, it'll throw an error
		ProjectManagerDetails projectManagerDetails = null;
		projectManagerDetails = projectManagerRepo.getProjectManagerByUserName(username);
		if (projectManagerDetails == null) {
			throw new ProjectManagerNotFoundException("Given Project-Manager-Details does not exist in our Database!!");
		}
		return projectManagerDetails;
	}

	// this method returns the User object based on the username...
	// whose password will get checked with the password we provided in this User object..
	// if match --> authenticated , if not match --> user not authenticated

	@Override
	public ProjectManagerDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// it gets the ProjectManager using ProjectManagerService and
		// from there it gets the ProjecManagerDetails from ProjectManager using
		// ProjectManagerDetailsService...
		// which is then used in SecurityConfig
		ProjectManagerDetails projectManagerDetails = null;
		projectManagerDetails = getProjectManagerByUserName(username);
		if (projectManagerDetails != null) {
			projectManagerDetails = new ProjectManagerDetails(getProjectManagerByUserName(username));
		}

		return projectManagerDetails;
	}

}
