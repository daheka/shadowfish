import { Component } from '@angular/core';
import {EventData} from "../../models/eventdata.model";
import {EventService} from "../../shared/services/event.service";
import 'rxjs/add/operator/filter';


@Component({
  templateUrl: './event.component.html'
})

export class EventComponent {
  public events: EventData[];
  public error: string;
  public warning: string;

  constructor(private eventService: EventService) {

  }

  searchEvents(keyword) {
    this.events = null;
    this.error = null;
    this.warning = null;
    this.eventService.searchEvents(keyword)
      .subscribe(
        (eventData:EventData[]) => {
          if(eventData.length == 0) {
            this.events = null;
            this.warning = keyword + ' has no upcoming events in the Netherlands, Belgium or Germany!';
          } else {
            this.events = eventData;
          }
        },
        (err: any) => {
          if(err.status === 0) {
            this.error = keyword + ' does not appear to be in the database.';
          }
        },
        () => {
          console.log('Getting events complete...');
        }
      )
  }
}
