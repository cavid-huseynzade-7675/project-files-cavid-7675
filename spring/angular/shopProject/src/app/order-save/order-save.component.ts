
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { API_URL } from '../constant';
import { Basket } from '../models/basket';
import { Order } from '../models/order';
import { Shop } from '../models/shop';

@Component({
  selector: 'app-order-save',
  templateUrl: './order-save.component.html',
  styleUrls: ['./order-save.component.css']
})
export class OrderSaveComponent implements OnInit {
  order: Order = new Order();
  ids:string= '';
  counts:string= '';
  minimum:number=3;
  maksimum:number=30;

  constructor( private http:HttpClient,
    public dialogRef: MatDialogRef<OrderSaveComponent>,
    private router:Router) {
    
     }
    shops: Shop[] = [];
    baskets: Basket[] = [];
  ngOnInit(): void {
    this.loadShops();
    this.loadBaskets();
  }
  loadShops(){
    this.http.get<Shop[]>(API_URL+'/shops').subscribe(
      response=>{
        this.shops=response; }    ); }
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
      
this.counts='';
this.ids='';
    for (let indexBasket = 0; indexBasket < this.baskets.length; indexBasket++) {
      const element = this.baskets[indexBasket].shopid;
     for (let index = 0; index < this.shops.length; index++) {
       const element1 = this.shops[index].id;
       if (element==element1) {
     
     

      
      this.ids += this.shops[index].id + ",";
      this.counts += this.baskets[indexBasket].count + ",";  
       
         
         
        
     }
  
    
    
    }

  }
  console.log(this.ids)

  this.ids =   this.ids.substring(0,   this.ids.length - 1);
  this.counts =   this.counts.substring(0,   this.counts.length - 1);
  console.log(this.ids)
}
onSaveOrder(){
  this.order.basketIds=this.ids;
  this.order.count=this.counts;
  this.order.date=new Date();
  console.log
  this.http.post<Order>(API_URL+'/orders',this.order).subscribe(
    resp=>{
     // this.service.TaskAdded.emit(resp);
     this.http.delete(API_URL+'/baskets/').subscribe(
      resp=>{
    
      }
    );
    }
    
       );
  
      
      
        this.dialogRef.close();
      
}
closeOrderSaveDialog(){
  this.dialogRef.close();
}
}
