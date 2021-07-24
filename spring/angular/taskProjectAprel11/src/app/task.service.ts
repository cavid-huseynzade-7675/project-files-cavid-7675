import { EventEmitter,Injectable } from '@angular/core';
import { Task } from './models/task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
tasks:Task[]=[];
TaskAdded:EventEmitter<Task>=new EventEmitter();
  constructor() {

    
   }
}
