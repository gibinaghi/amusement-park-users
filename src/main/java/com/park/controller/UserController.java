package com.park.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.park.service.UserService;

//crea, modifica, borra
@RestController
@RequestMapping("/V1/users")  //nombre del microservicio
public class UserController {
	
	//inyección normal
	@Autowired
	private UserService service; 
	
	@PostMapping("/test")
	public ResponseEntity<Void> test(){
		return ResponseEntity.ok().build();
	}
	
	//crear y guardar un usuario 
	@PostMapping
	public ResponseEntity<Void> createUser(@RequestBody User request){
		
		Integer id = service.create(request);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
		        .buildAndExpand(id).toUri();
		
		return ResponseEntity.created(location).build(); 
	}
	
	//obtener información
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable Integer userId){
		User response=service.getUser(userId);
		return ResponseEntity.ok(response);
	}


}
