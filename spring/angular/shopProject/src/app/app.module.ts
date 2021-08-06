import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppmenuComponent } from './appmenu/appmenu.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { ShopSaveComponent } from './shop-save/shop-save.component';
import { ShopListComponent } from './shop-list/shop-list.component';
import { FormsModule } from '@angular/forms';
import{HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http'
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { HttpInterSectorService } from './service/http-inter-sector.service';
import { DialogComponent } from './dialog/dialog.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DemoMaterialModule } from './material-module';
import { AgGridModule } from 'ag-grid-angular';  
@NgModule({
  declarations: [
    AppComponent,
    AppmenuComponent,
    LoginComponent,
    LogoutComponent,
    ShopSaveComponent,
    ShopListComponent,
    DialogComponent
  ],
  entryComponents:[DialogComponent],
  imports: [
    DemoMaterialModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ConfirmationPopoverModule.forRoot({
      confirmButtonType:'primary',cancelButtonType:'danger',confirmText:'Tesdiq',cancelText:'Legv Et'
          }),
    BrowserAnimationsModule,
    AgGridModule.withComponents([]), 
  ],
  providers: [{

    provide:HTTP_INTERCEPTORS,useClass:HttpInterSectorService,multi:true
    
      }],
  bootstrap: [AppComponent]
})
export class AppModule { }
