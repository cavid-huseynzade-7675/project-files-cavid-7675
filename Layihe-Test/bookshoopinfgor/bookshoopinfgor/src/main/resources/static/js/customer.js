var xht = new XMLHttpRequest();
var booksArrayGlobal = [];
var basketBooks = [];
var basketBooksFromStorage = localStorage.getItem("basketBooks");

if (basketBooksFromStorage == null) {
    localStorage.setItem("basketBooks", []);
} else {
    basketBooks = JSON.parse(basketBooksFromStorage);
}
var openBasketButton = document.getElementById("open-basket-btn");
var basketBooksTable = document.getElementById("basket-books-table");
var basketBookCount = document.getElementById("basket-book-count");
var totalPrice = document.getElementById("total-price");
xht.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
        var responseJSON = this.responseText;
        var booksArray = JSON.parse(responseJSON);
        booksArrayGlobal = booksArray.slice();
        var mainContent = document.getElementById("main-content");
        var mainContentHTML = "";
        for (var i = 0; i < booksArray.length; i++) {
            var book = booksArray[i];
            mainContentHTML += "<div class='product-card'>";
            mainContentHTML += "   <div class='product-card-item'>";
            mainContentHTML += " <div class='photo-div'>";
            mainContentHTML +=
                "     <img class='book-photo'  src='/files/" + book.image + "'></div>";
            mainContentHTML +=
                "<div class='text-div'><p class='price-text' title=" +
                book.price +
                " > " +
                book.price +
                " </p>";
            mainContentHTML +=
                "<p class='name-text'    title='" +
                book.name +
                "' >" +
                book.name +
                "</p>";
            mainContentHTML +=
                "<p class='desc-text'    title='" +
                book.description +
                "' >" +
                book.description +
                "</p>";
            mainContentHTML +=
                "<p class='auth-text'    title='" +
                book.author +
                "' >" +
                book.author +
                "</p> ";
            mainContentHTML +=
                "<p class='page-text'    title='" +
                book.pageCount +
                "' >" +
                book.pageCount +
                "</p> ";
            mainContentHTML +=
                "<div style='text-align:center;'><button " +
                "class='add-to-basket-btn btn btn-primary' onclick='addToBasket(" +
                book.id +
                ")'>Səbətə at</button></div>";
            mainContentHTML += "</div></div></div></div>";
        }

        mainContent.innerHTML = mainContentHTML;
    }
};
xht.open("GET", "/rest/books", true);
xht.send();

function addToBasket(bookId) {
    var bookExistsInBasket = false;
    for (var i = 0; i < basketBooks.length; i++) {
        var basketBook = basketBooks[i];
        if (basketBook.book.id == bookId) {
            basketBook.count++;
            bookExistsInBasket = true;
            break;
        }
    }

    if (bookExistsInBasket) {} else {
        for (var i = 0; i < booksArrayGlobal.length; i++) {
            if (booksArrayGlobal[i].id == bookId) {
                var basketBook = {
                    count: 1,
                    book: booksArrayGlobal[i],
                };
                basketBooks.push(basketBook);
                break;
            }
        }
    }

  // alert(JSON.stringify(bookId));
    openBasketButton.style.display = "none";
    basketBookCount.innerHTML = basketBooks.length;
    localStorage.setItem("basketBooks", JSON.stringify(basketBooks));
    setTimeout(function () {
        openBasketButton.style.display = "block";
    }, 300);
}

function openBasket() {
    fillBasketTable();
}

function fillBasketTable() {
    var basketBooksTableHTml = "";
    for (let i = 0; i < basketBooks.length; i++) {
        var basketBook = basketBooks[i];
        basketBooksTableHTml += "<tr><td>" + basketBook.book.id;
        basketBooksTableHTml +=
            "</td><td><img  style='width: 80px'  src='/files/" +
            basketBook.book.image +
            "'";
        basketBooksTableHTml += "'></td><td>" + basketBook.book.name;
        basketBooksTableHTml += "</td><td>" + basketBook.book.price;
        basketBooksTableHTml +=
            "</td><td><input type='number' value='" +
            basketBook.count +
            "'" +
            "oninput='bookCountChange(" +
            basketBook.book.id +
            ",this.value)'>";

        basketBooksTableHTml +=
            "</td><td id='book" +
            basketBook.book.id +
            "'>" +
            basketBook.book.price * basketBook.count;
        basketBooksTableHTml +=
            "</td><td><button onclick='deleteBasketBook(" +
            basketBook.book.id +
            ")' class='btn btn-danger'>X</button>";
        basketBooksTableHTml += "</td></tr>";
    }
    basketBooksTable.innerHTML = basketBooksTableHTml;
    calculateTotalPrice();
}

function bookCountChange(bookId, count) {
    for (let index = 0; index < basketBooks.length; index++) {
        var basketBook = basketBooks[index];
        if (basketBook.book.id == bookId) {
            basketBook.count = count;

            document.getElementById("book" + basketBook.book.id).innerHTML =
                count * basketBook.book.price;
            localStorage.setItem("basketBooks", JSON.stringify(basketBooks));
            calculateTotalPrice();
            break;
        }
    }
}

function calculateTotalPrice() {
    var totalpricenumber = 0;
    for (let index = 0; index < basketBooks.length; index++) {
        var basketBook = basketBooks[index];

        totalpricenumber += basketBook.count * basketBook.book.price;
    }
    totalPrice.innerHTML = "Umumi Qiymet:" + totalpricenumber + "AZN";
}

function deleteBasketBook(bookId) {
    for (let index = 0; index < basketBooks.length; index++) {
        if (basketBooks[index].book.id == bookId) {
            basketBooks.splice(index, 1);
        }
    }
    openBasketButton.style.display = "none";
    basketBookCount.innerHTML = basketBooks.length;
    localStorage.setItem("basketBooks", JSON.stringify(basketBooks));
    setTimeout(function () {
        openBasketButton.style.display = "block";
    }, 300);
    fillBasketTable();
}
function searchBook(searchText){
    xht.open("POST","/rest/books/search",true)
    xht.setRequestHeader("Content-type","application/json");

    var searchObject={search:searchText};

    xht.send(JSON.stringify(searchObject))
}