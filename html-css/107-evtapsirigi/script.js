var name12=document.getElementById('name');
var adres=document.getElementById('adres');
var phone=document.getElementById('phone');
var email=document.getElementById('email');
var note=document.getElementById('note');


function customername(name1){
    nametxt="";
  if(name1.length>15){
nametxt="<p style='color:red'> 15 herfden boyuk ola bilmez</p>";
}
    if(name1.length<3){
 nametxt="<p style='color:red'> 3 herfden balaca ola bilmez</p>";
}
       if(name1.length==0){
 nametxt="<p style='color:red'> Bos qoymaq olmaz</p>";
}
   name12.innerHTML=nametxt;
    
}
function customeradress(adress){
       adrestxt="";
  if(adress.length>25){
adrestxt="<p style='color:red'> 25 herfden boyuk ola bilmez</p>";
}
    if(adress.length<3){
 adrestxt="<p style='color:red'> 3 herfden balaca ola bilmez</p>";
}
       if(adress.length==0){
 adrestxt="<p style='color:red'> Bos qoymaq olmaz</p>";
}
   adres.innerHTML=adrestxt;
     console.log("2"); 
}
function customerphone(phone1){
         phonetxt="";
  if(phone1.length>25){
phonetxt="<p style='color:red'> 25 reqemden boyuk ola bilmez</p>";
}
    if(phone1.length<3){
 phonetxt="<p style='color:red'> 3 reqemden balaca ola bilmez</p>";
}
       if(phone1.length==0){
 phonetxt="<p style='color:red'> Bos qoymaq olmaz</p>";
}
   phone.innerHTML=phonetxt;
    
}
function customeremail(email1){
        emailtxt="";
  if(email1.length>25){
emailtxt="<p style='color:red'> 25 herfden boyuk ola bilmez</p>";
}
    if(email1.length<3){
 emailtxt="<p style='color:red'> 3 herfden balaca ola bilmez</p>";
}
       if(email1.length==0){
 emailtxt="<p style='color:red'> Bos qoymaq olmaz</p>";
}
   email.innerHTML=emailtxt;
}
function ordernote(note1){
    
     notet="";
  if(note1.length>50){
notet="<p style='color:red'> 50 herfden boyuk ola bilmez</p>";
}
    if(note1.length<10){
 notet="<p style='color:red'> 10 herfden balaca ola bilmez</p>";
}
       if(note1.length==0){
 notet="<p style='color:red'> Bos qoymaq olmaz</p>";
}
   note.innerHTML=notet;
    
}
