import {Component, OnInit} from '@angular/core';
import {Product} from '../models/product';
import {Order} from '../models/order';
import {ProductService} from '../service/product.service';
import {AccountService} from '../service/account.service';
import {OrderService} from '../service/order.service';
import {Account} from '../models/account';
import {error} from 'util';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

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

  createNewProduct() {
    // tslint:disable-next-line:triple-equals
    if (this.newProductName != '' && this.newProductPrice != 0 && this.newProductQuantity != 0) {
      this.productService.createNewProduct(this.newProductName, this.newProductPrice, this.newProductQuantity);
    } else {
      window.alert('puste pola!');
    }
  }

  createNewAccount() {
    // tslint:disable-next-line:triple-equals
    if (this.newAccountEmail != '' && this.newAccountName != '' && this.newAccountPassword != '') {
      this.accountService.createNewAccount(this.newAccountEmail, this.newAccountName, this.newAccountPassword);
    } else {
      window.alert('puste pola!');
    }
  }

  createNewOrder() {
    // tslint:disable-next-line:triple-equals
    if (this.newOrderAccount != '' && this.newOrderProduct != '' ) {
      // tslint:disable-next-line:triple-equals
      const account = this.accounts.find(p => p.getEmail() == this.newAccountEmail);
      // tslint:disable-next-line:triple-equals
      const product = this.products.find(p => p.getName() == this.newProductName);
      if (account != null && product != null) {
        this.orderService.createNewOrder(account, product);
      } else {
        window.alert('Wrong product or data');
      }
    } else {
      window.alert('puste pola!');
    }
  }

  removeAccount(account: Account) {
    this.accountService.removeAccount(account).subscribe(res => {
        window.location.reload(true);
      },
      // tslint:disable-next-line:no-shadowed-variable
      error => {
        window.alert(error.message);
      });
  }

  removePoduct(product: Product) {
    this.productService.removeProduct(product).subscribe(res => {
        window.location.reload(true);
      },
      // tslint:disable-next-line:no-shadowed-variable
      error => {
        window.alert(error.message + '\nobiekt moze wystepowac w relacji z inna tabela');
      });
  }

  removeOrder(order: Order) {
    this.orderService.removeOrder(order).subscribe(res => {
      window.location.reload(true);
    },
      // tslint:disable-next-line:no-shadowed-variable
      error => {
        window.alert(error.message + '\nobiekt moze wystepowac w relacji z inna tabela');
      });
  }
}
