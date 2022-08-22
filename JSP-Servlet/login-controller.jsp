<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "hrwjr.medicare.*" %>

<%

    String username = request.getParameter("email");
    String password = request.getParameter("password");

    String login = API.signIn(username , password);

    if(login.equals("true")){

        User user = DataStore.getPersistentStore().get(username);

        out.println("<h2><u>EMAIL</u>:</h2> "+ user.getEmail() +"\n");
        out.println("<h2><u>USERTYPE</u>:</h2> "+ user.getUserType() +"\n");
        out.println("<h2><u>FIRST NAME</u>:</h2> "+ user.getFirstName() +"\n");
        out.println("<h2><u>LAST NAME</u>:</h2> "+ user.getLastName() +"\n");
        out.println("<h2><u>GENDER</u>:</h2> "+ user.getGender() +"\n");
        out.println("<h2><u>COUNTRY</u>:</h2> "+ user.getCountry() +"\n");

    }else {

        out.println("<script>alert('"+ login +"');</script>\n");

        out.println("<h2>"+ login +"</h2>\n");
        
        out.println("<a href='/Hrwjr-Assessment-2-FE-BE/login.html'>Try again</a>\n");

    }

%>