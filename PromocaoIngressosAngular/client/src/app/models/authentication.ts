export interface Authentication {
    username: string;
    roles: string[];
    access_token: string;
    expires_in: number;
    refresh_token: string;
    when: Date;
}
