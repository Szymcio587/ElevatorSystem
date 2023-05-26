import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pickup',
  templateUrl: './pickup.component.html',
  styleUrls: ['./pickup.component.css']
})
export class PickupComponent {

  id: number = 4;
  floor: number = 0;
  currentDestination: number = 0;
  allDestinations: number[] = [];

  constructor(private httpClient: HttpClient, private router: Router) {}

  SubmitForm(): void {
    const formData = {
      floor: this.floor,
      destination: this.currentDestination
    };

    this.httpClient.post('http://localhost:8080/change/new', formData)
      .subscribe(response => { });

    this.router.navigate(['']);
  }

  GoBack(): void {
    this.router.navigate(['']);
  }
}
