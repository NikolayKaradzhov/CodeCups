import { Injectable } from '@angular/core';

import { Product } from "src/app/models/product";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  products: Product[] = []

  constructor(private httpClient: HttpClient) { }

  getAllProducts(): Product[] {
    //TODO: Populate products from API and return an Observable
    return this.products;
  }

  getProducts(): Observable<Product[]>{
    return this.httpClient.get<Product[]>('http://localhost:8080/v0/store/products?page=0&limit=12')
  }

}
