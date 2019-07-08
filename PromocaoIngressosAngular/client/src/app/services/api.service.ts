import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map, retry } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { Teatro } from '../models/teatro';
import { Site } from '../models/site';
import { Promocao } from '../models/promocao';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
const apiUrl = 'http://localhost:8080/PromocaoIngressos';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  getTeatros(): Observable<Teatro[]> {
    const url = `${apiUrl}/teatros`;
    return this.http.get<Teatro[]>(url)
      .pipe(
        tap(_ => console.debug('getTeatros')),
        retry(5),
        catchError(this.handleError('getTeatros', []))
      );
  }

  getTeatro(id: number): Observable<Teatro> {
    const url = `${apiUrl}/teatros/${id}`;
    return this.http.get<Teatro>(url).pipe(
      tap(_ => console.debug(`getTeatro id=${id}`)),
      retry(5),
      catchError(this.handleError<Teatro>(`getTeatro id=${id}`))
    );
  }

  addTeatro(teatro): Observable<Teatro> {
    const url = `${apiUrl}/teatros`;
    return this.http.post<Teatro>(url, teatro, httpOptions).pipe(
      tap((l: Teatro) => console.debug(`addTeatro w/id=${l.id}`)),
      retry(5),
      catchError(this.handleError<Teatro>('addTeatro'))
    );
  }

  updateTeatro(id, teatro): Observable<any> {
    const url = `${apiUrl}/teatros/${id}`;
    return this.http.put(url, teatro, httpOptions).pipe(
      tap(_ => console.debug(`updateTeatro id=${id}`)),
      retry(5),
      catchError(this.handleError<any>('updateTeatro'))
    );
  }

  deleteTeatro(id): Observable<Teatro> {
    const url = `${apiUrl}/teatros/${id}`;
    return this.http.delete<Teatro>(url, httpOptions).pipe(
      tap(_ => console.debug(`deleteTeatro id=${id}`)),
      retry(5),
      catchError(this.handleError<Teatro>('deleteTeatro'))
    );
  }
}
