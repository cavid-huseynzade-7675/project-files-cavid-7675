import { Component, OnInit } from '@angular/core';
import { Student } from '../models/student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-save',
  templateUrl: './student-save.component.html',
  styleUrls: ['./student-save.component.css']
})
export class StudentSaveComponent implements OnInit {
student:Student=new Student();
  constructor(private service: StudentService) { }

  ngOnInit(): void {
  }
  onSaveStudent() {
    this.service.students.push(this.student);
  }
}
