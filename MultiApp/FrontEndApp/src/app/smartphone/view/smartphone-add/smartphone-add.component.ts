import {Component, OnInit} from '@angular/core';
import {PhoneForm} from '../../model/phoneForm';
import {SmartphoneService} from '../../service/smartphone.service';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-smartphone-add',
  templateUrl: './smartphone-add.component.html',
  styleUrl: './smartphone-add.component.css'
})
export class SmartphoneAddComponent implements OnInit {
  brandId: string | undefined;
  phoneForm: PhoneForm = {
    model: "model name",
    modelId: "base_number-178825",
    memory: 0
  };

  ogForm: PhoneForm = {...this.phoneForm};

  constructor(private service: SmartphoneService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.brandId = params['brandId'];
    });
  }

  onSubmit(): void {
    if (this.brandId !== undefined) {
      this.service.postSmartphone(this.brandId, this.phoneForm).subscribe(
        () => {
          this.location.back();
        }
      )
    } else {
      console.log("error adding");
      this.location.back();
    }
  }
}
