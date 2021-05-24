var list = document.getElementById("list");
var kategoriyaInput = document.getElementById("kategoriyaInput");
var kategoriyaString = localStorage.getItem("kategoriyaCS");
var computerMelumat = [];
var computerString = localStorage.getItem("computerLayihe");

computerMelumat = JSON.parse(computerString);
var kategoriya = JSON.parse(kategoriyaString);
var showListString = "";
var buttons = document.getElementById("buttons");

function form(event) {
  event.preventDefault();
}

function showList() {
  showListString = "";

  for (var i = 0; i <= kategoriya.length - 1; i++) {
    showListString +=
      "<button class='list-group-item' onclick=select(" +
      kategoriya[i].id +
      "," +
      i +
      ")>" +
      kategoriya[i].name +
      "</button>";
  }
  list.innerHTML = showListString;
}

showList();

function newKategoriya() {
  var obyekt = kategoriya[kategoriya.length - 1];
  var newobyekt = {
    id: obyekt.id + 1,
    name: kategoriyaInput.value,
  };
  kategoriya.push(newobyekt);
  localStorage.setItem("kategoriyaCS", JSON.stringify(kategoriya));
  showList();
  kategoriyaInput.value = "";
}

function select(id, i) {
  kategoriyaString = localStorage.getItem("kategoriyaCS");
  kategoriya = JSON.parse(kategoriyaString);
  kategoriyaInput.value = kategoriya[i].name;

  setTimeout(function () {
    buttons.innerHTML =
      " <button onclick='redakte(" +
      i +
      ")' class='btn btn-warning'>Redakte et</button>" +
      "<button type='reset' class='btn btn-dark' onvalue= 'Reset'> Temizle</button>" +
      "<button onclick='deleteK(" +
      i +
      ")' class='btn btn-danger'>Sil</button>" +
      "<button onclick='btne(" +
      i +
      ")' class='btn btn-info'>Secili olani legv et</button>";
  }, 50);
}

function btne() {
  buttons.innerHTML =
    " <button onclick='newKategoriya()' class='btn btn-success'>Elave et</button>" +
    "<button type='reset' class='btn btn-dark' on value='Reset'> Temizle</button>";
  kategoriyaInput.value = "";
}

function redakte(i) {
  console.log("Ss");
  kategoriyaString = localStorage.getItem("kategoriyaCS");
  kategoriya = JSON.parse(kategoriyaString);
  for (var index = 0; index < computerMelumat.length; index++) {
    if(kategoriya[i].name==computerMelumat[index].computerABout.kategoriya){

computerMelumat[index].computerABout.kategoriya=kategoriyaInput.value;

    }
    
  }
  kategoriya[i].name = kategoriyaInput.value;
  localStorage.setItem("kategoriyaCS", JSON.stringify(kategoriya));
  localStorage.setItem("computerLayihe", JSON.stringify(computerMelumat));
  showList();
}

function deleteK(i) {
  kategoriyaString = localStorage.getItem("kategoriyaCS");
  kategoriya = JSON.parse(kategoriyaString);
  for (let m = 0; m < 10; m++) {
    for (var index = 0; index < computerMelumat.length; index++) {
      if(kategoriya[i].name==computerMelumat[index].computerABout.kategoriya){
    console.log(computerMelumat.length);
  computerMelumat.splice(index,1);
  
      }
      
    }
    
  }
  

  kategoriya.splice(i, 1);
  localStorage.setItem("kategoriyaCS", JSON.stringify(kategoriya));
  localStorage.setItem("computerLayihe", JSON.stringify(computerMelumat));
  showList();
  kategoriyaInput.value = "";
  btne();

}

$(document).ready(function () {
  $("#myInput").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#list button").filter(function () {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
  });
});