var loggedIn = true;
var loginButton = document.getElementById("login-button");
var logoutButton = document.getElementById("logout-button");
var productsButton = document.getElementById("products-button");
var ordersButton = document.getElementById("orders-button");
var signButton = document.getElementById("signup-button");
var account = document.getElementById("account");
var admin = document.getElementById("admin");
var frame = document.getElementById("frame");
function s() {
  var height =
    window.innerHeight ||
    document.documentElement.clientHeight ||
    document.body.clientHeight;
  var x = document.getElementById("n").offsetHeight;
  frame.height = height - x - 8;
}

s();

setInterval(function showNavbar() {
  var token;
  var tokenGlobalString = localStorage.getItem("tokenLayihe");
  if (tokenGlobalString == null) {
  } else {
    token = JSON.parse(tokenGlobalString);
  }

  if (token == null) {
    productsButton.style.display = "none";
    ordersButton.style.display = "none";
    loginButton.style.display = "block";
    logoutButton.style.display = "none";
    account.style.marginLeft = "50%";
    signButton.style.display = "block";
    admin.style.display = "none";
  } else {
    account.style.marginLeft = "42%";
    loginButton.style.display = "none";
    signButton.style.display = "none";
    productsButton.style.display = "block";
    ordersButton.style.display = "block";
    logoutButton.style.display = "block";
    admin.style.display = "none";
    if (token.userName == "admin") {
      admin.style.display = "block";
    } else {
      admin.style.display = "none";
    }
  }
}, 300);

function logout() {
  localStorage.removeItem("tokenLayihe");
  window.location.href = "";
  var x=[];
  localStorage.setItem("basketComputers",JSON.stringify(x));
  showNavbar();
}
