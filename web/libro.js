$(document).ready(function(){
  $("#rateYo1").rateYo({
    rating: $("#nValoracion1").html()
  });

  $("#rateYo2").rateYo({
    rating: $("#nValoracion2").html()
  });

  $("#rateYo3").rateYo({
    rating: $("#nValoracion3").html()
  });

  $('.nValoracion').hide();
});
