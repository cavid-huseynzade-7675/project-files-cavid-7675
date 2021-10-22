var customerName=document.getElementById('customer-name');
var customerAdress=document.getElementById('customer-adress');
var customerPhone=document.getElementById('customer-phone');

var order={};
var basketBooksFromStorage = localStorage.getItem('basketBooks');


if (basketBooksFromStorage == null) {
    localStorage.setItem('basketBooks', [])
} else {
    basketBooks = JSON.parse(basketBooksFromStorage);
}

order.basketBooks=basketBooks;
order.customer={};
function confirmOrder() {
    order.customer.name=customerName.value;
    order.customer.adress=customerAdress.value;
    order.customer.phone=customerPhone.value;
    console.log(order);
    var xhttp= new XMLHttpRequest();
    xhttp.onreadystatechange=function(){
        if (this.readyState==4 && this.status==200) {
            var respone=this.responseText;
        }
    };
    xhttp.open("POST","/rest/orders",true)
    xhttp.setRequestHeader("Content-type","application/json")
xhttp.send(JSON.stringify(order));
}