import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { API_URL } from '../constant';
import { Category } from '../models/category';
import { ImageBean } from '../models/imageBean';
import { Shop } from '../models/shop';
import { ShopService } from '../shop.service';

@Component({
  selector: 'app-shop-uptade',
  templateUrl: './shop-uptade.component.html',
  styleUrls: ['./shop-uptade.component.css']
})
export class ShopUptadeComponent implements OnInit {
  categories: Category[] = [];
  shops: Shop[] = [];
  shop: Shop = new Shop();
  minimum:number=3;
  maksimum:number=30;
  taskImageFile:any=null;
  imagePath:string='';
  constructor(
    private service: ShopService,
    private http:HttpClient,
    private router:Router,
    public dialogRef: MatDialogRef<ShopUptadeComponent>
  ) { }

  ngOnInit(): void {this.loadCategories();
    this.loadShops();
    this.imagePath=API_URL+'/files/files/'

  }

  onEditShop() {
    let formData:FormData=new FormData();
    formData.append('file',this.taskImageFile)
  
    this.http.post<ImageBean>(API_URL+'/files',formData).subscribe(
      resp=>{
       // this.service.TaskAdded.emit(resp);
      this.shop.image=resp.fileName;
    
      this.http.put<Shop>(API_URL+'/shops',this.shop).subscribe(
        resp=>{
         localStorage.setItem('loadShops','1')
         this.dialogRef.close();
        }
        
        
       
           );
    })

    // this.service.tasks.push(this.task);

   }
   onImageSelected(event:any){
    this.taskImageFile=event.target.files[0];
      }

   closeUptadeSaveDialog(){
    this.dialogRef.close();
   }
   loadShops(){
    this.http.get<Shop[]>(API_URL+'/shops').subscribe(
      response=>{
        this.shops=response;
        console.log(response);
       for (let index = 0; index < this.shops.length; index++) {
         const element = this.shops[index].id;
      
         

         if(Number(localStorage.getItem('id'))==element){
this.shop = this.shops[index]

         }
       }
       
        ;
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
}
