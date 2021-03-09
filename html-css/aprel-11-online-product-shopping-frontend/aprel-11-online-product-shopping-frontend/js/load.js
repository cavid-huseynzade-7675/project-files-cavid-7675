var products=[
{id:1,name:'product 1',price:14,description:'kitab 1',userId:1,imagePath:'images/01.jpg'},
{id:2,name:'product 2',price:15,description:'kitab 2',userId:1,imagePath:'images/02.jpg'},
{id:3,name:'product 3',price:18,description:'kitab 3',userId:2,imagePath:'images/03.jpg'},
{id:4,name:'product 4',price:34,description:'kitab 4',userId:2,imagePath:'images/04.jpg'},
{id:5,name:'product 5',price:44,description:'kitab 5',userId:3,imagePath:'images/05.jpg'},
{id:6,name:'product 6',price:54,description:'kitab 6',userId:3,imagePath:'images/06.jpg'}
];


for(var i=7;i<=100;i++){
	products.push(
	{id:i,name:'product '+i,price:(3*i),description:'kitab '+i,userId:3,imagePath:'images/06.jpg'}
	);
	
}

  localStorage.setItem('products',JSON.stringify(products));