import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TaskSaveComponent } from './task-save/task-save.component';
import { TaskListComponent } from './task-list/task-list.component';

import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import{HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http'
import { HttpInterSectorService } from './service/http-inter-sector.service';
import { LogoutComponent } from './component/logout/logout.component';

@NgModule({
  declarations: [
    AppComponent,
    TaskSaveComponent,
    TaskListComponent,
    LoginComponent,
    MenuComponent,
    LogoutComponent,
   

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ConfirmationPopoverModule.forRoot({
confirmButtonType:'primary',cancelButtonType:'danger',confirmText:'Tesdiq',cancelText:'Legv Et'
    })
  ],
  providers: [{

provide:HTTP_INTERCEPTORS,useClass:HttpInterSectorService,multi:true

  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
