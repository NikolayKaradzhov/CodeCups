import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {LoginService} from "../../services/login.service";
import {Observable} from "rxjs";
import {User} from "../components/dashboard/user-management/user";

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  usersUrl = 'http://localhost:8080/v0/administration/users?page=0&limit=12'

  constructor(private httpClient: HttpClient, private loginService: LoginService) { }

  getUsers(): Observable<User[]>{
    var token = this.loginService.getToken()
    var headers_object = new HttpHeaders().set("Authorization", "Bearer " + token);

    const httpOptions = {
      headers: headers_object
    };

    return this.httpClient.get<User[]>(this.usersUrl, httpOptions)
  }
}
