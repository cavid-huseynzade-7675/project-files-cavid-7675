import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { API_URL } from '../constant';
import { Category } from '../models/category';
import { Shop } from '../models/shop';
import { ShopService } from '../shop.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {
  shops: Shop[] = [];

  minimum:number=3;
  maksimum:number=30;
  categories: Category[] = [];
  popoverTitle:string='Təsdiq';
  popoverMessage:string='Kategoriya Silme prosesini təsdiqləməyə əminsiniz?';
  category: Category = new Category();
  constructor(
    private service: ShopService,
    private http:HttpClient,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.loadCategories();
   
   
  }

    
  onSaveCategory() {
    // this.service.tasks.push(this.task);
    this.http.post<Category>(API_URL+'/categories',this.category).subscribe(
 resp=>{
  // this.service.TaskAdded.emit(resp);
  this.loadCategories();
 }
 
    );
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
  deleteCategoryById(id:number){
  
    this.http.delete(API_URL+'/categories/'+id).subscribe(
      resp=>{
      
     this.loadCategories();
     this.deleteShop(id);
      }
    );
  }
  deleteShop(categoryid1:number){
    this.http.get<Shop[]>(API_URL+'/shops').subscribe(
      response=>{
        this.shops=response;    
        for (let index = 0; index < this.shops.length; index++) {
          const element = this.shops[index];
          if(categoryid1=element.categoryid){
         //   this.deleteShopById(element.id);
            console.log(element.categoryid);
            console.log(element.id);
            console.log(categoryid1);
          }
        
          
        }
     }

    );

   

}

deleteShopById(id:number){
  this.http.delete(API_URL+'/shops/'+id).subscribe(
    resp=>{
  
    }
  );
}
}

