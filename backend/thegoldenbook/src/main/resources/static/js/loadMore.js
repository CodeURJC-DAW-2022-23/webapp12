$(window).on("load", function(){
    valueIndex(1);
    $('#buttonNovedades').on("click",()=>functionCall("buttonNovedades", '#moreBooks', "BOOKS"))


})
var indexBook;

function ajaxCall(url, spinner, where) {
	$.ajax({
    	type: "GET",
        contenType: "aplication/json",
		url: url,
		beforeSend: function () {
        	$(spinner).removeClass('hidden')
        },
		success: function (result) {
			$(where).append(result);
		},
		complete: function () {
        	$(spinner).addClass('hidden')
        },
	});
}

function functionBook(where, spinner) {
	value = indexComment;
	this.indexComment += 1;	
	
	// Search parameter in url
	const arrayPath = window.location.pathname.split('/');
	const id= arrayPath[2];

	url=('/moreComments/' + id + '/' + value);
	
    ajaxCall(url, spinner, where);
}

function searchIndex(index) { //Se pueden meter más botones para hacer más cargas de objetos en la página
	value = 0;
	
	switch(index) {
		case ("buttonNovedades"): 
			value = indexNovedades;
			this.indexNovedades += 1;
			break;
	}
	
	return value;
}

function valueIndex(num) {
	this.indexNovedades = num;

}
