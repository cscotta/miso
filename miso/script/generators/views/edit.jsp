<%@ page import="models.[[ModelNameCapitalized]]" %>
<% [[ModelNameCapitalized]] [[ModelNameLowercase]] = ([[ModelNameCapitalized]]) request.getAttribute("[[ModelNameLowercase]]"); %>
<jsp:include page="../includes/header.html" />

  <h1>Edit a [[ModelNameCapitalized]]</h1>
    <p>Please fill out this form to update a [[ModelNameLowercase]]'s information.</p>

    <form method="post" action="/miso/app"/>
      [[InputFieldsForEditModel]]
      <input type="hidden" name="id" value="<%= [[ModelNameLowercase]].getID() %>" />
      <input type="hidden" name="controller" value="[[ModelNameLowercase]]" />
      <input type="hidden" name="action" value="update" />
      <input type="submit" value="Submit" />
    </form>
    
    <p><br /><a href="/miso/app?controller=[[ModelNameLowercase]]&amp;action=index">List [[ModelNameCapitalized]]s</a></p>
    
<jsp:include page="../includes/footer.html" />
