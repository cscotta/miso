<%@ page import="models.[[ModelNameCapitalized]]" %>
<% [[ModelNameCapitalized]] [[ModelNameLowercase]] = ([[ModelNameCapitalized]]) request.getAttribute("[[ModelNameLowercase]]"); %>

<jsp:include page="../includes/header.html" />

  <h1>View a [[ModelNameCapitalized]]</h1>
  <p>Here is all of the info we have about this [[ModelNameLowercase]]. <a href="/miso/app?controller=[[ModelNameLowercase]]&amp;action=add">Add another [[ModelNameLowercase]]</a>, or <a href="/miso/app?controller=[[ModelNameLowercase]]&amp;action=index">list all of them</a>.</p>

  [[ShowFieldsForColumns]]
  
  <form method="post" action="/miso/app">
    <input type="hidden" name="id" value="<%= [[ModelNameLowercase]].getID() %>">
    <input type="hidden" name="controller" value="[[ModelNameLowercase]]">
    <input type="hidden" name="action" value="destroy">
    <input type="submit" value="Delete" />
  </form>

<jsp:include page="../includes/footer.html" />
