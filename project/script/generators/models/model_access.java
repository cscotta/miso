package models;

import net.java.ao.*;
import java.sql.*;
import java.util.*;
import com.mysql.jdbc.*;
import org.json.simple.*;

public class [[ModelNameCapitalized]]Model {

  static String url = "jdbc:mysql://localhost/miso";
  static EntityManager em = new EntityManager(url, "root", "");

  // Find a single [[ModelNameLowercase]]
  public static [[ModelNameCapitalized]] get(String strId) {
    int id = new Integer(strId).intValue();
    return em.get([[ModelNameCapitalized]].class, id);
  }

  // Create a [[ModelNameLowercase]] from a HashMap
  public static [[ModelNameCapitalized]] create(HashMap params) {
    try {
      [[ModelNameCapitalized]] [[ModelNameLowercase]] = em.create([[ModelNameCapitalized]].class, params);
      return [[ModelNameLowercase]];
    } catch (SQLException ex) {
      return null;
    }
  }
  
  // Update a [[ModelNameLowercase]] from a HashMap
  public static [[ModelNameCapitalized]] update(String strId, HashMap params) {
    int id = new Integer(strId).intValue();
    [[ModelNameCapitalized]] [[ModelNameLowercase]] = em.get([[ModelNameCapitalized]].class, id);

    [[SetterFromParamsImplementation]]
    
    [[ModelNameLowercase]].save();
    
    return [[ModelNameLowercase]];
  }
  
  // Return a list of all [[ModelNameLowercase]]s.
  public static [[ModelNameCapitalized]][] list() {
    try {
      return em.find([[ModelNameCapitalized]].class);
    } catch (SQLException ex) {
      return null;
    }
  }

  // Find a single [[ModelNameLowercase]]
  public static void destroy(String strId) {
    int id = new Integer(strId).intValue();
    try {
      [[ModelNameCapitalized]] p = em.get([[ModelNameCapitalized]].class, id);
      em.delete(p);
    } catch (SQLException ex) { }
  }

  public static String listToJSONString([[ModelNameCapitalized]][] [[ModelNameLowercase]]s) {
    String output = "[";
    
    int listSize = [[ModelNameLowercase]]s.length;
    for (int i = 0; i < listSize; i++) {
      output += toJSONString([[ModelNameLowercase]]s[i]);
      if (i != (listSize - 1)) output += ",";
    }
    output += "]";   
    return output;
  }

  public static String toJSONString([[ModelNameCapitalized]] [[ModelNameLowercase]]) {
    JSONObject json = new JSONObject();
    [[JSONOutputForColumns]]
    return json.toString();
  }

}