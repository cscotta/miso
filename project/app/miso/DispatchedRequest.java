package miso;

// Servlet Imports
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.security.Principal;
import org.json.simple.JSONObject;
import org.apache.commons.lang.StringUtils;

public class DispatchedRequest {

  public static HttpServletRequest request;
  public static HttpServletResponse response;
  public static ServletContext context;
  
  public DispatchedRequest(HttpServletRequest req, HttpServletResponse resp, ServletContext ctx) {
    request = req;
    response = resp;
    context = ctx;
  }

  // Accessor methods for the servlet context, request, and response objects.
  public ServletContext getCtx() { return context; }
  public HttpServletRequest getReq() { return request; }
  public HttpServletResponse getResp() { return response; }

  // Syntactic sugar for controllers.
  public boolean isPost() { return request.getMethod() == "POST"; }
  public boolean isGet() { return request.getMethod() == "GET"; }
  public String getFormat() { 
    String format = request.getParameter("format");
    if (format == null) format = "";
    return format;
  }
  
  public HashMap getParams() { 
    HashMap params = new HashMap();
    params.putAll(request.getParameterMap());
    params.remove("controller");
    params.remove("action");

    // Convert params from an array of strings to a string.
    Iterator it = params.keySet().iterator(); 
    while(it.hasNext()) {
      Object key = it.next();
      Object val = params.put(key.toString(), StringUtils.join((String[]) params.get(key), ""));
    }

    return params;
  }
  
  
  // Provide a simple interface to a couple requently-used public HttpServletRequest methods.
  public Object       getParameter(String key)              { return request.getParameter(key); }
  public Map          getParameterMap()                     { return request.getParameterMap(); }
  public Object       getAttribute(String key)              { return request.getAttribute(key); }
  public void         setAttribute(String key, Object val)  { request.setAttribute(key, val); }
  public Cookie[]     getCookies()                          { return request.getCookies(); }
  public String       getQuerystring()                      { return request.getQueryString(); }
  public HttpSession  getSession()                          { return request.getSession(); }
  public HttpSession  getSession(Boolean create)            { return request.getSession(create); }

  // Provide a simple interface to a couple requently-used public HttpServletResponse methods.
  public void         addCookie(Cookie cookie)              { response.addCookie(cookie); }
  public void         setStatus(Integer status)                 { response.setStatus(status); }
}