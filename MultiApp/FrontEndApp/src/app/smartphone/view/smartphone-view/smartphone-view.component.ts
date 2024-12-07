import {Component, OnInit} from '@angular/core';
import {SmartphoneService} from '../../service/smartphone.service';
import {SmartphoneDetails} from '../../model/smartphoneDetails';
import {ActivatedRoute, Router} from '@angular/router';
import {BrandDetails} from '../../../brand/model/brandDetails';
import {BrandService} from '../../../brand/service/brand.service';

@Component({
  selector: 'app-smartphone-view',
  templateUrl: './smartphone-view.component.html',
  styleUrl: './smartphone-view.component.css'
})
export class SmartphoneViewComponent implements OnInit {
  phone: SmartphoneDetails | undefined;
  brand: BrandDetails | undefined;

  constructor(private service: SmartphoneService,
              private brandService: BrandService,
              private route: ActivatedRoute,
              private router: Router) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getSmartphoneDetails(params['uuid']).subscribe(res => this.phone = res);
      this.brandService.getBrand(params['brandId']).subscribe(res => this.brand = res);
    })
  }

  onDelete(smartphone: SmartphoneDetails): void {
    this.service.deleteSmartphone(smartphone.id).subscribe(() =>
      this.router.navigate(['/brands/' + this.brand?.id!]));
  }
}
