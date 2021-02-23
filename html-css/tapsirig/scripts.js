var newStudentModal=document.getElementById('new-Student-Modal');
var modalClosebtn=document.getElementById('modal-Close-Button');
var sts=document.getElementById('sts');
var counter=0;
var student={};
var students=[];
var studentName=document.getElementById('student-name');
var studentSurname=document.getElementById('student-surname');
var studentSector=document.getElementById('student-sector');
var studentBirthday=document.getElementById('student-birthday');
var checkjs=document.getElementById('js');
var checkjava=document.getElementById('php');
var checkphp=document.getElementById('java');

var studentString=localStorage.getItem('students');
    if(studentString==null){localStorage.setItem('students','[]');}else{
        students=JSON.parse(studentString);}

loadStudents();
function    newStudent(){
    student={name:'',surname:'',sector:'Az',languages:[]};
    student.id=0;
    showNewStudentModal();
    
}
function showNewStudentModal(){
    
   newStudentModal.style.display="block";
    studentName.value=student.name;
    studentSurname.value=student.surname;
    studentSector.value=student.sector;
    studentBirthday.value=student.birthday;
    checkjava.checked=false;
     checkjs.checked=false;
     checkphp.checked=false;
   
}



modalClosebtn.addEventListener("click",function(){
             newStudentModal.style.display="none";                    
                               
                               });
function ChangeName(name){
    student.name=name;
}
function ChangeSurname(sn){
    student.surname=sn;
}
function ChangeSector(sn){
    student.sector=sn;
}
function ChangeBirthday(sn){
    student.birthday=sn;
}
function saveStudent(){
    console.log(student.languages);
    newStudentModal.style.display="none";  
    if(checkjava.checked==true){
       student.languages.push(checkjava.value); 
    }
     if(checkjs.checked==true){
       student.languages.push(checkjs.value); 
    }
     if(checkphp.checked==true){
       student.languages.push(checkphp.value); 
    }
    
    
   
    if(student.id>0){
        saveStudentsToStorage();
        loadStudents();
    }else{
        var idMax=0;
        for(s of students){
if(s.id>idMax){
    idMax=s.id;
}
        }
        
  idMax++;
        student.id=idMax;
        students.push(student);
         saveStudentsToStorage();
        loadStudents();
        
        
    }
    
}
function  loadStudents(){
    var tbodyhtml="";
    
   
    for (var i=0;i<students.length;i++){
        var st=students[i];
     
      
        tbodyhtml+="<tr><td>"+st.id;
        tbodyhtml+="</td><td>"+st.name;
         tbodyhtml+="</td><td>"+st.surname;
         tbodyhtml+="</td><td>"+st.sector;
         tbodyhtml+="</td><td>"+st.birthday;
      
      
         tbodyhtml+="</td><td>"+st.languages;
         tbodyhtml+="</td><td> <button onclick='deleteStudent("+st.id+")' class='btn btn-border btn-danger'>Sil</button>"+
        "<button onclick='editStudent("+st.id+")' style='margin-left:15px;' class='btn btn-border btn-warning'>Redakte</button> </td></tr>";
        
    }
    sts.innerHTML=tbodyhtml;
}
    var studentString=localStorage.getItem('students');
    if(studentString==null){localStorage.setItem('students','[]');}else{
        students=JSON.parse(studentString);}
loadStudents;
    
   
function deleteStudent(id){
for(var i=0;students.length;i++){
    if(id==students[i].id){ 
        students.splice(i,1);break;
        
    }
}

loadStudents();
     saveStudentsToStorage();


}

function editStudent(id){
    
 for(var i=0;students.length;i++){
    if(id==students[i].id){
        student=students[i];
        student.languages.splice(0,3);break;
    }
}   
 showNewStudentModal();   
}

function saveStudentsToStorage(){
    localStorage.setItem('students',JSON.stringify(students));
}

function langJava(lang){
  

    }
function langPhp(lang){
    

    }
function langJavaScript(lang){
   

    }
    
