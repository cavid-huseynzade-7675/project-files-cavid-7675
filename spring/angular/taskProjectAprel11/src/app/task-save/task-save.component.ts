import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core'
import { Router } from '@angular/router';
import { API_URL } from '../constants';
import { Task } from '../models/task';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task-save',
  templateUrl: './task-save.component.html',
  styleUrls: ['./task-save.component.css'],
})



export class TaskSaveComponent implements OnInit {
  task: Task = new Task();
  minimum:number=3;
maksimum:number=30;
  constructor(
    private service: TaskService,
    private http:HttpClient,
    private router:Router) {}

  ngOnInit(): void {}
  onSaveTask() {
   // this.service.tasks.push(this.task);
   this.http.post<Task>(API_URL+'/tasks',this.task).subscribe(
resp=>{
 // this.service.TaskAdded.emit(resp);
 this.router.navigate(['tasks']);
}

   );
  }
}
