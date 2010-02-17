<% String error = (String) request.getAttribute("error"); %>
<jsp:include page="includes/header.html" />

  <h1>Sad Robot :-(</h1>
  <p>Sorry, there was a problem.</p>
  <pre><strong><%= error %></strong></pre>
  <p>Please see the application log for details on this error.</p>
    
<jsp:include page="includes/footer.html" />
