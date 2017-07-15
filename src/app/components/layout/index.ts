import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { MaterializeModule } from 'ng2-materialize';
import { Ng2CompleterModule } from "ng2-completer";

import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoadingIndicatorComponent } from '../../shared/components/loading-indicator/loading-indicator.component';
import { UserLocationComponent } from '../../shared/components/user-location/user-location.component';


@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    LoadingIndicatorComponent,
    UserLocationComponent
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    LoadingIndicatorComponent
  ],
  imports: [
    FormsModule,
    Ng2CompleterModule,
    MaterializeModule.forRoot(),
    RouterModule
  ],
  providers: [
    
  ]
})
export class LayoutModule {}
