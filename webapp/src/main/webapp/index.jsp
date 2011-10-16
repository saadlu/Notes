<html xmlns="http://www.w3.org/1999/xhtml" 
      lang="en"
      xml:lang="en"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-Instance"
      xsi:schemaLocation="http://www.w3.org/1999/xhtml
                          http://www.w3.org/2002/08/xhtml/xhtml1-strict.xsd">

    <head>
        <title>Sa'ad Tries JSP</title>
    </head>
    <body>
        <p>
          Time now: <%= new java.util.Date() %>
        </p>
        <p>
            <%
                System.out.println("Sa'ad learns JSP");
                request.getRequestDispatcher("/FirstServlet").forward(request,response);
            %>
        </p>
        <a href="FirstServlet">Servlet</a>
    </body>
</html>
