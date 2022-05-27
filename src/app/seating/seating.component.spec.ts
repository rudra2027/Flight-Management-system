import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeatingComponent } from './seating.component';

describe('SeatingComponent', () => {
  let component: SeatingComponent;
  let fixture: ComponentFixture<SeatingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeatingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeatingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
