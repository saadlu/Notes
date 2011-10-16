package net.mashrur.tryouts.servlets.listeners;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

/**
 * @web.listener
 */


public class TestServletContextListener
    implements ServletContextListener{

    public void contextInitialized(ServletContextEvent event){
	System.out.println("context initialized");
    }

    public void contextDestroyed(ServletContextEvent event){
	System.out.println("context destroyed");
    }
}