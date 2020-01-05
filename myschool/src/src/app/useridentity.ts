import { UserInformation } from './userinformation';
import { UserRole } from './userrole';
export class UserIdentity {
  constructor(
    public username?: string,
    public password?: string,
    public token?: string,
    public userInformation?: UserInformation,
    public userRoles?: Array<UserRole>
  ) {}
}