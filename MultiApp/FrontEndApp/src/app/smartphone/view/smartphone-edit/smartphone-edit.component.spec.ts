import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmartphoneEditComponent } from './smartphone-edit.component';

describe('SmartphoneEditComponent', () => {
  let component: SmartphoneEditComponent;
  let fixture: ComponentFixture<SmartphoneEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SmartphoneEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SmartphoneEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
