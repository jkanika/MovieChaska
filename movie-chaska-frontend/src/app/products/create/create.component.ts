import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { ApiService } from 'src/app/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  public movieForm :FormGroup;
  submitted: boolean;

  // DI -> by adding properties in constrctor.
  constructor(private formBuilder:FormBuilder, private apiService:ApiService,private router :Router) { }

  ngOnInit(): void {

    this.movieForm = this.formBuilder.group({
      movName : ['',Validators.required],
      movDesc :['',Validators.required],
      movRel :['',Validators.required],
      movPrice :['',Validators.required],
    });

  }

  public hasError(field:any){
    return (this.movieForm.get(field).invalid && this.movieForm.get(field).touched 
    && this.movieForm.get(field).errors);
  }

  public submitForm(form:any){
    // console.log(form);
    if(form.valid) {
      this.submitted  = true;
      //console.log("Submitted");
      // if product is valid 
      alert("Product Created..!")
      this.apiService.createProduct(this.movieForm.value).subscribe(res=>{
        this.router.navigateByUrl('/products');
    });

  }else{
      this.validateForm(form);
    }
    // console.log(this.productForm.value);
  }

  validateForm(form:any){
    Object.keys(form.controls).forEach(field=>{
      const control = form.get(field);
      if( control instanceof FormControl){
        control.markAsTouched({ onlySelf : true })
      } else{
        this.validateForm(control);
      }
    })
  }

  get movName() { return this.movieForm.get('movName')}
  get movDesc() { return this.movieForm.get('movDesc')}
  get movRel() { return this.movieForm.get('movRel')}
  get movPrice() { return this.movieForm.get('movPrice')}

}