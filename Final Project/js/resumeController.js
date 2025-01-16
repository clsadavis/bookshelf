(function () {
    var bookshelf = angular.module("bookshelf");
  
    bookshelf.controller("resumeController", function ($scope, $http, $location) {
  
      $scope.getAllTbrBooks = function() {
        $http.get("http://localhost:8080/api/tbr")
        .then(function(response) {
          $scope.tbrBooks = response.data;
          console.log("number of books: " + $scope.tbrBooks.length);
        }, function(response) {
          console.log("error http GET books: " + response.status);
        });
      }
  
      $scope.getAllTbrBooks();
  
      $scope.goToUpdateTbrView = function(tbrBookId){
        console.log('go to update TBR view');
        console.log('bookId: ' + tbrBookId);
        $location.path('/updateTbr/' + tbrBookId);
      }
  
      $scope.goToCreateTbrView = function(){
              console.log('go to create TBR view');
              $location.path('/createTbr/');
          }
  
      $scope.orderByColumn = function(column){
        $scope.orderByValue = column;
        if($scope.reverse == true){
          $scope.reverse = false;
        } else {
          $scope.reverse = true;
        }
      }
  
      $scope.reverse = false;
    
    $scope.showResume = true;
    $scope.showBits = false;

    $scope.resume = function(){
      if($scope.showResume){
        $scope.showResume  = false;
        $scope.showBits = true;
      } else {
        $scope.showResume = true;
        $scope.showBits = false;
        
      }
    }
  
    });
  })()