import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class HelloWorldBean{
  constructor(public message:string){ }
}

@Injectable({
  providedIn: 'root'
})
export class MessageDataService {

  constructor(
    private http:HttpClient
  ) { }

  executeHelloWorldBeanService(name){
    return this.http.get<HelloWorldBean>(`http://localhost:8080/hello-bean/${name}`)
    //console.log("Execute hello world bean service")
  }
}
