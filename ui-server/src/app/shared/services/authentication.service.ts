import {Injectable} from "@angular/core";
import {Observable} from 'rxjs/Observable';
import  'rxjs/add/operator/map';
import {Http, Headers, RequestOptions, Response} from "@angular/http";
import {Email} from "../helpers/email.component";

@Injectable()
export class AuthService {

  authenticated: boolean;
  profile: Object;

  constructor(private http: Http) {
    this.authenticated = false;
  }

  login(value: any) {
    // Once the form is submitted and we get the users email and password we’ll format our request based on the Auth0 API.
    let form = {
      'client_id' : 'nkL98exUFtD6xBqjBUxfAkIIQD_RG39z',
      'username' : value.username,
      'password' : value.password,
      'connection' : 'Username-Password-Authentication',
      'grant_type' : 'password',
      'scope' : 'openid name email'
    }
    // Once we have our data formed, we’ll send the request using the Angular 2 HTTP library.
    return this.http.post('https://rforkink.eu.auth0.com/oauth/ro', form)
      .map((res:any)=>{
        // We’ll subscribe to the request and capture the response
        let data = res.json();
        // If we get an id_token, we’ll know the request is successful so we’ll store the token in localStorage. We won’t handle the error use case for this tutorial.
        if(data.id_token){
          localStorage.setItem('jwt', data.id_token);
          // Finally, we’ll call our getUserInfo function which will get the user details from Auth0
          this.getUserInfo(data);
          this.authenticated = true;
        }
      }
    )
  }

  // Here we are similarly calling the Auth0 API, this time the /tokeninfo endpoint which will return the users data we requested. All we’ll need to pass to the request is our JSON Web Token.
  getUserInfo(data: any){
    let form = {
      'id_token' : data.id_token
    }
    this.http.post('https://rforkink.eu.auth0.com/tokeninfo', form).subscribe(
      (res:any)=>{
        let data = res.json();
        this.profile = data;
        localStorage.setItem('profile', JSON.stringify(data));
        // We’ll use the reset() method to reset the form. So if a user logs out they will need to enter their credentials again. If we did not do this, the previous values would still be displayed.
      }
    )
  }

  isAuthenticated() {
    return this.authenticated;
  }

  getProfile() {
    return this.profile;
  }

  logout(){
    localStorage.removeItem('jwt');
    localStorage.removeItem('profile');
    this.authenticated = false;
  }
}
