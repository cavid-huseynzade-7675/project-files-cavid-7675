

var users=[
{id:1,username:'u1',password:'p1'},
{id:2,username:'u2',password:'p2'},
{id:3,username:'u3',password:'p3'}
];

var usersString=localStorage.getItem('users');
    if(usersString==null){localStorage.setItem('users','[]');}else{
        users=JSON.parse(usersString);}
var products=[
{id:1,name:'product 1',price:14,description:'kitab 1',userId:1,imagePath:'images/01.jpg',totalprice:14,necedene:1},
{id:2,name:'product 2',price:15,description:'kitab 2',userId:1,imagePath:'images/02.jpg',totalprice:15,necedene:1},
{id:3,name:'product 3',price:18,description:'kitab 3',userId:2,imagePath:'images/03.jpg',totalprice:18,necedene:1},
{id:4,name:'product 4',price:34,description:'kitab 4',userId:2,imagePath:'images/04.jpg',totalprice:34,necedene:1},
{id:5,name:'product 5',price:44,description:'kitab 5',userId:3,imagePath:'images/05.jpg',totalprice:44,necedene:1},
{id:6,name:'product 6',price:54,description:'kitab 6',userId:3,imagePath:'images/06.jpg',totalprice:54,necedene:1}
];
  localStorage.setItem('products',JSON.stringify(products));

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




    