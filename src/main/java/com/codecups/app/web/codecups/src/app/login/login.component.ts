import { Component, OnInit } from '@angular/core';
import {LoginService} from "../services/login.service";

@Component({
  selector: 'app-test-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials= {
    email:'',
    password:''
  }

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    if ((this.credentials.email != '' && this.credentials.password != '') &&
    (this.credentials.email != null && this.credentials.password != null)) {
      console.log("We have to submit the form")

      this.loginService.generateToken(this.credentials).subscribe(
        (response: any) => {
          console.log(response)

          this.loginService.loginUser(response.authenticationToken)
          window.location.href="v0/administration/dashboard"
        },
        error => {
          console.log(error)
        }
      )
    } else  {
      console.log("Fields are empty")
    }
  }
}
