// Obtener el botón de "Cargar más libros"
const btnCargarMasLibros = document.getElementById("btn-cargar-mas-libros");

// Añadir un evento click al botón
btnCargarMasLibros.addEventListener("click", cargarMasLibros);

// Función para cargar más libros
function cargarMasLibros() {
  // Obtener el contenedor de libros
  const contenedorLibros = document.getElementById("contenedor-libros");

  // Crear un objeto XMLHttpRequest
  const xhr = new XMLHttpRequest();

  // Establecer la URL del archivo que contiene los libros adicionales
  const url = "libros-adicionales.html";

  // Abrir una conexión con el servidor
  xhr.open("GET", url, true);

  // Establecer el tipo de respuesta que se espera
  xhr.responseType = "document";

  // Añadir un evento load para manejar la respuesta
  xhr.onload = function() {
    // Obtener la respuesta del servidor
    const respuesta = xhr.response;

    // Obtener los nuevos libros
    const nuevosLibros = respuesta.querySelectorAll(".libro");

    // Añadir los nuevos libros al contenedor
    nuevosLibros.forEach(function(libro) {
      contenedorLibros.appendChild(libro);
    });
  };

  // Enviar la petición al servidor
  xhr.send();

  // Ocultar el botón de "Cargar más libros"
  btnCargarMasLibros.style.display = "none";
}