import { Component, Input } from '@angular/core';
import { FormControl } from '@angular/forms';
import {ValidationService} from "../services/validation.service";

@Component({
  selector: 'control-messages',
  template: `<p class="contact-error" *ngIf="errorMessage !== null">{{errorMessage}}</p>`
})
export class ControlMessages {
  @Input() control: FormControl;
  @Input() control2: FormControl;
  constructor() { }

  get errorMessage() {
    for (let propertyName in this.control.errors) {
      if (this.control.errors.hasOwnProperty(propertyName) && this.control.touched) {
        return ValidationService.getValidatorErrorMessage(propertyName, this.control.errors[propertyName]);
      }
    }

    return null;
  }
}
