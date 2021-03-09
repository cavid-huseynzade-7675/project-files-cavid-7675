var basketProductsTableBody= document.getElementById('basket-products-table-body');
var newStudentModel=document.getElementById('new-student-modal');
var modalCloseButton=document.getElementById('modal-close-button');
var productname=document.getElementById('product-name');
var productprice=document.getElementById('product-price');
var productdescription=document.getElementById('product-description');
var productimage=document.getElementById('product-image');


var tokentring=localStorage.getItem('token');
    if(tokentring==null){localStorage.setItem('token','[]');}else{
        token=JSON.parse(tokentring);} 
var productString=localStorage.getItem('products');
    if(productString==null){localStorage.setItem('products','{}');}else{
        products=JSON.parse(productString);}
modalCloseButton.addEventListener("click",function(){
    newStudentModel.style.display="none";
    
})
function openmodal(){
newStudentModel.style.display="block";
    
}
function loadProducts(){
	var products=localStorage.getItem('products');
	products=JSON.parse(products);
	 
productsTableBodyHtml='';
		for (let index = 0; index < products.length; index++) {
			const p = products[index];
             var tt1=token;
            
              productsTableBodyHtml+='<tr><td>'+p.id;
			productsTableBodyHtml+='</td><td><img class="basket-phone-image" src="'+p.imagePath+'"/>';
			productsTableBodyHtml+='</td><td>'+p.name;
			productsTableBodyHtml+='</td><td>'+p.price;
            productsTableBodyHtml+='AZN</td><td>'+p.description;
	
			productsTableBodyHtml+='</td><td><button onclick=deleteStudent('+p.id+') class="btn-danger">Sil</button></td><tr>';  
            
			
		 
		}
		basketProductsTableBody.innerHTML=productsTableBodyHtml;
	 
	}
	

	
 
loadProducts();


function priceall(deyer,id){
for(var i=0;products.length;i++){
    if(id==products[i].id){ 
        products[i].totalprice=deyer*products[i].price;
        products[i].necedene=deyer;
       
       break;
    }
}


      localStorage.setItem('products',JSON.stringify(products));
    loadProducts();

}
function deleteStudent(id){
for(var i=0;products.length;i++){
    if(id==products[i].id){ 
        products.splice(i,1);break;
        
    }
}


      localStorage.setItem('products',JSON.stringify(products));
    loadProducts();


}





function saveproduct(){
    var tt=token;
  var productobyekt={id:products.length+1,name:productname.value,price:productprice.value,description:productdescription.value,userId:tt.userId,imagePath:productimage.value};
products.push(productobyekt);
    localStorage.setItem('products',JSON.stringify(products));
    loadProducts();
     newStudentModel.style.display="none";
    
  
}
