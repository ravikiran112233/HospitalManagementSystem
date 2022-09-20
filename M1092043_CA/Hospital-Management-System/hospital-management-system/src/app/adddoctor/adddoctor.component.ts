import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HospitalserviceService } from '../hospitalservice.service';
import { IDoctor } from '../model/iDoctor';


@Component({
  selector: 'app-adddoctor',
  templateUrl: './adddoctor.component.html',
  styleUrls: ['./adddoctor.component.css']
})
export class AdddoctorComponent implements OnInit {

  public doctor:IDoctor = {} as IDoctor;
  constructor(private service:HospitalserviceService,private router:Router) { }

  ngOnInit(): void {
  }
  saveDoctor(){
    this.service.AddDoctor(this.doctor).subscribe({
      next: (data) => {
        alert("Doctor is added to the hospital database");
        this.router.navigate(['/']).then();
      },
      error: (e) => {
        this.router.navigate(['/doctors/doctor/add']).then();
        alert("Error ! Sorry try again..");
      }
    })
  }
 
}
