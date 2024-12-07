import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmartphoneAddComponent } from './smartphone-add.component';

describe('SmartphoneAddComponent', () => {
  let component: SmartphoneAddComponent;
  let fixture: ComponentFixture<SmartphoneAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SmartphoneAddComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SmartphoneAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
