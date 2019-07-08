import { Teatro } from './teatro';
import { Site } from './site';


export class Promocao {
  id: string;
  nomePeca: string;
  preco: string;
  dataHora: string;
  teatro: Teatro;
  site: Site;
}
