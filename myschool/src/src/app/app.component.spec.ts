import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { imports } from 'app/shared/app.imports';
import { decl } from 'app/shared/app.imports';
import { provd } from 'app/shared/app.imports';
describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
         decl
      ],
      providers: [provd],
      imports: [imports
      ]
    }).compileComponents();
  }));
  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));
 // it(`should have as title 'app'`, async(() => {
 //   const fixture = TestBed.createComponent(AppComponent);
 //   const app = fixture.debugElement.componentInstance;
 //   expect(app.title).toEqual('app');
 // }));
 // it('should render title in a h1 tag', async(() => {
 //   const fixture = TestBed.createComponent(AppComponent);
 //   fixture.detectChanges();
 //   const compiled = fixture.debugElement.nativeElement;
 //   expect(compiled.querySelector('h1').textContent).toContain('Welcome to schoolUI!');
 // }));
});
