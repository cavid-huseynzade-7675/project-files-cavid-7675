var customerName = document.getElementById("customer-name");
var customerAdress = document.getElementById("customer-adress");
var customerPhone = document.getElementById("customer-phone");
var orderNote = document.getElementById("order-note");
var customerEmail= document.getElementById("customer-email");
var order = {};
var basketBooksFromStorage = localStorage.getItem("basketBooks");

if (basketBooksFromStorage == null) {
  localStorage.setItem("basketBooks", []);
} else {
  basketBooks = JSON.parse(basketBooksFromStorage);
}

order.basketBooks = basketBooks;
order.customer = {};
function confirmOrder() {
  order.customer.name = customerName.value;
  order.customer.adress = customerAdress.value;
  order.customer.phone = customerPhone.value;
  order.note=orderNote.value;
  order.customer.email=customerEmail.value;
  console.log(order);
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var respone = this.responseText;
      localStorage.setItem("basketBooks", "[]");
      window.location.href = "confirm-order-mesasge";
    }
  };
  xhttp.open("POST", "/rest/orders", true);
  xhttp.setRequestHeader("Content-type", "application/json");
  xhttp.send(JSON.stringify(order));
}
