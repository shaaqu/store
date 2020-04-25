import {Component, OnInit} from '@angular/core';
import {Product} from '../models/product';
import {Order} from '../models/order';
import {ProductService} from '../service/product.service';
import {AccountService} from '../service/account.service';
import {OrderService} from '../service/order.service';
import {Account} from '../models/account';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit{

  products: Product[];
  orders: Order[];
  accounts: Account[];

  newProductName: string;
  newProductPrice: number;
  newProductQuantity: number;

  newOrderAccount: string;
  newOrderProduct: string;

  newAccountEmail: string;
  newAccountName: string;
  newAccountPassword: string;

  // stronnicowanie
  productsItems: Array<any>;
  ordersItems: Array<any>;
  accountsItems: Array<any>;

  onChangePageProducts(productsItems: Array<any>) {
    // update current page of items
    this.productsItems = productsItems;
  }

  onChangePageOrders(ordersItems: Array<any>) {
    // update current page of items
    this.ordersItems = ordersItems;
  }

  onChangePageAccounts(adressesItem: Array<any>) {
    // update current page of items
    this.accountsItems = adressesItem;
  }

  constructor(private productService: ProductService, private accountService: AccountService, private orderService: OrderService) {}

  ngOnInit() {

    this.getProducts();
    this.getAccounts();
    this.getOrders();

    this.newProductName = '';
    this.newProductPrice = 0;
    this.newProductQuantity = 0;

    this.newAccountEmail = '';
    this.newAccountName = '';
    this.newAccountPassword = '';

    this.newOrderAccount = '';
    this.newOrderProduct = '';
  }

  private getProducts() {
    this.productService.getAllProducts().subscribe(res => {
      this.products = res.map(el => new Product(el));
    });
  }

  private getAccounts() {
    this.accountService.getAllAccounts().subscribe(res => {
      this.accounts = res.map(el => new Account(el));
    });
  }

  private getOrders() {
    this.orderService.getAllOrders().subscribe(res => {
      this.orders = res.map(el => new Order(el));
    });
  }
}
