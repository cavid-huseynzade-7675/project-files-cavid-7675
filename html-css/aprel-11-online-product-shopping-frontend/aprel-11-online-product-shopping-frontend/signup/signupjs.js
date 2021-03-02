var newStudentModel=document.getElementById('new-student-modal');
var modalCloseButton=document.getElementById('modal-close-button');
var userName=document.getElementById('user-name');
var userPassword=document.getElementById('user-password');
var username=document.getElementById('user-name');
    var usersurname=document.getElementById('user-surname');
        var useristifadeciname=document.getElementById('user-istifadeci-name');
            var useremail=document.getElementById('user-email');
                var userpassword=document.getElementById('user-sifre');
var usersString=localStorage.getItem('users');
    if(usersString==null){localStorage.setItem('users','[]');}else{
        users=JSON.parse(usersString);}
function validation123(deyer,name){
    var setir=document.getElementById(name);
   var  htmltext="";
  if(deyer.length>25){
htmltext="<p style='color:red'> 25 herfden boyuk ola bilmez</p>";   
}
 if(deyer.length<5){
 htmltext="<p style='color:red'> 5 herfden balaca ola bilmez</p>";     
}      if(deyer.length==0){
 htmltext="<p style='color:red'> Bos qoymaq olmaz</p>";           
}
   if(deyer.length>4 && deyer.length<26){
      htmltext="<p style='color:green'> Dogrudur</p>";  
       
   }
   setir.innerHTML=htmltext;
}

function validationAdd(deyer){ 
    
    if(deyer.length>25){ return false;} 
    if(deyer.length<5){ return false;}
    return true;}
console.log(users);
function saveuser(){
    var id=users.length;
    var booll=true;
 
    var nm,srnm,email,password,username12;
    
    if(validationAdd(username.value)==true){nm=username.value}else{showNewStudentModal('Melumatlari dogru yaz:Ad','red');booll=false;}
    
if(validationAdd(usersurname.value)==true){srnm=usersurname.value}else{showNewStudentModal('Melumatlari dogru yaz:SoyAd','red');booll=false;}
    
if(validationAdd(userpassword.value)==true){password=userpassword.value}else{showNewStudentModal('Melumatlari dogru yaz:Password','red');booll=false;}
    
if(validationAdd(useristifadeciname.value)==true){username12=useristifadeciname.value}else{showNewStudentModal('Melumatlari dogru yaz:username','red'); booll=false;}
    email=useremail.value;
   
    if(booll==true){
        var booll2=true;
        for (var i=0;i<users.length;i++){
       if(username12==users[i].username){
        booll2=false;
        showNewStudentModal('Bu Istafadeci ad istifade olunur','red')   
           
       }
                  
        }}
        
           if(booll2==true){
                 id++;
         var user={id:id,username:username12,password:password,name:nm,surname:srnm,email:email};
        users.push(user);console.log(users);
    	localStorage.setItem('users',JSON.stringify(users));
                 showNewStudentModal('Ugurla qeyd olundu','green');   
           }        

}
modalCloseButton.addEventListener("click",function(){
    newStudentModel.style.display="none";
})
function showNewStudentModal(yazi,reng){
newStudentModel.style.display="block";
    var text=document.getElementById('error-modal');
    text.innerHTML="<p style='color:"+reng+"'> "+yazi+"</p>"
}
 
    