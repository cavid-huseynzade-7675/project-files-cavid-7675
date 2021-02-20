var students=[];
var studentName=document.getElementById('student-name');
var studentSurname=document.getElementById('student-surname');
var sqiymet=document.getElementById('s-qiymet');
var ssekil=document.getElementById('s-sekil');
var studentsTbody=document.getElementById('students-tbody');
 var adalert=document.getElementById('ad-alert');
 var muellifalert=document.getElementById('muellif-alert');
 var qiymetalert=document.getElementById('qiymet-alert');
var body=document.getElementById('bodys');


var studentName1=document.getElementById('student-name1');
var studentSurname1=document.getElementById('student-surname1');
var sqiymet1=document.getElementById('s-qiymet1');
var ssekil1=document.getElementById('s-sekil1');

 var adaler1=document.getElementById('ad-alert1');
 var muellifalert1=document.getElementById('muellif-alert1');
 var qiymetalert1=document.getElementById('qiymet-alert1');
function saveStudent(){
 
var id=1;
    for(var i=0;i<students.length;i++){
        
        if(students[i].id>id){id=students[i].id}
    }
   id++;
var student={id:id,name:studentName.value,surname:studentSurname.value,qiymet:sqiymet.value,sekil:ssekil.value}
   
    students.push(student);
    fillStudentTable(students);
    
    
    newStudentModel.style.display="none";
}

function fillStudentTable(students){
    var xxxxx=true;
    var idsss=1;
     ;
    studentsTbody.innerHTML='';
    for(var i=0;i<students.length;i++){
var s=students[i];
        var tr=document.createElement('tr');
        tr.innerHTML="<tr id="+idsss+"></tr>";
       tr.setAttribute("id",idsss);
        
        
        
          var idTd=document.createElement('td');
        idTd.innerHTML=s.id;
       
        
          var nTd=document.createElement('td');
       if(validatead(s.name,'Adi',"ad")==true){   nTd.innerHTML=s.name;}else{xxxxx=false;}
      
     
        
          var snTd=document.createElement('td');
        if(validatesoy(s.surname,'Soyadi',"soy")==true){    snTd.innerHTML=s.surname;}else{xxxxx=false;}
      
        
          var qTd=document.createElement('td');
        
         if(validatenumer(s.qiymet)==true){    qTd.innerHTML=s.qiymet;}else{xxxxx=false;}
          var sTd=document.createElement('td');
       
        sTd.innerHTML=s.sekil;
   
    
       
        var pppTd=document.createElement('td');
          var opsTd=document.createElement('div');
        opsTd.innerHTML="<button onclick='delStudent("+s.id+")' style='float:left' class='btn btn-border btn-danger'>Sil</button>";
       
         var psTd=document.createElement('div');
        psTd.innerHTML="<button style='float:left;margin-left:5%' onclick='redaStudent("+idsss+",)' class='btn btn-border btn-warning'>Redakte</button>";
 

        tr.appendChild(idTd);
         tr.appendChild(nTd);
        tr.appendChild(snTd);
        tr.appendChild(qTd);
         tr.appendChild(sTd);
        pppTd.appendChild(opsTd);
          pppTd.appendChild(psTd);
         tr.appendChild(pppTd);
        
        studentsTbody.appendChild(tr);
    idsss++;
        
        if(xxxxx==false){delStudent(s.id);}
        xxxxx=true;
    }
}
function delStudent(id){
    ;
    for(var i=0;i<students.length;i++){
        
     if(students[i].id==id)   {
         
       students.splice(i,1)  ;break;
     }
    }
  fillStudentTable(students);  
  
}
function validatead(yoxlama,yazi) {
    var y=yoxlama;
var x=y.trim();
  if (x.length<2) {
  
       adalert.innerHTML="<p>"+yazi+" 2 herfden balaca ola bilmez</p>";
return false;     
  }if( x.length>20){
     
        adalert.innerHTML="<p>"+yazi+" 20 herfden boyuk ola bilmez</p>";
      return false;
  }else{
       adalert.innerHTML="<p style='color: green' >Dogrudur</p>";
    return true;  
  }
   
}
function validatesoy(yoxlama,yazi) {
    var y=yoxlama;
var x=y.trim();
  if (x.length<2) {
  muellifalert.innerHTML="<p>"+yazi+" 2 herfden balaca ola bilmez</p>";
return false;     
  }if( x.length>20){
       muellifalert.innerHTML="<p>"+yazi+" 20 herfden boyuk ola bilmez</p>";
      return false;
  }else{
  
       muellifalert.innerHTML="<p style='color: green' >Dogrudur</p>";
        return true;  
  }
   
}
var idred=0;;
function redaStudent(id){
    
    newStudentModel1.style.display="block";
var idredakte=id;
    idred=id;
  
}
 
function saveReda(){
 

        
          students[idred]={id:idred,name:studentName1.value,surname:studentSurname1.value,qiymet:sqiymet1.value,sekil:ssekil1.value};
            
      
    
    
    
    
    
    
   
 
   
   fillStudentTable(students);
    idred=0;
    
}
  function validatenumer(number) {
    var x=number;
 
   if(x=="")  
  { 
      qiymetalert.innerHTML="<p>Tevelludu bos qoymaq olmaz</p>";
     return false;
     
  }  else {
     qiymetalert.innerHTML="<p style='color: green' >Dogrudur</p>";
 
   return true;
     
  }
  }
