window.addEventListener("load", inicio);

var cont = 1;
var librosPorPantalla = 2; // Variable para saber cuantos queremos mostar por panta cada vez que se ejecuta el metodo mostrarMasLibros

function inicio() {
	mostarMasLibros();
    document.getElementById("buttonNovedades").addEventListener("click", mostarMasLibros);
}

function mostarMasLibros(){
	var listaLibros = document.getElementsByName("libros");
	for(var i = 0; i<(librosPorPantalla*cont) && i<listaLibros.length;i++){
		listaLibros[i].style.visibility = "visible";
		listaLibros[i].style.display = "inline";
	}
	for(var i = (librosPorPantalla*cont); i<listaLibros.length;i++){
		listaLibros[i].style.visibility = "hidden";
		listaLibros[i].style.display = "none";
	}
	if ((cont*librosPorPantalla)>=listaLibros.length){
		document.getElementById("buttonNovedades").style.visibility = "hidden";
	}
	cont++;
}