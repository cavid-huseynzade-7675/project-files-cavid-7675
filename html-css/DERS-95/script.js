var students=[];
var studentName=document.getElementById('student-name');
var studentSurname=document.getElementById('student-surname');
var sqiymet=document.getElementById('s-qiymet');
var studentsTbody=document.getElementById('students-tbody');
function saveStudent(){
    console.log('save 1');
var id=0;
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
        
          var opsTd=document.createElement('td');
        opsTd.innerHTML="<button onclick='delStudent("+s.id+")' class='del-btn'>Sil</button>";
        tr.appendChild(idTd);
         tr.appendChild(nTd);
         tr.appendChild(snTd);
        tr.appendChild(qTd);
         tr.appendChild(opsTd);
        
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