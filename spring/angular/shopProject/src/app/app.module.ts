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

@NgModule({
  declarations: [
    AppComponent,
    AppmenuComponent,
    LoginComponent,
    LogoutComponent,
    ShopSaveComponent,
    ShopListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
