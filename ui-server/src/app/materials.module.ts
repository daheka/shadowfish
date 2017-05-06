import {
  MdIconModule, MdInputModule, MdButtonModule,
  MdCheckboxModule, MdMenuModule, MdToolbarModule,
  MdSelectModule, MdCardModule, MdRadioModule, MdListModule, MdTabsModule, MdGridListModule
} from '@angular/material';
import {NgModule} from '@angular/core';

@NgModule({
  imports: [
    MdButtonModule,
    MdCheckboxModule,
    MdMenuModule,
    MdToolbarModule,
    MdIconModule,
    MdInputModule,
    MdSelectModule,
    MdCardModule,
    MdRadioModule,
    MdListModule,
    MdTabsModule,
    MdGridListModule,
  ],
  exports: [
    MdButtonModule,
    MdCheckboxModule,
    MdMenuModule,
    MdToolbarModule,
    MdIconModule,
    MdInputModule,
    MdSelectModule,
    MdCardModule,
    MdRadioModule,
    MdListModule,
    MdTabsModule,
    MdGridListModule,
  ],
})
export class MaterialsModule { }
