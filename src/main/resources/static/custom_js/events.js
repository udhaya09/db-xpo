$(document).ready(function() {
	
	   $('#enable-new-con-form').on('click', function() {
	    	console.log("info: enable-new-con-form")
	    	
	    	$('#new-connection-form').show();
	    	
	    });
	   
	   
	   $('#enable-query-execute-form').on('click', function() {
	    	console.log("info: enable-query-execute-form")
	    	
	    	$('#query-execute-form').show();
	    	
	    });
	   
	
	   
	   $('#enable-exis-query').on('click', function() {
	    	console.log("info: enable-exis-query")
	    	
	    	$('#exist-query-form').show();
	    	
	    });
	   
	   

});