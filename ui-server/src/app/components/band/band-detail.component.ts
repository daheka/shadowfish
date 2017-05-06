import { Component, OnInit, OnDestroy } from '@angular/core';
import {Band} from "../../models/band.model";
import {ActivatedRoute} from "@angular/router";
import {BandService} from "../../shared/services/band.service";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/switchMap';
import {EventData} from "../../models/eventdata.model";
import {EventService} from "../../shared/services/event.service";

@Component({
  selector : 'band-detail',
  templateUrl: './band-detail.component.html'
})

export class BandDetailComponent implements OnInit, OnDestroy {
  public name: string;
  public currentBand: Band;
  public events: EventData[];
  public error: string;
  public warning: string;
  private sub: any; // pointer to subscription on Route
  private eventSub: any;

  constructor(private route: ActivatedRoute, private bandService: BandService, private eventService: EventService) {
    // Credits: http://blog.thoughtram.io/angular/2016/06/14/routing-in-angular-2-revisited.html
    // ActivatedRoute comes with a 'params' property which is an Observable.
    // To access the property 'id', all we have to do is to subscribe to
    // the parameters Observable changes.
  }

  ngOnInit() {
    this.events = null;
    this.error = null;
    this.warning = null;

    // this.name = this.route.params['name'];

    this.sub = this.route.params
    	.map(params => params['name'])
    	.switchMap(name => this.bandService.getBand(name))
    	.subscribe((band) => {
    		this.currentBand = <Band>band[0]; // b/c our service returns an array w/ 1 object (not best practice, but hey, it works)
    	});


    this.eventSub = this.route.params
      .map(params => params['name'])
      .switchMap(name => this.eventService.searchEvents(name))
      .subscribe(
        (eventData:EventData[]) => {
          if(eventData.length == 0) {
            this.events = null;
            this.warning = ' has no upcoming events in the Netherlands, Belgium or Germany!';
          } else {
            this.warning = null;
            this.events = eventData;
          }
        },
        (err: any) => {
          if(err.status === 0) {
            this.error = ' does not appear to be in the database.';
          }
        },
        () => {
          console.log('Getting events complete...');
        }
      )
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
