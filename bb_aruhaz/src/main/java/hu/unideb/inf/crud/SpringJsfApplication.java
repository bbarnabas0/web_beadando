package hu.unideb.inf.crud;

import com.sun.faces.config.ConfigureListener;
import jakarta.faces.webapp.FacesServlet;
import jakarta.servlet.Servlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJsfApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringJsfApplication.class, args);
    }

    /*
     * Below sets up the Faces Servlet for Spring Boot
     */
    @Bean
    public FacesServlet facesServlet() {
        return new FacesServlet();
    }

    @Bean
    public ServletRegistrationBean<Servlet> facesServletRegistration() {
        ServletRegistrationBean<Servlet> registration = new ServletRegistrationBean<Servlet>(facesServlet(), "*.jsf");
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
    }

}
