import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SchoolactivityComponent } from './schoolactivity.component';

describe('SchoolactivityComponent', () => {
  let component: SchoolactivityComponent;
  let fixture: ComponentFixture<SchoolactivityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SchoolactivityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SchoolactivityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
