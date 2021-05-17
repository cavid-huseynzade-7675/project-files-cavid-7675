 function showLoginPage() {

     window.location.href = 'login.html';
 }


 var newStudentModel = document.getElementById('new-student-modal');
 var userName = document.getElementById('user-name');
 var userPassword = document.getElementById('user-password');
 var username = document.getElementById('user-name');
 var usersurname = document.getElementById('user-surname');
 var useristifadeciname = document.getElementById('user-istifadeci-name');
 var useremail = document.getElementById('user-email');
 var userpassword = document.getElementById('user-sifre');

var id;
 var users=[];


 

 var usersString = localStorage.getItem("usersLayihe");
 if (usersString == null) {
     users=[{id:1,username:'u1',password:'p1'},
    {id:2,username:'u2',password:'p2'},
    {id:3,username:'u3',password:'p3'}
    ,{id:4,username:'u4',password:'p4'}
    ,{id:5,username:'u5',password:'p5'}
    ,{id:6,username:'admin',password:'admin'}]
    localStorage.setItem('usersLayihe', JSON.stringify(users));

 } else {
  
   users = JSON.parse(usersString);
 }


 function validation123(deyer, name) {
     var setir = document.getElementById(name);
     var htmltext = "";
     if (deyer.length > 25) {
         htmltext = "<p style='color:red'> 25 herfden boyuk ola bilmez</p>";
     }
     if (deyer.length < 3) {
         htmltext = "<p style='color:red'> 3 herfden balaca ola bilmez</p>";
     }
     if (deyer.length == 0) {
         htmltext = "<p style='color:red'> Bos qoymaq olmaz</p>";
     }
     if (deyer.length > 2 && deyer.length < 26) {
         htmltext = "<p style='color:green'> Dogrudur</p>";

     }
     setir.innerHTML = htmltext;
 }

 function validationAdd(deyer) {

     if (deyer.length > 25) {
         return false;
     }
     if (deyer.length < 3) {
         return false;
     }
     return true;
 }
 console.log(users);

 function saveuser() {


    
     var booll = true;

     var   password, username12;

     

     if (validationAdd(userpassword.value) == true) {
         password = userpassword.value
     } else {
        newStudentModel.classList.remove("alert-success");
        newStudentModel.classList.add("alert-danger");
         showNewStudentModal('Melumatlari dogru yaz:Password');
         booll = false;
     }

     if (validationAdd(useristifadeciname.value) == true) {
         username12 = useristifadeciname.value
     } else {
        newStudentModel.classList.remove("alert-success");
        newStudentModel.classList.add("alert-danger");
         showNewStudentModal('Melumatlari dogru yaz:username');
         booll = false;
     }
     

     if (booll == true) {
         var booll2 = true;
         for (var i = 0; i < users.length; i++) {
             if (username12 == users[i].username) {
                 booll2 = false;
                 newStudentModel.classList.remove("alert-success");
                 newStudentModel.classList.add("alert-danger");
                 showNewStudentModal('Bu Istafadeci ad istifade olunur')

             }

         }
     }

     if (booll2 == true) {
      var   obyekt=users[users.length-1];
      
      console.log();
         var user = {
             id:obyekt.id+1 ,
             username: username12,
             password: password,
         };
         users.push(user);
         console.log(users);
         localStorage.setItem('usersLayihe', JSON.stringify(users));
         newStudentModel.classList.add("alert-success");
         newStudentModel.classList.remove("alert-danger");
         showNewStudentModal('Ugurla qeyd olundu');
     }

 }

 function showNewStudentModal(yazi) {
     
     newStudentModel.style.display = "block";
     var text = document.getElementById('error-modal');
     text.innerHTML = "<p> " + yazi + "</p>"
 }

