import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MatSnackBar} from "@angular/material/snack-bar";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-register-test',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerUrl = 'http://localhost:8080/v0/registration'

  credentials= {
    firstName: '',
    lastName: '',
    email: '',
    password: ''
  }

  formRegister!: FormGroup;

  constructor(private httpClient: HttpClient, private _snackBar: MatSnackBar, private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    this.formRegister = this.formBuilder.group( {
      firstName: '',
      lastName: '',
      email: '',
      password: ''
    });
  }

  // onSubmit(user: User) {
  //   const body: User = {
  //     firstName: user.firstName,
  //     lastName: user.lastName,
  //     email: user.email
  //   }
  //   this.httpClient.post(this.registerUrl)
  // }

  openSnackBar() {
    this._snackBar.open("Успешна Регистрация", "Затвори", {
      duration: 3000
      }
    );
  }

  submitRegistration(): void {
    console.log(this.formRegister.getRawValue())
    this.httpClient.post("http://localhost:8080/v0/registration", this.formRegister.getRawValue())
      .subscribe()

    //window.location.assign("http://localhost:4200/v0/login-test")
  }
}
