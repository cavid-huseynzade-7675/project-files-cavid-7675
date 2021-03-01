var userName=document.getElementById('user-name');
var userPassword=document.getElementById('user-password');

var users=[
{id:1,username:'u1',password:'p1'},
{id:2,username:'u2',password:'p2'},
{id:3,username:'u3',password:'p3'}
];


var products=[
{id:1,name:'product 1',price:14,description:'',userId:1,imagePath:'images/01.jpg'},
{id:2,name:'product 2',price:15,description:'',userId:1,imagePath:'images/02.jpg'},
{id:3,name:'product 3',price:18,description:'',userId:2,imagePath:'images/03.jpg'},
{id:4,name:'product 4',price:34,description:'',userId:2,imagePath:'images/04.jpg'},
{id:5,name:'product 5',price:44,description:'',userId:3,imagePath:'images/05.jpg'},
{id:6,name:'product 6',price:54,description:'',userId:3,imagePath:'images/06.jpg'}
];

var basketProducts=[
{id:1,count:3,productId:2},
{id:2,count:5,productId:4},
{id:3,count:7,productId:6}
];

var order={
id:1,basketProducts:basketProducts,
customer:{id:1,name:'Customer-1',phone:'055-555-5555',
address:'Address-1',email:'email@gmail.com'},
register:new Date(),notes:'qeyd-1',totalPrice:1234
};

var orders=[];
orders.push(order);


function login(){
var username=userName.value.trim();
var password=userPassword.value.trim();

var successLogin=true;
var userId=1;
if(successLogin){
window.location.href='home.html';
}else{alert('login failed');}

}

function saveModels(){
	
	localStorage.setItem('products',JSON.stringify(products));
	
}

saveModels();