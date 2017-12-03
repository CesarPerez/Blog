import { Component, OnInit } from '@angular/core';
import { Entry } from '../../models/entry';
import { EntryService } from '../../services/entry.service';

@Component({
  selector: 'app-entry',
  templateUrl: './entry.component.html',
  styleUrls: ['./entry.component.css']
})
export class EntryComponent implements OnInit {

  private entries: Entry[];
  private newEntry: Boolean = false;
  private tempEntry: Entry = {} as Entry;

  constructor(private entryService: EntryService) { 
  }

  private loadEntries(){
    this.entryService.getEntries().subscribe((res:Entry[]) => {
      this.entries = res;
    });
  }
  
  private clearModel(){
    this.tempEntry.text = '';
    this.tempEntry.title = '';
  }

  ngOnInit() {
    this.loadEntries();
  }

  toogleNewEntry(){
     this.newEntry = !this.newEntry;
     this.clearModel();
  }

  saveEntry(){
    this.entryService.saveEntry(this.tempEntry).subscribe(() => {
       this.entries.push(this.tempEntry);
       this.toogleNewEntry();
       this.loadEntries();
    });
  }

}
