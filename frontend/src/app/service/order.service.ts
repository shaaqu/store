import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Order} from '../moduls/order';

@Injectable()
export class OrderService{
  constructor(private http: HttpClient) { }

  getAllOrders(): Observable<any> {
    return this.http.get('http://localhost:8080/order');
  }

  createNewOrder() {
    const data = {
      product,
      dane
    };
    const order = new Order(data);
    this.http.post('http://localhost:8080/order', order).subscribe(res => {
      console.log(res);
    });
    // window.alert('New order has been added');
    // window.location.reload(true);
  }

}
