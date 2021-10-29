package az.developia.bookshoopinfgor.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import az.developia.bookshoopinfgor.BookshoopinfgorApplication;

public class ServletInitilazier  extends SpringBootServletInitializer{
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(BookshoopinfgorApplication.class);
    }
}
