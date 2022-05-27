import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardAttendeeComponent } from './board-attendee/board-attendee.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { CancelBookingComponent } from './cancel-booking/cancel-booking.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PaymentComponent } from './payment/payment.component';
import { RegisterComponent } from './register/register.component';
import { SeatingComponent } from './seating/seating.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'user/:flight_id/:date', component: BoardUserComponent },
  { path: 'attendee', component: BoardAttendeeComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'cancelBooking', component: CancelBookingComponent },
  { path: 'seating', component: SeatingComponent },
  { path: 'payment/:userId/:amount', component: PaymentComponent },

  { path: '', redirectTo: 'home', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
