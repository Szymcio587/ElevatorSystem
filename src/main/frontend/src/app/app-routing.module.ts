import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StatusComponent } from './status/status.component';
import { HomeComponent } from './home/home.component';
import { PickupComponent } from './pickup/pickup.component';
import { ChangeComponent } from './change/change.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'status', component: StatusComponent },
  { path: 'pickup', component: PickupComponent },
  { path: 'change', component: ChangeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}

