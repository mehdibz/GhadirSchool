(function () {
'use strict';

var app=angular.module('RepostCheck',[]);
	app.controller('ReportController',["$scope","$http",ReportController]);

	
ReportController.$inject = ['$scope','$http'];
function ReportController($scope, $http) {

	var PasswIsOK=false;
	var CareCdNumIsOK=false;
	var CityIsOK=false;
	var PostalCodeIsOK=false;
	var FarsiGradeIsOK=false;
	var PhoneIsOK=false;
	var EmergencyIsOK=false;
	var NameIsOK=false;
	var FamilyIsOK=false;
	var EmailIsOK=false;
	var TermIsOK=false;
	var BirthDateIsOK=false;
	var BirthDayIsOK=false;
	var BirthMonthIsOK=false;
	var BirthYearIsOK=false;

	var parts;
	var part1; 
	var part2;
	
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
    $scope.carecardCheck = function(){

    	 if($scope.user.CareCardNo!=null){
    			if(($scope.user.CareCardNo).length != 10){
    				$scope.user.status= "Care card # is invalid!";
    				CareCdNumIsOK=false;
    			}
    			else{
    				CareCdNumIsOK=true;
    				$scope.user.status=null;
    			}
    		 }
    }	 
    $scope.FarsiGradeCheck = function(){
      	 if($scope.user.FarsiGrade=="---"){
      		 	
      		 	$scope.user.status= "Please select the Farsi Grade!";
      		 	FarsiGradeIsOK=false;
      	 }else{
      		 	FarsiGradeIsOK=true;
   		 	$scope.user.status=null;
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
    		//temp2.replace(/ /g,"");
    	
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
    $scope.phoneCheck = function(){

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
    $scope.emergencyCheck = function(){
    	 if($scope.user.Emergency_Phone!=null){
    		 	if(($scope.user.Emergency_Phone).length != 10){
    		 		$scope.user.status= "Emergency # is invalid!";
    		 		EmergencyIsOK=false;
    		 	}
    		 	else{
    		 		EmergencyIsOK=true;
    		 		$scope.user.status=null;
    		 	}
    	 }
    }
    $scope.FamilyCheck = function(){
    	if($scope.user.Family!=null){
    		if(($scope.user.Family).length < 2){
    			$scope.user.status= "Last Name is invalid!";
    			FamilyIsOK=false;
    		}
    		else{
    			FamilyIsOK=true;
    			$scope.user.status=null;
    		}
    	}
    }
    $scope.NameCheck = function(){
    	if($scope.user.Name!=null){
    		if(($scope.user.Name).length < 2){
    			$scope.user.status= "First Name is invalid!";
    			NameIsOK=false;
    		}
    		else{
    			NameIsOK=true;
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
     	
    if(((CareCdNumIsOK)&&(PhoneIsOK)&&(EmergencyIsOK)&&(FamilyIsOK)&&(NameIsOK)&&(PasswIsOK)&&(BirthDateIsOK)&&(EmailIsOK)&&(PostalCodeIsOK)&&(CityIsOK)&&(FarsiGradeIsOK)&&(TermIsOK))==true){
    	
    	$scope.user.ReSubPermission="false";
    	$scope.user.Result="";
    	
    	$http({
    	
    	//	headers: {'Content-Type': 'application/json'},
    	//	data:  $scope.user
    		method: 'POST',
    	//	url: 'http://localhost:8080/ghadirschool/StudentRegisterServlet',
    	//	url: 'http://ghadirschool.com:8080/ghadirschool/StudentRegisterServlet',
    		url: 'StudentRegisterServlet',
    		headers: {'contentType':'application/x-www-form-urlencoded; charset=UTF-8'},
    		data: JSON.stringify($scope.user)
    	//	data:  $scope.user
    	}).then(function (data) 
    			{
     			   			
    		//	console.log(data); 
   				if(data.data!="failed!")
   				{
   					if(data.data!=null){
   						var parts = data.data.split("@");
   						var part1 = parts[0]; 
   						var part2 = parts[1];
   					}
   					if(part1=="duplicate!"){
   						//$scope.user.status="Invalid CareCard Number!";
   						$scope.Reset();
   						$scope.user.status="The student already registered with student ID " + part2 + " !!";
       					//$scope.user.CareCardNo=null;
       					
   					}else{

   						var parts = data.data.split("@");
   						var part1 = parts[0]; 
   						var part2 = parts[1]; 
   						var ret = part1 +"\r\n"+ part2;
   						
   						$scope.user.Result=ret;
   						$scope.user.status="Application Submitted!";
   						$scope.BirthdateStyle = {'background-color':'#a6ffa6'};
   						$scope.FarsiGradeStyle = {'background-color':'#a6ffa6'};
   						$scope.CityStyle = {'background-color':'#a6ffa6'};
   				    	$scope.isSubDisabled = true;
   				    	$scope.isDisabled=true;
   					}
   				}else{
   					$scope.user.status="Application failed!";
   				}
    			});

    }else{
    	if(CareCdNumIsOK==false){
    		$scope.user.status="Please correct the Care card #!";
    		$scope.user.CareCardNo=null;
    	}
    	if(PostalCodeIsOK==false){
    		$scope.user.status="Please correct the Postal Code!";
    		$scope.user.PostalCode=null;
    	}
    	if(FarsiGradeIsOK==false){
    		$scope.user.status="Please choose the Farsi Grade!";
    		$scope.user.FarsiGrade="---";
    		$scope.FarsiGradeStyle = {'animation':'1s blinker linear infinite',
		  						'-webkit-animation':'1s blinker linear infinite',
		  						'-moz-animation':'1s blinker linear infinite',
		  						'background-color':'#ffc1c8'};
    	}else{
    		$scope.FarsiGradeStyle = {'background-color':'#a6ffa6'};
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
    		
    	if(EmergencyIsOK==false){
    		$scope.user.status="Please correct the Emergency #!";
    		$scope.user.Emergency_Phone=null;
    	}
    	if(FamilyIsOK==false){
    		$scope.user.status="Please correct the Family!";
    		$scope.user.Family=null;
    	}
    	if(NameIsOK==false){
    		$scope.user.status="Please correct the Name!";
    		$scope.user.Name=null;
    	}
    	
   	
    	if(BirthDateIsOK==false){
    		$scope.user.status="Please correct the date of birth!";
    		//$scope.ng-style = "myStyle";
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
	        url: 'StudentRegisterServlet',
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
	   $scope.user.CareCardNo=null;
	   $scope.user.City="No";
	   $scope.user.FarsiGrade="---";
	   $scope.user.PostalCode=null;
	   $scope.user.Primary_Email=null;
	   $scope.user.Primary_Phone=null;
	   $scope.user.Emergency_Phone=null;
	   $scope.user.Restriction="No";
	   $scope.user.Address=null;
	   $scope.user.Password=null;
	   $scope.user.RePass=null;
	   $scope.user.Details=null;
	   $scope.user.sex="male";
	   $scope.user.status=null;
	   $scope.user.Term=null;
	   EmailIsOK=false;
	   BirthDateIsOK=false;
	   BirthDayIsOK=false;
	   BirthMonthIsOK=false;
	   BirthYearIsOK=false;
	   FarsiGradeIsOK=false;
	   CityIsOK=false;
	   TermIsOK=false;
	   $scope.BirthdateStyle = {'background-color':'#ffffff'};
	   $scope.FarsiGradeStyle = {'background-color':'#ffffff'};
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


//============================================================================================================
/*	self.user.status=self.user;
switch (self) {

	case self.user.CareCardNo:
		self.user.status="Selected Case Number is 1";
		break;
		
	case self.user.Primary_Phone:
		alert("Selected Case Number is 2");
		break;
		
	case self.user.Emergency_Phone:
		alert("Selected Case Number is 2");
		break;
		
	case self.user.Password:
		alert("Selected Case Number is 2");
		break;
	default:
}

==========================================================

	var model = this;
	  model.message = "";

	  model.user = {
	    username: "",
	    password: "",
	    confirmPassword: ""
	  }; 

   model.submit = function(isValid) {
	    console.log("h");
	    if (isValid) {
	      model.message = "Submitted " + model.user.username;
	    } else {
	      model.message = "There are still invalid fields below";
	    }
	  };	

*/	
