import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoardAttendeeComponent } from './board-attendee.component';

describe('BoardAttendeeComponent', () => {
  let component: BoardAttendeeComponent;
  let fixture: ComponentFixture<BoardAttendeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoardAttendeeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoardAttendeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
