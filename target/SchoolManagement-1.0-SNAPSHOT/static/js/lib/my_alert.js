var birdAlert = new BirdAlert({
	position: 'top right'
});


$('#btnSuccess').on('click', function () {
	birdAlert.notify({
		msg: 'Facilisis pellentesque dictumst dignissim, mauris et tincidunt tincidunt', 
		title: 'Success', 
		className: 'success'
	});
});

$('#btnError').on('click', function () {
	birdAlert.notify({
		msg: 'Facilisis pellentesque dictumst dignissim, mauris et tincidunt tincidunt', 
		title: 'Error', 
		className: 'error'
	});
});

$('#btnWarning').on('click', function () {
	birdAlert.notify({
		msg: 'Facilisis pellentesque dictumst dignissim, mauris et tincidunt tincidunt', 
		title: 'Warning', 
		className: 'warning'
	});
});
$('#btnInfo').on('click', function () {
	birdAlert.notify({
		msg: 'Facilisis pellentesque dictumst dignissim, mauris et tincidunt tincidunt', 
		title: 'Info', 
		className: 'info'
	});
});




