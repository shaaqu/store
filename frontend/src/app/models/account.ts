export class Account {
  private email: string;
  private name: string;
  private password: string;

  constructor(obj?: any) {
    this.email = (obj && obj.email) || '';
    this.name = (obj && obj.name) || '';
    this.password = (obj && obj.password) || '';
  }

  getEmail(): string {
    return this.email;
  }

  getName(): string {
    return this.name;
  }

  getPassword(): string {
    return this.password;
  }
}
