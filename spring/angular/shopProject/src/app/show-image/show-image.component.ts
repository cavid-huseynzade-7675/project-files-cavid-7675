import { Component, OnInit } from '@angular/core';
import { ShopService } from '../shop.service';

@Component({
  selector: 'app-show-image',
  templateUrl: './show-image.component.html',
  styleUrls: ['./show-image.component.css']
})
export class ShowImageComponent implements OnInit {
  shopImage:string='';
  constructor(private shopS:ShopService) { }

  ngOnInit(): void {
    this.shopImage=this.shopS.selectedImagePath;
  }

}
