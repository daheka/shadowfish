// Angular modules
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialsModule } from './materials.module';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

// Components
import { AppComponent } from './app.component';
// Common Components
import { TopMenuComponent, FooterComponent } from "./components/common/index";

//Section Components
import { HomeComponent } from "./components/home/index";
import { EventComponent } from "./components/event/index";
import { ContactComponent } from "./components/contact/index";
import { BandComponent, BandDetailComponent } from "./components/band/index";
import { LoginComponent } from "./components/login/index";
import { NewsComponent } from "./components/news/news.component";
import { routing } from "./app.routing";

//Material Components
import { SearchBoxComponent, NewsPostComponent } from './materials/index';

// Services
import { EventService, BandService, ValidationService, ContactService, AuthService } from "./shared/services/index";

//Guards
import { AuthGuard } from "./shared/guards/index";

// Directives
import {ControlMessages} from "./shared/directives/control-messages.directive";

@NgModule({
  declarations: [
    AppComponent,

    TopMenuComponent,
    FooterComponent,

    HomeComponent,
    EventComponent,
    BandComponent,
    LoginComponent,
    BandDetailComponent,
    ContactComponent,
    NewsComponent,

    SearchBoxComponent,
    NewsPostComponent,

    ControlMessages,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    routing,
  ],
  providers: [
    EventService,
    BandService,
    ValidationService,
    ContactService,
    AuthService,

    [AuthGuard]
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
