import {Component} from "@angular/core";

@Component({
    selector: 'top-menu',
    templateUrl: 'top-menu.component.html',
})

export class TopMenuComponent {

  searches = [
    {value: 'Members', viewValue: 'Members'},
    {value: 'Bands', viewValue: 'Bands'},
    {value: 'Locations', viewValue: 'Locations'},
  ];
}
