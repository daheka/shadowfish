import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";


@Component({
  selector: 'searchbox',
  templateUrl: 'searchbox.component.html',
  styleUrls: ['searchbox.component.css'],
})

export class SearchBoxComponent implements OnInit {
  @Input() options: string[];
  currentOption: string;
  searchText: string;

  constructor(private router: Router) {

  }

  ngOnInit() {
    this.currentOption = this.options[0];
  }

  setCurrentOption(option: string) {
    this.currentOption = option;
  }

  search(searchText: string, event) {
    if(this.currentOption === this.options[1]) {
      this.router.navigateByUrl('/bands/' + searchText);
      event.target.value = null;
    }
  }
}
