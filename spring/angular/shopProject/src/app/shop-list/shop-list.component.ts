import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { API_URL } from '../constant';
import { DialogComponent } from '../dialog/dialog.component';
import { Shop } from '../models/shop';
import { User } from '../models/user';
import { ShopUptadeComponent } from '../shop-uptade/shop-uptade.component';
import { ShopService } from '../shop.service';
import { ShowImageComponent } from '../show-image/show-image.component';

@Component({
  selector: 'app-shop-list',
  templateUrl: './shop-list.component.html',
  styleUrls: ['./shop-list.component.css']
})
export class ShopListComponent implements OnInit {

  name:any=localStorage.getItem('username');
  shops: Shop[] = [];
imagePath:string='';
  popoverTitle:string='Təsdiq';
  popoverMessage:string='Tələbə Silme prosesini təsdiqləməyə əminsiniz?';
  constructor(private service: ShopService,private http:HttpClient,public dialog:MatDialog) {


  }

  
openDialog(){
  this.dialog.open(DialogComponent);
}
openUptadeDialog(id:number){
  this.dialog.open(ShopUptadeComponent);
  var x = id,
  toString = x.toString(),
  toConcat = x + "";
  localStorage.setItem('id',toConcat)
}

  ngOnInit(): void {
    this.imagePath=API_URL+'/files/files/'
   this.loadShops();
this.load()
  }



 loadShops(){
    this.http.get<Shop[]>(API_URL+'/shops/user/'+this.name).subscribe(
      response=>{
        this.shops=response;
        console.log(response);
       
       
        ;
     }

    );
  }
load(){
  setInterval(() => {
    if (localStorage.getItem('loadShops')=='1'){
this.loadShops();
localStorage.setItem('loadShops','0')

    } 
      
    },100);

  }


  deleteShopById(id:number){
  
      this.http.delete(API_URL+'/shops/'+id).subscribe(
        resp=>{
       this.loadShops();
        }
      );
    }


    openImage(path:string){
      this.service.selectedImagePath=path;
      this.dialog.open(ShowImageComponent);
    }
}
