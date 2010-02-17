<%@ page import="models.[[ModelNameCapitalized]]" %>
<% [[ModelNameCapitalized]][] [[ModelNameLowercase]]s = ([[ModelNameCapitalized]][]) request.getAttribute("[[ModelNameLowercase]]s"); %>

<jsp:include page="../includes/header.html" />

  <h1>Listing [[ModelNameCapitalized]]s</h1>
  <p>
    Here are all of the [[ModelNameLowercase]]s in your database. 
    <a href="/miso/app?controller=[[ModelNameLowercase]]&amp;action=add">Add another [[ModelNameLowercase]].</a>
  </p>

  <table width="600">
    <thead>
      <tr>
        [[TableHeadingsForIndexColumnNames]]
        <th colspan="3">Actions</th>
      </tr>
    </thead>
    <tbody>
    <% for ([[ModelNameCapitalized]] [[ModelNameLowercase]] : [[ModelNameLowercase]]s) { %>
      <tr>
        [[TDsForIndexColumns]]
        <td>
          <form method="get" action="/miso/app">
            <input type="hidden" name="id" value="<%= [[ModelNameLowercase]].getID() %>">
            <input type="hidden" name="controller" value="[[ModelNameLowercase]]">
            <input type="hidden" name="action" value="show">
            <input type="submit" value="Show" />
          </form>
        </td>
        <td>
          <form method="get" action="/miso/app">
            <input type="hidden" name="id" value="<%= [[ModelNameLowercase]].getID() %>">
            <input type="hidden" name="controller" value="[[ModelNameLowercase]]">
            <input type="hidden" name="action" value="edit">
            <input type="submit" value="Edit" />
          </form>
        </td>
        <td>
          <form method="post" action="/miso/app">
            <input type="hidden" name="id" value="<%= [[ModelNameLowercase]].getID() %>">
            <input type="hidden" name="controller" value="[[ModelNameLowercase]]">
            <input type="hidden" name="action" value="destroy">
            <input type="submit" value="Delete" />
          </form>
        </td>
      </tr>
    <% } %>
    </tbody>
  </table>

<jsp:include page="../includes/footer.html" />
