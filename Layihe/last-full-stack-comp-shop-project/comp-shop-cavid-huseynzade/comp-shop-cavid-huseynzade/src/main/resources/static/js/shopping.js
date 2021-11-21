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
           
           
           mainContentHTML += "<div class='product-card'>";
           mainContentHTML += "   <div class='product-card-item'>";
           mainContentHTML += " <div class='photo-div'>";
           mainContentHTML +=
           "     <img class='book-photo'  src='files/" + computer.image + "'></div>";
           mainContentHTML +=
           "<div class='text-div'><p class='price-text' title=" +
           computer.price +
           " > " +
           computer.price+
           " </p>";
           mainContentHTML +=
           "<p class='marka-text'    title='" +
           computer.marka +
           "' >" +
           computer.marka +
           "</p>";
           mainContentHTML +=
           "<p class='model-text'    title='" +
           computer.model +
           "' >" +
           computer.model +
           "</p>";
        console.log(users);
for (let index = 0; index < users.length; index++) {
    var element = users[index];
   console.log(element.username,computer.username)
    if (computer.username==element.username) {
        mainContentHTML +=
        "<p class='name-text'    title='" +
        element.nameandsurname +
        "' >" +
        element.nameandsurname +
         "</p>";
         mainContentHTML +=
         "<p class='phone-text'    title='" +
         element.phone +
         "' >" +
         element.phone +
         "</p>";
    }
}

               
        
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




