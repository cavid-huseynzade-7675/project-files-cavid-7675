 
var productContainer= document.getElementById('container');

function homePage(){
	window.location.href='../home.html';
}





function loadProducts(){
	var products=localStorage.getItem('products');
	products=JSON.parse(products);
	var productsHtml='';
	for(var i=0;i<products.length;i++){
        var p = products[i];
		productsHtml+="<div class='product-card'><div class='product-card-item'><div class='photo-div'><img class='book-photo' src='"+p.imagePath+"'></div><div class='text-div'><p class='price-text'>"+p.price+" AZN</p><p class='name-text'>"+p.name+"</p><p class='desc-text'>"+p.description+"</p></div></div></div>";
		
	}
	productContainer.innerHTML=productsHtml;
	
}
loadProducts();