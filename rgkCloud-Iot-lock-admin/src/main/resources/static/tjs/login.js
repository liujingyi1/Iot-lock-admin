jQuery(function($) {
	$(document).on('click', '.toolbar a[data-target]', function(e) {
		e.preventDefault();
		var target = $(this).data('target');
		$('.widget-box.visible').removeClass('visible');// hide others
		$(target).addClass('visible');// show target
	});

});

function mouseover(obj) {
	obj.style.cursor = "pointer";
}

function refresh(obj) {
	obj.src = "getVerifyCode?" + Math.random();
}