import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardCodedAuthService {

  constructor() { }

  auth(username,password){
    if(username==='akshata' && password==='akkshata'){
      sessionStorage.setItem('authUser',username)
      console.log(this.isLogedIn)
      return true
    }
    return false
  }

  isLogedIn(){
    let user = sessionStorage.getItem('authUser')
    return !(user===null)
  }

  logout(){
    sessionStorage.removeItem('authUser');
  }

}
