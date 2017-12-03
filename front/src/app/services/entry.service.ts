import { Entry } from './../models/entry';
import { Injectable } from '@angular/core';
import { NgModel } from '@angular/forms';

import { Http, Response, RequestOptions, Headers } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {Observable} from 'rxjs/Rx';

@Injectable()
export class EntryService {

  constructor(private http: Http) { }

  getEntries(): Observable<Entry[]>{
    return this.http.get('/api/entries/all').map((res:Response) => {
      return res.json(); 
    }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  saveEntry(entry: Entry): Observable<Number>{
    return this.http.post('/api/entries',entry).map((res:Response) => {
      return res.json(); 
    }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }


}
