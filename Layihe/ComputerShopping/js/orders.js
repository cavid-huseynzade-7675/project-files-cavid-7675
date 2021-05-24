var tableBody = document.getElementById("tableBody");
var orders = [];
var ordersString = localStorage.getItem("ordersLayihe");
if (ordersString == null) {
  localStorage.setItem("ordersLayihe", JSON.stringify(orders));
} else {
  orders = JSON.parse(ordersString);
}
var token;
var tokenGlobalString = localStorage.getItem("tokenLayihe");
if (tokenGlobalString == null) {
} else {
  token = JSON.parse(tokenGlobalString);
}

function filter() {
  for (var a = 0; a < orders.length; a++) {
    var o = orders[a];
    id = a;
    for (var i = 0; i < o.basket.length; i++) {
      var b = o.basket[i];
      if (b.computer.customer.userId == token.userId) {
      } else {
        console.log("false");
        orders[id].basket.splice(i, 1);
        i -= 1;
      }
    }
    if (o.basket.length == 0) {
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
        orderNumber.id +
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
        orderNumber.id +
        "'>Etrafli</button>";

      totalPrice += parseInt(
        orderNumber.basket[a].count * computerCustomer.price
      );
    }

    computerString += "" + "</ol>";
    var o1="";
    var  o2="";
    var  o3="";
    var  o4="";
    var   o5="";
if (orderNumber.kargo=="Sirketde") {
  o1="selected";
}if (orderNumber.kargo=="Pocta tehvil verildi"){
  o2="selected";
}if (orderNumber.kargo=="Masina yuklendi"){
  o3="selected";
}if (orderNumber.kargo=="Yola cixdi"){
  o4="selected";
}if(orderNumber.kargo=="Tehvil verildi"){  o5="selected";}
    orderString +=
      "<tr><td>" +
      orderNumber.id +
      "</td><td>" +
      orderNumber.date +
      "</td><td><ul><li>Ad: " +
      orderNumber.customer.name +
      "</li><div id='cs" +
      index +
      "'class='collapse'><li>Telefon: " +
      orderNumber.customer.phone +
      "</li><li>Adres: " +
      orderNumber.customer.adress +
      "</li><li>E-mail: " +
      orderNumber.customer.email +
      "</li></div> <button type='button' class='btn btn-info' data-toggle='collapse' data-target='#cs" +
      index +
      "'>Etrafli</button></ul> " +
      "</td><td>" +
      computerString +
      "</td><td>" +
      totalPrice +
      "</td><td>" +
      orderNumber.note +
      "</td><td><select onchange='changedKargo("+orderNumber.id+",this.value)'  class='form-control'>"+
      "<option "+o1+">Sirketde</option>"+
      "<option "+o2+">Pocta tehvil verildi</option>"+
      "<option "+o3+">Masina yuklendi</option>"+
      "<option "+o4+">Yola cixdi</option>"+
      "<option "+o5+">Tehvil verildi</option>"+
      "</select></td></tr>";
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

function changedKargo(id,value){
  for (let index = 0; index < orders.length; index++) {
    const b = orders[index];
    if (b.id === id) {
      orders[index].kargo=value;
     
    }
  }
  localStorage.setItem("ordersLayihe", JSON.stringify(orders));
  }