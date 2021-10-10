export interface IUser {
  id: number;
  name: string;
}

export interface ICreateUser {
  email: string;
  password: string;
  telephone: string;
  checkbox: boolean;
}
