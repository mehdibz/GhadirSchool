
// Fill select option Value from Array
/*
	//document.addEventListener('touchstart', onTouchStart, {passive: true});
	addEventListener(document, "touchstart", function(e) {
    console.log(e.defaultPrevented);  // will be false
    e.preventDefault();   // does nothing since the listener is passive
    console.log(e.defaultPrevented);  // still false
  }); */
//===================================================================

		function goBack() {
			window.history.back();
		}
		function logout() {
		    location.replace("../logout.jsp")
		}
		function Alert(){
        	document.getElementById('logMsg').style.display = 'inline-table';
        	//document.getElementById('CurrentDate').value = '';
		}
		function Print(){
		     var printContents = document.getElementById('print').innerHTML;
		     var originalContents = document.body.innerHTML;

		     document.body.innerHTML = printContents;
		     window.print();
		     document.body.innerHTML = originalContents;
		}
		function textCounter(field,field2,maxlimit)
		{
		 var countfield = document.getElementById(field2);
		 if ( field.value.length > maxlimit ) {
		  field.value = field.value.substring( 0, maxlimit );
		  return false;
		 } else {
		  countfield.value = maxlimit - field.value.length;
		   document.getElementById('count').value="کاراکتر باقی مانده = "+countfield.value;
		 }
		}
		function del_Tbl() {
        	var csName = document.getElementById('view_combo_MainCourse').value;
        	var table = document.getElementById('csName');
        	var rowCount = table.rows.length;
        	
        	while(rowCount>0)
        		{
        			document.getElementById(csName).deleteRow(rowCount - 1);
        			rowCount--;
        		}
            
        }
		function pageload1(){
        	document.getElementById('Farsi_div').style.display = 'none';
        	document.getElementById('total_score_div').style.display = 'none';
        	document.getElementById('description1').style.display = 'none';
        	document.getElementById('description2').style.display = 'none';
        	document.getElementById('description3').style.display = 'none';
        	document.getElementById('description4').style.display = 'none';
        	document.getElementById('count').style.display = 'none';
        	document.getElementById('view_combo_stdName').value = '-';
        	document.getElementById('view_combo_MainCourse').value = '-';
        	document.getElementById('isvalid').value = '';
		}
		function profileForm(obj){
	/*		if(obj==null){
				document.getElementById('swap2').style.display = 'none';
				document.getElementById('swap1').style.display = 'block';
			}else{
				document.getElementById('swap1').style.display = 'none';
				document.getElementById('swap2').style.display = 'block';
			}
		*/	
		}
		function show_sub_farsi(){
        	var course_name=document.getElementById('view_combo_MainCourse').value;
        	
        	document.getElementById('count').style.display = 'inline-table';		
        	if(course_name=="-")
        	{
        		document.getElementById('total_score_div').style.display = 'none';
        	}else
        	{
        		document.getElementById('total_score_div').style.display = 'inline-table';
        	}
        	
        	if(course_name=="Farsi")
        		{
        			document.getElementById('Farsi_div').style.display = 'inline-table';
        		}
        	else
        		{
        			document.getElementById('Farsi_div').style.display = 'none';
        		}
        	
        	document.getElementById('description1').style.display = 'none';
			document.getElementById('description2').style.display = 'none';
			document.getElementById('description3').style.display = 'none';
			document.getElementById('description4').style.display = 'none';			
			switch(course_name){
	        case "Farsi": 	  	document.getElementById('description1').style.display = 'inline-table';
	        					document.getElementById('description2').style.display = 'none';
	        					document.getElementById('description3').style.display = 'none';
	        					document.getElementById('description4').style.display = 'none';
	        					document.getElementById('Farsi_div').style.display = 'inline-table';
        						
	        break;

	        case "Religion":  	
								document.getElementById('description2').style.display = 'inline-table';
	        					document.getElementById('description1').style.display = 'none';
	        					document.getElementById('description3').style.display = 'none';
	        					document.getElementById('description4').style.display = 'none';
								document.getElementById('Farsi_div').style.display = 'none';
	        break;
	        
	        case "Quran": 	  	
								document.getElementById('description3').style.display = 'inline-table';
	        					document.getElementById('description1').style.display = 'none';
	        					document.getElementById('description2').style.display = 'none';
	        					document.getElementById('description4').style.display = 'none';
								document.getElementById('Farsi_div').style.display = 'none';
	        break;
	        
	        case "Salat": 	  	
								document.getElementById('description4').style.display = 'inline-table';
								document.getElementById('description1').style.display = 'none';
	        					document.getElementById('description2').style.display = 'none';
	        					document.getElementById('description3').style.display = 'none';
	        					document.getElementById('Farsi_div').style.display = 'none';
	        break;

	        
	        default:  			pageload1();
			}
            //style.backgroundImage="url("+previewPic.src+")";
            //document.getElementById('image').innerHTML=previewPic.alt;
    	}
		
		//=================Clock===================================================================================
		//=========================================================================================================
		
		var alternate=0
		var standardbrowser=!document.all&&!document.getElementById
		
		if (standardbrowser)
		document.write('<form name="tick"><input type="text" name="tock" size="1"></form>')
		
		function show(){
			if (!standardbrowser)
				//var clockobj=document.getElementById? document.getElementById("digitalclock") : document.all.digitalclock
				var clockobj= document.getElementById("digitalclock") 
				var Dateobj= document.getElementById("TotalCurrentDate") 
				var Digital=new Date()
				var hours=Digital.getHours()
				var minutes=Digital.getMinutes()
				var day=Digital.getDay()
				var month=Digital.getMonth()
				var year=Digital.getYear()
				var dn="AM"
				
				

			if (year < 1000)
				year+=1900

			var daym=Digital.getDate()
				if (daym<10)
					daym="0"+daym
			var dayarray=new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday");
			var montharray=new Array("January","February","March","April","May","June","July","August","September","October","November","December");
			var TotalCurrentDate=dayarray[day]+" <br> "+montharray[month]+" "+daym+", "+year;
			var OnlyCurrentYear=year;
					
					if (hours==12) dn="PM" 
						if (hours>12){
							dn="PM"
								hours=hours-12
						}
				if (hours==0) hours=12
				if (hours.toString().length==1)
					hours="0"+hours
					if (minutes<=9)
						minutes="0"+minutes
						
						if (standardbrowser){
							if (alternate==0)
								document.tick.tock.value=hours+" : "+minutes+" "+dn
							else
									document.tick.tock.value=hours+"   "+minutes+" "+dn
						}
						else{
							if (alternate==0)
								clockobj.innerHTML=hours+" : "+minutes+" "+"<sup style='font-size:70%'>"+dn+"</sup>"
							else
								clockobj.innerHTML=hours+" : "+minutes+" "+"<sup style='font-size:70%'>"+dn+"</sup>"
						}
				alternate=(alternate==0)? 1 : 0
				Dateobj.innerHTML="<br>"+TotalCurrentDate
				setTimeout("show()",1000)
			}
			window.onload= show