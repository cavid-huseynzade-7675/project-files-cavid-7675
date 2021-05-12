var loggedIn = true;
var card1 = document.getElementById('card1');
var card3 = document.getElementById('card3');


setInterval(showHome(), 300);




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