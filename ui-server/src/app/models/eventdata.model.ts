import { VenueData } from './venuedata.model';
import { OfferData } from './offerdata.model';

export class EventData {
  constructor(
    public id: string,
    public artist_id: string,
    public url: string,
    public datetime: string,
    public venue: VenueData,
    public offers: OfferData[],
    public lineUp: string[]
  ) {

  }
}

