import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {AuthService} from "../../shared/services/authentication.service";
import {Router, ActivatedRoute} from "@angular/router";
import {ValidationService} from "../../shared/services/validation.service";


@Component({
  selector: 'login',
  templateUrl: './login.component.html'
})

export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  accountForm: FormGroup;
  loading = false;
  errorMessage: string = null;
  returnUrl: string;

  constructor(fb: FormBuilder,private route: ActivatedRoute, private router: Router, private authService: AuthService){
    // For our form, we’ll just have two fields and we’ll require both of them to be filled out before the form can be submitted
    this.loginForm = fb.group({
      username: [null, Validators.required],
      password: [null, Validators.required],
    })

    this.accountForm = fb.group({
      firstName: ['', [Validators.required, Validators.minLength(4)]],
      lastName: ['', [Validators.required, Validators.minLength(4)]],
      username: ['', [Validators.required, Validators.minLength(4)]],
      email: ['', [Validators.required, Validators.minLength(9), ValidationService.emailValidator]],
      password: ['', [Validators.required, Validators.minLength(6), ValidationService.passwordValidator]],
      confirmPassword: ['', [Validators.required, Validators.minLength(10), ValidationService.passwordValidator]],
      checkbox: ['', Validators.required],
    });
  }

  ngOnInit() {
    // reset login status
    this.authService.logout();

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  login(formValue: any){
    this.loading = true;
    this.errorMessage = null;
    this.authService.login(formValue)
      .subscribe(
        data => {
          // login successful so redirect to return url
          this.router.navigate([this.returnUrl]);
        },
        error => {
          // login failed so display error
          if(error.status == 401) {
            this.errorMessage = "Username or password is incorrect";
          }
          if(error.status == 429) {
            this.errorMessage = "Too many attempts, try again in a few minutes";
          }
          this.loading = false;
        });
  }

  clearForm() {
    for (let name in this.accountForm.controls) {
      this.accountForm.controls[name].setValue('');
      this.accountForm.controls[name].markAsUntouched();
      this.accountForm.controls[name].markAsPristine();
    }
  }
}
