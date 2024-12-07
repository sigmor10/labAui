import {Component, OnInit} from '@angular/core';
import {BrandDetails} from '../../model/brandDetails';
import {BrandService} from '../../service/brand.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Brand} from '../../model/brand';
import {SmartphoneService} from '../../../smartphone/service/smartphone.service';
import {Smartphones} from '../../../smartphone/model/smartphones';
import {Smartphone} from '../../../smartphone/model/smartphone';
import {Location} from '@angular/common';

@Component({
  selector: 'app-brand-view',
  templateUrl: './brand-view.component.html',
  styleUrl: './brand-view.component.css'
})
export class BrandViewComponent implements OnInit{
  brand: BrandDetails | undefined;
  phones: Smartphones | undefined;

  constructor(private service: BrandService, private phoneService: SmartphoneService,
              private route: ActivatedRoute, private router: Router, private location: Location) {
  }

  loadPhones(id: string): void {
    this.phoneService.getBrandSmartphones(id)
      .subscribe(res => this.phones = res);
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getBrand(params['brandId'])
        .subscribe(res => this.brand = res);
      this.loadPhones(params['brandId'])
    })
  }

  onDelete(brand: Brand): void {
    this.service.deleteBrand(brand.id).subscribe(() =>
    this.location.back());
  }

  onPhoneDelete(phone: Smartphone): void {
    let brandId = this.brand?.id
    if (brandId) {
      this.phoneService.deleteSmartphone(phone.id).subscribe(() =>
        this.loadPhones(brandId));
    }
  }
}
