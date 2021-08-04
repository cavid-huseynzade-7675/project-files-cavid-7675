import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { API_URL } from '../constant';
import { User } from '../models/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:User=new User();
  constructor(private http:HttpClient,private router:Router) {}

  ngOnInit(): void {}
  onLogin(){
    let token:string='Basic '+window.btoa(this.user.username +':'+ this.user.password);
    this.http.get(API_URL +'/shops',{
headers:new HttpHeaders(
{ Authorization:token}

)

    }).subscribe(
      resp =>{
      //  alert('ugurlu giris')
      localStorage.setItem('token',token)
      this.router.navigate(['shops']);
      },
      error =>{
        alert('ugursuz gris')
      }
    );
  }

}
