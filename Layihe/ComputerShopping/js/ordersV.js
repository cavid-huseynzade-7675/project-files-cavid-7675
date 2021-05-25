var tableBody = document.getElementById("tableBody");
var orders = [];
var ordersString = localStorage.getItem("ordersLayihe");
if (ordersString == null) {
  localStorage.setItem("ordersLayihe", JSON.stringify(orders));
} else {
  orders = JSON.parse(ordersString);
}
var token={};
var tokenGlobalString = localStorage.getItem("tokenLayihe");
if (tokenGlobalString == null) {
} else {
  token = JSON.parse(tokenGlobalString);
}

function filter() {
  for (var a = 0; a < orders.length; a++) {
    var o = orders[a];

    if (o.userId !== token.userId) {
      orders.splice(a, 1);
    }
  }
  console.log(orders);
}
filter();

function loadOrders(orders) {
  var totalPrice = 0;
  tableBody.innerHTML = "";
  var orderString = "";
  var computerString = "";
  for (let index = 0; index < orders.length; index++) {
    computerString = "<ol>";
    var totalPrice = 0;
    const orderNumber = orders[index];
    for (var a = 0; a < orderNumber.basket.length; a++) {
      var computer = orderNumber.basket[a].computer;
      var computerCustomer = computer.customer;
      var computerAbout = computer.computerABout;

      computerString +=
        a +
        1 +
        "." +
        computerCustomer.name +
        "<div id='c" +
        index+a +
        "'class='collapse'><ul><li>Qiymeti: " +
        computerCustomer.price +
        " AZN</li></ul>" +
        "<ul><li>Miqdari: " +
        orderNumber.basket[a].count +
        " eded</li></ul>" +
        "<ul><li>Umumi qiymet: " +
        orderNumber.basket[a].count * computerCustomer.price +
        " AZN</li></ul>" +
        " </li></div> <button type='button' class='btn btn-info' data-toggle='collapse' data-target='#c" +
        index+a+
        "'>Etrafli</button><br><br>";

      totalPrice += parseInt(
        orderNumber.basket[a].count * computerCustomer.price
      );
    }

    computerString += "" + "</ol>";


    orderString +=
      "<tr><td>" +
      orderNumber.id +
      "</td><td>" +
      orderNumber.date +
      "</td>" +
      "<td>" +
      computerString +
      "</td><td>" +
      totalPrice +
      " AZN</td><td>" +
      orderNumber.kargo +
      "</td><td>" +
      orderNumber.note +
      "</td><td>" +
      "<button  class='btn btn-danger' onclick='deleteOrder("+orderNumber.id+")'" +
      "'>Legv et</button>"+
      "</td></tr>";
  }

  tableBody.innerHTML = orderString;
}

loadOrders(orders);

$(document).ready(function () {
  $("#myInput").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#tableBody tr").filter(function () {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
  });
});

function deleteOrder(id){

    for (let index = 0; index < orders.length; index++) {
        const o = orders[index];
        if (o.id === id) {
          orders.splice(index, 1);
          break;
        }
      }
    
      localStorage.setItem("ordersLayihe", JSON.stringify(orders));
      loadOrders(orders);
   
}