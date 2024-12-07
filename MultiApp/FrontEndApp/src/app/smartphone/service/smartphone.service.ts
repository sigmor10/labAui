import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Smartphones} from '../model/smartphones';
import {SmartphoneDetails} from '../model/smartphoneDetails';
import {PhoneForm} from '../model/phoneForm';

@Injectable({
  providedIn: 'root'
})
export class SmartphoneService {

  constructor(private http: HttpClient) { }

  getSmartphones(): Observable<Smartphones>{
    return this.http.get<Smartphones>('/api/smartphones');
  }

  getBrandSmartphones(id: string): Observable<Smartphones> {
    return this.http.get<Smartphones>(`/api/brands/${id}/smartphones`);
  }

  getSmartphoneDetails(id: string): Observable<SmartphoneDetails> {
    return this.http.get<SmartphoneDetails>(`/api/smartphones/${id}`);
  }

  postSmartphone(brandId: string, request: PhoneForm): Observable<any> {
    return this.http.post(`/api/brands/${brandId}/smartphones`, request);
  }

  putSmartphone(phoneId: string, request: PhoneForm): Observable<any> {
    return this.http.put(`/api/smartphones/${phoneId}`, request);
  }

  deleteSmartphone(id: string): Observable<any> {
    return this.http.delete(`/api/smartphones/${id}`);
  }
}
