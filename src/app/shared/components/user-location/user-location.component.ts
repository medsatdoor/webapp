import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { CompleterService, CompleterData } from 'ng2-completer';


@Component({
  selector: 'app-user-location',
  templateUrl: './user-location.component.html',
  styleUrls: ['./user-location.component.css']
})
export class UserLocationComponent implements OnInit {
	swingOpen: boolean = true;
  protected selectedLoc: string;

  @Output()
  userLoc: EventEmitter<string> = new EventEmitter<string>();

  protected locations = [
    'Electronic City', 'Doddathogur',
    'Neeladri Nagar', 'Konappana Agrahara', 
    'Rupena Agrahara', 'Silk board', 'BTM',
    'St. John'
  ];
  constructor() { }

  ngOnInit() {
  }

  closeLoc() {
  	this.swingOpen=false;
    this.userLoc.emit(this.selectedLoc);
  }
}
