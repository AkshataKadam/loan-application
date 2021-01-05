import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardCodedAuthService } from '../service/hard-coded-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = '';
  password = '';
  err = '**Invalid Credentials';
  invalidLogin = false;
  constructor(private router: Router,
    private HardCodedAuthService: HardCodedAuthService) { }

  ngOnInit(): void {
  }

  loginHandle(): void{
    //console.log(this.username);
    if(this.HardCodedAuthService.auth(this.username,this.password)){
      this.router.navigate(['loans']);
    this.invalidLogin=false;
    }
    else
    this.invalidLogin=true;
  }

}
