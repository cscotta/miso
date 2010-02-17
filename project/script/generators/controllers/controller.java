package controllers;

// Servlet Imports
import models.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Framework Imports
import miso.DispatchedRequest;
import miso.Controller;

// Utility Imports
import java.util.HashMap;


// [[ModelNameCapitalized]] Controller Actions
public class [[ModelNameCapitalized]]Controller extends Controller {
  static [[ModelNameCapitalized]]Model model = new [[ModelNameCapitalized]]Model();

  public void show(DispatchedRequest req) {
    [[ModelNameCapitalized]] [[ModelNameLowercase]] = model.get((String) req.getParameter("id"));
    req.setAttribute("[[ModelNameLowercase]]", [[ModelNameLowercase]]);

    if (req.getFormat().equals("json")) { renderString(model.toJSONString([[ModelNameLowercase]]), req); }
    else { render("show", req); }
  }

  public void index(DispatchedRequest req) {
    [[ModelNameCapitalized]][] [[ModelNameLowercase]]s = model.list();
    req.setAttribute("[[ModelNameLowercase]]s", [[ModelNameLowercase]]s);

    if (req.getFormat().equals("json")) { renderString(model.listToJSONString([[ModelNameLowercase]]s), req); }
    else { render("index", req); }
  }

  public void edit(DispatchedRequest req) {
    [[ModelNameCapitalized]] [[ModelNameLowercase]] = model.get((String) req.getParameter("id"));
    req.setAttribute("[[ModelNameLowercase]]", [[ModelNameLowercase]]);
    render("edit", req);
  }

  public void add(DispatchedRequest req) {
    render("add", req);
  }

  public void create(DispatchedRequest req) {
    if (!req.isPost()) redirect(req, "/java/app?controller=[[ModelNameLowercase]]&action=index");

    [[ModelNameCapitalized]] [[ModelNameLowercase]] = model.create(req.getParams());
    req.setAttribute("[[ModelNameLowercase]]", [[ModelNameLowercase]]);
    redirect(req, "/java/app?controller=[[ModelNameLowercase]]&action=show&id=" + [[ModelNameLowercase]].getID());
  }
  
  public void update(DispatchedRequest req) {
    String [[ModelNameLowercase]]Id = (String) req.getParameter("id");
    String redirectTo = "/java/app?controller=[[ModelNameLowercase]]&action=show&id=" + [[ModelNameLowercase]]Id;
    req.setAttribute("redirectTo", redirectTo);
    if (!req.isPost()) redirect(req, redirectTo);

    [[ModelNameCapitalized]] [[ModelNameLowercase]] = model.update([[ModelNameLowercase]]Id, req.getParams());
    redirect(req, redirectTo);
  }
  
  public void destroy(DispatchedRequest req) {
    String redirectTo = "/java/app?controller=[[ModelNameLowercase]]&action=index";
    if (!req.isPost()) redirect(req, redirectTo);
    
    model.destroy((String) req.getParameter("id"));
    req.setAttribute("[[ModelNameLowercase]]s", model.list());
    redirect(req, redirectTo);
  }

}