import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../service/login-service.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private loginS:LoginServiceService) { }

  ngOnInit(): void {
    localStorage.removeItem('token');
    this.loginS.userLogin.emit(false);
    this.loginS.userRoles.emit([]);
  }

}
