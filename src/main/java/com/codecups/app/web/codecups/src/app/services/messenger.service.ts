import { Injectable } from '@angular/core';
import { Subject} from "rxjs";
import {Product} from "../models/product";

@Injectable({
  providedIn: 'root'
})
export class MessengerService {

  subject= new Subject<Product>();

  constructor() { }

  sendMsg(product: Product) {
    //called by the product component
    this.subject.next(product) //triggering an event
  }

  getMsg() {
    //called by the cart component
    return this.subject.asObservable();
  }
}
