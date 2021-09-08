import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { API_URL } from '../constant';
import { Order } from '../models/order';
import { OrderList } from '../models/orderList';
import { OrderListShop } from '../models/orderListShop';
import { Shop } from '../models/shop';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {
  shops: Shop[] = [];
  orders: Order[] = [];
  say:number=0;
  orderBasketIdsArray:Array<Number>=[];
  orderCountsIdsArray:Array<Number>=[];
  ordersList: Array<OrderList>=[];
  constructor( private http:HttpClient,
    private router:Router) { }

  ngOnInit(): void {
    this.loadShops();
    this.loadOrders();
    console.log( "1,2,3,4,5".split(',').map( n => parseInt(n, 10)));
  }



  loadShops(){
    this.http.get<Shop[]>(API_URL+'/shops').subscribe(
      response=>{
        this.shops=response; 
     
    }    ); }

        
  loadOrders(){
    this.http.get<Order[]>(API_URL+'/orders').subscribe(
      response=>{
        this.orders=response; 
      this.loadOrderList();
      }    ); }

      loadOrderList(){
for (let orderIndex = 0; orderIndex < this.orders.length; orderIndex++) {
  const elementOrder = this.orders[orderIndex];
  this.orderBasketIdsArray= elementOrder.basketIds.split(',').map( n => parseInt(n, 10))
  this.orderCountsIdsArray= elementOrder.count.split(',').map( n => parseInt(n, 10))
 
  let  orderL=new OrderList();
  orderL.id=elementOrder.id;
    orderL.adress=elementOrder.adress;
    orderL.email=elementOrder.email;
    orderL.name=elementOrder.name;
    orderL.phone=elementOrder.phone;
    orderL.note=elementOrder.note;
    orderL.date=elementOrder.date;
  for (let idsIndex = 0; idsIndex < this.orderBasketIdsArray.length; idsIndex++) {
    const elementIds = this.orderBasketIdsArray[idsIndex];
  

    for (let shopsIndex = 0; shopsIndex < this.shops.length; shopsIndex++) {
      const elementShops = this.shops[shopsIndex];
      if (elementShops.id==elementIds) {
        
        let  orderLS=new OrderListShop();
        
orderLS.shopName=elementShops.name;
orderLS.price=elementShops.price;
orderLS.count=Number(this.orderCountsIdsArray[idsIndex]) ;
orderLS.allPrice=elementShops.price*Number(this.orderCountsIdsArray[idsIndex]);
orderL.allPriceInaAllpriceColumn+=elementShops.price*Number(this.orderCountsIdsArray[idsIndex]);
orderL.shopsOrder.push(orderLS);
      }

    }
  }
  if(orderL.allPriceInaAllpriceColumn==0){
    
  }else{
    this.ordersList.push(orderL);
  }

}
console.log(this.ordersList[1].shopsOrder)
      }
}
