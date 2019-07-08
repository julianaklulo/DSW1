import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeatroEdicaoComponent } from './teatro-edicao.component';

describe('TeatroEdicaoComponent', () => {
  let component: TeatroEdicaoComponent;
  let fixture: ComponentFixture<TeatroEdicaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeatroEdicaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeatroEdicaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
