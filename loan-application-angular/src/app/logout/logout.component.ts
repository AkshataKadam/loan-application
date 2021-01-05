import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardCodedAuthService } from './../service/hard-coded-auth.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router,
    private HardCodedAuthService: HardCodedAuthService) { }

  ngOnInit(): void {
    this.HardCodedAuthService.logout()
    this.router.navigate(['login']);
  }

}
