import {Component} from '@angular/core';
import {BrandService} from '../../service/brand.service';
import {Router} from '@angular/router';
import {BrandForm} from '../../model/brandForm';

@Component({
  selector: 'app-brand-add',
  templateUrl: './brand-add.component.html',
  styleUrl: './brand-add.component.css'
})
export class BrandAddComponent {
  brandForm: BrandForm = {
    name: "name",
    rating: 0.0,
    foundingYear:2000
  };

  ogForm: BrandForm = {...this.brandForm};

  constructor(private service: BrandService, private router: Router) {
  }

  onSubmit(): void {
    this.service.postBrand(this.brandForm).subscribe(() => this.router.navigate(['/brands']));
  }
}
