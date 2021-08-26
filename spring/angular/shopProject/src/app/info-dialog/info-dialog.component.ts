import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { API_URL } from '../constant';
import { Category } from '../models/category';
import { Shop } from '../models/shop';
import { ShopService } from '../shop.service';

@Component({
  selector: 'app-info-dialog',
  templateUrl: './info-dialog.component.html',
  styleUrls: ['./info-dialog.component.css']
})
export class InfoDialogComponent implements OnInit {
  categories: Category[] = [];
  shops: Shop[] = [];
  shop: Shop = new Shop();
  category: Category = new Category();
  constructor(private service: ShopService,private http:HttpClient,public dialog:MatDialog
    , public dialogRef: MatDialogRef<InfoDialogComponent>) { }

  ngOnInit(): void {
    this.loadShops();
  }
  closeInfoDialog(){
    
    this.dialogRef.close();
  }
  loadShops(){
    this.http.get<Shop[]>(API_URL+'/shops').subscribe(
      response=>{
        this.shops=response;
        console.log(response);
       for (let index = 0; index < this.shops.length; index++) {
         const element = this.shops[index].id;
      
         

         if(Number(localStorage.getItem('idInfo'))==element){
this.shop = this.shops[index]
console.log(this.shop)
this.loadCategories(this.shop.categoryid);
         }
       }
       
        ;
     }

    );
  }

  loadCategories(id:number){
    this.http.get<Category[]>(API_URL+'/categories').subscribe(
      response=>{
        this.categories=response;
        console.log(response);
       for (let index = 0; index < this.categories.length; index++) {
         const element1 = this.categories[index];
         if(element1.id=id){
           this.category=element1;
         }

       }
       
        ;
     }

    );
  }
}
