import {Component, OnInit} from '@angular/core';
import {Brands} from '../../model/brands';
import {BrandService} from '../../service/brand.service';
import {Brand} from '../../model/brand';

@Component({
  selector: 'app-brand-list',
  templateUrl: './brand-list.component.html',
  styleUrl: './brand-list.component.css'
})
export class BrandListComponent implements OnInit {
  brands: Brands | undefined;

  constructor(private service: BrandService) {
  }

  ngOnInit(): void {
    this.service.getBrands().subscribe(res => this.brands = res);
  }

  onDelete(brand: Brand): void {
    this.service.deleteBrand(brand.id).subscribe(() => this.ngOnInit());
  }
}
