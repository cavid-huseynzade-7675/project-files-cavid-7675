import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { API_URL } from '../constant';
import { Shop } from '../models/shop';
import { ShopService } from '../shop.service';

@Component({
  selector: 'app-shop-save',
  templateUrl: './shop-save.component.html',
  styleUrls: ['./shop-save.component.css']
})
export class ShopSaveComponent implements OnInit {

  shop: Shop = new Shop();
  minimum:number=3;
maksimum:number=30;
  constructor(
    private service: ShopService,
    private http:HttpClient,
    private router:Router) {}

  ngOnInit(): void {}
  onSaveShop() {
   // this.service.tasks.push(this.task);
   this.http.post<Shop>(API_URL+'/shops',this.shop).subscribe(
resp=>{
 // this.service.TaskAdded.emit(resp);
 this.router.navigate(['shops']);
}

   );
  }

}
