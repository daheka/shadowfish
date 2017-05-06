import { Component } from '@angular/core';
import {AuthService} from "./shared/services/authentication.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
})
export class AppComponent {
  title = 'app works!';

  constructor(private authService: AuthService) {

  }

  isAuthenticated() {
    return this.authService.isAuthenticated();
  }
}
