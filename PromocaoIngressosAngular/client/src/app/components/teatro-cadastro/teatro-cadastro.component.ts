import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroupDirective, FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { Teatro } from '../../models/teatro';

@Component({
  selector: 'app-teatro-cadastro',
  templateUrl: './teatro-cadastro.component.html',
  styleUrls: ['./teatro-cadastro.component.css']
})
export class TeatroCadastroComponent implements OnInit {

  teatroForm: FormGroup;
  isLoadingResults = false;

  constructor(private router: Router, private api: ApiService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.teatroForm = this.formBuilder.group({
      nome: [null, Validators.required],
      cnpj: [null, Validators.required],
      cidade: [null, Validators.required]
    });
  }

  onFormSubmit(form: NgForm) {
    this.isLoadingResults = true;
    this.api.addTeatro(form)
      .subscribe(res => {
        const id = res.id;
        this.isLoadingResults = false;
        this.router.navigate(['/teatro-detalhes', id]);
      }, (err) => {
        console.log(err);
        this.isLoadingResults = false;
      });
  }
}
