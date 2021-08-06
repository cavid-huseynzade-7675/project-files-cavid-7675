import { Component } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  displayedColumns: string[] = [ 'name', 'weight' ,'button'];
  title = 'new';
  dataSource = new MatTableDataSource([]);
  saveBtn = true;

  constructor() {
    var data = localStorage.getItem("data");
    if (data) {
      var parsedData = JSON.parse(localStorage.getItem("data"));
      this.dataSource = new MatTableDataSource(parsedData);
    }
  }
}
export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}


;