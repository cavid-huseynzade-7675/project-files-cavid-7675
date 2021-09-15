import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';


import { API_URL } from '../constant';
import { Basket } from '../models/basket';
import { BasketTable } from '../models/basketTable';
import { Shop } from '../models/shop';
import { OrderSaveComponent } from '../order-save/order-save.component';
import { ShopService } from '../shop.service';

@Component({
  selector: 'app-basket-table',
  templateUrl: './basket-table.component.html',
  styleUrls: ['./basket-table.component.css']
})
export class BasketTableComponent implements OnInit {
  shops: Shop[] = [];
  baskets:Basket[] = [];
  basketCount:Basket = new Basket();
tableBaskets: Array<BasketTable>=[];
imagePath:string='';
priceAll:number=0;


  popoverTitle:string='Təsdiq';
  popoverMessage:string='Mehsul Silme prosesini təsdiqləməyə əminsiniz?';
  constructor(private service: ShopService,private http:HttpClient,public dialog:MatDialog
    , public dialogRef: MatDialogRef<BasketTableComponent>) { }

  ngOnInit(): void {
    this.loadShops();
    this.loadBaskets();

    this.imagePath=API_URL+'/files/files/'
  }
  openOrderSaveDialog(){
    this.dialog.open(OrderSaveComponent);
    this.dialogRef.close();
  }
closeBasketSaveDialog(){
    
    this.dialogRef.close();
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
       
       
       
        ;
     }

    );
  }
  loadTableBaskets(){
    this.tableBaskets=[];
    this.priceAll=0;
    for (let indexBasket = 0; indexBasket < this.baskets.length; indexBasket++) {
      const element = this.baskets[indexBasket].shopid;
     for (let index = 0; index < this.shops.length; index++) {
       const element1 = this.shops[index].id;
       if (element==element1) {
      let  basket=new BasketTable();
        basket.id=this.baskets[indexBasket].id;
        basket.shopid=this.shops[index].id;
         basket.shopname=this.shops[index].name;
         basket.price=this. shops[index].price;
         basket.count=this.baskets[indexBasket].count;
          basket.image=this.shops[index].image;
          basket.allPrice=this. shops[index].price*this.baskets[indexBasket].count;
          this.priceAll+=this. shops[index].price*this.baskets[indexBasket].count;
          this.tableBaskets.push(basket);
       
         
       
        
     }
  
    
    
    }


  }

}

deleteBasketById(id:number){
  
  this.http.delete(API_URL+'/baskets/'+id).subscribe(
    resp=>{
   this.loadBaskets();
    }
  );
}

onCountChanged(id:number,shopid:number,event:any){

console.log(id,shopid,Number(event.target.value))
this.basketCount.id=id;
this.basketCount.shopid=shopid;
this.basketCount.count=Number(event.target.value);
this.http.put<Basket>(API_URL+'/baskets',this.basketCount).subscribe(
  resp=>{
   // this.service.TaskAdded.emit(resp);
  
   this.loadBaskets();

  }
  
     );
}
}