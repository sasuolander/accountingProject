

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

	
@ComponentScan(basePackages="accounting")
@SpringBootApplication
public class MainController extends SpringBootServletInitializer{
	
	private static Class<MainController> MainControllerClass = MainController.class;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainControllerClass, args);
	}
}



