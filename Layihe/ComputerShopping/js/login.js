var userPassword = document.getElementById('user-password');
var userName = document.getElementById('user-name');

var successLogin = false;
var users;

var usersString = localStorage.getItem("usersLayihe");
if (usersString == null) {
    users=[];
 
  
} else {
    users = JSON.parse(usersString);
}

function onLogin() {
   
        var username = userName.value.trim();
        var password = userPassword.value.trim();
       successLogin = false;
        for (var i = 0; i < users.length; i++) {
            if (users[i].username === username && users[i].password === password) {
                localStorage.setItem('tokenLayihe', JSON.stringify({
                    userName: username,
                    password: password,
                    userId: users[i].id
                }));
                successLogin = true;
                error(successLogin);
                break;
    
            }
    
        }
    
    

  

}
function error(successLogin){

    if (successLogin) {
        window.location.href = 'home.html';
    } else {
        alert('login failed');
    }
};