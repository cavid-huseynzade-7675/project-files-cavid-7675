var loggedIn = true;
var card1 = document.getElementById('card1');
var card3 = document.getElementById('card3');


setInterval(showHome(), 300);

var computerMelumat=[]
var computerString = localStorage.getItem("computerLayihe");
if (computerString == null) {
  for (var i = 1; i < 41; i++) {
    var customer={userId:i,name:'Acer'+i,description:'tesvir'+i,price:i*3,phone:'050 216 48 06',imagePath:'images/acer.png'};
    var computerABout={new:'beli',ram:i+'gb',cpu:'Core|'+i,storage:i*2+' gb',storageType:'ssd',operationSystem:'Windows 10',gpu:i+' gb',kategoriya:'acer'}
    var all={id:i,customer:customer,computerABout:computerABout};
    computerMelumat.push(all);
  }
  for (var i = 41; i < 81; i++) {
    var customer={userId:i,name:'monster'+i,description:'tesvir'+i,price:i*3,phone:'050 216 48 06',imagePath:'images/macbook.png'};
    var computerABout={new:'beli',ram:i+'gb',cpu:'Core|'+i,storage:i*2+' gb',storageType:'ssd',operationSystem:'Windows 10',gpu:i+' gb',kategoriya:'monster'}
    var all={id:i,customer:customer,computerABout:computerABout};
    computerMelumat.push(all);
  }
  for (var i = 81; i < 121; i++) {
    var customer={userId:i,name:'asus'+i,description:'tesvir'+i,price:i*3,phone:'050 216 48 06',imagePath:'images/asus.png'};
    var computerABout={new:'beli',ram:i+'gb',cpu:'Core|'+i,storage:i*2+' gb',storageType:'ssd',operationSystem:'Windows 10',gpu:i+' gb',kategoriya:'asus'}
    var all={id:i,customer:customer,computerABout:computerABout};
    computerMelumat.push(all);
  }
  for (var i = 121; i < 161; i++) {
    var customer={userId:i,name:'macbook'+i,description:'tesvir'+i,price:i*3,phone:'050 216 48 06',imagePath:'images/macbook.png'};
    var computerABout={new:'beli',ram:i+'gb',cpu:'Core|'+i,storage:i*2+' gb',storageType:'ssd',operationSystem:'Windows 10',gpu:i+' gb',kategoriya:'macbook'}
    var all={id:i,customer:customer,computerABout:computerABout};
    computerMelumat.push(all);
  }
  for (var i = 161; i < 201; i++) {
    var customer={userId:i,name:'lenovo'+i,description:'tesvir'+i,price:i*3,phone:'050 216 48 06',imagePath:'images/lenovo.png'};
    var computerABout={new:'beli',ram:i+'gb',cpu:'Core|'+i,storage:i*2+' gb',storageType:'ssd',operationSystem:'Windows 10',gpu:i+' gb',kategoriya:'lenovo'}
    var all={id:i,customer:customer,computerABout:computerABout};
    computerMelumat.push(all);
  }

  localStorage.setItem('computerLayihe',JSON.stringify(computerMelumat));

} else {
  computerMelumat = JSON.parse(computerString);
}

var kategoriya=[]
var kategoriyaString = localStorage.getItem("kategoriyaCS");
if (kategoriyaString == null) {
kategoriya=[
	{id:1,name:'acer'},
	{id:2,name:'monster'},
	{id:3,name:'asus'},
	{id:4,name:'macbook'},
	{id:5,name:'lenovo'},
]

  localStorage.setItem('kategoriyaCS',JSON.stringify(kategoriya));

} else {
	kategoriya = JSON.parse(computerString);
}


function showHome () {
	var token;
	var tokenGlobalString = localStorage.getItem("tokenLayihe");
	if (tokenGlobalString == null) {} else {
		token = JSON.parse(tokenGlobalString);
	}

	if (token == null) {

		card1.style.display = 'none';
		card3.style.display = 'none';
		

	} else {
		card1.style.marginLeft = "block";
		card3.style.display = 'block';

	}




}
showHome();