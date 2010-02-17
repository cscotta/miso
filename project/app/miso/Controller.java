package miso;

// Servlet Imports
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import miso.DispatchedRequest;

public class Controller {
  
  public void render(String template, DispatchedRequest obj) {
    try {
      try {
        RequestDispatcher disp = obj.getCtx().getRequestDispatcher("/views/" + obj.getParameter("controller") + "/" + template + ".jsp");
        disp.forward(obj.getReq(), obj.getResp());
      } catch (Throwable e) {
        System.out.println("== DIED IN RENDER");
        e.printStackTrace();      
        obj.getReq().setAttribute("error", e.toString());
        RequestDispatcher disp = obj.getCtx().getRequestDispatcher("/views/500.jsp");
        disp.forward(obj.getReq(), obj.getResp());
      }      
    } catch (Throwable e) {
      System.out.println("== DIED RENDERING ERROR PAGE IN RENDER");
    }
  }
  
  public void renderString(String string, DispatchedRequest obj) {
    try {
      
      try {
        PrintWriter out = obj.getResp().getWriter();
           out.println(string);
           out.close();
      } catch (Throwable e) {
        System.out.println("== DIED IN RENDERSTRING");
        e.printStackTrace();      
        obj.getReq().setAttribute("error", e.toString());
        RequestDispatcher disp = obj.getCtx().getRequestDispatcher("/views/500.jsp");
        disp.forward(obj.getReq(), obj.getResp());
      }
    } catch (Throwable e) {
      System.out.println("== DIED RENDERING ERROR PAGE IN RENDERSTRING");
    }
  }
  
  public void redirect(DispatchedRequest obj, String redirectTo) {
    try {
      obj.getResp().sendRedirect(redirectTo);
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }
  
}