var productCard= document.getElementById('product-card');
var productContainer= document.getElementById('container');

function homePage(){
	window.location.href='../home.html';
}





function loadProducts(){
	var products=localStorage.getItem('products');
	products=JSON.parse(products);
	var productsHtml='';
	for(var i=0;i<products.length;i++){
		productsHtml+="<div class='product-card'><div class='product-card-item'></div></div>";
		
	}
	productContainer.innerHTML=productsHtml;
	
}
loadProducts();