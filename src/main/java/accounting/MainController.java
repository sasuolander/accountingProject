package accounting;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


	

@Configuration 
@ComponentScan
public class MainController extends SpringBootServletInitializer{
	
	private static Class<MainController> MainControllerClass = MainController.class;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainControllerClass, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainControllerClass);
   }
}



