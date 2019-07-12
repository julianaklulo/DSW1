import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JwtService } from './services/jwt.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Promoção de Ingressos';

  constructor(private jwtService: JwtService, private router: Router) {}

  logout() {
    this.jwtService.logout();
    this.router.navigate(['/login']);
  }

  public get loggedIn(): boolean {
    return localStorage.getItem('access_token') !== null;
  }
}
