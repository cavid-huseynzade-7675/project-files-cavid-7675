var kategoriyaSelect=document.getElementById("kategoriyaSelect");
var nameInput=document.getElementById("nameInput");
var priceInput=document.getElementById("priceInput");
var descriptionInput=document.getElementById("descriptionInput");
var yeniSelect=document.getElementById("yeniSelect");
var imageInput=document.getElementById("imageInput");
var ramInput=document.getElementById("ramInput");
var cpuInput=document.getElementById("cpuInput");
var storageInput=document.getElementById("storageInput");
var storageselectType=document.getElementById("storageselectType");
var operationSystemInput=document.getElementById("operationSystemInput");
var gpuInput=document.getElementById("gpuInput");
var telefonInput=document.getElementById("telefonInput");
var saver=document.getElementById("saver");

var kategoriyaString=localStorage.getItem('kategoriyaCS');
var kategoriya=JSON.parse(kategoriyaString);




var tableBody=document.getElementById("tableBody");
var computerMelumat=[]
var computerString = localStorage.getItem("computerLayihe");
computerMelumat = JSON.parse(computerString);
var token;
		var tokenGlobalString = localStorage.getItem("tokenLayihe");
		if (tokenGlobalString == null) {} else {
			token = JSON.parse(tokenGlobalString);}

function  loadComputers(){
  tableBody.innerHTML = "";
  var tableBodyHtml = "";
   for (let index = 0; index < computerMelumat.length; index++) {
    const b = computerMelumat[index];
     if(b.customer.userId==token.userId){
      tableBodyHtml += "<tr><td>" + b.id;
      tableBodyHtml += "</td><td>" + b.customer.name;
      tableBodyHtml += "</td><td><img style='width: 60px;'' src='" + b.customer.imagePath+"'>";
      tableBodyHtml += "</td><td>" + b.customer.price;
      tableBodyHtml += "</td><td> <button class='btn btn-danger'>Sil</button>"+
      "<button class='btn btn-warning'>Redakte et</button></td></tr>" ;

     }
    
    
   
     
   }
   tableBody.innerHTML = tableBodyHtml;
  
 }
loadComputers(computerMelumat);

 function kategoriyaload(){
var  showselectString="";
 
    for(var i=0;i<=kategoriya.length-1;i++){
    
      showselectString+="<option>"+kategoriya[i].name+"</option>"
   
        }
        kategoriyaSelect.innerHTML=showselectString;


}
kategoriyaload();
function saverClicked() {

  

  if (saver.classList.item(1) == "btn-success") {
    saveComputer();
  } else {
    //editComputer();
  }
}

function saveComputer(){

  var   obyekt=computerMelumat[computerMelumat.length-1];
  var customer={userId:token.userId,name:nameInput.value,description:descriptionInput.value,
    price:priceInput.value,phone:telefonInput.value,imagePath:imageInput.value};

var computerABout={new:yeniSelect.value,
  ram:ramInput.value,cpu:cpuInput.value,storage:storageInput.value,
  storageType:storageselectType.value,operationSystem:operationSystemInput.value,
  gpu:gpuInput.value,kategoriya:kategoriyaSelect.value}

var all={id:obyekt.id+1,customer:customer,computerABout:computerABout};
computerMelumat.push(all);
console.log(computerMelumat);
localStorage.setItem("computerLayihe",JSON.stringify(computerMelumat));


var computerString = localStorage.getItem("computerLayihe");
computerMelumat = JSON.parse(computerString);

loadComputers(computerMelumat);

}

function form(event){

  event.preventDefault();
}