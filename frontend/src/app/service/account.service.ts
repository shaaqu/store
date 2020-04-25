import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Account} from '../models/account';

const apiUrl = 'http://localhost:8080';

@Injectable()
export class AccountService {

  constructor(private http: HttpClient) {  }

  getAllAccounts(): Observable<any> {
    return this.http.get('{apiUrl}/account');
  }

  createNewAccount(email: string, name: string, password: string) {
    const data = {
      email,
      name,
      password
    };
    const dane = new Account(data);
    this.http.post('{apiUrl}/account', dane).subscribe();
    console.log('New account has been added');
    window.location.reload(true);
  }
}
