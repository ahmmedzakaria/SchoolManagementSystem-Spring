'use strict';

app.factory('Gurdian', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/SchoolManagement/gurdian/gurdianlist/:Id', {id: '@Id'},
	{
		update: {method: 'PUT'}
	}
    );
}]);

app.controller('GurdianController', ['$scope', 'Gurdian', function($scope, Gurdian) {
    var ob = this;
    ob.objArray=[];
    ob.obj = new Gurdian(); 
    
    ob.fetchAllObject = function(){
        ob.objArray = Gurdian.query();
    };
    //ob.fetchAllObject();
    
    ob.addObject = function(){
	console.log('Inside save');
	if($scope.objForm.$valid) {
	  ob.obj.$save(function(object){
	     console.log(object); 
	     ob.flag= 'created';	
	     ob.reset();	
	    // ob.fetchAllObject();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editObject = function(id){
	    console.log('Inside edit');
        ob.obj = Gurdian.get({ id: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateObjectDetail = function(){
	console.log('Inside update');
	if($scope.objForm.$valid) {
    	   ob.obj.$updateTsp(function(object){
    		console.log(object); 
		ob.updatedId = object.id;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllObject();
           });
	}
    };	
    ob.deleteObject = function(id){
	    console.log('Inside delete');
	    ob.obj = Gurdian.delete({ id: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllObject(); 
	    });
    };		
    ob.reset = function(){
    	ob.obj = new Gurdian();
        $scope.objForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.obj = new Gurdian();
	    ob.flag= '';	
   	    ob.fetchAllObject();
    };    
}]); 


