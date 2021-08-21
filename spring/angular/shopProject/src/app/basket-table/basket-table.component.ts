import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';


import { API_URL } from '../constant';
import { Basket } from '../models/basket';
import { BasketTable } from '../models/basketTable';
import { Shop } from '../models/shop';
import { ShopService } from '../shop.service';

@Component({
  selector: 'app-basket-table',
  templateUrl: './basket-table.component.html',
  styleUrls: ['./basket-table.component.css']
})
export class BasketTableComponent implements OnInit {
  shops: Shop[] = [];
  baskets:Basket[] = [];
tableBaskets: Array<BasketTable>=[];




  popoverTitle:string='Təsdiq';
  popoverMessage:string='Tələbə Silme prosesini təsdiqləməyə əminsiniz?';
  constructor(private service: ShopService,private http:HttpClient,public dialog:MatDialog) { }

  ngOnInit(): void {
    this.loadShops();
    this.loadBaskets();

   
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
  loadShops(){
    this.http.get<Shop[]>(API_URL+'/shops').subscribe(
      response=>{
        this.shops=response;
        console.log(response);
       
       
        ;
     }

    );
  }
  loadTableBaskets(){

    for (let indexBasket = 0; indexBasket < this.baskets.length; indexBasket++) {
      const element = this.baskets[indexBasket].shopid;
     for (let index = 0; index < this.shops.length; index++) {
       const element1 = this.shops[index].id;
       console.log(index,indexBasket);
       if (element==element1) {
      let  basket=new BasketTable();
        basket.id=this.shops[index].id;
         basket.shopname=this.shops[index].name;
         basket.price=this. shops[index].price;
         basket.count=this.baskets[indexBasket].count;
          basket.image=this.shops[index].image;
          console.log(basket);
          this.tableBaskets.push(basket);
       
         
       
        
     }
  
    
    
    }


  }

}

 

}