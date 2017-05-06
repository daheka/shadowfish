import {Component, OnInit} from '@angular/core';
import {Band} from "../../models/band.model";
import {BandService} from "../../shared/services/band.service";
import 'rxjs/add/operator/filter';


@Component({
  selector: 'band',
  templateUrl: './band.component.html'
})

export class BandComponent implements OnInit {
  public bands: Band[];
  public currentBand: Band;
  public error: string;
  public warning: string;

  constructor(private bandService: BandService) {

  }

  ngOnInit() {
    this.bandService.getBands()
      .subscribe(
        (bandData:Band[]) => {
          this.bands = bandData;
        },
        (err: any) => {
          console.log(err);
        },
        () => {
          console.log('Getting bands complete...');
        }
      )
  }

  getBand(band) {
    this.currentBand = band;
  }
}
