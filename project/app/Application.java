// Servlet Imports
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Utilities
import java.util.HashMap;
import java.lang.reflect.*;
import org.apache.commons.lang.StringUtils;

// Import controllers
import miso.Controller;
import miso.DispatchedRequest;

// Main entry point to the application.
public class Application extends HttpServlet {

  // HTTP GET requests
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    dispatchRequest(req, resp);
  }
  
  // HTTP POST requests
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    dispatchRequest(req, resp);
  }
  
  // Main application routing and dispatching.
  private void dispatchRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String template = "";
    
    // Route the request to a controller and action based on URL.
      // Grab the action and controller names.
      String actionName = req.getParameter("action");
      String controllerName = StringUtils.capitalize(req.getParameter("controller")) + "Controller";

      DispatchedRequest dispatchedRequest = new DispatchedRequest(req, resp, getServletContext());
      
    try {
      // Locate and instantiate the controller, then invoke the action.
      template = actionName;
      Class controllerClass = Class.forName("controllers." + controllerName);
      Method method = controllerClass.getMethod(actionName, new Class[]{DispatchedRequest.class});
      req = (HttpServletRequest) method.invoke(controllerClass.newInstance(), new Object[]{dispatchedRequest});

    // Handle controller not found, action not found, and rendering errors.
    } catch (ClassNotFoundException e) {
      RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/404.jsp");
      disp.forward(req, resp);

    } catch (NoSuchMethodException e) {
      RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/404.jsp");
      disp.forward(req, resp);

    } catch (Throwable e) {
      System.out.println(e.getCause());
      System.out.println(e.toString());
      e.printStackTrace();
      req.setAttribute("error", e.toString());
      RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/500.jsp");
      disp.forward(req, resp);
    }
    
  }
}
