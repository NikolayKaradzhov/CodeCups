import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css']
})
export class ContactsComponent implements OnInit {

  router: Router;
  constructor(private _router: Router) {
    this.router = _router;
  }

  ngOnInit(): void {
  }

}
