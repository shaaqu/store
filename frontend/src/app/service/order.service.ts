import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Order} from '../models/order';

@Injectable()
export class OrderService {
  constructor(private http: HttpClient) { }

  getAllOrders(): Observable<any> {
    return this.http.get('http://localhost:8080/order');
  }

  createNewOrder(product: string, account: string) {
    const data = {
      product,
      account
    };
    const order = new Order(data);
    this.http.post('http://localhost:8080/order', order).subscribe(res => {
      console.log(res);
    });
    console.log('New order has been added');
    window.location.reload(true);
  }

}
