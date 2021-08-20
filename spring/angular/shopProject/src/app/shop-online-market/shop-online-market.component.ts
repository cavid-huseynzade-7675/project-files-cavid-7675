import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';

import { API_URL } from '../constant';
import { Basket } from '../models/basket';
import { Shop } from '../models/shop';

import { ShopBasketComponent } from '../shop-basket/shop-basket.component';
import { ShopService } from '../shop.service';

@Component({
  selector: 'app-shop-online-market',
  templateUrl: './shop-online-market.component.html',
  styleUrls: ['./shop-online-market.component.css']
})
export class ShopOnlineMarketComponent implements OnInit {
  shops: Shop[] = [];
  baskets: Basket[] = [];
basket:Basket=new Basket();
  constructor(private service: ShopService,private http:HttpClient,public dialog:MatDialog, private router:Router) { }

  loadShops(){
    this.http.get<Shop[]>(API_URL+'/shops').subscribe(
      response=>{
        this.shops=response;
        console.log(this.shops);
       
       
        ;
     }

    );
  }
  loadBaskets(){
    this.http.get<Basket[]>(API_URL+'/baskets').subscribe(
      response=>{
        this.baskets=response;
      console.log(this.baskets)
       
       
        ;
     }

    );
  }

  openDialog(id:number){
   this.addBasket(id);
   

    this.dialog.open(ShopBasketComponent);
  }
  ngOnInit(): void {
    this.loadShops();
   this.loadBaskets()
  }
addBasket(id:number){

  var bool=true;
  this.basket.shopid=id;
  this.basket.count=1;
  for (let index = 0; index < this.baskets.length; index++) {
    const element = this.baskets[index].shopid;
    if (id==element) {
      this.basket.count=this.baskets[index].count+1;
      this.basket.id=this.baskets[index].id;
console.log(id,element);
this.http.put<Basket>(API_URL+'/baskets',this.basket).subscribe(
resp=>{
 // this.service.TaskAdded.emit(resp);
 console.log(this.basket)
 this.loadBaskets();
 bool=false;
}

   );
    }}
 
  if (bool) {
    this.http.post<Basket>(API_URL+'/baskets',this.basket).subscribe(
      resp=>{
       // this.service.TaskAdded.emit(resp);
       console.log(this.baskets)
       this.loadBaskets();
      
      }
      
         );
  }
 this.router.navigate(['sign-in']);

}
}
