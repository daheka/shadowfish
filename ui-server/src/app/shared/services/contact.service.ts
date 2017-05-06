import {Injectable} from "@angular/core";
import {Observable} from 'rxjs/Observable';
import  'rxjs/add/operator/map';
import {Http, Headers, RequestOptions, Response} from "@angular/http";
import {Email} from "../helpers/email.component";

@Injectable()
export class ContactService {
  constructor (private http: Http) {}

  private _contactUrl = 'http://localhost/contact/email.php';

  postEmail(newMail: Email): Observable<string>{
    let body = `name=${newMail.name}&email=${newMail.email}&message=${newMail.message}&subject=${newMail.subject}`;
    let headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded' });
    let options = new RequestOptions({ headers: headers });

    return this.http.post(this._contactUrl, body, options)
    // .map(res =>  <string> res.json())
      .catch(this.handleError)
  }

  private handleError (error: Response) {
    // in a real world app, we may send the server to some remote logging infrastructure
    // instead of just logging it to the console
    console.error('Error in retrieving news: ' + error);
    return Observable.throw(error.json().error || 'Server error');
  }
}
