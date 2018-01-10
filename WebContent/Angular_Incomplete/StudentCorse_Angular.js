(function () {
'use strict';

var app=angular.module('StdCourse',[]);
	app.controller('StdCourseController',["$scope","$http",StdCourseController]);

	
StdCourseController.$inject = ['$scope','$http'];
function StdCourseController($scope, $http) {

	var CareCdNumIsOK=false;
	var CityIsOK=false;
	var FarsiGradeIsOK=false;
	var TermIsOK=false;

	var parts;
	var part1; 
	var part2;
	
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
 
//=============================================================================	

  $scope.user = {};
  $scope.CourseEdit = function() 
  {	
  	
    if(((CareCdNumIsOK)&&(CityIsOK)&&(FarsiGradeIsOK)&&(TermIsOK))==true){
    	
    	$scope.user.ReSubPermission="false";
    	$scope.user.Result="";
    	
    	$http({
    	
    	//	headers: {'Content-Type': 'application/json'},
    	//	data:  $scope.user
    		method: 'POST',
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
	   $scope.user.CareCardNo=null;
	   $scope.user.City="No";
	   $scope.user.FarsiGrade="---";
	   $scope.user.Details=null;
	   $scope.user.status=null;
	   $scope.user.Term=null;
	   FarsiGradeIsOK=false;
	   CityIsOK=false;
	   TermIsOK=false;
	   $scope.FarsiGradeStyle = {'background-color':'#ffffff'};
	   $scope.CityStyle = {'background-color':'#ffffff'};
   }	


	$scope.isDisabled=true;
	$scope.isSubDisabled = true;	
}  

})()
