import {Component, OnInit} from '@angular/core';
import {FormGroup, Validators, FormBuilder} from "@angular/forms";
import {ValidationService} from "../../shared/services/validation.service";
import {ContactService} from "../../shared/services/contact.service";
import {Email} from "../../shared/helpers/email.component";

@Component({
  selector: 'contact',
  templateUrl: './contact.component.html',
})

export class ContactComponent implements OnInit {

  private form: FormGroup;
  private success: boolean;

  public message: Email = {name: '', email: '', subject: '', message: ''};

  constructor(private fb: FormBuilder, private contactService: ContactService) {
    this.success = false;
  }

  ngOnInit() {
    this.form = this.fb.group({
      firstName: ['', [Validators.required, Validators.minLength(4)]],
      lastName: ['', [Validators.required, Validators.minLength(4)]],
      email: ['', [Validators.required, Validators.minLength(9), ValidationService.emailValidator]],
      phone: ['', Validators.pattern('[0-9]{2}-[0-9]{3,14}$')],
      subject: ['', [Validators.required, Validators.minLength(6)]],
      message: ['', [Validators.required, Validators.minLength(10)]],
    });
  }

  clearForm() {
      for (let name in this.form.controls) {
        this.form.controls[name].setValue('');
        this.form.controls[name].markAsUntouched();
        this.form.controls[name].markAsPristine();
      }
  }

  submitForm() {
    this.message.name = this.form.controls['firstName'].value + ' ' + this.form.controls['lastName'].value;
    this.message.subject = this.form.controls['subject'].value;
    this.message.email = this.form.controls['email'].value;
    this.message.message = this.form.controls['message'].value;
    this.contactService.postEmail(this.message).subscribe(
      response => this.handleResponse(response),
      error => this.handleResponse(error)
    );
  }

  handleResponse(response){
    if(response.status == 200){
      this.clearForm();
      this.success = true;
    }

    if(response.status != 200){
      this.success = false;
    }
  }
}
