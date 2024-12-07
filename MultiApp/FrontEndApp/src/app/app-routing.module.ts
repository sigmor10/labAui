import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {BrandListComponent} from './brand/view/brand-list/brand-list.component';
import {BrandViewComponent} from './brand/view/brand-view/brand-view.component';
import {BrandEditComponent} from './brand/view/brand-edit/brand-edit.component';
import {SmartphoneViewComponent} from './smartphone/view/smartphone-view/smartphone-view.component';
import {SmartphoneEditComponent} from './smartphone/view/smartphone-edit/smartphone-edit.component';
import {BrandAddComponent} from './brand/view/brand-add/brand-add.component';
import {SmartphoneAddComponent} from './smartphone/view/smartphone-add/smartphone-add.component';

const routes: Routes = [
  {
    path: 'brands',
    component: BrandListComponent,
  },
  {
    path: 'brands/add',
    component: BrandAddComponent,
  },
  {
    path: 'brands/:brandId',
    component: BrandViewComponent,
  },
  {
    path: 'brands/:brandId/edit',
    component: BrandEditComponent,
  },
  {
    path: 'brands/:brandId/smartphones/add',
    component: SmartphoneAddComponent,
  },
  {
    path: 'brands/:brandId/smartphones/:uuid',
    component: SmartphoneViewComponent,
  },
  {
    path: 'brands/:brandId/smartphones/:uuid/edit',
    component: SmartphoneEditComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
