export class User {
  userId: string;
  firstName: string;
  lastName: string;
  email: string;

  constructor(id: string, firstName: string, lastName: string, email: string) {
    this.userId = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}
