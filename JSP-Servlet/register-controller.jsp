<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "hrwjr.medicare" %>

<%

    String userType = request.getParameter("userType");

    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String reTypePassword = request.getParameter("re-password");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String gender = request.getParameter("gender");
    String country = request.getParameter("country");

    String register = User.signUp(email, password, reTypePassword, firstName, lastName, gender, country , userType);

    if(register.equals("true")) {

        response.sendRedirect("/login");

    }else {

        out.println("<h2>"+ register +"</h2>\n");

    }

%>