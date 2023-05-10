package complotback.complotback.controllers.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController{
    
	@GetMapping("/test")
    public ResponseEntity<String> test() {
    	return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}