import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { ShopListComponent } from './shop-list/shop-list.component';
import { ShopOnlineMarketComponent } from './shop-online-market/shop-online-market.component';
import { ShopSaveComponent } from './shop-save/shop-save.component';
import { SignInComponent } from './sign-in/sign-in.component';

const routes: Routes = [

  { path: 'shop-save', component:ShopSaveComponent },
  { path: 'shops', component: ShopListComponent },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'sign-in', component: SignInComponent },
  { path: 'shop-online-market', component: ShopOnlineMarketComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
