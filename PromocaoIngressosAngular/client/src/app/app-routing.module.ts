import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TeatrosComponent } from './components/teatros/teatros.component';
import { TeatroCadastroComponent } from './components/teatro-cadastro/teatro-cadastro.component';
import { TeatroDetalhesComponent } from './components/teatro-detalhes/teatro-detalhes.component';
import { TeatroEdicaoComponent } from './components/teatro-edicao/teatro-edicao.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './helpers/auth-guard';

const routes: Routes = [
  {
    path: 'teatros',
    component: TeatrosComponent,
    canActivate: [AuthGuard],
    data: { title: 'Lista de Teatros' }
  },
  {
    path: 'teatro-detalhes/:id',
    component: TeatroDetalhesComponent,
    canActivate: [AuthGuard],
    data: { title: 'Detalhes do Teatro' }
  },
  {
    path: 'teatro-cadastro',
    component: TeatroCadastroComponent,
    canActivate: [AuthGuard],
    data: { title: 'Cadastro Teatro' }
  },
  {
    path: 'teatro-edicao/:id',
    component: TeatroEdicaoComponent,
    canActivate: [AuthGuard],
    data: { title: 'Edição Teatro' }
  },
  {
    path: 'login',
    component: LoginComponent,
    data: { title: 'Login' }
  },
  { path: '',
    redirectTo: '/',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
