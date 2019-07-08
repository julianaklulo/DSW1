import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeatroDetalhesComponent } from './teatro-detalhes.component';

describe('TeatroDetalhesComponent', () => {
  let component: TeatroDetalhesComponent;
  let fixture: ComponentFixture<TeatroDetalhesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeatroDetalhesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeatroDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
