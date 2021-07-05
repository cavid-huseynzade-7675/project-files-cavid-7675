import { Component, OnInit } from '@angular/core';
import { Task } from '../models/task';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
tasks:Task[]=[];
  constructor() { }

  ngOnInit(): void {
    let java:Task=new Task();
    java.id=1;
    java.name="Cavid";
    java.task="JAva oyren";
    java.description="Ilk 5 movzunu oyrenmek lazimdir";
    java.status="Bitmemis";
    java.begindate=new Date(2018,0O5,0O5);
    java.enddate=new Date(2018,0O5,0O15);
    this.tasks.push(java);

    let css:Task=new Task();
    css.id=2;
    css.name="Agali";
    css.task="Css oyren";
    css.description="Ilk 15 movzunu oyrenmek lazimdir";
    css.status="Bitib";
    css.begindate=new Date(2018,0O1,0O5);
    css.enddate=new Date(2018,0O6,0O12);
    this.tasks.push(css);

    let html:Task=new Task();
    html.id=3;
    html.name="Ismayil";
    html.task="Html oyren";
    html.description="Ilk 30 movzunu oyrenmek lazimdir";
    html.status="Bitmemis";
    html.begindate=new Date(2018,0O5,0O5);
    html.enddate=new Date(2018,0O5,0O17);
    this.tasks.push(html);
  }

}
