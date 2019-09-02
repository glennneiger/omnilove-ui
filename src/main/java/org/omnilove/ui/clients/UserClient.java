package org.omnilove.ui.clients;


import com.sun.deploy.net.HttpResponse;
import org.omnilove.ui.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Service
@FeignClient(name = "userClient", url = "http://localhost:8090/user")
	public interface UserClient {

		@RequestMapping(method = RequestMethod.GET, value = "/all")
		List<User> getAllUsers();

		@RequestMapping(method = RequestMethod.GET, value = "/user/{userId}", produces = "application/json")
		User getUserById(@PathVariable("userId") Long postId);

		@RequestMapping(method = RequestMethod.POST, value = "/register", produces = "application/json")
		HttpResponse registerUser(@RequestParam String username,
	                              @RequestParam String firstName,
	                              @RequestParam String name,
	                              @RequestParam String motivation,
	                              @RequestParam String email,
	                              @RequestParam LocalDate birthday);


}


	//registrataaion

	//update

	//delete
