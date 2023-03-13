# webapp12

# Nombre: THE GOLDEN BOOK

Paula Monrobel Ugidos           p.monrobel.2019@alumnos.urjc.es     Akram1013

Laila El Khattabi El Hassnaoui	l.elkhattabi.2020@alumnos.urjc.es   lailaelkhattabielhas

Gabriel Serrano Díaz            g.serranod.2020@alumnos.urjc.es     Gabriel15010

Jesús Pérez Sánchez             j.perezsa.2020@alumnos.urjc.es      DiosYisus77

Xavier Medina Salas             jx.medina@alumnos.urjc.es           XdeXavi

# Enlace a Trello: https://trello.com/b/CVAiUcJD/daw-the-golden-book

### ENTIDADES

* Usuario
* Libro
* Autor
* Reseña
* Compra

Relación: Un libro siempre tiene un autor y puede tener una o varias reseñas de los usuarios que compraron el libro.

### PERMISOS

* Usuario Anonimo: Puede ver la web de libros, los autores y las reseñas de cada libro. 
* Usuario Registrado: Además de los permisos de Usuario Anónimo, puede comprar libros y guardar una lista con sus favoritos y escribir reseñas de cualquier libro.
* Usuario Administrador: Todos los permisos anteriores. Además, puede añadir, eliminar y/o modificar información sobre cada libro, autor y reseña.

### IMAGENES

* Usuario Registrado: Cada uno puede modificar su imagen de perfil.
* Libro: Cada libro lleva asociada una portada.
* Autor: Si el autor no es anónimo y se conoce su apariencia se incluye también una imagen.

### GRAFICOS

Un gráfico de líneas por cada autor registrado en la web, con el Nº de libros vendidos mensualmente.

Un gráfico de barras general con el Nº de ventas mensuales. 
(...Gráficos adicionales posteriores a Fase 0)


### TECNOLOGÍA COMPLEMENTARIA

Envio de correo de confirmación a los usuraios que se registren en la web.
Opción de generación de PDF con el recibo/factura de una compra reciente.

### ALGORITMO O CONSULTA AVANZADA

Habilitar una sección de recomedados para aquellos usuarios que compraron o tienen como favoritos a algún autor.
(...Requisitos adicionales posteriores a Fase 0)


### PANTALLAS DE LA APLICACIÓN WEB 

--FASE 1  

* Pantallas comunes a todos los usuarios: 

* Inicio: Es la pantalla principal de la página. Se caracteriza por tener una barra de navegación en la parte superior desde la que  puedes acceder a cualquier otra pantalla de la web. Además, posee un resumen de los libros que puedes encontrar en la página distribuyéndolos en distintas secciones ("Novedades", "más leídos" y "recomendados para ti"). 
![Pantalla de incio](https://user-images.githubusercontent.com/123741250/218403579-e5c02bc8-ca25-4ee3-a86a-982ff139ecae.png)
![Pantalla de inicio 1](https://user-images.githubusercontent.com/123741250/218403588-56bb7183-7409-4496-8566-fdc0f45110b0.png)
![Pantalla de inicio 2](https://user-images.githubusercontent.com/123741250/218403592-cf0c60af-c9b6-4317-a47a-964d2b5d7845.png)

* Registro: Pantalla en la cual puedes crearte un perfil en la web y pasar a tener el rol de usuario registrado, con el que puedes disfrutar de distintas ventajas. Para ello, es necesario introducir tu nombre completo, correo electrónico y una contraseña con la que cifrar tu cuenta. Una vez introducidos los datos, deberás pulsar en "Regístrate" y si no hay ningún problema, tu cuenta ya estará creada y serás devuelto a "inicio".  
![registro](https://user-images.githubusercontent.com/123741250/218403613-14e3809b-0a44-48e9-b8aa-c2a35474c845.png)

 * Cesta: Página en la que se mostrará todos los libros que has ido añadiendo a esta y puedes o anularla (eliminando todos los elementos que contiene) o proceder al pago conjunto. Como ayuda, se muestran todos los precios de los libros que has añadido, las cantidades de cada ejemplar que has pedido y el sumando total de la compra. 
![cesta](https://user-images.githubusercontent.com/123741250/218403640-fe820053-5f74-449d-9270-160da87a8502.png)
![cesta 1](https://user-images.githubusercontent.com/123741250/218403649-b8d54e0c-6e25-42b5-9dfd-90eea372268d.png)

* Pantallas de los usuarios registrados: 

* Iniciar Sesión: Pantalla muy similar a la de "Registro" pero solo debes introducir tu correo y contraseña. Si los datos son correctos, entrarás a tu cuenta y tendrás todas las ventajas de los usuarios registrados. Si no tienes una cuenta, puedes entrar a la pantalla de "Registro". 
![inicio sesion](https://user-images.githubusercontent.com/123741250/218403721-87ce2e7a-bb3b-4dd8-b4c3-04c4f33e81d7.png)

* Perfil: Página en la que se muestran tus datos introducidos y puedes acceder a la pantalla de "Modificar perfil" 
![PERFIL](https://user-images.githubusercontent.com/123741250/218403782-dd0ffcb9-3904-461b-a455-b78f6c44d028.png)
* Modificar Perfil: Puedes cambiar tus datos introducidos cuando te registraste y además introducir datos extras tales como "Dirección", "Nº de teléfono" y "Géneros favoritos". Además, puedes introducir una foto que te represente para una experiencia más personalizada. 
![MODIFICAR PERFIL](https://user-images.githubusercontent.com/123741250/218403807-eccaa12e-943d-4c51-a982-1e742464f9a9.png)
* Pantallas de los usuarios administradores (admin): 

* Añadir/Modificar Libro: Pantalla desde la cual un administrador puede introducir un nuevo libro en la base de datos de la página para mostrarlo al resto de usuarios. Debe introducir: "Título", "Precio", "Autor", "Sinopsis", "Cantidad" y una foto de la portada del libro. Tras haber realizado estos pasos, debes pulsar "Aceptar" y los cambios serán guardados. 
![modificar libro](https://user-images.githubusercontent.com/123741250/218403868-444c6518-6514-456e-a521-d4a2acc9b4cc.png)

* Añadir/Modificar Autor: Pantalla desde la cual un administrador puede introducir un nuevo autor en la base de datos de la página para mostrarlo al resto de usuarios. Debe introducir: "Nombre", "Apellidos", "Información" (acerca del autor y su biografía) y una foto que represente al autor. Tras haber realizado estos pasos, debes pulsar "Aceptar" y los cambios serán guardados. 
![modificacion autor](https://user-images.githubusercontent.com/123741250/218403928-c6e4f8b7-0938-4a13-8ea0-d2ffb85152c2.png)



*Diagrama de Navegación
 
 



![diagram de navegacion completo](https://user-images.githubusercontent.com/123741250/218428540-8080e049-ea30-4d82-8f57-f911f9dae78c.png)

 ###FASE 2 
 
 * Navegación
 
 * Instrucciones de ejecución 
 
 * Diagrama de entidades de la base de datos 
 



![DIAGRAMA DE BBDD](https://user-images.githubusercontent.com/123741250/224628859-d0a22e8f-5c7c-4a4e-8fe8-1e4eb3f21d57.PNG)


* Diagrama de clases y templates

![image](https://user-images.githubusercontent.com/103439723/224640172-9296fdd4-4ce4-4a03-baf3-989132cd174e.png)


*Participación de miembros
#Laila El Khattabi El Hassnaoui 
-Durante la realizacón de la fase 2 he colaborado en la realización y edición de los templates, por otra parte he trabajado  con los controladores para el correcto de funcionamiento de la página  e inicializado de los objetos de la base de datos.
**5 commits principales

e2897fd5728b65a7765211f47bd2cdccdf00fe72

a21a888ecb0e471fc88db81f82cdddc4c71c86fe

5f42a2c47abb1459394838055160863bfc54f772

2281b888f69dc7121e26b3d197784e44ea7c69b5

4a3f154c0e12c9c2fddbd6e200aa1dd4857549d6

**5 ficheros en los que más he trabajado
https://github.com/CodeURJC-DAW-2022-23/webapp12/tree/main/backend/thegoldenbook/src/main/java/codeurjc/controller
https://github.com/CodeURJC-DAW-2022-23/webapp12/tree/main/backend/thegoldenbook/src/main/java/codeurjc/model
https://github.com/CodeURJC-DAW-2022-23/webapp12/tree/main/backend/thegoldenbook/src/main/java/codeurjc/repository
https://github.com/CodeURJC-DAW-2022-23/webapp12/tree/main/backend/thegoldenbook/src/main/java/codeurjc/service
https://github.com/CodeURJC-DAW-2022-23/webapp12/tree/main/backend/thegoldenbook/src/main/resources/templates

#JESÚS PÉREZ SÁNCHEZ
- Durante la realización de la fase 2, he trabajado mayoritariamente en la realización de los distintos templates de la aplicación, también he trabajado en la creación de entidades (concrétamente user, book y author) y en los controladores con métodos para crear un libro y crear un autor. 

**5 commits principales**

NEW BOOK V1 - 1be99a7b176147072031cc6dd095159c94cf94f1
imagenes libro funciona - 593366c54e6d6225616d9f6d38206ea107575601
MySQL funciona (por fin xD) - 80a86bd3665324e50bd7394d63c3f23e8a319dc4
Book Model - 9eeb39b6a40b3d3e03758a8c5daf987918a9fa74
authorMod - b77869a75ad14830235227de73eb459d9e7bd48c

**5 ficheros donde más he trabajado**
AuthorController - https://github.com/CodeURJC-DAW-2022-23/webapp12/blob/main/backend/thegoldenbook/src/main/java/codeurjc/controller/AuthorController.java
BookController - https://github.com/CodeURJC-DAW-2022-23/webapp12/blob/main/backend/thegoldenbook/src/main/java/codeurjc/controller/BookController.java
UserController - https://github.com/CodeURJC-DAW-2022-23/webapp12/blob/main/backend/thegoldenbook/src/main/java/codeurjc/controller/UserControler.java
Author - https://github.com/CodeURJC-DAW-2022-23/webapp12/blob/main/backend/thegoldenbook/src/main/java/codeurjc/model/Book.java
Book - https://github.com/CodeURJC-DAW-2022-23/webapp12/blob/main/backend/thegoldenbook/src/main/java/codeurjc/model/Author.java
