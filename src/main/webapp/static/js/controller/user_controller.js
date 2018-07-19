'use strict';

app.factory('Users', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/SchoolManagement/userinfo/userlist/:userId', {userId: '@userId'},
	{
		updateUsers: {method: 'PUT'}
	}
    );
}]);


app.controller('UsersController', ['$scope', 'Users', function($scope, Users) {
    var ob = this;
    ob.test='zakaria';
    ob.userss=[];
    ob.studentRecordBses=[];
    ob.users = new Users(); 
    ob.fetchAllUserss = function(){
        ob.userss = Users.query();
    };
    ob.fetchAllUserss();
    ob.addUsers = function(){
	console.log('Inside save');
	if($scope.usersForm.$valid) {
            
	  ob.users.$save(function(users){
	     console.log(users); 
	     ob.flag= 'created';	
	     ob.reset();	
	     //ob.fetchAllUserss();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editUsers = function(id){
	    console.log('Inside edit');
        ob.users = Users.get({ userId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateUsersDetail = function(){
	console.log('Inside update');
	if($scope.usersForm.$valid) {
    	   ob.users.$updateUsers(function(users){
    		console.log(users); 
		ob.updatedId = users.userId;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllUserss();
           });
	}
    };	
    ob.deleteUsers = function(id){
	    console.log('Inside delete');
	    ob.users = Users.delete({ userId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllUserss(); 
	    });
    };		
    ob.reset = function(){
    	ob.users = new Users();
        $scope.usersForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.users = new Users();
	    ob.flag= '';	
   	    ob.fetchAllUserss();
    };    
}]); 


