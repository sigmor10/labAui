import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { BrandListComponent } from './brand/view/brand-list/brand-list.component';
import { BrandViewComponent } from './brand/view/brand-view/brand-view.component';
import { BrandEditComponent } from './brand/view/brand-edit/brand-edit.component';
import {provideHttpClient} from '@angular/common/http';
import { SmartphoneViewComponent } from './smartphone/view/smartphone-view/smartphone-view.component';
import { SmartphoneEditComponent } from './smartphone/view/smartphone-edit/smartphone-edit.component';
import {FormsModule} from '@angular/forms';
import { BrandAddComponent } from './brand/view/brand-add/brand-add.component';
import { SmartphoneAddComponent } from './smartphone/view/smartphone-add/smartphone-add.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    BrandListComponent,
    BrandViewComponent,
    BrandEditComponent,
    SmartphoneViewComponent,
    SmartphoneEditComponent,
    BrandAddComponent,
    SmartphoneAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    provideHttpClient()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
