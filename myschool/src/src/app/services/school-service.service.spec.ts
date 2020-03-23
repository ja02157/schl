import { TestBed, inject } from '@angular/core/testing';
import { imports } from 'app/shared/app.imports';
import { decl } from 'app/shared/app.imports';
import { provd } from 'app/shared/app.imports';
import { SchoolServiceService } from './school-service.service';

describe('SchoolServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SchoolServiceService, provd],
      imports: [imports],
      declarations: [decl]
      
    });
  });

  it('should be created', inject([SchoolServiceService], (service: SchoolServiceService) => {
    expect(service).toBeTruthy();
  }));
});
