<jsp:include page="../includes/header.html" />

  <h1>Create a Puppy</h1>
    <p>Please fill out this form to update a puppy's information.</p>

    <form method="post" action="/miso/app"/>
      <label for="name">Name: </label><input name="name" class="text" type="text" /><br />
    <label for="breed">Breed: </label><input name="breed" class="text" type="text" /><br />
    <label for="owner">Owner: </label><input name="owner" class="text" type="text" /><br />
    <label for="cuteness">Cuteness: </label><input name="cuteness" class="text" type="text" /><br />
    
      <input type="hidden" name="controller" value="puppy" />
      <input type="hidden" name="action" value="create" />
      <input type="submit" value="Submit" />
    </form>
    
    <p><br /><a href="/miso/app?controller=puppy&amp;action=index">List Puppys</a></p>
    
<jsp:include page="../includes/footer.html" />