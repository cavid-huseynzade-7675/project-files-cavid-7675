import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { API_URL } from '../constant';
import { Category } from '../models/category';
import { ShopService } from '../shop.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {
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
    this.loadCategories()
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
      }
    );
  }
}
