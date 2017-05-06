import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {EventData} from "../../models/eventdata.model";
import  'rxjs/add/operator/map';
import  'rxjs/add/operator/catch';

@Injectable()
export class EventService {

  url: string = 'https://rest.bandsintown.com/artists/';
  app_id: string = 'squared';

  constructor(private http: Http) {

  }

  searchEvents(keyword):Observable<EventData[]> {
    return this.http.get(this.url + keyword + '/events?app_id=' + this.app_id)
      .map(res => (res.json()))
      .map((events:any) => {
        return events.map(event => {
         return new EventData(
            event.id,
            event.artist_id,
            event.url,
            event.datetime,
            event.venue,
            event.offers,
            event.lineup);
        })
          .filter(event => event.venue.country === 'Netherlands'
                  || event.venue.country === 'Belgium'
                  || event.venue.country === 'Germany')
      })
  }
}
