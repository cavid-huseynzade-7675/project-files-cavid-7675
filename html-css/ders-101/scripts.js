var newStudentModel=document.getElementById('new-student-modal');
var modalCloseButton=document.getElementById('modal-close-button');
var newStudentModel1=document.getElementById('new-student-modal1');
var modalCloseButton1=document.getElementById('modal-close-button1');
var counter='0';
function showNewStudentModal(){
newStudentModel.style.display="block";
    
}
function showNewStudentModal1(){
newStudentModel1.style.display="block";
    
}

modalCloseButton.addEventListener("click",function(){
    newStudentModel.style.display="none";console.log('close')
})
modalCloseButton1.addEventListener("click",function(){
    newStudentModel1.style.display="none";console.log('close')
})

