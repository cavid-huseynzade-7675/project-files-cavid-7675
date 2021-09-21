import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { API_URL } from '../constant';
import { Category } from '../models/category';
import { FieldErrorModel, ValidationEror } from '../models/error';
import { ErrorShop } from '../models/errorShop';
import { ImageBean } from '../models/imageBean';
import { Shop } from '../models/shop';
import { ShopListComponent } from '../shop-list/shop-list.component';
import { ShopService } from '../shop.service';

@Component({
  selector: 'app-shop-save',
  templateUrl: './shop-save.component.html',
  styleUrls: ['./shop-save.component.css']
})
export class ShopSaveComponent implements OnInit {

  categories: Category[] = [];
  shop: Shop = new Shop();
  minimum:number=3;
maksimum:number=30;
error:ValidationEror=new ValidationEror ();
errorShop:ErrorShop=new ErrorShop();
name:any=localStorage.getItem('username');
taskImageFile:any=null;
  constructor(
    private service: ShopService,
    private http:HttpClient,
    private router:Router,
    public dialogRef: MatDialogRef<ShopSaveComponent>) {}

  ngOnInit(): void {this.loadCategories();
  
  console.log();
  }

  
  onSaveShop() {
  let formData:FormData=new FormData();
  formData.append('file',this.taskImageFile)

  this.http.post<ImageBean>(API_URL+'/files',formData).subscribe(
    resp=>{
     // this.service.TaskAdded.emit(resp);
    this.shop.image=resp.fileName;


    this.shop.username=this.name;  
   
   // this.service.tasks.push(this.task);
   this.http.post<Shop>(API_URL+'/shops',this.shop).subscribe(
resp=>{
 // this.service.TaskAdded.emit(resp);
 this.router.navigate(['shops']);
 localStorage.setItem('loadShops','1')
 this.dialogRef.close();
},error=>{
  this.error.errors=[];
  this.errorShop.errorDescription=[];
  this.errorShop.errorName=[];
  this.errorShop.errorStatus=[];
  for (let index = 0; index < error.error.length; index++) {
    this.error.errors.push(error.error[index]);
    console.log(error.error[index]);
    if(error.error[index].fieldName=="name"){
this.errorShop.errorName.push(error.error[index].fieldError);

    };
    if(error.error[index].fieldName=="status"){
      this.errorShop.errorStatus.push(error.error[index].fieldError);
      
          };
          if(error.error[index].fieldName=="description"){
            this.errorShop.errorDescription.push(error.error[index].fieldError);
            
                };
    
  }
  console.log(this.errorShop);
 
  
}

   );
    });



    
  }
  onImageSelected(event:any){
this.taskImageFile=event.target.files[0];
  }

  closeShopSaveDialog(){
    this.dialogRef.close();
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
