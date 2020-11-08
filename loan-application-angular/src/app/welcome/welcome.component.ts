import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MessageDataService } from '../service/data/message-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  serviceMessage:string
  name=''
  constructor(private router:ActivatedRoute,
    private service:MessageDataService) { }

  ngOnInit(): void {
    this.name = this.router.snapshot.params['name'];
  }
  getMessage(){
    //console.log(this.service.executeHelloWorldBeanService())
    this.service.executeHelloWorldBeanService(this.name).subscribe(
      response=>this.handleResponse(response),
      error=>this.handleError(error)
    )
    console.log("Last line")
    //console.log("get messageeeeeeee")
  }

  handleResponse(response){
    this.serviceMessage=response.mess
    //console.log(response)
    //console.log(response.mess)
  }

  handleError(error){
    this.serviceMessage=error.error.message
    //console.log("error",error)
    //console.log("error.error",error.error)
    //console.log("err.err.mess",error.error.message)
  }

}
