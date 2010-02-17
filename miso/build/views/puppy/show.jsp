<%@ page import="models.Puppy" %>
<% Puppy puppy = (Puppy) request.getAttribute("puppy"); %>

<jsp:include page="../includes/header.html" />

  <h1>View a Puppy</h1>
  <p>Here is all of the info we have about this puppy. <a href="/miso/app?controller=puppy&amp;action=add">Add another puppy</a>, or <a href="/miso/app?controller=puppy&amp;action=index">list all of them</a>.</p>

  <p><strong>Name:</strong> <%= puppy.getName() %></p>
    <p><strong>Breed:</strong> <%= puppy.getBreed() %></p>
    <p><strong>Owner:</strong> <%= puppy.getOwner() %></p>
    <p><strong>Cuteness:</strong> <%= puppy.getCuteness() %></p>
    
  
  <form method="post" action="/miso/app">
    <input type="hidden" name="id" value="<%= puppy.getID() %>">
    <input type="hidden" name="controller" value="puppy">
    <input type="hidden" name="action" value="destroy">
    <input type="submit" value="Delete" />
  </form>

<jsp:include page="../includes/footer.html" />
