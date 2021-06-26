import { Component, OnInit, Input } from '@angular/core';
import {Product} from "src/app/models/product";
import { MessengerService} from "../../../services/messenger.service";
import { CartService } from "../../../services/cart.service";

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {

  @Input() productItem!: Product

  constructor(private message: MessengerService, private cartService: CartService) {

  }

  ngOnInit(): void {
  }

  handleAddToCart() {
    this.message.sendMsg(this.productItem)
  }
}
