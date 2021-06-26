import { Component, OnInit } from '@angular/core';
import { MessengerService } from "../../services/messenger.service";
import { Product } from "src/app/models/product";

@Component({
  selector: 'app-cartt',
  templateUrl: './cartt.component.html',
  styleUrls: ['./cartt.component.css']
})
export class CarttComponent implements OnInit {

  cartItems: any[] = []

  cartTotal = 0;

  constructor(private message: MessengerService) { }

  ngOnInit() {
    this.message.getMsg().subscribe((product: Product) => {
      this.addProductToCart(product)
    })
  }

  addProductToCart(product: Product) {

    let productExists = false

    for (let i in this.cartItems) {
      if (this.cartItems[i].productId === product.id) {
        this.cartItems[i].qty++
        productExists = true
        break;
      }
    }

    if (!productExists) {
      this.cartItems.push({ productId: product.id, productName: product.name, qty: 1, price: product.price })
    }

    this.cartTotal = 0
    this.cartItems.forEach(item => {
      this.cartTotal += (item.qty * item.price)
    })
  }
}
