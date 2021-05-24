var kategoriyaSelect = document.getElementById("kategoriyaSelect");
var nameInput = document.getElementById("nameInput");
var priceInput = document.getElementById("priceInput");
var descriptionInput = document.getElementById("descriptionInput");
var yeniSelect = document.getElementById("yeniSelect");
var imageInput = document.getElementById("imageInput");
var ramInput = document.getElementById("ramInput");
var cpuInput = document.getElementById("cpuInput");
var storageInput = document.getElementById("storageInput");
var storageselectType = document.getElementById("storageselectType");
var operationSystemInput = document.getElementById("operationSystemInput");
var gpuInput = document.getElementById("gpuInput");
var telefonInput = document.getElementById("telefonInput");
var saver = document.getElementById("saver");
var myModal = document.getElementById("myModal");
var kategoriyaString = localStorage.getItem("kategoriyaCS");
var kategoriya = JSON.parse(kategoriyaString);

var selectId = 0;
var image = document.getElementById("img");
function imagesrc() {
  console.log(imageInput.value);
  image.src = imageInput.value;
}

var tableBody = document.getElementById("tableBody");
var computerMelumat = [];
var computerString = localStorage.getItem("computerLayihe");
computerMelumat = JSON.parse(computerString);
var token;
var tokenGlobalString = localStorage.getItem("tokenLayihe");
if (tokenGlobalString == null) {
} else {
  token = JSON.parse(tokenGlobalString);
}
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#tableBody tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
function loadComputers() {
  tableBody.innerHTML = "";
  var tableBodyHtml = "";
  for (let index = 0; index < computerMelumat.length; index++) {
    const b = computerMelumat[index];
    if (b.customer.userId == token.userId) {
      tableBodyHtml += "<tr><td>" + b.id;
      tableBodyHtml += "</td><td>" + b.customer.name;
      tableBodyHtml +=
        "</td><td><img style='width: 60px;'' src='" +
        b.customer.imagePath +
        "'>";
      tableBodyHtml += "</td><td>" + b.customer.price;
      tableBodyHtml +=
        "</td><td> <button onclick='deleteComputer(" +
        b.id +
        ")' class='btn btn-danger'>Sil</button>" +
        "<button   onclick=onEditComputer(" +
        b.id +
        ")   data-toggle='modal'data-target='#myModal'  class='btn btn-warning'>Redakte et</button>" +
        " <span  title='Etrafli Bax'   data-toggle='tooltip' data-placement='right' ><button    class='btn btn-info'  onclick='showMelumatModal(" +
        b.id +
        ")' data-toggle='modal' data-target='#modalMelumat' ><svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' fill='currentColor' class='bi bi-eye' viewBox='0 0 16 16'><path d='M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z'/> <path d='M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z'/>/svg></button> </span></div>";
      +"</td></tr>";
    }
  }
  $(function () {
    $('[data-toggle="tooltip"]').tooltip();
  });
  tableBody.innerHTML = tableBodyHtml;
}
$(function () {
  $('[data-toggle="tooltip"]').tooltip();
});
loadComputers(computerMelumat);

function kategoriyaload() {
  var showselectString = "";

  for (var i = 0; i <= kategoriya.length - 1; i++) {
    showselectString += "<option>" + kategoriya[i].name + "</option>";
  }
  kategoriyaSelect.innerHTML = showselectString;
}
kategoriyaload();
function saverClicked(event) {
  event.preventDefault();

  if (saver.classList.item(1) == "btn-success") {
    saveComputer();
  } else {
    editComputer();
  }
}

function saveComputer() {
  var obyekt = computerMelumat[computerMelumat.length - 1];
  var customer = {
    userId: token.userId,
    name: nameInput.value,
    description: descriptionInput.value,
    price: priceInput.value,
    phone: telefonInput.value,
    imagePath: imageInput.value,
  };

  var computerABout = {
    new: yeniSelect.value,
    ram: ramInput.value,
    cpu: cpuInput.value,
    storage: storageInput.value,
    storageType: storageselectType.value,
    operationSystem: operationSystemInput.value,
    gpu: gpuInput.value,
    kategoriya: kategoriyaSelect.value,
  };

  var all = {
    id: obyekt.id + 1,
    customer: customer,
    computerABout: computerABout,
  };
  computerMelumat.push(all);
  console.log(computerMelumat);
  localStorage.setItem("computerLayihe", JSON.stringify(computerMelumat));

  var computerString = localStorage.getItem("computerLayihe");
  computerMelumat = JSON.parse(computerString);

  loadComputers(computerMelumat);
  nameInput.value = "";
  priceInput.value = "";
  descriptionInput.value = "";
  imageInput.value = "";
  ramInput.value = "";
  cpuInput.value = "";
  storageInput.value = "";
  operationSystemInput = "";
  gpuInput.value = "";
  telefonInput.value = "";
}

function deleteComputer(productId) {
  for (let index = 0; index < computerMelumat.length; index++) {
    const b = computerMelumat[index];
    if (b.id === productId) {
      computerMelumat.splice(index, 1);
      break;
    }
  }

  localStorage.setItem("computerLayihe", JSON.stringify(computerMelumat));
  loadComputers();
}

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

function newComputer() {
  saver.innerHTML = "Elave et";
  saver.classList.remove("btn-warning");
  saver.classList.add("btn-success");
  nameInput.value = "";
  priceInput.value = "";
  descriptionInput.value = "";
  imageInput.value = "";
  ramInput.value = "";
  cpuInput.value = "";
  storageInput.value = "";
  operationSystemInput.value = "";
  gpuInput.value = "";
  telefonInput.value = "";
}

function onEditComputer(id) {
  saver.innerHTML = "Redakte et";
  selectId = id;
  saver.classList.remove("btn-success");
  saver.classList.add("btn-warning");
  for (let index = 0; index < computerMelumat.length; index++) {
    const b = computerMelumat[index];
    if (b.id === id) {
      kategoriyaSelect.value = b.computerABout.kategoriya;
      nameInput.value = b.customer.name;
      priceInput.value = b.customer.price;
      descriptionInput.value = b.customer.description;
      yeniSelect.value = b.computerABout.new;
      imageInput.value = b.customer.imagePath;
      ramInput.value = b.computerABout.ram;
      cpuInput.value = b.computerABout.cpu;
      storageInput.value = b.computerABout.storage;
      storageselectType.value = b.computerABout.storageType;
      operationSystemInput.value = b.computerABout.operationSystem;
      gpuInput.value = b.computerABout.gpu;
      telefonInput.value = b.customer.phone;
      console.log(b.computerABout.ram);
    }
  }
}

function editComputer() {
  var customer = {
    userId: token.userId,
    name: nameInput.value,
    description: descriptionInput.value,
    price: priceInput.value,
    phone: telefonInput.value,
    imagePath: imageInput.value,
  };

  var computerABout = {
    new: yeniSelect.value,
    ram: ramInput.value,
    cpu: cpuInput.value,
    storage: storageInput.value,
    storageType: storageselectType.value,
    operationSystem: operationSystemInput.value,
    gpu: gpuInput.value,
    kategoriya: kategoriyaSelect.value,
  };

  var all = { id: selectId, customer: customer, computerABout: computerABout };

  for (let index = 0; index < computerMelumat.length; index++) {
    const b = computerMelumat[index];
    if (b.id === selectId) {
      computerMelumat[index] = all;
    }
  }

  console.log(computerMelumat);
  localStorage.setItem("computerLayihe", JSON.stringify(computerMelumat));

  var computerString = localStorage.getItem("computerLayihe");
  computerMelumat = JSON.parse(computerString);

  loadComputers(computerMelumat);
  nameInput.value = "";
  priceInput.value = "";
  descriptionInput.value = "";
  imageInput.value = "";
  ramInput.value = "";
  cpuInput.value = "";
  storageInput.value = "";
  operationSystemInput = "";
  gpuInput.value = "";
  telefonInput.value = "";
}
