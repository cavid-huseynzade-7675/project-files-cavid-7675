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
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { SignInComponent } from './sign-in/sign-in.component';
import { ShopOnlineMarketComponent } from './shop-online-market/shop-online-market.component';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { ShopBasketComponent } from './shop-basket/shop-basket.component';
import { ShopUptadeComponent } from './shop-uptade/shop-uptade.component';
import { BasketTableComponent } from './basket-table/basket-table.component';
import { OrderSaveComponent } from './order-save/order-save.component';
import { OrderListComponent } from './order-list/order-list.component';
import { FilterPipe } from './filter.pipe';
import { InfoDialogComponent } from './info-dialog/info-dialog.component';
import { MainComponent } from './main/main.component';
import { ShowImageComponent } from './show-image/show-image.component';

@NgModule({
  declarations: [
    AppComponent,
    AppmenuComponent,
    LoginComponent,
    LogoutComponent,
    ShopSaveComponent,
    ShopListComponent,
    DialogComponent,
    SignInComponent,
    ShopOnlineMarketComponent,
    AdminPanelComponent,
    ShopBasketComponent,
    ShopUptadeComponent,
    BasketTableComponent,
    OrderSaveComponent,
    OrderListComponent,
    FilterPipe,
    InfoDialogComponent,
    MainComponent,
    ShowImageComponent,
  
  ],
  entryComponents:[DialogComponent],
  imports: [
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
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
