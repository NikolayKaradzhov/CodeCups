import {Component, Input, OnInit} from '@angular/core';
import {UsersService} from "../../service/users.service";
import {User} from "./user-management/user";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  users: User[] = []

  constructor(private userService: UsersService) { }

  ngOnInit(): void {
    this.getUsers()
  }

  getUsers() {
    return this.userService.getUsers()
  }
}
