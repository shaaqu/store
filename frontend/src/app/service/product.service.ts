import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../models/product';


const apiUrl = 'http://localhost:8080';

@Injectable()
export class ProductService {


  constructor(private http: HttpClient) { }

  getAllProducts(): Observable<any> {
    return this.http.get('{apiUrl}/product');
  }

  createNewProduct(name: string, price: number, quantity: number) {
    const data = {
      name,
      price,
      quantity
    };
    const product = new Product(data);
    return this.http.post('{apiUrl}/product', product).subscribe(res => {
      console.log(res);
    });
    console.log('New product has been added');
    window.location.reload(true);
  }

}
