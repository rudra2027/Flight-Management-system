import { Component, HostListener, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderServiceService } from '../_service/order-service.service';
import { TokenStorageService } from '../_service/token-storage.service';

declare var Razorpay: any;
@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
form: any = {}; 
    paymentId?: any;
    error?: any;
   username?:any;
   amount?:any;
   
    constructor(private orderService: OrderServiceService,private tokenStorageService:TokenStorageService,private route:ActivatedRoute,private router:Router ) {
 
    }
  ngOnInit(): void {
   
  
    this.route.paramMap.subscribe((params)=>{this.amount=params.get('amount')!});
    console.log(this.amount);
    this.route.paramMap.subscribe((params)=>{this.username=params.get('userId')!});
    console.log(this.username);
    this.form.amount=this.amount;
    this.form.name=this.username;

  }
 
    options = {
    "key": "",
    "amount": this.amount, 
    "name": "Adarsh Gour",
    "description": "FlightBuzz",
    "image": "",
    "order_id":"",
    "handler": function (response:any){
        var event = new CustomEvent("payment.success", 
            {
                detail: response,
                bubbles: true,
                cancelable: true
            }
        );    
        window.dispatchEvent(event);
    }
    ,
    "prefill": {
    "name": this.username,
    "email": "",
    "contact": "",
    "amount":this.amount
    },
    "notes": {
    "address": ""
    },
    "theme": {
    "color": "#3399cc"
    }
    };
 
    onSubmit(): void {
      
        this.paymentId = ''; 
        this.error = ''; 
        this.orderService.createOrder(this.form).subscribe(
          (        data: { secretKey: string; razorpayOrderId: string; applicationFee: string; }) => {
            this.options.key = data.secretKey;
            this.options.order_id = data.razorpayOrderId;
            this.options.amount = this.form.amount; //paise
            this.options.prefill.name = this.form.name;
            this.options.prefill.email = this.form.email;
            this.options.prefill.contact = this.form.phone;
            var rzp1 = new Razorpay(this.options);
            rzp1.open();
                       
            rzp1.on('payment.failed',  (response: { error: { code: any; description: any; source: any; step: any; reason: any; metadata: { order_id: any; payment_id: any; }; }; }) =>{    
                // Todo - store this information in the server
                console.log(response.error.code);    
                console.log(response.error.description);    
                console.log(response.error.source);    
                console.log(response.error.step);    
                console.log(response.error.reason);    
                console.log(response.error.metadata.order_id);    
                console.log(response.error.metadata.payment_id);
                this.error = response.error.reason;
            }
            );
        }
        ,
          (        err: { error: { message: any; }; }) => {
            this.error = err.error.message;
        }
        );
    }
 
    @HostListener('window:payment.success', ['$event']) 
    onPaymentSuccess(event: { detail: any; }): void {
        this.orderService.updateOrder(event.detail).subscribe(
          (        data: { message: any; }) => {
            this.paymentId = data.message;
          
        }
        ,
          (        err: { error: { message: any; }; }) => {
            this.error = err.error.message;
        }
        );
    }
}
