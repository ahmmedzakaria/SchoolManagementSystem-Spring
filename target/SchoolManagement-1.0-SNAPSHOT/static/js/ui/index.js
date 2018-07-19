

app.controller("AppController",function($scope){
  $scope.toggleSideMenu = function($event){
    $event.preventDefault();
    $scope.closed=!$scope.closed;
    $scope.test="Zakaria";
  };
  
  $scope.items = [];
  $scope.refresh = function(){
    for (var i=0;i<5;i++){
      $scope.items.push("Item "+i);
    }
  }
  
  $scope.removeAll = function(){
    $scope.items.splice(0);
  }
});