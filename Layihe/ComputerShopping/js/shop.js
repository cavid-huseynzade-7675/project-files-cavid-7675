var cardsComputer = localStorage.getItem("cardsComputer");
var modalbodymelumat = localStorage.getItem("modalbodymelumat");
var list = document.getElementById("kategoriya");
var basketCount = document.getElementById("basket-count");
var kategoriyaString = localStorage.getItem("kategoriyaCS");
var kategoriya = JSON.parse(kategoriyaString);
var openBasketButton = document.getElementById("open-basket-button-c");
var token;
var tokenGlobalString = localStorage.getItem("tokenLayihe");
if (tokenGlobalString == null) {
} else {
  token = JSON.parse(tokenGlobalString);
}

var showListString = "";
var computerMelumat = [];
var computerString = localStorage.getItem("computerLayihe");
var basketComputersTableBody = document.getElementById(
  "basketComputersTableBody"
);
var basketComputers = [];
var basketComputersString = localStorage.getItem("basketComputers");
if (basketComputersString == null) {
  localStorage.setItem("basketComputers", JSON.stringify(basketComputers));
} else {
  basketComputers = JSON.parse(basketComputersString);
}
var orders = [];
var ordersString = localStorage.getItem("ordersLayihe");
if (ordersString == null) {
  localStorage.setItem("ordersLayihe", JSON.stringify(orders));
} else {
  orders = JSON.parse(ordersString);
}

var allPrice = document.getElementById("allPrice");
var emailInput = document.getElementById("emailInput");
var noteInput = document.getElementById("noteInput");
var adressInput = document.getElementById("adressInput");
var telefonInput = document.getElementById("telefonInput");
var nameInput = document.getElementById("nameInput");

computerMelumat = JSON.parse(computerString);

function select1(id) {

  var mas = [];
  var kn;
  for (var i = 0; i < kategoriya.length; i++) {
    var c = kategoriya[i];

    if (c.id == id) {
      kn = c.name;
      console.log(kn);
    }
  }
  if (id == null) {
    showComputers(computerMelumat);
  } else {
    for (var i = 0; i < computerMelumat.length; i++) {
      var c = computerMelumat[i];

      if (c.computerABout.kategoriya == kn) {
        mas.push(c);
      }
    }
    
  document.getElementById("myInputShop").value=
    showComputers(mas);

  }
}
window.activate = function (el) {
  var current = document.querySelector(".active");
  if (current) {
    current.classList.remove("active");
  }
  el.classList.add("active");
};

function someF(x, id) {
  select1(id);
  activate(x);
}

function showList() {
  showListString = "";
  showListString +=
    "<li  " +
    "class='list-group-item active d-flex" +
    " justify-content-between align-items-center'style='width: 100%;'" +
    " onclick='someF(this," +
    null +
    ")' >Hamisini goster</li>";

  for (var i = 0; i <= kategoriya.length - 1; i++) {
    var id = kategoriya[i].id;
    showListString +=
      "<li class='list-group-item d-flex justify-content-between" +
      " align-items-center' style='width: 100%;' onclick='someF(this," +
      id +
      ")' " +
      " >" +
      kategoriya[i].name +
      "</li>";
  }
  showListString += "";
  list.innerHTML = showListString;
}

showList();

$(document).ready(function () {
  $("#myInput").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("li").filter(function () {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
  });
});

$(document).ready(function () {
  $("#myInputShop").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#cardsComputer .card").filter(function () {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
  });
});

function showComputers(computerMelumat) {
  $(document).ready(function () {
    $("#cardsComputer").html("");
    $("#cardsComputer").html("<div class='loader'>Loading...</div>");
  });
  setTimeout(function () {
    var showcardString = "";

    for (var i = 0; i <= computerMelumat.length-1; i++) {
      var name = computerMelumat[i].customer.name;
      var description = computerMelumat[i].customer.description;
      var price = computerMelumat[i].customer.price + "man";
      var newS = computerMelumat[i].computerABout.new;
      var phone = computerMelumat[i].customer.phone;
      var nameN = "";
      var descriptionN = "";
      var priceN = "";
      var newSN = "";
      var phoneN = "";
      if (name.length > 7) {
        nameN = "...";
      }
      if (description.length > 7) {
        descriptionN = "...";
      }
      if (price.length > 7) {
        priceN = "...";
      }
      if (newS.length > 7) {
        newSN = "...";
      }
      if (phone.length > 7) {
        phoneN = "...";
      }

      showcardString +=
        "<div class='card'  style='width:18%;float:left;margin:1%'>" +
        "<img class='card-img-top'   src='" +
        computerMelumat[i].customer.imagePath +
        "' alt='Card image' style='width:100%>" +
        "<div class='card-body'>" +
        "<div class='card-text' style='float:none'>" +
        " <div class='pn' ><p title=" +
        name +
        " data-toggle='tooltip' data-placement='right'><b>Ad:</b>" +
        name.substring(0, 7) +
        "" +
        nameN +
        "</p></div>" +
        "<div  class='pn'><p  title=" +
        description +
        " data-toggle='tooltip' data-placement='right'><b>Tesvir:</b>" +
        description.substring(0, 7) +
        "" +
        descriptionN +
        "</p></div>" +
        "<div class='pn'><p  title=" +
        price +
        " data-toggle='tooltip' data-placement='right'><b>Qiymet:</b>" +
        price.substring(0, 7) +
        "" +
        priceN +
        "</p></div>" +
        "<div  class='pn'><p  title=" +
        newS +
        " data-toggle='tooltip' data-placement='right'><b>Yeni:</b> " +
        newS.substring(0, 7) +
        "" +
        newSN +
        "</p></div>" +
        "<div class='pn' ><p  title=" +
        phone +
        " data-toggle='tooltip' data-placement='right'><b>Telefon:</b> " +
        phone.substring(0, 8) +
        "" +
        phoneN +
        "</p></div></div>" +
        " <div ><button  title='Sebete At' data-toggle='tooltip' class='btn btn-primary' onclick=onAddToBasket(" +
        computerMelumat[i].id +
        ")><svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' fill='currentColor' class='bi bi-cart-plus' viewBox='0 0 16 16'><path d='M9 5.5a.5.5 0 0 0-1 0V7H6.5a.5.5 0 0 0 0 1H8v1.5a.5.5 0 0 0 1 0V8h1.5a.5.5 0 0 0 0-1H9V5.5z'/> <path d='M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zm3.915 10L3.102 4h10.796l-1.313 7h-8.17zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z'/></svg></button> " +
        " <span  title='Etrafli Bax'   data-toggle='tooltip' data-placement='right' ><button    class='btn btn-info'  onclick='showMelumatModal(" +
        computerMelumat[i].id +
        ")' data-toggle='modal' data-target='#modalMelumat' ><svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' fill='currentColor' class='bi bi-eye' viewBox='0 0 16 16'><path d='M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z'/> <path d='M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z'/>/svg></button> </span></div>" +
        "<div  style='display:none'>" +
        " <p ><b>Ad:</b>" +
        name +
        "</p>" +
        "<p ><b>Tesvir:</b>" +
        description +
        "</p>" +
        "<p ><b>Qiymet:</b>" +
        price +
        "</p>" +
        "<p ><b>Yeni:</b> " +
        newS +
        "</p>" +
        "<p ><b>Telefon:</b> " +
        phone +
        "</p>" +
        "</div>" +
        "</div>" +
        "</div>" +
        "</div>";
    }

    $(document).ready(function () {
      $("#cardsComputer").html(showcardString);
    });

    $(function () {
      $('[data-toggle="tooltip"]').tooltip();
    });
  }, 500);
}

$(function () {
  $('[data-toggle="tooltip"]').tooltip();
});

showComputers(computerMelumat);

function showMelumatModal(id) {
  console.log(id);
  var showMelumatModalString = "";
  for (var i = 0; i < computerMelumat.length; i++) {
    var c = computerMelumat[i];

    if (c.id == id) {
      showMelumatModalString +=
        "<div class='card' style='width:98%;margin:1%'>" +
        "<img class='card-img-top'  src='" +
        computerMelumat[i].customer.imagePath +
        "' alt='Card image' style='width:25%;margin-left:37.5%;'>" +
        "<div class='card-body'>" +
        "<div class='card-text'>" +
        " <div class='pn' ><p><b>Ad:</b>" +
        computerMelumat[i].customer.name +
        "</p></div>" +
        "<div  class='pn'><p></p><b>Tesvir:</b>" +
        computerMelumat[i].customer.description +
        "</p></div>" +
        "<div class='pn'><p></p><b>Qiymet:</b>" +
        computerMelumat[i].customer.price +
        "man</p></div>" +
        "<div class='pn' ><p><b>Telefon:</b> " +
        computerMelumat[i].customer.phone +
        "</p></div>" +
        "<div  class='pn'><p><b>Yeni:</b> " +
        computerMelumat[i].computerABout.new +
        "</p></div>" +
        " <div class='pn' ><p><b>Ram:</b>" +
        computerMelumat[i].computerABout.ram +
        "</p></div>" +
        "<div  class='pn'><p></p><b>Cpu:</b>" +
        computerMelumat[i].computerABout.cpu +
        "</p></div>" +
        "<div class='pn'><p></p><b>Daimi Yaddas:</b>" +
        computerMelumat[i].computerABout.storage +
        "</p></div>" +
        "<div  class='pn'><p><b>Daimi Yaddas tipi:</b> " +
        computerMelumat[i].computerABout.storageType +
        "</p></div>" +
        "<div class='pn' ><p><b>Emeliyyat sistemi:</b> " +
        computerMelumat[i].computerABout.operationSystem +
        "</p></div>" +
        "<div class='pn' ><p><b>Gpu(Video kart):</b> " +
        computerMelumat[i].computerABout.gpu +
        "</p></div>" +
        "</div>" +
        "</div>" +
        "</div>";
    }
  }
  $(document).ready(function () {
    $("#modalbodymelumat").html(showMelumatModalString);
  });
}

function onAddToBasket(computerId) {
  var localComputer = null;
  for (var i = 0; i < computerMelumat.length; i++) {
    if (computerId === computerMelumat[i].id) {
      localComputer = computerMelumat[i];
      break;
    }
  }
  console.log(basketComputers.length);
  var computerExist = false;

  for (var i = 0; i < basketComputers.length; i++) {
    if (computerId === basketComputers[i].computer.id) {
      basketComputers[i].count++;
      computerExist = true;
    }
  }

  if (computerExist) {
  } else {
    basketComputers.push({
      count: 1,
      computer: localComputer,
    });
  }
  addToBasketAction();
  console.log(basketComputers);
  localStorage.setItem("basketComputers", JSON.stringify(basketComputers));
}

function addToBasketAction() {
  openBasketButton.style.display = "none";

  setTimeout(function () {
    openBasketButton.style.display = "block";
    basketCount.innerHTML = basketComputers.length;
  }, 200);
}
addToBasketAction();

function deleteALL(){
basketComputers=[];
addToBasketAction();
localStorage.setItem("basketComputers", JSON.stringify(basketComputers));
}

function refreshComputerdBasket() {
  

    var basketComputersTableBody = document.getElementById(
      "basketComputersTableBody");
 
    basketComputersTableBody.innerHTML = "";
    var basketComputersTableBodyHtml = "";
    for (let index = 0; index < basketComputers.length; index++) {
      const b = basketComputers[index];
      basketComputersTableBodyHtml += "<tr><td>" + b.computer.id;
      basketComputersTableBodyHtml +=
        '</td><td><img style="max-witdh:45px;height:40px;" src="' +
        b.computer.customer.imagePath +
        '"/>';
      basketComputersTableBodyHtml += "</td><td>" + b.computer.customer.name;
      basketComputersTableBodyHtml += "</td><td>" + b.computer.customer.price;
      basketComputersTableBodyHtml +=
        ' AZN</td><td><input min="1" max="10000" type="number" value="' +
        b.count +
        '" ' +
        ' onchange="computerCountChanged(this,' +
        b.computer.id +
        ')" onkeypress="checkCount(event)" />';
      basketComputersTableBodyHtml +=
        '</td><td id="product-total-price-' +
        b.computer.id +
        '">' +
        b.computer.customer.price * b.count;
      basketComputersTableBodyHtml +=
        ' AZN</td><td><button onclick="deleteBasketComputer(' +
        b.computer.id +
        ')" class="btn btn-danger">Sil</button></td><tr>';
    }
    totalpricef();
    addToBasketAction();
    basketComputersTableBody.innerHTML = basketComputersTableBodyHtml; 
  
  }
  
  


function onOpenBasket() {

//if(basketComputers==[]){
 // $("#modal-bodyT").html("<h1>Sebet Bosdur</h1>");
    
 // $("#modal-footerT").html("");
 // }if(basketComputers!==[]){
 //   $("#modal-bodyT").html("<table class='table table-bordered'><thead><tr><th>ID</th><th>Şəkil</th><th>Ad</th><th>Qiymət</th><th>Miqdar</th><th>Ümumi qiymət</th><th></th></tr></thead><tbody id='basketComputersTableBody'></tbody></table>");
   // $("#modal-footerT").html("  <div id='allPrice'><h2 ></h2></div><div type='button' data-dismiss='modal'><button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModalCon'>Sifarisi Tesdiqle</button> </div>");
    refreshComputerdBasket();
  //  console.log(basketComputers);
 // }
 
}

function computerCountChanged(countInput, computerID) {
  if (countInput.value == "" || countInput.value == "0") {
    countInput.value = "1";
  }

  for (let index = 0; index < basketComputers.length; index++) {
    const b = basketComputers[index];
    if (b.computer.id === computerID) {
      b.count = Number(countInput.value);
      document.getElementById(
        "product-total-price-" + b.computer.id
      ).innerHTML = "" + b.count * b.computer.customer.price + " AZN";
      break;
    }
  }

  localStorage.setItem("basketComputers", JSON.stringify(basketComputers));
  totalpricef();
}

function checkCount(event) {
  var code = event.charCode;
  if (code >= 48 && code <= 57) {
  } else {
    event.returnValue = false;
  }

  if (Number(event.target.value + "" + event.key) > 10000) {
    event.target.value = "1";
    event.returnValue = false;
  }
  checkCount;
}

function deleteBasketComputer(productId) {
  for (let index = 0; index < basketComputers.length; index++) {
    const b = basketComputers[index];
    if (b.computer.id === productId) {
      basketComputers.splice(index, 1);
      break;
    }
  }

  localStorage.setItem("basketComputers", JSON.stringify(basketComputers));
  refreshComputerdBasket();
  addToBasketAction();
 
}
$(function () {
  $('[data-toggle="tooltip"]').tooltip();
});

function saveOrder(event) {
  event.preventDefault();
  var today = new Date();
  var dd = String(today.getDate()).padStart(2, "0");
  var mm = String(today.getMonth() + 1).padStart(2, "0"); //January is 0!
  var yyyy = today.getFullYear();

  today = yyyy + "/" + mm + "/" + dd;

  var customerOrder = {
    name: nameInput.value,
    adress: adressInput.value,
    phone: telefonInput.value,
    email: emailInput.value,
  };

  var order = {
    id: orders.length + 1,
    date: today,
    customer: customerOrder,
    basket: basketComputers,
    note: noteInput.value,
    totalprice: totalpricef(),
    kargo:"Sirketde",
    userId: token.userId,
  };

  orders.push(order);
  console.log(orders);
  nameInput.value = "";
    adressInput.value = "";
    noteInput.value = "";
    emailInput.value = "";
    telefonInput.value = "";
   
  localStorage.setItem("ordersLayihe", JSON.stringify(orders));
  basketComputers=[];
  localStorage.setItem("basketComputers", JSON.stringify(basketComputers));
  addToBasketAction();
}

function totalpricef() {
  var totalprice = 0;
  for (let index = 0; index < basketComputers.length; index++) {
    const b = basketComputers[index];
    totalprice += b.computer.customer.price * b.count;
  }
  allPrice.innerHTML =
    '<h2 id="total-price" style="margin: 10px;font-size: 25px;">Umumi qiymet:' +
    totalprice +
    "</h2>";
  return totalprice;
}



