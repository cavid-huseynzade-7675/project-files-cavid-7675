var mainContentHTML = "";
var begin = 0;
var length = 20;
var xht = new XMLHttpRequest();
var xhttp = new XMLHttpRequest();
var users=[];
var computeraArrayGlobal = [];
var userXht;
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     var responseJSON = this.responseText;
users  =JSON.parse(responseJSON);
xht.onreadystatechange = function () {


    if (this.readyState == 4 && this.status == 200) {
        var responseJSON = this.responseText;
        var computeraArray = JSON.parse(responseJSON);
        computeraArrayGlobal.push(...computeraArray)

        var mainContent = document.getElementById("cards");
       
        for (var i = 0; i < computeraArray.length; i++) {

          
           var computer = computeraArray[i];
           var computerPrice=computer.price;
               var computerModel=computer.model;
           var computerMarka=computer.marka;
         

           var markaN = "";
           var modelN = "";
             if (computerMarka.length > 6) {
                markaN = "...";
           }
           if (computerModel.length > 6) {
            modelN = "...";
           }
           
        
         

           
           mainContentHTML += "<div class='product-card'>";
           mainContentHTML += "   <div class='product-card-item'>";
           mainContentHTML += " <div class='photo-div'>";
           mainContentHTML +=
           "     <img class='book-photo'  src='files/" + computer.image + "'></div>";
           mainContentHTML +=
           "<div class='text-div'><p class='price-text' title=" +
           computerPrice +
           " > " +
           computerPrice+
           " </p>";
           mainContentHTML +=
           "<p class='marka-text'    title='" +
           computerMarka +
           "' >" +
           computerMarka.substring(0,6) + markaN
           "</p>";
           mainContentHTML +=
           "<p class='model-text'    title='" +
           computerModel +
           "' >" +
           computerModel.substring(0,6) + modelN
           "</p>";
        console.log(users);
for (let index = 0; index < users.length; index++) {
    var element = users[index];
   console.log(element.username,computer.username)
    if (computer.username==element.username) {
        var nameandsurname= element.nameandsurname;
        var phone=element.phone;
        var nameandsurN = "";
        var phoneN = "";
          if (nameandsurname.length >6) {
            nameandsurN = "...";
        }
        if (phone.length > 6) {
         phoneN = "...";
        }

        mainContentHTML +=
        "<p class='name-text'    title='" +
        nameandsurname +
        "' >" +
        nameandsurname.substring(0,6) +nameandsurN
         "</p>";
         mainContentHTML +=
         "<p class='phone-text'    title='" +
        phone +
         "' >" +
        phone.substring(0,6) +phoneN
         "</p>";
    }
}

               
mainContentHTML +=
"<br><button onclick=showInfo("+computer.id+") data-toggle='modal' data-target='#myModal'  style='witdh:50%;margin-left:25%;' class='btn btn-primary'>Etrafli</button> ";


           mainContentHTML += "</div></div></div></div>";
        }

        mainContent.innerHTML = mainContentHTML;
    }
};
xht.open("POST", "rest/computers/search-find-partial", true);
xht.setRequestHeader("Content-type","application/json");
var searchObject={search:'',begin:begin,length:length};
xht.send(JSON.stringify(searchObject));


    }
}   ;
xhttp.open("GET", "/rest/users", true);
xhttp.setRequestHeader("Content-type","application/json");
xhttp.send();

function showInfo(Computerid) {
    var modalHtml="";

    console.log(computeraArrayGlobal)
    for (let index = 0; index < computeraArrayGlobal.length; index++) {
        var element = computeraArrayGlobal[index];
       if (element.id==Computerid) {
        modalHtml +=
        "<div class='card' style='width:98%;margin:1%'>" +
        "<img class='card-img-top' src='files/" + element.image + "'" +
        
        "' alt='Card image' style='width:25%;margin-left:37.5%;'>" +
        "<div class='card-body'>" +
        "<div class='card-text'>" +
        " <div class='pn' ><p><b>Marka:</b>" +
        element.marka+ 
        "</p></div>" +
        "<div  class='pn'><p></p><b>Model:</b>" +
       element.model+
        "</p></div>" +
        "<div class='pn'><p></p><b>Qiymet:</b>" +
        element.price +
        "man</p></div>" +
        "<div class='pn' ><p><b>Ram:</b> " +
        element.ram +
        "</p></div>" +
        "<div  class='pn'><p><b>Cpu:</b> " +
        element.cpu +
        "</p></div>" +
        " <div class='pn' ><p><b>Gpu:</b>" +
      element.gpu +
        "</p></div>" +
      
        "<div class='pn'><p></p><b>Daimi Yaddas:</b>" +
        element.yaddas +
        "</p></div>" +
        "<div  class='pn'><p><b>Daimi Yaddas tipi:</b> " +
        element.yaddastipi+
              "</p></div>" +
        "<div class='pn' ><p><b>Emeliyyat sistemi:</b> " +
        element.emeliyyatsistemi +
        "</p></div>" ;
        
       
  
            for (let index = 0; index < users.length; index++) {
                var user = users[index];
                if (user.username==element.username) {
                    
                    modalHtml+="<div class='pn' ><p><b>Saticinin Adi:</b> " +
                    user.username +
                    "</p></div>"+"<div class='pn' ><p><b>Saticinin Emaili:</b> " +
                    user.email +
                    "</p></div>"+"<div class='pn' ><p><b>Saticinin telefon nomresi:</b> " +
                    user.phone +
                    "</p></div>"+ 
                    "</div>" +
                    "</div>" +
                    "</div>";
  
                   
                }

                
            }

            document.getElementById("modal").innerHTML=modalHtml
        }
        
    }
}



