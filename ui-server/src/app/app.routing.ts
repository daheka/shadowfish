import { Routes, RouterModule } from '@angular/router';

import {HomeComponent} from "./components/home/index";
import {BandComponent, BandDetailComponent } from "./components/band/index";
import {EventComponent} from "./components/event/index";
import {ContactComponent} from "./components/contact/index";
import { LoginComponent } from "./components/login/index";
import { AuthGuard } from "./shared/guards/index";
import {NewsComponent} from "./components/news/news.component";

const appRoutes : Routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'events', component: EventComponent, canActivate: [AuthGuard] },
  { path: 'bands', component: BandComponent, canActivate: [AuthGuard] },
  { path: 'bands/:name', component: BandDetailComponent, canActivate: [AuthGuard]},
  { path: 'contact', component: ContactComponent, canActivate: [AuthGuard] },
  { path: 'news', component: NewsComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },

  // otherwise redirect to home
  { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);
