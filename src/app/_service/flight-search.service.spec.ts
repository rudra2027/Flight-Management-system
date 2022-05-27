import { TestBed } from '@angular/core/testing';

import { FlightSearchService } from './flightsearch.service';

describe('FlightSearchService', () => {
  let service: FlightSearchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FlightSearchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
