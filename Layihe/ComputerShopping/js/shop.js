var cardsComputer=localStorage.getItem("cardsComputer");
var modalbodymelumat=localStorage.getItem("modalbodymelumat");
var list=document.getElementById("kategoriya");
var basketCount=document.getElementById("basket-count");
var kategoriyaString=localStorage.getItem('kategoriyaCS');
var kategoriya=JSON.parse(kategoriyaString);
var openBasketButton=document.getElementById('open-basket-button-c');
var showListString="";
var computerMelumat=[]
var computerString = localStorage.getItem("computerLayihe");
var basketComputersTableBody=document.getElementById('basketComputersTableBody');
var basketComputers=[];
var basketComputersString=localStorage.getItem('basketComputers');
if (basketComputersString == null) {


  localStorage.setItem('basketComputers',JSON.stringify(basketComputers));

} else {
	basketComputers = JSON.parse(basketComputersString);
}









computerMelumat = JSON.parse(computerString);
function select1(id){
  var mas=[];
  var kn;
  for (var i = 0; i < kategoriya.length; i++) {
    var c = kategoriya[i];
   
    if (c.id == id) {
kn=c.name;
console.log(kn);
    }
  }
  if(id==null){
    showComputers(computerMelumat);

  }else{
    for (var i = 0; i < computerMelumat.length; i++) {
      var c = computerMelumat[i];
     
      if (c.computerABout.kategoriya ==kn ) {
  mas.push(c);
      }
    }
    showComputers(mas);
    }

  }
  
  
function showList() {
   
   showListString="";
   showListString+="<button class='list-group-item' style='width: 100%;' onclick='select1()'>Hamisini goster</button>"
   
    for(var i=0;i<=kategoriya.length-1;i++){
    var id=kategoriya[i].id;
     showListString+="<button class='list-group-item' style='width: 100%;' onclick='select1("+id+")'>"+kategoriya[i].name+"</button>"
   
        }
        list.innerHTML=showListString;
      
    }

 showList();

 $(document).ready(function(){
    $("#myInput").on("keyup", function() {
      var value = $(this).val().toLowerCase();
      $("#kategoriya button").filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
      });
    });
  });


  
  function showComputers(computerMelumat){
   var showcardString="";
 
    for(var i=0;i<=computerMelumat.length-1;i++){
    
     showcardString+=  "<div class='card' style='width:18%;float:left;margin:1%'>"+
     "<img class='card-img-top' onclick='showMelumatModal("+computerMelumat[i].id+")' data-toggle='modal' data-target='#modalMelumat' src='"+computerMelumat[i].customer.imagePath+"' alt='Card image' style='width:100%'>"+
     "<div class='card-body'>"+
     "<div class='card-text'>"+
    " <div class='pn' ><p><b>Ad:</b>"+computerMelumat[i].customer.name+"</p></div>"+
"<div  class='pn'><p></p><b>Tesvir:</b>"+computerMelumat[i].customer.description+"</p></div>"+
"<div class='pn'><p></p><b>Qiymet:</b>"+computerMelumat[i].customer.price+"man</p></div>"+
"<div  class='pn'><p><b>Yeni:</b> "+computerMelumat[i].computerABout.new+"</p></div>"+
"<div class='pn' ><p><b>Telefon:</b><br> "+computerMelumat[i].customer.phone+"</p></div></div>"+
"<div class='pn' ><button class='btn btn-primary' onclick=onAddToBasket("+computerMelumat[i].id+")>Sebete at</button> </div>"+

"</div>"+
     "</div>"+
   "</div>";
   
        }
        
        
        $(document).ready(function(){
        $("#cardsComputer").html(showcardString);
});
  }
 showComputers(computerMelumat);

  function showMelumatModal(id){
    console.log(id);
    var showMelumatModalString = "";
    for (var i = 0; i < computerMelumat.length; i++) {
      var c = computerMelumat[i];
     
      if (c.id == id) {
       
        showMelumatModalString+=  "<div class='card' style='width:98%;margin:1%'>"+
        "<img class='card-img-top'  src='"+computerMelumat[i].customer.imagePath+"' alt='Card image' style='width:25%;margin-left:37.5%;'>"+
        "<div class='card-body'>"+
        "<div class='card-text'>"+
       " <div class='pn' ><p><b>Ad:</b>"+computerMelumat[i].customer.name+"</p></div>"+
   "<div  class='pn'><p></p><b>Tesvir:</b>"+computerMelumat[i].customer.description+"</p></div>"+
   "<div class='pn'><p></p><b>Qiymet:</b>"+computerMelumat[i].customer.price+"man</p></div>"+
   "<div class='pn' ><p><b>Telefon:</b> "+computerMelumat[i].customer.phone+"</p></div>"+
   "<div  class='pn'><p><b>Yeni:</b> "+computerMelumat[i].computerABout.new+"</p></div>"+
   " <div class='pn' ><p><b>Ram:</b>"+computerMelumat[i].computerABout.ram+"</p></div>"+
   "<div  class='pn'><p></p><b>Cpu:</b>"+computerMelumat[i].computerABout.cpu+"</p></div>"+
   "<div class='pn'><p></p><b>Daimi Yaddas:</b>"+computerMelumat[i].computerABout.storage+"man</p></div>"+
   "<div  class='pn'><p><b>Daimi Yaddas tipi:</b> "+computerMelumat[i].computerABout.storageType+"</p></div>"+
   "<div class='pn' ><p><b>Emeliyyat sistemi:</b> "+computerMelumat[i].computerABout.operationSystem+"</p></div>"+
   "<div class='pn' ><p><b>Gpu(Video kart):</b> "+computerMelumat[i].computerABout.gpu+"</p></div>"+
   "</div>"+
        "</div>"+
      "</div>";
   
      }
    }
    $(document).ready(function(){
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
    basketComputers.push({ count: 1, computer: localComputer });
  }
 addToBasketAction();
  console.log(basketComputers);
  localStorage.setItem("basketComputers", JSON.stringify(basketComputers));
}
function addToBasketAction() {
 
  openBasketButton.style.display = 'none';
  
  setTimeout(function () {
    openBasketButton.style.display='block';
     basketCount.innerHTML = basketComputers.length;
  }, 200);
}
addToBasketAction();

function refreshComputerdBasket() {
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
  basketComputersTableBody.innerHTML = basketComputersTableBodyHtml;
 
}


function onOpenBasket(){

  refreshComputerdBasket();
}
function computerCountChanged(countInput, computerID) {
  if (countInput.value == "" || countInput.value == "0") {
    countInput.value = "1";
  }

  for (let index = 0; index < basketComputers.length; index++) {
    const b = basketComputers[index];
    if (b.computer.id === computerID) {
      b.count = Number(countInput.value);
      document.getElementById("product-total-price-" + b.computer.id).innerHTML =
        "" + b.count * b.computer.customer.price + " AZN";
      break;
    }
  }

  localStorage.setItem("basketComputers", JSON.stringify(basketComputers));}

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
  if (basketComputers.length === 0) {
    document.getElementById("modalbasket").style.display = "none";
  }
}