import { EventEmitter,Injectable } from '@angular/core';
import { Shop } from './models/shop';


@Injectable({
  providedIn: 'root'
})
export class ShopService {
shops:Shop[]=[];
selectedImagePath:string='';
ShopAdded:EventEmitter<Shop>=new EventEmitter();
  constructor() {

    
   }
}