import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { API_URL } from '../constant';
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
  constructor(private service: ShopService,private http:HttpClient,public dialog:MatDialog) { }

  loadShops(){
    this.http.get<Shop[]>(API_URL+'/shops').subscribe(
      response=>{
        this.shops=response;
        console.log(this.shops);
       
       
        ;
     }

    );
  }

  openDialog(){
    this.dialog.open(ShopBasketComponent);
  }
  ngOnInit(): void {
    this.loadShops();
   
  }

}
