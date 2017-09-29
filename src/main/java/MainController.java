

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@RestController
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MainController {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainController.class, args);
	}

	
	public void configuration(){
		
	}


}



