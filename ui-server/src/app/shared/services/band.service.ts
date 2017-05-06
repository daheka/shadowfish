import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Band} from "../../models/band.model";
import  'rxjs/add/operator/map';

@Injectable()
export class BandService {

  url: string = 'assets/data/bands.json';

  constructor(private http: Http) {

  }

  getBands():Observable<Band[]> {
    return this.http.get(this.url)
      .map(res => (res.json()))
      .map((bands:any) => {
        return bands.map(band => {
          return new Band(
            band.name,
            band.bandURL,
            band.country,
            band.bandmembers,
            band.exbandmembers);
        })
      })
  }

  getBand(name):Observable<Band[]> {
    return this.http.get(this.url)
      .map(res => (res.json()))
      .map((bands:any) => {
        return bands.map(band => {
          return new Band(
            band.name,
            band.bandURL,
            band.country,
            band.bandmembers,
            band.exbandmembers);
        })
          .filter(band => band.name.toLowerCase() === name.toLowerCase())
      })
  }
}
