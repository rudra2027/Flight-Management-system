import { TestBed } from '@angular/core/testing';

import { OrderServiceService } from './order-service.service';

describe('OrderServiceService', () => {
  let service: OrderServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrderServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
