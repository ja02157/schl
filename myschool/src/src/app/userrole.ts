import { Roles } from './roles';
export class UserRole {
  constructor(
    public username?: string,
    public role?: Roles
  ) {}
}