/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author huynq
 */
public class WebServletConfig implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext sc) throws ServletException {

        AnnotationConfigWebApplicationContext webContext
                = new AnnotationConfigWebApplicationContext();

        webContext.register(SpringConfig.class);

        ServletRegistration.Dynamic servlet
                = sc.addServlet("dispatcher", new DispatcherServlet(webContext));

        servlet.setLoadOnStartup(1);

        servlet.addMapping("/");
    }

}
