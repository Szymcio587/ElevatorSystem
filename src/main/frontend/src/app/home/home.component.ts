import { Component } from '@angular/core';
import { ElevatorService } from '../elevator.service';
import { Data, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  currSteps: number = 0;

  constructor(private elevatorService: ElevatorService, private router: Router, private httpClient: HttpClient) { }

  Redirect(url : String): void {
    this.currSteps = 0;
    this.router.navigate([`${url}`]);
  }

  PerformStep(): void {
    this.currSteps++;

    const fakeData = {};

    this.httpClient.post('http://localhost:8080/change/step', fakeData)
    .subscribe(response => { });
  }

}
