import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class NewsService{

  private backendUrl = 'http://localhost:8080';
  
  constructor(private http: HttpClient){}

  getNews(): Observable<any>{
    return this.http.get<any>(`${this.backendUrl}/news`);
  }
}