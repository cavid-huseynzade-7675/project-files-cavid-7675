import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from '../models/order';

@Component({
  selector: 'app-order-save',
  templateUrl: './order-save.component.html',
  styleUrls: ['./order-save.component.css']
})
export class OrderSaveComponent implements OnInit {
  order: Order = new Order();
  constructor( private http:HttpClient,
    private router:Router) { }

  ngOnInit(): void {
  }

}
