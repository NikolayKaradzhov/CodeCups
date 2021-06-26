import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loginUrl = "http://localhost:8080/v0/authenticate"

  constructor(private http: HttpClient) { }

  generateToken(credentials: any) {
    return this.http.post(this.loginUrl, credentials)
  }

  loginUser(token: string) {
    localStorage.setItem('authenticationToken', token)
    return true;
  }

  isUserLoggedIn() {
    let token = localStorage.getItem('authenticationToken')

    if (token == undefined || token == '' || token == null) {
      return false;
    } else {
      return true;
    }
  }

  logout() {
    localStorage.removeItem("authenticationToken")
    return true;
  }

  getToken() {
    return localStorage.getItem("authenticationToken");
  }









  //test-login

  generateToken1(credentials: any) {
    return this.http.post(this.loginUrl, credentials)
  }

  loginUser1(token: string) {
    localStorage.setItem("token", token)
    return true;
  }


  isUserLoggedIn1() {
    let token = localStorage.getItem("token")

    if (token == undefined || token == '' || token == null) {
      return false;
    } else {
      return true;
    }
  }


  logout1() {
    localStorage.removeItem("token")
    return true;
  }


  getToken1() {
    return localStorage.getItem("token");
  }
}
