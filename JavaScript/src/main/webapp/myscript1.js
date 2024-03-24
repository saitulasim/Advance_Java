function convertTOINR()
{
	const dollarInput=document.getElementById("dollarInput").value;
	const rupees=(parseFloat(dollarInput)*82.89);
	document.getElementById("rupeeInput").value=rupees.toFixed(2);
}
convertTOINR()