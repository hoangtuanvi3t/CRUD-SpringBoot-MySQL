package basics.controller;

import basics.model.User;
import basics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/user") // This means URL's start with /user (after Application path)
public class UserController {

    @Autowired
	private UserService userService;

	@GetMapping(path="/add") // Map ONLY GET Requests
	public String addNewUser (@RequestParam(required = false) String name, @RequestParam String email) {

		// @RequestParam means it is a parameter from the GET or POST request
		return userService.addNewUser(name, email);
	}

	@GetMapping(path="/all")
	public List<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userService.findAll();
	}

	@PutMapping(path = "/update/{id}")
    public String updateUser (@RequestBody User user, @PathVariable int id) {
	    return userService.updateUser(user, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteUser (@PathVariable int id) {
	    return userService.deleteUser(id);
    }
}