import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-change',
  templateUrl: './change.component.html',
  styleUrls: ['./change.component.css']
})
export class ChangeComponent {

  number: number = 0;
  id: number = 1;
  floor: number = 0;
  currentDestination: number = 0;
  allDestinations: number[] = [];

  constructor(private httpClient: HttpClient, private router: Router) {}

  AddNumber() {
    if (this.number >= 0 && this.number <= 15 && !this.allDestinations.includes(this.number)) {
      this.allDestinations.push(this.number);
    }
  }

  SubmitForm() {
    const formData = {
      id: this.id,
      floor: this.floor,
      currentDestination: this.currentDestination,
      allDestinations: this.allDestinations
    };

    this.httpClient.post('http://localhost:8080/change/elevator', formData)
      .subscribe(response => { });

    this.router.navigate(['']);
  }
}
