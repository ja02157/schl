import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { imports } from 'app/shared/app.imports';
import { decl } from 'app/shared/app.imports';
import { provd } from 'app/shared/app.imports';
import { PersonalInfoFormComponent } from './personal-info-form.component';

describe('PersonalInfoFormComponent', () => {
  let component: PersonalInfoFormComponent;
  let fixture: ComponentFixture<PersonalInfoFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonalInfoFormComponent,decl ],
      providers: [provd],
      imports: [imports
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonalInfoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
