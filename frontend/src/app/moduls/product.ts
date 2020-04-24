export class Product {
  private  id: number;
  private name: string;
  private price: number;
  private quantity: number;

  constructor(obj?: any) {
    this.id = (obj && obj.id) || '';
    this.name = (obj && obj.name) || '';
    this.price = (obj && obj.price) || '';
    this.quantity = (obj && obj.quantity) || '';
  }

  getName(): string {
    return this.name;
  }

  getPrice(): number {
    return this.price;
  }

  getQuantity(): number {
    return this.quantity;
  }
}


