import { Component } from '@angular/core';
import { ElevatorService } from '../elevator.service';
import { Router } from '@angular/router';
import { OnInit } from '@angular/core';

@Component({
  selector: 'app-status',
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css']
})
export class StatusComponent implements OnInit {

  elevators: any;

  constructor(private elevatorService: ElevatorService, public router: Router) { }

  ngOnInit(): void {
      this.getData();
  }

  getData(): void {
    this.elevatorService.getAllData().subscribe(elevators => {
      this.elevators = elevators;
      console.log(this.elevators);
    });
  }

  Redirect(): void {
    this.router.navigate(['']);
  }

}
