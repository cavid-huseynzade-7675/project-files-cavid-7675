var newStudentModel=document.getElementById('new-student-modal');
var modalCloseButton=document.getElementById('modal-close-button');
var counter='0';
function showNewStudentModal(){
newStudentModel.style.display="block";
    console.log('showw');
}

modalCloseButton.addEventListener("click",function(){
    newStudentModel.style.display="none";console.log('close')
})
window.addEventListener("click",function(event){
    if(event.target===newStudentModel){
        newStudentModel.style.display="none";console.log('c2')
    }
})