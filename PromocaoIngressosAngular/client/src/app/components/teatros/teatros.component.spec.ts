import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeatrosComponent } from './teatros.component';

describe('TeatrosComponent', () => {
  let component: TeatrosComponent;
  let fixture: ComponentFixture<TeatrosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeatrosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeatrosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
