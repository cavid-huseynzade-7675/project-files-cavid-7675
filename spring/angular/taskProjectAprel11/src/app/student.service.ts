import { Injectable } from '@angular/core';
import { Student } from './models/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
students:Student[]=[];
  constructor() {


    let telebe1:Student=new Student();
    telebe1.id=1;
    telebe1.name="Cavid";
    telebe1.surname="Huseynzade";
    telebe1.phone="050-222-22-22";
    this.students.push(telebe1);

    let telebe2:Student=new Student();
    telebe2.id=2;
    telebe2.name="Adil";
    telebe2.surname="Qafarov";
    telebe2.phone="050-333-33-33";
    this.students.push(telebe2);

    let telebe3:Student=new Student();
    telebe3.id=1;
    telebe3.name="Serxan";
    telebe3.surname="Babayev";
    telebe3.phone="050-444-44-44";
    this.students.push(telebe1);

    
   }
}
