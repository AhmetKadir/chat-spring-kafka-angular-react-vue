import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MessagesComponent} from './messages/messages.component';
import {RoomsComponent} from './rooms/rooms.component';
import {LoginComponent} from "./login/login.component";

const routes: Routes = [
  {
    path: 'rooms',
    component: RoomsComponent
  },
  {
    path: 'messages/:roomId',
    component: MessagesComponent
  },
  {
    path: '**',
    redirectTo: 'login'
  },
  {
    path: 'login',
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
