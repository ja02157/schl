import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { imports } from 'app/shared/app.imports';
import { decl } from 'app/shared/app.imports';
import { provd } from 'app/shared/app.imports';
import { EntryComponent } from './entry.component';

describe('EntryComponent', () => {
  let component: EntryComponent;
  let fixture: ComponentFixture<EntryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EntryComponent,decl ],
      providers: [provd],
       imports: [
    imports
  ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
