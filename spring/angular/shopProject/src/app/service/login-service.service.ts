import { Injectable,EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
userLogin:EventEmitter<boolean>=new EventEmitter();
userRoles:EventEmitter<string[]>=new EventEmitter();

  constructor() { }
}
