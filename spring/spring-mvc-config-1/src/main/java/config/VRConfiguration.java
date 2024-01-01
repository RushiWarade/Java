package config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
public class VRConfiguration {

    @Bean
    public InternalResourceViewResolver getResolver(){
    InternalResourceViewResolver ivr = new InternalResourceViewResolver();

    ivr.setPrefix("/webapp/");
    ivr.setSuffix(".html");
    return ivr;
    }
}
