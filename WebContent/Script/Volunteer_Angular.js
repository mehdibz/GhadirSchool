(function () {
'use strict';

var app=angular.module('RepostCheck',[]);
	app.controller('ReportController',["$scope","$http",ReportController]);

	
ReportController.$inject = ['$scope','$http'];
function ReportController($scope, $http) {

	var PasswIsOK=false;
	var CityIsOK=false;
	var PostalCodeIsOK=false;
	var PhoneIsOK=false;
	var RefNameIsOK=false;
	var RefPhoneIsOK=false;
	var EmailIsOK=false;
	var TermIsOK=false;
	var BirthDateIsOK=false;
	var BirthDayIsOK=false;
	var BirthMonthIsOK=false;
	var BirthYearIsOK=false;

	
	$scope.passCheck = function(){
    	if(($scope.user.Password)===($scope.user.RePass)){
        	if($scope.user.Password!=null){
        	 	if(($scope.user.Password).length < 5){
        	 		$scope.user.status= "Password too short!";
        	 		PasswIsOK=false;
        	 	}
        	 	else{
        	 		PasswIsOK=true;
        	 		$scope.user.status=null;
        	 	}
        	 }
    	}
    	else{
	 		$scope.user.status= "Passwords do not much!";
	 		PasswIsOK=false;
    	}
    }
   	$scope.cityCheck = function(){
      		 if($scope.user.City=="No"){
      			 
      			$scope.user.status= "Please choose the City!";
      			CityIsOK=false;
      		 }else{
      			CityIsOK=true;
      			$scope.user.status=null;
      		 }
   	}
    $scope.postalcodeCheck = function(){
    	
       	if($scope.user.PostalCode!=null){
       		if($scope.user.PostalCode.length != 6){
    			$scope.user.status= "Please correct the Postal Code!";
    			PostalCodeIsOK=false;
    		}
    		else{
    			PostalCodeIsOK=true;
    			$scope.user.status=null;
    		}
    	} 
    }	 
    $scope.PhoneCheck = function(){

    	 if($scope.user.Primary_Phone!=null){
    		 if(($scope.user.Primary_Phone).length != 10){
    			 $scope.user.status= "Phone # is invalid!";
    			 PhoneIsOK=false;
    		 }
    		 else{
    			 PhoneIsOK=true;
    			 $scope.user.status=null;
    		 }
    	 }
    }	 
    $scope.RefPhoneCheck = function(){
    	
    	if($scope.user.RefPhone!=null){
    		if(($scope.user.RefPhone).length != 10){
    			$scope.user.status= "Reference Phone # is invalid!";
    			RefPhoneIsOK=false;
    		}
    		else{
    			RefPhoneIsOK=true;
    			$scope.user.status=null;
    		}
    	}
    }	 
    $scope.RefNameCheck = function(){
    	
    	if($scope.user.RefName!=null){
    		if(($scope.user.RefName).length != 10){
    			$scope.user.status= "Reference Name # is invalid!";
    			RefNameIsOK=false;
    		}
    		else{
    			RefNameIsOK=true;
    			$scope.user.status=null;
    		}
    	}
    }	 
    $scope.TermCheck = function(){
    	if($scope.user.Term !=true){

    			$scope.user.status= "Please accept terms and conditions!";
    			TermIsOK=false;
    	}
    	else{
    			TermIsOK=true;
    			$scope.user.status=null;
    	}
    }
    
    $scope.birthDateCheck = function(){
   	 if($scope.user.DaysSelected=="Day"){
   		 	
   		 	$scope.user.status= "Day is invalid!";
   		 	BirthDayIsOK=false;
   	 }else{
   		 	BirthDayIsOK=true;
		 	$scope.user.status=null;
   	 }
   	 if($scope.user.MonthSelected=="Month"){
   		 
   		 $scope.user.status= "Month is invalid!";
   		 BirthMonthIsOK=false;
   	 }else{
   		 BirthMonthIsOK=true;
   		 $scope.user.status=null;
   	 }
   	 if($scope.user.YearSelected=="Year"){
   		 
   		 $scope.user.status= "Year is invalid!";
   		 BirthYearIsOK=false;
   	 }else{
   		BirthYearIsOK=true;
   		 $scope.user.status=null;
   	 }
   	if((BirthDayIsOK)&&(BirthMonthIsOK)&&(BirthYearIsOK)){
   		BirthDateIsOK=true;
   	}
   	else{
   		BirthDateIsOK=false;
   	}
   }

//=============================================================================	

  $scope.user = {};
  $scope.createUser = function() 
  {	
  	
     	if(($scope.user.Primary_Email.indexOf("@") !=-1)&&($scope.user.Primary_Email.indexOf(".") !=-1)) {
    		 $scope.user.status= null;
    		EmailIsOK=true;
     	} else {
    		 $scope.user.status= "Email address is invalid!";
    		 $scope.user.Primary_Email=null;
    		EmailIsOK=false;
     	}
     	
    if(((PhoneIsOK)&&(PasswIsOK)&&(BirthDateIsOK)&&(EmailIsOK)&&(PostalCodeIsOK)&&(CityIsOK)&&(TermIsOK)&&(RefPhoneIsOK)&&(RefNameIsOK))==true){
    	
    	$scope.user.ReSubPermission="false";
    	$scope.user.Result="";
    	
    	$http({
    	
    		method: 'POST',
    		url: 'VolunteerRegisterServlet',
    		headers: {'contentType':'application/x-www-form-urlencoded; charset=UTF-8'},
    		data: JSON.stringify($scope.user)

    	}).then(function (data) 
    			{
     			   			
    			console.log(data); 
   				if(data.data!="failed!")
   				{
   					if(data.data=="duplicate!"){
   						$scope.user.status="Invalid Email Address!";
       					$scope.user.Primary_Email=null;
       					
   					}else{

   						var parts = data.data.split("@");
   						var part1 = parts[0]; 
   						var part2 = parts[1]; 
   						var ret = part1 +"\r\n"+ part2;
   						
   						$scope.user.Result=ret;
   						$scope.user.status="Application Submitted!";
   						$scope.BirthdateStyle = {'background-color':'#a6ffa6'};
   						$scope.CityStyle = {'background-color':'#a6ffa6'};
   				    	$scope.isSubDisabled = true;
   				    	$scope.isDisabled=true;
   					}
   				}else{
   					$scope.user.status="Application failed!";
   				}
    			});

    }else{

    	if(PostalCodeIsOK==false){
    		$scope.user.status="Please correct the Postal Code!";
    		$scope.user.PostalCode=null;
    	}

    	if(CityIsOK==false){
    		$scope.user.status="Please choose the City!";
    		$scope.user.City="No";
    		$scope.CityStyle = {'animation':'1s blinker linear infinite',
					  			'-webkit-animation':'1s blinker linear infinite',
					  			'-moz-animation':'1s blinker linear infinite',
					  			'background-color':'#ffc1c8'};
    	}else{
    		$scope.CityStyle = {'background-color':'#a6ffa6'};
    	}
    		
    	if(PhoneIsOK==false){
    		$scope.user.status="Please correct the Phone # !";
    	    $scope.user.Primary_Phone=null;
    	}
    		
    	if(PasswIsOK==false){
    		$scope.user.status="Check your password!";
    		$scope.user.Password=null;
    		$scope.user.RePass=null;
    	}
    		
    	if(BirthDateIsOK==false){
    		$scope.user.status="Please correct the date of birth!";

    		$scope.BirthdateStyle = {'animation':'1s blinker linear infinite',
    						  '-webkit-animation':'1s blinker linear infinite',
		    				  '-moz-animation':'1s blinker linear infinite',
    						  'background-color':'#ffc1c8'};

    	}
    	else{
    	   	$scope.BirthdateStyle = {'background-color':'#a6ffa6'};
    	}
    	if(TermIsOK==false){
    		$scope.user.status="Please accept terms and conditions!";
    	}
    	$scope.isSubDisabled = false;
    	$scope.isDisabled=false;
    }
   };			
//=================================================================================
   $scope.SubmitEnable = function() {
		  
	   $scope.user.ReSubPermission="OK";

	    $http({
	        method: 'POST',
	        url: 'VolunteerRegisterServlet',
	        headers: {'contentType':'application/x-www-form-urlencoded; charset=UTF-8'},
	        data: JSON.stringify($scope.user)
	      }).then(function (data) 
	        {
	      			//$scope.user.Result=data;
	        });  
	    $scope.Reset();
	    $scope.isDisabled=false;		
	    $scope.isSubDisabled = false; 		
   } 
 //==================================================================================
   $scope.Reset = function() {
	   $scope.user.Result=null;
	   $scope.user.Name=null;
	   $scope.user.Family=null;
	   $scope.user.MonthSelected="Month";
	   $scope.user.DaysSelected="Day";
	   $scope.user.YearSelected="Year";
	   $scope.user.City="No";
	   $scope.user.PostalCode=null;
	   $scope.user.Primary_Email=null;
	   $scope.user.Primary_Phone=null;
	   $scope.user.Address=null;
	   $scope.user.Password=null;
	   $scope.user.RePass=null;
	   $scope.user.Details=null;
	   $scope.user.Resume=null;
	   $scope.user.sex="male";
	   $scope.user.status=null;
	   $scope.user.Term=null;
	   EmailIsOK=false;
	   BirthDateIsOK=false;
	   BirthDayIsOK=false;
	   BirthMonthIsOK=false;
	   BirthYearIsOK=false;
	   CityIsOK=false;
	   TermIsOK=false;
	   $scope.BirthdateStyle = {'background-color':'#ffffff'};
	   $scope.CityStyle = {'background-color':'#ffffff'};
   }	

	$scope.isDisabled=true;
	$scope.isSubDisabled = true;	
}  


var compareTo = function() {
	   return {
	     require: "ngModel",
	     scope: {
	       otherModelValue: "=compareTo"
	     },
	     link: function(scope, element, attributes, ngModel) {

	       ngModel.$validators.compareTo = function(modelValue) {
	         return modelValue == scope.otherModelValue;
	       };

	       scope.$watch("otherModelValue", function() {
	         ngModel.$validate();
	       });
	     }
	   };
	 };

var validNumber = function(){
		 return {
	     require: 'ngModel',
	     link: function(scope, element, attrs, ngModelCtrl) {
	       if(!ngModelCtrl) {
	         return; 
	       }
	       
	       ngModelCtrl.$parsers.push(function(val) {
	         var clean = val.replace( /[^0-9]+/g, '');
	         if (val !== clean) {
	           ngModelCtrl.$setViewValue(clean);
	           ngModelCtrl.$render();
	         }
	         return clean;
	       });
	       
	       element.bind('keypress', function(event) {
	         if(event.keyCode === 32) {
	           event.preventDefault();
	         }
	       });
	     }
	   };
	 };	 
	 
app.directive('compareTo', compareTo);
app.directive('validNumber', validNumber);
		
})();
