import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { API_URL } from '../constants';
import { Task } from '../models/task';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css'],
})
export class TaskListComponent implements OnInit {
  tasks: Task[] = [];
  constructor(private service: TaskService,private http:HttpClient) {}

  ngOnInit(): void {
    this.http.get<Task[]>(API_URL+'/tasks').subscribe(
response=>{
  this.tasks=response;
}

    )
  }
}
