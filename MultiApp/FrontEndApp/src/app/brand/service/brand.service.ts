import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Brands} from '../model/brands';
import {BrandDetails} from '../model/brandDetails';
import {BrandForm} from '../model/brandForm';

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  constructor(private http: HttpClient) { }

  getBrands(): Observable<Brands> {
    return this.http.get<Brands>('/api/brands');
  }

  getBrand(id: String): Observable<BrandDetails> {
    return this.http.get<BrandDetails>(`/api/brands/${id}`);
  }

  postBrand(request: BrandForm): Observable<any> {
    return this.http.post<Brands>('/api/brands', request);
  }

  putBrand(id: string, request: BrandForm): Observable<any> {
    return this.http.put(`/api/brands/${id}`, request);
  }

  deleteBrand(id: String): Observable<any> {
    return this.http.delete(`/api/brands/${id}`)
  }
}
