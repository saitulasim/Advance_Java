function validateForm()
{
	//read the form data
	var proId=document.getElementById("proId").value;
		var proName=document.getElementById("proName").value;
		var proName=document.getElementById("proName").value;
		var proPrice=document.getElementById("proPrice").value;
		var proBrand=document.getElementById("proBrand").value;
		var promadeIn=document.getElementById("promadeIn").value;
if(ProId.trim()===""||ProName.trim()===""||ProPrice.trim()===""||ProBrand.trim()===""||
	ProMadein.trim()===""||ProMFGDate.trim()===""||ProEXPDate.trim()===""){
		alert("All Fields Must Be Filled Out");
	return false;
	}
	
	 if(parseFloat(ProPrice)<0){
	alert("The Product Price Will Not Be Negative");
	return false;
	}
	
	
	 if(ProName.length>50||ProBrand.length>50){
	alert("The Product Name and Price should Be Less Than 50 Characters");
	return false;
	}
	
	var ManfactureDateobj = new Date(ProMFGDate);
	var ExpiryDateobj = new Date(ProEXPDate);

	 if(ManfactureDateobj>ExpiryDateobj){
		alert("The Manfacturing Date Can't be Greater than Expiry Date");
		return false;
	}
	return true;
}