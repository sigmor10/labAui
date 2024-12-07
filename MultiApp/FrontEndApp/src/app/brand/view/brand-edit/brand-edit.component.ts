import {Component, OnInit} from '@angular/core';
import {BrandForm} from '../../model/brandForm';
import {BrandService} from '../../service/brand.service';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-brand-edit',
  templateUrl: './brand-edit.component.html',
  styleUrl: './brand-edit.component.css'
})
export class BrandEditComponent implements OnInit{
  id: string | undefined;
  ogForm: BrandForm | undefined;
  brandForm: BrandForm | undefined;

  constructor(private service: BrandService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['brandId'];
      this.service.getBrand(params['brandId']).subscribe( brand => {
        this.ogForm = {
          name: brand.name,
          foundingYear: brand.foundingYear,
          rating: brand.rating
        };
        this.brandForm = {...this.ogForm};
      })
    })
  }

  onSubmit(): void{
    this.service.putBrand(this.id!, this.brandForm!).subscribe(()=> this.location.back());
  }

  onCancel(): void{
    this.location.back();
  }
}
