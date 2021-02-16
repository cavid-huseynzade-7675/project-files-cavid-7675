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
function saveStudent(){
 
var id=1;
    for(var i=0;i<students.length;i++){
        
        if(students[i].id>id){id=students[i].id}
    }
   id++;
var student={id:id,name:studentName.value,surname:studentSurname.value,qiymet:sqiymet.value,sekil:ssekil.value}
   
    students.push(student);
    fillStudentTable(students);
    
    
    
}

function fillStudentTable(students){
    var xxxxx=true;
     ;
    studentsTbody.innerHTML='';
    for(var i=0;i<students.length;i++){
var s=students[i];
        var tr=document.createElement('tr');
        
          var idTd=document.createElement('td');
        idTd.innerHTML=s.id;
       
        
          var nTd=document.createElement('td');
       if(validatead(s.name,'Kitabin Adi',"ad")==true){   nTd.innerHTML=s.name;}else{xxxxx=false;}
      
     
        
          var snTd=document.createElement('td');
        if(validatesoy(s.surname,'Muellifin adi',"soy")==true){    snTd.innerHTML=s.surname;}else{xxxxx=false;}
      
        
          var qTd=document.createElement('td');
        
         if(validatenumer(s.qiymet)==true){    qTd.innerHTML=s.qiymet;}else{xxxxx=false;}
          var sTd=document.createElement('td');
       
        sTd.innerHTML="<img src='"+s.sekil+"' class='output'>";
   
    
       
        var pppTd=document.createElement('td');
          var opsTd=document.createElement('div');
        opsTd.innerHTML="<button onclick='delStudent("+s.id+")' class='btn btn-border btn-danger'>Sil</button>";
       
         var psTd=document.createElement('div');
        psTd.innerHTML="<button onclick='redaStudent("+s.id+","+nTd+","+snTd+","+qTd+","+sTd+")' class='btn btn-border btn-warning'>Redakte</button>";
 

        tr.appendChild(idTd);
         tr.appendChild(nTd);
         tr.appendChild(snTd);
        tr.appendChild(qTd);
         tr.appendChild(sTd);
        pppTd.appendChild(opsTd);
          pppTd.appendChild(psTd);
         tr.appendChild(pppTd);
        
        studentsTbody.appendChild(tr);
    
        
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
function redaStudent(id,nTd,snTd,qTd,sTd){
    
    for(var i=0;i<students.length;i++){
        
     if(students[i].id==id)   {
         
     
         snTd.innerHTML=studentSurname.value;
         qTd.innerHTML=sqiymet.value;
         sTd.innerHTML=ssekil.value;
          ntd.innerHTML=studentName.value; 
     }
    }

  
}
  function validatenumer(number) {
    var x=number;
 if ( x < 0 || x > 1000) {
    qiymetalert.innerHTML="<p>0 ile 1000  arasi eded yazin</p>";
     return false;
  } if(x=="")  
  { 
      qiymetalert.innerHTML="<p>Qiymeti bos qoymaq olmaz</p>";
     return false;
     
  }  else {
     qiymetalert.innerHTML="<p style='color: green' >Dogrudur</p>";
 
   return true;
     
  }
  }
      
    
  