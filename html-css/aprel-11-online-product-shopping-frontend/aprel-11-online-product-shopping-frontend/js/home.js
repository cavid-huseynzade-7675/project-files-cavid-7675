var loggedIn=true;
var loginButton=document.getElementById('login-button');
var logoutButton=document.getElementById('logout-button');
var productsButton=document.getElementById('products-button');
var ordersButton=document.getElementById('orders-button');

var token=localStorage.getItem('token');

if(token==null){
	logoutButton.style.display='none';
	productsButton.style.display='none';
	ordersButton.style.display='none';
	
}else{
	loginButton.style.display='none';
	
}
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


function login(){
 
	window.location.href='login/login.html';
}


function logout(){
 localStorage.removeItem('token');
	window.location.href='';
}

function productsShow(){
 
	window.location.href='products.html';
}




//showButtonsIfLogin();