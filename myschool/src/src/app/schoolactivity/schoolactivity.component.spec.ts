import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { imports } from 'app/shared/app.imports';
import { decl } from 'app/shared/app.imports';
import { provd } from 'app/shared/app.imports';
import { SchoolactivityComponent } from './schoolactivity.component';

describe('SchoolactivityComponent', () => {
  let component: SchoolactivityComponent;
  let fixture: ComponentFixture<SchoolactivityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SchoolactivityComponent,decl ],
      providers: [provd],
      imports: [
       imports
  ]
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
