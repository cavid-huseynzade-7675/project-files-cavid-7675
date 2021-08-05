import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { API_URL } from '../constant';
import { Shop } from '../models/shop';
import { User } from '../models/user';
import { ShopService } from '../shop.service';


@Component({
  selector: 'app-shop-list',
  templateUrl: './shop-list.component.html',
  styleUrls: ['./shop-list.component.css']
})
export class ShopListComponent implements OnInit {
  shops: Shop[] = [];
  popoverTitle:string='Təsdiq';
  popoverMessage:string='Tələbə Silme prosesini təsdiqləməyə əminsiniz?';
  constructor(private service: ShopService,private http:HttpClient) {}

  ngOnInit(): void {
  //  this.loadShops();
   // this.service.TaskAdded.subscribe(
   //   resp=>{
   //     this.shops.push(resp);
   //   }
   //
  }

 loadShops(){
    this.http.get<Shop[]>(API_URL+'/shops').subscribe(
      response=>{
        this.shops=response;
     }
    );
  }


  deleteShopById(id:number){
  
      this.http.delete(API_URL+'/shops/'+id).subscribe(
        resp=>{
          this.loadShops();
        }
      );
    }

}
