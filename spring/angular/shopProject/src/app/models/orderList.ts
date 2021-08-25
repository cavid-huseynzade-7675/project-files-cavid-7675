import {OrderListShop} from './orderListShop';
export class OrderList {
    public id:number=0;
    public adress: string = '';
    public email: string = '';
    public name: string = '';
    public note: string = '';
    public phone: string = '';
    public date: Date = new Date();
    public allPriceInaAllpriceColumn :number=0;
    public shopsOrder:OrderListShop[]=[];
  }
  