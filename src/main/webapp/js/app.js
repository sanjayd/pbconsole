$(function() {
	$('#password-toggle').click(function() {
		document.getElementById("login-password").type = $(this).prop('checked') ? 'text' : 'password';
	});

	$('#alarm-toggle').bootstrapSwitch();	
	$('#alarm-toggle').on('switch-change', function(event) {
		$.ajax({
			url: 'alarm',
			type: 'POST',
			data: {armed: $('#alarm-toggle').prop('checked')},
			dataType: 'json'
		});
	});
});
