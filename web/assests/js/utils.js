$(document).ready(function () {
    $('.addProductBtn').click(function () {
        addProduct($(this));
    });
    $('.reduceProductBtn').click(function () {
        reduceProduct($(this));
    });
});

function addProduct(element) {
    var bookId = $(element).attr('id');
    var json = JSON.stringify(bookId);
    console.log(json);
    $.ajax({
        type: 'get',
        url: contextUrl + '/frontController?command=addBook&bookId=' + productId
    }).done(function (data) {
        $('#count'+bookId).text(data);
    }).fail(function (data) {
        if (console && console.log) {
            console.log("Error data:", data);
        }
    });
}

function reduceProduct(element) {
    var bookId = $(element).attr('id');
    $.ajax({
        type: 'post',
        url: contextUrl + '/frontController',
        data:{command:'reduceProduct', id:productId}
    }).done(function (data) {
        $('#count'+bookId).text(data);
    }).fail(function (data) {
        if (console && console.log) {
            console.log("Error data:", data);
        }
    });
}
