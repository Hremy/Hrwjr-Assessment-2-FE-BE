<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "hrwjr.medicare.*" %>

<%

    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String reTypePassword = request.getParameter("re-px assword");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String gender = request.getParameter("gender");
    String country = request.getParameter("country");
    String userType = request.getParameter("usertype");

    String register = API.signUp(email, password, reTypePassword, firstName, lastName, gender, country , userType);

    if(register.equals("true")) {

        out.println("<script>alert('Registration successfully.');</script>\n");
        
        out.println("<h2>Regitration successfully</h2>\n");

        out.println("<a href='/Hrwjr-Assessment-2-FE-BE/login.html'>Continue to login</a>\n");

    }else {
        
        out.println("<script>alert('"+ register +"');</script>\n");

        out.println("<h2>"+ register +"</h2>\n");
        
        out.println("<a href='/Hrwjr-Assessment-2-FE-BE/index.html'>Try again</a>\n");

    }

%>