import {Component, OnInit} from '@angular/core';
import {PhoneForm} from '../../model/phoneForm';

import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import {SmartphoneService} from '../../service/smartphone.service';

@Component({
  selector: 'app-smartphone-edit',
  templateUrl: './smartphone-edit.component.html',
  styleUrl: './smartphone-edit.component.css'
})
export class SmartphoneEditComponent implements OnInit {
  phoneId: string | undefined;
  ogForm: PhoneForm | undefined;
  phoneForm: PhoneForm | undefined;

  constructor(private service: SmartphoneService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.phoneId = params['uuid'];
      this.service.getSmartphoneDetails(params['uuid']).subscribe(res =>{
        this.ogForm = {
          model: res.model,
          modelId: res.modelId,
          memory: res.memory
        };
        this.phoneForm = {...this.ogForm};
      })
    })
  }

  onSubmit(): void {
    this.service.putSmartphone(this.phoneId!, this.phoneForm!).subscribe(()=> this.location.back());
  }

  onCancel(): void{
    this.location.back();
  }
}
