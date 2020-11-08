import { Component, OnInit } from '@angular/core';
import { HardCodedAuthService } from './../service/hard-coded-auth.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private HardCodedAuthService: HardCodedAuthService) { }

  ngOnInit(): void {
    this.HardCodedAuthService.logout()
  }

}
