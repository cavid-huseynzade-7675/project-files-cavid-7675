import { Component, OnInit } from '@angular/core';
import { Student } from '../models/student';
import { Task } from '../models/task';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task-save',
  templateUrl: './task-save.component.html',
  styleUrls: ['./task-save.component.css'],
})
export class TaskSaveComponent implements OnInit {
  task: Task = new Task();
  constructor(private service: TaskService) {}

  ngOnInit(): void {}
  onSaveTask() {
    this.service.tasks.push(this.task);
  }
}
