<%-- 
    This is the poster of user's messages.
    Contact: Sergey Pitirimov, sergey.pitirimov@innopolis.ru
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Poster.Editor"%>
<%@page import="Poster.Storage"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Your posts are here</title>
  </head>
  <body>
    <%
      HttpSession editSession = request.getSession();
      if (editSession.getAttribute("username") != null)
      {
    %>
        <h1><%=editSession.getAttribute("username").toString()%>, you may create or edit your posts here!</h1>

        <form method="get" action="Editor">
          New post: <input type="text" name = "newpost" value="" size="80" autofocus>
          <input type="submit" value="Publish">
          <%
            Storage editStorage = new Storage();
      
            /* Print all posts of user, who has logged in */
            for(String post: editStorage.getPosts(editStorage.getUserId(editSession.getAttribute("username").toString())))
            {
          %>
              <br>Edit post: <input type="text" name="<%=editStorage.getPostId(post)%>" value="<%=post%>" size="80">
            <%
            }
            %>
        </form>
    <%
      }
      else
      {
        response.sendRedirect("Login.jsp");
      }
    %>
  </body>
</html>