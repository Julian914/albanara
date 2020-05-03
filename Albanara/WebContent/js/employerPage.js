/**
 * 
 */
	//공고목록에 아코디언 적용
	(function($) {
		$(function() {
			$('.accordion').accordion();
		});
	})(jQuery);



	$(document).ready(function() {
	    $("header").load("header.html")
	    $("nav").load("nav.html")
	    $("footer").load("footer.html")
	 });

	$(document).ready(function() {
		$("#div.accordion-title").click(function(){
			$("#div.accordion-contents").css('margin-top',-100);
		})	
	})