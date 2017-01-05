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

public class Login extends HttpServlet
{
  private static final String LOGGER_PROPERTIES_FILE = "/home/pitirimov/Javaworks/Poster/log4j.properties";
  private static Logger logger = LoggerFactory.getLogger(Login.class);
  
  public Login()
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
      Storage loginStorage = new Storage();

      /* Go to the user's page */
      if (!((request.getParameter("username")).equals("")))
      {
        if (loginStorage.getUserId(request.getParameter("username")) < 0)
        {
          /* Create new user */
          loginStorage.addUser(request.getParameter("username"), request.getParameter("userpassword"));
        }

        /* Save user's name for another servlet */
        HttpSession userSession = request.getSession();
        userSession.setAttribute("username", request.getParameter("username"));

        /* Go to the user's page */
        response.sendRedirect("Editor.jsp");
      }
      else
      {
        /* Go to the initial page */
        response.sendRedirect("Login.jsp");      
      }
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
    logger.info("This is the logger servlet information.");
    return "This is the logger servlet!";
  }
}