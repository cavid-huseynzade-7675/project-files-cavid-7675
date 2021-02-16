var newStudentModel=document.getElementById('new-student-modal');
var modalCloseButton=document.getElementById('modal-close-button');
var counter='0';
function showNewStudentModal(){
newStudentModel.style.display="block";
    
}

modalCloseButton.addEventListener("click",function(){
    newStudentModel.style.display="none";console.log('close')
})
