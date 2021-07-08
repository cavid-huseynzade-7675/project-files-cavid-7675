import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TaskSaveComponent } from './task-save/task-save.component';
import { TaskListComponent } from './task-list/task-list.component';


import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentSaveComponent } from './student-save/student-save.component';

@NgModule({
  declarations: [
    AppComponent,
    TaskSaveComponent,
    TaskListComponent,
    LoginComponent,
    MenuComponent,
    StudentListComponent,
    StudentSaveComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
