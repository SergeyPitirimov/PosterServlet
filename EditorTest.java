package Poster;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EditorTest
{
  
  public EditorTest()
  {
  }
  
  @BeforeClass
  public static void setUpClass()
  {
  }
  
  @AfterClass
  public static void tearDownClass()
  {
  }
  
  @Before
  public void setUp()
  {
  }
  
  @After
  public void tearDown()
  {
  }

  /**
   * Test of processRequest method, of class Editor.
   */
  @Test
  public void testProcessRequest() throws Exception
  {
    System.out.println("processRequest");
    HttpServletRequest request = null;
    HttpServletResponse response = null;
    Editor instance = new Editor();
    instance.processRequest(request, response);
    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
  }

  /**
   * Test of doGet method, of class Editor.
   */
  @Test
  public void testDoGet() throws Exception
  {
    System.out.println("doGet");
    HttpServletRequest request = null;
    HttpServletResponse response = null;
    Editor instance = new Editor();
    instance.doGet(request, response);
    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
  }

  /**
   * Test of doPost method, of class Editor.
   */
  @Test
  public void testDoPost() throws Exception
  {
    System.out.println("doPost");
    HttpServletRequest request = null;
    HttpServletResponse response = null;
    Editor instance = new Editor();
    instance.doPost(request, response);
    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
  }

  /**
   * Test of getServletInfo method, of class Editor.
   */
  @Test
  public void testGetServletInfo()
  {
    System.out.println("getServletInfo");
    Editor instance = new Editor();
    String expResult = "";
    String result = instance.getServletInfo();
//    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
  }
  
}
