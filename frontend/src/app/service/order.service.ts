import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Order} from '../models/order';
import {Product} from '../models/product';

@Injectable()
export class OrderService {
  constructor(private http: HttpClient) { }

  getAllOrders(): Observable<any> {
    return this.http.get('http://localhost:8080/order');
  }

  createNewOrder(account: Account, product: Product) {
    const data = {
      account,
      product
    };
    const order = new Order(data);
    this.http.post('http://localhost:8080/order', order).subscribe(res => {
      console.log(res);
    });
    console.log('New order has been added');
    window.location.reload(true);
  }

  removeOrder(order: Order) {
    return this.http.delete('http://localhost:8080/order/' + order.getId());
  }
}
