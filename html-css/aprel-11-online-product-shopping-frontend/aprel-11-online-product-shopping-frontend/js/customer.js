var openBasketButton= document.getElementById('open-basket-button');
var productContainer= document.getElementById('container');
var basketCount= document.getElementById('basket-count');
var newStudentModel3=document.getElementById('new-student-modal3');
var basketProductsTableBody= document.getElementById('basket-products-table-body');
var basketProducts=[];
var productsGlobal;
var productsHtml='';

function homePage(){
	window.location.href='../home.html';
}
function loadProducts(){
	var products=localStorage.getItem('products');
	products=JSON.parse(products);
	productsGlobal=products.slice();
	
	var initialProducts=[];
	for(var i=0;i<20;i++){
		initialProducts.push(productsGlobal[i]);
	}
	addProductsToPage(initialProducts);
}

function addProductsToPage(products12){
	
	for(var i=0;i<products12.length;i++){
        var p = products12[i];
		productsHtml+="<div class='product-card'><div class='product-card-item'><div class='photo-div'>"+
		"<img class='book-photo' src='"+p.imagePath+"'></div><div class='text-div'><p class='price-text'>"+p.price+
		" AZN</p><p class='name-text'>"+p.name+"</p><p class='desc-text'>"+p.description+"</p>"+
		"<div style='text-align:center;'><button class='btn btn-primary' onclick='onAddToBasket("+p.id+
		")'>Səbətə at</button></div></div></div></div>";
	}
	productContainer.innerHTML=productsHtml;
	
}
loadProducts();
function onAddToBasket(productId){
	var localProduct=null;
	for(var i=0;i<productsGlobal.length;i++){
		if(productId===productsGlobal[i].id){
			localProduct=productsGlobal[i];break;
		}
	}
	var productExists=false;
	for(var i=0;i<basketProducts.length;i++){
		if(productId===basketProducts[i].product.id){
			basketProducts[i].count++;
			productExists=true;
			break;
		}
	}
	if(productExists){}else{
		basketProducts.push({count:1,product:localProduct});
	}
	addToBasketAction();
	console.log(basketProducts);
}
function addToBasketAction(){
	openBasketButton.style.display='none';
	setTimeout(function(){
		openBasketButton.style.display='block';
		basketCount.innerHTML=basketProducts.length;
		},200);
}

var begin=0;
var length=20;

function loadNextProducts(){ // 1000 
	begin+=20;
	if((begin+length)>productsGlobal.length){
		
	}else{
		
		
		
		var initialProducts=[];
	for(var i=begin;i<(begin+length);i++){
		initialProducts.push(productsGlobal[i]);
	}
	addProductsToPage(initialProducts);
	
	
	
	}
	
}

var counter=0;
var allowScroll=true;
window.addEventListener('scroll',function (){
	
	const distanceToBottom = document.body.getBoundingClientRect().bottom;
	const clientHeight=document.documentElement.clientHeight;
	if(allowScroll){
  if(distanceToBottom<clientHeight+100){
	  allowScroll=false;
	  setTimeout(function (){
		  loadNextProducts();
		  allowScroll=true;
	  },1000);
  }
  }
		
	//counter++;
	//console.log('scroll = '+counter);
	//console.log('height = '+distanceToBottom+', '+clientHeight);
	
});

 function  closemodal(){
     console.log('ss');
    newStudentModel3.style.display='none';
    
}
function onOpenBasket(){
    newStudentModel3.style.display='block';
    productsTableBodyHtml='';
    for (let index = 0; index < basketProducts.length; index++) {
			const p = basketProducts[index];
             
            
              productsTableBodyHtml+='<tr><td>'+p.count;
			productsTableBodyHtml+='</td><td><img class="basket-phone-image" style="max-height: 60px;max-width: 80px;" src="'+p.product.imagePath+'"/>';
			productsTableBodyHtml+='</td><td>'+p.product.name;
			productsTableBodyHtml+='</td><td>'+p.product.price;
            productsTableBodyHtml+='AZN</td><td>'+p.product.description;
	
			productsTableBodyHtml+='</td><tr>';  
            
			
		 
		}
		basketProductsTableBody.innerHTML=productsTableBodyHtml;
    
    
}

function search(deyersearch){
var products=localStorage.getItem('products');
	products=JSON.parse(products);
	productsGlobal123=products.slice();
	
	var initialProducts12=[];
	for(var i=0;i<20;i++){
        var denek=productsGlobal123[i];
        
        if(deyersearch===productsGlobal123[i].name){
     initialProducts12.push(productsGlobal123[i])
        }
		
	}
    console.log(initialProducts12);
	addProductsToPage(initialProducts12);
     
}

