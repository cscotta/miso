<%@ page import="models.Puppy" %>
<% Puppy[] puppys = (Puppy[]) request.getAttribute("puppys"); %>

<jsp:include page="../includes/header.html" />

  <h1>Listing Puppys</h1>
  <p>
    Here are all of the puppys in your database. 
    <a href="/miso/app?controller=puppy&amp;action=add">Add another puppy.</a>
  </p>

  <table width="600">
    <thead>
      <tr>
        <th>Name</th>
    <th>Breed</th>
    <th>Owner</th>
    <th>Cuteness</th>
    
        <th colspan="3">Actions</th>
      </tr>
    </thead>
    <tbody>
    <% for (Puppy puppy : puppys) { %>
      <tr>
        <td><%= puppy.getName() %></td>
    <td><%= puppy.getBreed() %></td>
    <td><%= puppy.getOwner() %></td>
    <td><%= puppy.getCuteness() %></td>
    
        <td>
          <form method="get" action="/miso/app">
            <input type="hidden" name="id" value="<%= puppy.getID() %>">
            <input type="hidden" name="controller" value="puppy">
            <input type="hidden" name="action" value="show">
            <input type="submit" value="Show" />
          </form>
        </td>
        <td>
          <form method="get" action="/miso/app">
            <input type="hidden" name="id" value="<%= puppy.getID() %>">
            <input type="hidden" name="controller" value="puppy">
            <input type="hidden" name="action" value="edit">
            <input type="submit" value="Edit" />
          </form>
        </td>
        <td>
          <form method="post" action="/miso/app">
            <input type="hidden" name="id" value="<%= puppy.getID() %>">
            <input type="hidden" name="controller" value="puppy">
            <input type="hidden" name="action" value="destroy">
            <input type="submit" value="Delete" />
          </form>
        </td>
      </tr>
    <% } %>
    </tbody>
  </table>

<jsp:include page="../includes/footer.html" />
