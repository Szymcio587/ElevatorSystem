import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Data } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ElevatorService {

  private elevatorUrl = "http://localhost:8080/elevators";

  elevators: any;

  constructor(private http: HttpClient) { }
  getAllData(): Observable<any[]> {
    return this.http.get<any[]>(this.elevatorUrl);
  }
}
