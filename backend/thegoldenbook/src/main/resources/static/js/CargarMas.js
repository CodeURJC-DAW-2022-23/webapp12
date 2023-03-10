var currentPage = 0;
const valores = window.location.search;

function moreContent() {
    switchMoreContentButtonActivation(true)
    currentPage = currentPage + 1;
    console.log(valores);
    const urlParams = new URLSearchParams(valores);
    var searchtext = urlParams.get('searchtext');
    if (searchtext == null)
        $.ajax({
            type: 'GET',
            url: '/books?currentPage=' + currentPage,
            error: function () {
                console.log('Something went wrong')
                switchMoreContentButtonActivation(false)
            },
            success: function (data) {
                var books = $(data).find('#Books').html();
                var noMoreBooks = $(data).find('#noMoreBooks').html();
                if (noMoreBooks == undefined) {
                    $('#Books').append(books)
                    switchMoreContentButtonActivation(false)
                } else {
                    $('#moreContentButton').css("display", "none");
                }
            }
        }) 
    else
        $.ajax({
            type: 'GET',
            url: '/books?searchtext=' + searchtext + '&currentPage=' + currentPage,
            error: function () {
                console.log('Something went wrong')
                switchMoreContentButtonActivation(false)
            },
            success: function (data) {
                var books = $(data).find('#Books').html();
                var noMoreBooks = $(data).find('#noMoreBooks').html();
                if (noMoreBooks == undefined) {
                    $('#Books').append(books)
                    switchMoreContentButtonActivation(false)
                } else {
                    $('#moreContentButton').css("display", "none");
                }
            }
        })
}
