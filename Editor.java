package Poster;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Editor extends HttpServlet
{
  private static final String LOGGER_PROPERTIES_FILE = "/home/pitirimov/Javaworks/Poster/log4j.properties";
  private static Logger logger = LoggerFactory.getLogger(Editor.class);
  
  public Editor()
  {
    super();
    /* Logger configuration */
    PropertyConfigurator.configure(LOGGER_PROPERTIES_FILE);
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    if ((request != null) && (response != null))
    {
      /* Create the local storage for database access */
      Storage editorStorage = new Storage();    
      HttpSession editorSession = request.getSession();

      /* Add the new post and update already saved posts */
      if (editorSession.getAttribute("username") != null)
      {
        for(String element: editorStorage.getPosts(editorStorage.getUserId(editorSession.getAttribute("username").toString())))
        {
          /* Update or delete the post if it is necessary */
          if (!((request.getParameter(Integer.toString(editorStorage.getPostId(element)))).equals(element)))
          {
            if (!((request.getParameter(Integer.toString(editorStorage.getPostId(element)))).equals("")))
            {
              /* Update the post */
              editorStorage.updatePost(editorStorage.getPostId(element), request.getParameter(Integer.toString(editorStorage.getPostId(element))));
            }
            else
            {
              /* Delete the post because it is empty */
              editorStorage.deletePost(editorStorage.getPostId(element));
            }
          }
        }

        /* Add the new post */
        if (!request.getParameter("newpost").equals(""))
        {
          editorStorage.addPost(editorStorage.getUserId(editorSession.getAttribute("username").toString()), request.getParameter("newpost"));
        }

        /* Clear the user's session data */
        editorSession.removeAttribute("username");
        editorSession.invalidate();
      }

      /* Go to the login page */
      response.sendRedirect("Login.jsp");
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    processRequest(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    processRequest(request, response);
  }

  public String getServletInfo()
  {
    logger.info("This is the editor servlet information.");
    return "This is the editor servlet!";
  }
}