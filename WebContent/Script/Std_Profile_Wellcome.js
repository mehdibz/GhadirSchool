(function () {
'use strict';

var app=angular.module('RepostCheck',[]);
	app.controller('ReportController',["$scope","$http", "$templateCache",ReportController]);

	
ReportController.$inject = ['$scope','$http'];
function ReportController($scope, $http,$templateCache) {
	
	var PasswIsOK=false;
	var CareCdNumIsOK=false;
	var CityIsOK=false;
	var PostalCodeIsOK=false;
	var FarsiGradeIsOK=false;
	var PhoneIsOK=false;
	var EmergencyIsOK=false;
	var EmailIsOK=false;
	var TermIsOK=false;
	var BirthDateIsOK=false;
	var BirthDayIsOK=false;
	var BirthMonthIsOK=false;
	var BirthYearIsOK=false;


		

	/*
    
    	$http({
    			//'loginbean.jsp.json'
    	
    	//	headers: {'Content-Type': 'application/json'},
    	//	data:  $scope.user
    		method: 'POST',
    		url: 'StudentProfileServlet',
    	//	cache: $templateCache,
    		headers: {'contentType':'application/x-www-form-urlencoded; charset=UTF-8'},
    		data: JSON.stringify($scope.user)
    	//	data:  $scope.user 
    	}).then(function (response) 
    			{
   						var parts = response.data.split("@");
    					$scope.obj =response.data;
   						var parts = response.data;
   						var part1 = parts[0]; 
   						var part2 = parts[1]; 
   					//	var ret = part1 +"\r\n"+ part2;
   						
   					//	console.log("Hello = "+ part1 + " - " + part2 + " @@@@@ " + response.id);
   						console.log("Hello = " + response.data + " @@@@@ " + parts + "@@@@" +"###" + part2);
   						
   					//	$scope.user.Result=ret;
   						$scope.user.status="Application Submitted!";
   						$scope.BirthdateStyle = {'background-color':'#a6ffa6'};
   						$scope.FarsiGradeStyle = {'background-color':'#a6ffa6'};
   						$scope.CityStyle = {'background-color':'#a6ffa6'};
   				    	$scope.isSubDisabled = true;
   				    	$scope.isDisabled=true;

    			});
	
	
	
	*/
	
	
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

 // $scope.user = {};
  $scope.createUser = function() 
  {	
  	
	  console.log("Hello befor data ");
    	$scope.user.ReSubPermission="false";
    	$scope.user.Result="";
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
/*
app.directive('directiveName', function(){
    return {
        restrict:'E',
        scope: {
           parameter:'@'
        },
  //      template:'<div>parameter:{{parameter}}objID:{{obj.ID}}ObjNAME:{{obj.Name}}</div>',
        template:'{{parameter}}',
        controller: function($scope) {
     //     $scope.obj = JSON.parse($scope.parameter);
        }
      };
    }); */
		
})();

/*
$scope.obj = {
        ID: '110110',
        Name: 'Mehdi'
      };

*/