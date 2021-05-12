
var list=document.getElementById("kategoriya");
var kategoriyaString=localStorage.getItem('kategoriyaCS');
var kategoriya=JSON.parse(kategoriyaString);
var showListString="";


function showList() {
   
   showListString="";
 
    for(var i=0;i<=kategoriya.length-1;i++){
    
     showListString+="<button class='list-group-item' style='width: 100%;' onclick=select("+kategoriya[i].id+","+i+")>"+kategoriya[i].name+"</button>"
   
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