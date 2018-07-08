import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-schoolactivity',
  templateUrl: './schoolactivity.component.html',
  styleUrls: ['./schoolactivity.component.css']
})
export class SchoolactivityComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  
  onTest(): void {
        console.log('Hi There');
}

}
