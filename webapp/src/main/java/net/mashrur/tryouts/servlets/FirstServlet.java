package net.mashrur.tryouts.servlets;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @web.servlet
 *    name = "FirstServlet"
 *
 * @web.servlet-mapping
 *    url-pattern="/FirstServlet/*"
 * 
 */

public class FirstServlet
    extends HttpServlet{

    private int count = 0;

    public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException{

	try{
	    super.service(request,response);
	    synchronized(this){
		count++;
	    }
	}finally{
	    synchronized(this){
		count--;
	    }
	}

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)

        throws IOException, ServletException{

        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        out.println("Output starts from FirstServlet. count " 
		    + count +  "<br/>");
        
        System.out.println("To my server: getting and getting more!!!");

        RequestDispatcher dispatcher = 
            getServletContext().getRequestDispatcher("/IncludeTestServlet");
        
        if(dispatcher!=null){
            dispatcher.include(request,response);
        }

	out.println("<br/>Output ends from FirstServlet<br>");
        

        
    }

    public void init()
        throws ServletException{

        System.out.println("Initializing");

    }
    
}