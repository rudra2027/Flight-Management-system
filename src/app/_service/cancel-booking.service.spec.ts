import { TestBed } from '@angular/core/testing';

import { CancelBookingService } from './cancel-booking.service';

describe('CancelBookingService', () => {
  let service: CancelBookingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CancelBookingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
