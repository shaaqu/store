import {Account} from './account';
import {Product} from './product';

export class Order {
  private id: number;
  private account: Account;
  private product: Product;

  constructor(obj?: any) {
    this.id = (obj && obj.id) || '';
    this.account = (obj && obj.account) || '';
    this.product = (obj && obj.product) || '';
    /* ???
    this.account = new Account();
    this.product = new Product();*/
  }

  getId(): number {
    return this.id;
  }

  getAccount(): Account {
    return this.account;
  }

  getProduct(): Product{
    return this.product;
  }
}
