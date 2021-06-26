export class Product {
  id: string;
  name: string;
  description: string;
  price: number;
  imageUrl: string;


  constructor(id: string, name: string, description = '', price = 0, imageUrl = 'https://dummyimage.com/600x400/55595c/fff') {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.imageUrl = imageUrl;
  }
}
