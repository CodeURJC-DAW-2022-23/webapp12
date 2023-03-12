function loadMoreBooks() {
    const container = document.getElementById("recomendationSet"); // Obtener el contenedor donde se muestran los libros
    const booksPerPage = 6; // Número de libros por página
    let page = parseInt(container.dataset.page); // Obtener la página actual
    const totalPages = parseInt(container.dataset.totalPages); // Obtener el número total de páginas
    
    if (page < totalPages) { // Si hay más páginas para cargar
      page++; // Incrementar la página actual
      container.dataset.page = page; // Actualizar el atributo "data-page" del contenedor
    
      // Realizar petición AJAX para obtener los libros de la siguiente página
      const xhr = new XMLHttpRequest();
      xhr.open("GET", "/loadmore?page=" + page + "&limit=" + booksPerPage);
      xhr.onload = function() {
        if (xhr.status === 200) {
          const newBooks = JSON.parse(xhr.responseText); // Convertir la respuesta en un objeto JavaScript
          newBooks.forEach(function(book) { // Para cada libro obtenido
            // Crear un elemento HTML para mostrar el libro
            const bookElem = document.createElement("div");
            bookElem.innerHTML = `
              <div>
                ${book.image ? '<img src="/' + book.id + '/image" class="image">' : '<img src="/images/no_image.png" class="image">'}
                <br><br>
                <div class="information">
                  <a href="/book/${book.id}">${book.title}</a>
                  <p>${book.author}</p>
                  <p>${book.stock}</p>
                  <p>${book.info}</p>
                  <p>${book.price}</p>
                  ${container.dataset.logged === "true" ? '<form action="/addbooktocart/' + book.id + '" method="post"><button type="submit" value="Añadir" class="button" id="add"/></form>' : ''}
                </div>
              </div>
              <hr>
            `;
            container.appendChild(bookElem); // Agregar el elemento al contenedor de libros
          });
        } else {
          console.error("Error al cargar más libros: " + xhr.status);
        }
      };
      xhr.send();
    }
  }