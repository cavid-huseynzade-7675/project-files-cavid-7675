import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentSaveComponent } from './student-save/student-save.component';
import { TaskListComponent } from './task-list/task-list.component';
import { TaskSaveComponent } from './task-save/task-save.component';

const routes: Routes = [
  { path: 'task-save', component: TaskSaveComponent },
  { path: 'tasks', component: TaskListComponent },
  { path: 'login', component: LoginComponent },
  { path: 'student-save', component: StudentSaveComponent },
  { path: 'student-list', component: StudentListComponent }
  
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
