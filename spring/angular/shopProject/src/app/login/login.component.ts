import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { API_URL } from '../constant';
import { User } from '../models/user';
import { LoginServiceService } from '../service/login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:User=new User();
  constructor(private http:HttpClient,private router:Router,private loginS:LoginServiceService) {}

  ngOnInit(): void {}
  onLogin(){
    let token:string='Basic '+window.btoa(this.user.username +':'+ this.user.password);
    this.http.get<string[]>(API_URL +'/login',{
headers:new HttpHeaders(
{ Authorization:token}

)

    }).subscribe(
      resp =>{
      //  alert('ugurlu giris')
      localStorage.setItem('token',token)
      localStorage.setItem('username',this.user.username)
      this.loginS.userLogin.emit(true);
      this.loginS.userRoles.emit(resp);
      this.router.navigate(['main']);
      },
      error =>{
        alert('ugursuz gris')
      }
    );
  }
  onSignUp(){
this.router.navigate(['sign-in']);
  }
}
