package az.developia.compshopcavidhuseynzade.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import az.developia.compshopcavidhuseynzade.CompShopCavidHuseynzadeApplication;

public class ServletInitalizer  extends SpringBootServletInitializer{
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(CompShopCavidHuseynzadeApplication.class);
    }
}
