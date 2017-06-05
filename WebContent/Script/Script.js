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
		
		//=================Clock=================
		
		var alternate=0
		var standardbrowser=!document.all&&!document.getElementById
		
		if (standardbrowser)
		document.write('<form name="tick"><input type="text" name="tock" size="11"></form>')
		
		function show(){
			if (!standardbrowser)
				var clockobj=document.getElementById? document.getElementById("digitalclock") : document.all.digitalclock
				var Digital=new Date()
				var hours=Digital.getHours()
				var minutes=Digital.getMinutes()
				var dn="AM"
					
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
				setTimeout("show()",1000)
			}
			window.onload=show
		//=================================Date=================
		
		function CurrentDate(){
			var mydate=new Date()
			var year=mydate.getYear()
			if (year < 1000)
				year+=1900
				var day=mydate.getDay()
				var month=mydate.getMonth()
				var daym=mydate.getDate()
				if (daym<10)
					daym="0"+daym
					var dayarray=new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday");
			var montharray=new Array("January","February","March","April","May","June","July","August","September","October","November","December");
			var TotalCurrentDate="<small><font color='000000' face='Arial' class='small_date' ><b>"+dayarray[day]+", "+montharray[month]+" "+daym+", "+year+"</b></font></small><br>";
			var OnlyCurrentYear="<small><font color='000000' face='Arial' class='small_date' ><b>"+year+"</b></font></small><br>";
			document.write(CDate)
			document.getElementById('OnlyCurrentYear').value = CDate;
		}
