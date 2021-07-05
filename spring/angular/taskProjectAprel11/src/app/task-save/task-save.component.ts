import { Component, OnInit } from '@angular/core';
import { Student } from '../models/student';
import { Task } from '../models/task';

@Component({
  selector: 'app-task-save',
  templateUrl: './task-save.component.html',
  styleUrls: ['./task-save.component.css']
})
export class TaskSaveComponent implements OnInit {
task:Task=new Task();
  constructor() { }

  ngOnInit(): void {
  }

}
