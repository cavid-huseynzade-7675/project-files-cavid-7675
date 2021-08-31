import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { BasketTableComponent } from '../basket-table/basket-table.component';

import { API_URL } from '../constant';
import { InfoDialogComponent } from '../info-dialog/info-dialog.component';
import { Basket } from '../models/basket';
import { BasketTable } from '../models/basketTable';
import { Category } from '../models/category';
import { Shop } from '../models/shop';

import { ShopBasketComponent } from '../shop-basket/shop-basket.component';
import { ShopService } from '../shop.service';

@Component({
  selector: 'app-shop-online-market',
  templateUrl: './shop-online-market.component.html',
  styleUrls: ['./shop-online-market.component.css']
})
export class ShopOnlineMarketComponent implements OnInit {
  searchText = '';
  tableBasketsOnline: Array<Number>=[];
  filterShops: Array<Shop>=[];
  categories: Category[] = [];
  characters = [
    'Ant-Man',
    'Aquaman',
    'Asterix',
    'The Atom',
    'The Avengers',
    'Batgirl',
    'Batman',
    'Batwoman'
  ];
  shops: Shop[] = [];
  baskets: Basket[] = [];
basket:Basket=new Basket();
basketCount:number=0;
  constructor(private service: ShopService,private http:HttpClient,public dialog:MatDialog, private router:Router) { }

  loadShops(){
    this.http.get<Shop[]>(API_URL+'/shops').subscribe(
      response=>{
        this.shops=response;

       this.filterOnShops(0);
       
        ;
     }

    );
  }
loadBasketCount(){
  setInterval(() => {
   
this.loadBaskets();


      
    },100);
}
  loadBaskets(){
    this.http.get<Basket[]>(API_URL+'/baskets').subscribe(
      response=>{
        this.baskets=response;

        this.loadTableBaskets();

       
        ;
     }

    );
  }
  loadTableBaskets(){
    this.tableBasketsOnline=[];

    for (let indexBasket = 0; indexBasket < this.baskets.length; indexBasket++) {
      const element = this.baskets[indexBasket].shopid;
     for (let index = 0; index < this.shops.length; index++) {
       const element1 = this.shops[index].id;
       if (element==element1) {
      let  anys=1;
     
       
          this.tableBasketsOnline.push(anys);
       
         
          this.basketCount=this.tableBasketsOnline.length;
        
     }
  
    
    
    }


  }

}
openInfoDialog(id:number){
  var x = id,
  toString = x.toString(),
  toConcat = x + "";
  localStorage.setItem('idInfo',toConcat)
  

   this.dialog.open(InfoDialogComponent);
 }

  openDialog(id:number){
   
   

    this.dialog.open(ShopBasketComponent);
  }
  ngOnInit(): void {
    this.loadShops();
   this.loadBaskets();
this.loadBasketCount();
this.loadCategories();
  }

openBasket(){
  this.dialog.open(BasketTableComponent);

}
filterOnShops(categoryid:number){
  this.filterShops=[];
if (categoryid==0) {
  this.filterShops=this.shops;
}

for (let index = 0; index < this.shops.length; index++) {
  const element = this.shops[index];
  
  if (element.categoryid==categoryid) {
    this.filterShops.push(element);
    
  }
}

}

loadCategories(){
  this.http.get<Category[]>(API_URL+'/categories').subscribe(
    response=>{
      this.categories=response;
      console.log(response);
     
     
      ;
   }

  );
}
}
