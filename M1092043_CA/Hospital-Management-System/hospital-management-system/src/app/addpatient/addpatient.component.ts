import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HospitalserviceService } from '../hospitalservice.service';
import { IDoctor } from '../model/iDoctor';
import { IPatient } from '../model/iPatient';

@Component({
  selector: 'app-addpatient',
  templateUrl: './addpatient.component.html',
  styleUrls: ['./addpatient.component.css']
})
export class AddpatientComponent implements OnInit {

  public patient:IPatient ={} as IPatient;
  public doctors:IDoctor[] = {} as IDoctor[];
  public errorMessage:string | null = null;

  constructor(private service:HospitalserviceService , private router : Router) { }

  ngOnInit(): void {
    this.service.getAllDoctors().subscribe({
      next:(data) =>{
        this.doctors = data;
      }
    })
  }
  savePatient(){
    this.service.AddPatient(this.patient).subscribe({
      next:(data)=>{
        alert("Patient Added to the database")
        this.router.navigate(['/']).then();
      },
      error:(e)=>{
        this.errorMessage = e;
        console.warn(e);
        alert("Invalid Information")
        this.router.navigate(['/patients/patient/add']).then();
      }
    });
  }

}
