'use strict';

app.factory('Guardian', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/SchoolManagement/guardian/guardianlist/:guardianId', {guardianId: '@guardianId'},
	{
		updateGuardian: {method: 'PUT'}
	}
    );
}]);


app.controller('GuardianController', ['$scope', 'Guardian', function($scope, Guardian) {
    var ob = this;
    ob.test='zakaria';
    ob.guardians=[];
    ob.guardian = new Guardian(); 
    ob.fetchAllGuardians = function(){
        ob.guardians = Guardian.query();
    };
    ob.fetchAllGuardians();
    ob.addGuardian = function(){
	console.log('Inside save');
	if($scope.guardianForm.$valid) {
	  ob.guardian.$save(function(guardian){
	     console.log(guardian); 
	     ob.flag= 'created';	
	     ob.reset();	
	     //ob.fetchAllGuardians();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editGuardian = function(id){
	    console.log('Inside edit');
        ob.guardian = Guardian.get({ guardianId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateGuardianDetail = function(){
	console.log('Inside update');
	if($scope.guardianForm.$valid) {
    	   ob.guardian.$updateGuardian(function(guardian){
    		console.log(guardian); 
		ob.updatedId = guardian.guardianId;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllGuardians();
           });
	}
    };	
    ob.deleteGuardian = function(id){
	    console.log('Inside delete');
	    ob.guardian = Guardian.delete({ guardianId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllGuardians(); 
	    });
    };		
    ob.reset = function(){
    	ob.guardian = new Guardian();
        $scope.guardianForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.guardian = new Guardian();
	    ob.flag= '';	
   	    ob.fetchAllGuardians();
    };    
}]); 


