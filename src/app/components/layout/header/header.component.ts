import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  title = 'Header';
  userLoc: string;
  constructor() {}

  userSelectedLoc(event) {
  	console.log(event);
  	this.userLoc = event;
  }
}
