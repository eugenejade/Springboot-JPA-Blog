package com.cos.blog.test;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 -> 응답(HTML)파일 
//@Controller 
//사용자가 요청 -> 응답(Data) 
@RestController
public class HttpControllerTest {
	
	public static final String TAG ="HttpControllerTest";
	//http://localhost:8000/blog/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest(Member m) {
		return "get 요청 " + m.getId() + "," + m.getUsername()+","+ m.getPassword()+","+m.getEmail(); 
	}
	
	//인터넷브라우저요청은 무조건get요청밖에 할수없다.
	//http://localhost:8080/http/get
	@GetMapping("/http/get")
	public String getTest(@RequestBody(required = false) Member m) {
		return "get 요청 "; 
	}
	@PostMapping("/http/post") //text/plain, application json
	public String PostTest(@RequestBody Member m) { //MessageConverter (스프링부트)
		return "post 요청 " +","+ m.getId() + "," + m.getUsername()+","+ m.getPassword()+","+m.getEmail(); 
	}
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청"+ m.getId() + "," + m.getUsername()+","+ m.getPassword()+","+m.getEmail(); 
	}
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete요청"; 
	}
}
