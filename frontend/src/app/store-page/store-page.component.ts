import {Component, OnInit} from '@angular/core';
import {Product} from '../models/product';
import {ProductService} from '../service/product.service';

@Component({
  selector: 'app-store-page',
  templateUrl: './store-page.component.html',
  styleUrls: ['./store-page.component.css']
})
export class StorePageComponent implements  OnInit {

  products: Product[];

  newProductName: string;
  newProductPrice: string;
  newProductQuantity: string;

  productsItems: Array<any>;

  onChangePageProducts(productsItems: Array<any>) {
    // update current page of items
    this.productsItems = productsItems;
  }

  constructor(private productsService: ProductService) {  }

  ngOnInit() {
    this.getProducts();

    this.newProductName = '';
    this.newProductPrice = '';
    this.newProductQuantity = '';
  }
  private getProducts() {
    this.productsService.getAllProducts().subscribe(res => {
      this.products = res.map(el => new Product(el));
    });
  }

}
