import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {User} from "./user";
import {UsersService} from "../../../service/users.service";
import {MatSort} from "@angular/material/sort";
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-users',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.css']
})
export class UserManagementComponent {

  displayedColumns = ['userId', 'firstName', 'lastName', 'email', 'actions'];
  users: User[] = []

  dataSource!: MatTableDataSource<User>;

  @ViewChild(MatSort) sort!: MatSort
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  searchKey!: string

  constructor(private userService: UsersService) {

  }

  ngOnInit() {
    this.userService.getUsers().subscribe(response => {
      console.log(response)
      this.users = response
      this.dataSource = new MatTableDataSource(this.users);
      this.dataSource.sort = this.sort;
      setTimeout(() => this.dataSource.paginator = this.paginator);
    })


  }

  onSearchClear() {
    this.searchKey = ""
    this.applyFilter();
  }

  applyFilter() {
    this.dataSource.filter = this.searchKey.trim().toLowerCase()
  }
}



