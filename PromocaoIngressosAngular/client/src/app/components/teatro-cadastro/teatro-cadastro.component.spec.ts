import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeatroCadastroComponent } from './teatro-cadastro.component';

describe('TeatroCadastroComponent', () => {
  let component: TeatroCadastroComponent;
  let fixture: ComponentFixture<TeatroCadastroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeatroCadastroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeatroCadastroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
