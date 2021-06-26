import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../services/login.service";
import {Router} from "@angular/router";
import {UsersService} from "../../admin/service/users.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public isLoggedIn = false;

  constructor(private loginService: LoginService, private router: Router, private userService: UsersService) { }

  ngOnInit(): void {
    this.isLoggedIn = this.loginService.isUserLoggedIn()
  }

  logoutUser() {
    this.loginService.logout();

    this.router.navigate(["/v0/home"])

    location.reload();
  }

}
