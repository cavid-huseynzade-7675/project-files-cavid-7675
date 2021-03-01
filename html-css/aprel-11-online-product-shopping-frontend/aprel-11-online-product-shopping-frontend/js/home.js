var loggedIn=true;
var loginButton=document.getElementById('login-button');
var logoutButton=document.getElementById('logout-button');
var productsButton=document.getElementById('products-button');
var ordersButton=document.getElementById('orders-button');
function customerPage(){
 
	window.location.href='customer/index.html';
}


function showButtonsIfLogin(){
	if(loggedIn){
		loginButton.style.display='none';
	}else{
		 logoutButton.style.display='none';
		 productsButton.style.display='none';
		 ordersButton.style.display='none';
	}
}

showButtonsIfLogin();