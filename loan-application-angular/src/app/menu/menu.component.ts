import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { HardCodedAuthService } from './../service/hard-coded-auth.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  //isLoggedIn: boolean= false
  constructor(public HardCodedAuthService: HardCodedAuthService) { }

  ngOnInit(): void {
    //this.isLoggedIn = this.HardCodedAuthService.isLogedIn()
  }

}
