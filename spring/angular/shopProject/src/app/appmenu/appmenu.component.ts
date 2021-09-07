import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../service/login-service.service';

@Component({
  selector: 'app-appmenu',
  templateUrl: './appmenu.component.html',
  styleUrls: ['./appmenu.component.css']
})
export class AppmenuComponent implements OnInit {
roles:string[]=[];
userLoggedin:boolean=false;
  constructor(private loginSerice:LoginServiceService) { }

  ngOnInit(): void {
this.loginSerice.userLogin.subscribe(
resp=>{

  this.userLoggedin=resp;
}

);

this.loginSerice.userRoles.subscribe(
  resp=>{
  
    this.roles=resp;
  }
  
  );

  }

}
