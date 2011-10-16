package net.mashrur.tryouts.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @web.servlet
 *    name = "IncludeTestServlet"
 *
 * @web.servlet-mapping
 *    url-pattern = "/IncludeTestServlet/*"
 * 
 */


public class IncludeTestServlet extends HttpServlet{

    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response)
        throws IOException{

        output(request,response);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response)
        throws IOException{
        
        output(request,response);

    }


    private void output(HttpServletRequest request,
                        HttpServletResponse response)
        throws IOException{
        
        PrintWriter out = response.getWriter();
        out.println("This is being included");
        
    }
}