var students=[];
var studentName=document.getElementById('student-name');
var studentSurname=document.getElementById('student-surname');
var sqiymet=document.getElementById('s-qiymet');
var ssekil=document.getElementById('s-sekil');
var studentsTbody=document.getElementById('students-tbody');
 var xeber=document.getElementById('alert');

function saveStudent(){
    console.log('save 1');
var id=1;
    for(var i=0;i<students.length;i++){
        
        if(students[i].id>id){id=students[i].id}
    }
   id++;
var student={id:id,name:studentName.value,surname:studentSurname.value,qiymet:sqiymet.value}
   
    students.push(student);
    fillStudentTable(students);
    
     console.log('save 2');
    
}

function fillStudentTable(students){
    var xxxxx=true;
     console.log('fill 1');
    studentsTbody.innerHTML='';
    for(var i=0;i<students.length;i++){
var s=students[i];
        var tr=document.createElement('tr');
        
          var idTd=document.createElement('td');
        idTd.innerHTML=s.id;
       
        
          var nTd=document.createElement('td');
       if(validateForm(s.name,'Kitabin Adi')==true){   nTd.innerHTML=s.name;}else{xxxxx=false;}
      
     
        
          var snTd=document.createElement('td');
        if(validateForm(s.surname,'Muellifin adi')==true){    snTd.innerHTML=s.surname;}else{xxxxx=false;}
      
        
          var qTd=document.createElement('td');
        
         if(validatenumer(s.qiymet)==true){    qTd.innerHTML=s.qiymet;}else{xxxxx=false;}
          var sTd=document.createElement('td');
        console.log(ssekil.getImageData);
        sTd.innerHTML="<img src='"+ssekil.url+"' class='output'>";
   
    
       
        var pppTd=document.createElement('td');
          var opsTd=document.createElement('div');
        opsTd.innerHTML="<button onclick='delStudent("+s.id+")' class='del-btn'>Sil</button>";
       
         var psTd=document.createElement('div');
        psTd.innerHTML="<button onclick='redaStudent("+s.id+","+nTd+","+snTd+","+qTd+","+sTd+")' class='redak-btn'>Redakte</button>";
 

        tr.appendChild(idTd);
         tr.appendChild(nTd);
         tr.appendChild(snTd);
        tr.appendChild(qTd);
         tr.appendChild(sTd);
        pppTd.appendChild(opsTd);
          pppTd.appendChild(psTd);
         tr.appendChild(pppTd);
        
        studentsTbody.appendChild(tr);
    
         console.log('fill 2');
        if(xxxxx==false){delStudent(s.id);}
        xxxxx=true;
    }
}
function delStudent(id){
     console.log('del 1');
    for(var i=0;i<students.length;i++){
        
     if(students[i].id==id)   {
         
       students.splice(i,1)  ;break;
     }
    }
  fillStudentTable(students);  
    console.log('del 2');
}
function validateForm(yoxlama,yazi) {
    var y=yoxlama;
    var i;
var x=y.trim();
  if (x.length<2) {
  
   alert(yazi+" 2 herfden balaca ola bilmez");
      
    
return false;
      
  }if( x.length>20){
      
      alert(yazi+" 20 herfden boyuk ola bilmez"); 
      return false;
  }else{
    return true;  
      
  }
   
}
function redaStudent(id,nTd,snTd,qTd,sTd){
     console.log('red 1');
    for(var i=0;i<students.length;i++){
        
     if(students[i].id==id)   {
         
     
         snTd.innerHTML=studentSurname.value;
         qTd.innerHTML=sqiymet.value;
         sTd.innerHTML=ssekil.value;
          ntd.innerHTML=studentName.value; 
     }
    }

    console.log('red 2');
}
  function validatenumer(number) {
    var x=number;
 if ( x < 0 || x > 10000) {
    alert("0 ile 1000  arasi eded yazin");
     return false;
  } if(x=="")  
  { 
   alert("Qiymeti bos qoymaq olmaz");
     return false;
  
  }  else {
   return true;
  }
  }
      
    
  