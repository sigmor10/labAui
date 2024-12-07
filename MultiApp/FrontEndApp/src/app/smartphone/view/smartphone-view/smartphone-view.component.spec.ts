import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmartphoneViewComponent } from './smartphone-view.component';

describe('SmartphoneViewComponent', () => {
  let component: SmartphoneViewComponent;
  let fixture: ComponentFixture<SmartphoneViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SmartphoneViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SmartphoneViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
