import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LogoutComponent } from './component/logout/logout.component';
import { LoginComponent } from './login/login.component';

import { TaskListComponent } from './task-list/task-list.component';
import { TaskSaveComponent } from './task-save/task-save.component';

const routes: Routes = [
  { path: 'task-save', component: TaskSaveComponent },
  { path: 'tasks', component: TaskListComponent },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent }
  
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
