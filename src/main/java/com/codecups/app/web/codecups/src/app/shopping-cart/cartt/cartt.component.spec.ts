import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarttComponent } from './cartt.component';

describe('CarttComponent', () => {
  let component: CarttComponent;
  let fixture: ComponentFixture<CarttComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarttComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarttComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
