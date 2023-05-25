import { Component } from '@angular/core';
import { ElevatorService } from '../elevator.service';
import { Data, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(private elevatorService: ElevatorService, public router: Router) { }

  Redirect(url : String): void {
    this.router.navigate([`${url}`]);
  }

  PerformStep(): void {
    //moving animation
  }

}
