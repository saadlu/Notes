package net.mashrur.tryouts.servlets.filters;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * @web.filter name="TestServletFilter"
 * 
 * @web.filter-mapping servlet-name="FirstServlet"
 */


public class TestServletFilter
    implements Filter{

    public void init(FilterConfig config){
	System.out.println("Filter initialized yeah!!!");
    }

    public void doFilter(ServletRequest request,
			 ServletResponse response,
			 FilterChain filterChain)
	throws IOException, ServletException{
	System.out.println("doFilter called");
	CharResponseWrapper crw = 
	    new CharResponseWrapper((HttpServletResponse)response);
	filterChain.doFilter(request,crw);

	PrintWriter out = ((HttpServletResponse)response).getWriter();
	out.println(crw.toString());
	out.println("Stuff from filter");
	out.close();
	

    }

    private static class CharResponseWrapper
	extends HttpServletResponseWrapper{
	private CharArrayWriter output;
	
	public CharResponseWrapper(HttpServletResponse response){
	    super(response);
	    output = new CharArrayWriter();
	}

	public String toString(){
	    return output.toString();
	}

	public PrintWriter getWriter(){
	    return new PrintWriter(output);
	}
    }
    
    public void destroy(){
	System.out.println("Filter destroyed");
    }
}