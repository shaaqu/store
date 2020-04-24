import {Account} from './account';
import {Product} from './product';

export class Order {
  private id: number;
  private account: string;
  private product: string;

  constructor(obj?: any) {
    this.id = (obj && obj.id) || '';
    this.account = (obj && obj.account) || '';
    this.product = (obj && obj.price) || '';
    /* ???
    this.account = new Account();
    this.product = new Product();*/
  }

  getId(): number {
    return this.id;
  }

  getAccount(): string {
    return this.account;
  }

  getProduct(): string{
    return this.product;
  }
}
