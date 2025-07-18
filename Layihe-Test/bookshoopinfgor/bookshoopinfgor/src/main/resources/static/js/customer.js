var xht = new XMLHttpRequest();
var booksArrayGlobal = [];
var basketBooks = [];
var searchextGlobal='';
var mainContentHTML = "";
var begin = 0;
var length = 20;

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
        booksArrayGlobal.push(...booksArray)

        var mainContent = document.getElementById("main-content");
      
        for (var i = 0; i < booksArray.length; i++) {
            var book = booksArray[i];
            mainContentHTML += "<div class='product-card'>";
            mainContentHTML += "   <div class='product-card-item'>";
            mainContentHTML += " <div class='photo-div'>";
            mainContentHTML +=
                "     <img class='book-photo'  src='files/" + book.image + "'></div>";
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
xht.open("POST", "rest/books/search-find-partial", true);
xht.setRequestHeader("Content-type","application/json");
var searchObject={search:'',begin:begin,length:length};
xht.send(JSON.stringify(searchObject));

function addToBasket(bookId) {
    var bookExistsInBasket = false;
    for (var i = 0; i < basketBooks.length; i++) {
        var basketBook = basketBooks[i];
        if (basketBook.book.id == bookId) {
            basketBook.count++;
            bookExistsInBasket = true;
           
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
    if (basketBooks.length==0) {
        document.getElementById('confirm-order-btn').style.display='none';
    } else {
        document.getElementById('confirm-order-btn').style.display='block';
    }
}

function fillBasketTable() {
    var basketBooksTableHTml = "";
    for (let i = 0; i < basketBooks.length; i++) {
        var basketBook = basketBooks[i];
        basketBooksTableHTml += "<tr><td>" + basketBook.book.id;
        basketBooksTableHTml +=
            "</td><td><img  style='width: 80px'  src='files/" +
            basketBook.book.image +
            "'";
        basketBooksTableHTml += "'></td><td>" + basketBook.book.name;
        basketBooksTableHTml += "</td><td>" + basketBook.book.price;
        basketBooksTableHTml +=
            "</td><td><input min='1' max='10000' class='form-control' type='number' value='" +
            basketBook.count +
            "'" +
            "onchange='bookCountChange(" +
            basketBook.book.id +
            ",this)' onkeypress='checkCount(event)'>";

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

function bookCountChange(bookId, countInput) {
if (countInput.value =='' || countInput.value =='0') {
    countInput.value='1';
    
}
var count=Number(countInput.value)
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
    if (basketBooks.length==0) {
        document.getElementById('confirm-order-btn').style.display='none';
    }
    setTimeout(function () {
        openBasketButton.style.display = "block";
    }, 300);
    fillBasketTable();
}
function searchBook(searchText){
    var booksArrayGlobal = [];
    searchextGlobal=searchText;
     mainContentHTML = "";
    xht.open("POST", "rest/books/search-find-partial", true);
    xht.setRequestHeader("Content-type","application/json");
    begin=0;
    var searchObject={search:searchText,begin:begin,length:length};
    xht.send(JSON.stringify(searchObject));
}
var counter=0;
var allowScroll=true;
function onScroll() {
    if (allowScroll) {
     
        const distanceToBottom=document.body.getBoundingClientRect().bottom;
        const documentHeight=document.documentElement.clientHeight;

        if (distanceToBottom< documentHeight+150) {
            
            allowScroll=false;
            counter++;
            begin+=20;

            xht.open("POST", "rest/books/search-find-partial", true);
            xht.setRequestHeader("Content-type","application/json");

            var searchObject={search:searchextGlobal,begin:begin,length:length};
            xht.send(JSON.stringify(searchObject));

            setTimeout(function() {
                allowScroll=true;
            }, 1000);
        }
    }
}
window.addEventListener("scroll",onScroll);

function confirmOrder() {
 
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
     
        window.location.href = "confirm-order";
      }
    };
    xhttp.open("POST", "rest/orders/save-basket-books", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(basketBooks));
  }
  
  function checkCount(event) {
      var code=event.charCode;
      if (code >=48 && code <= 57) {
          
      } else {
          event.returnValue=false;
      }
      
      if (Number(event.target.value + "" +event.key) >10000) {
          event.target.value="1";
          event.returnValue=false;
      }
if (event.target.value === "0" && event.key === "0") {
    event.returnValue=false;
}
  }