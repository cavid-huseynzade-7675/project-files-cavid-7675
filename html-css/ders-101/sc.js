var students=[];
var studentName=document.getElementById('student-name');
var studentSurname=document.getElementById('student-surname');
var sqiymet=document.getElementById('s-qiymet');
var ssekil=document.getElementById('s-sekil');
var studentsTbody=document.getElementById('students-tbody');

function saveStudent(){
    console.log('save 1');
var id=1;
    for(var i=0;i<students.length;i++){
        
        if(students[i].id>id){id=students[i].id}
    }
   id++;
    var student={id:id,name:studentName.value,surname:studentSurname.value,qiymet:sqiymet.value};
    students.push(student);
    fillStudentTable(students);
    
     console.log('save 2');
    
}
function fillStudentTable(students){
     console.log('fill 1');
    studentsTbody.innerHTML='';
    for(var i=0;i<students.length;i++){
var s=students[i];
        var tr=document.createElement('tr');
        
          var idTd=document.createElement('td');
        idTd.innerHTML=s.id;
        
          var nTd=document.createElement('td');
        nTd.innerHTML=s.name;
        
          var snTd=document.createElement('td');
        snTd.innerHTML=s.surname;
        
          var qTd=document.createElement('td');
        qTd.innerHTML=s.qiymet;
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
  

  