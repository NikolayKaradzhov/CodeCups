import { Injectable } from '@angular/core';
import {CartItem} from "../models/cart-item";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Product} from "../models/product";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private httpClient: HttpClient) { }

  getCartItems(): Observable<CartItem[]> {
    //TODO: Mapping the obtained result to our CartItem props. (pipe() and map())
    return this.httpClient.get<CartItem[]>("http://localhost:8080/v0/products")
  }

  addProductToCart(product: Product): Observable<any> {
    return this.httpClient.post("http://localhost:8080/v0/store/products", product)
  }
}
