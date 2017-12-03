import { EntryService } from './services/entry.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { EntryComponent } from './components/entry/entry.component';

import { HttpModule } from '@angular/http';
import { CommentComponent } from './components/comment/comment.component';
import { SidebarModule } from 'ng-sidebar';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    EntryComponent,
    CommentComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule,
    SidebarModule.forRoot(),
    FormsModule
  ],
  providers: [EntryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
