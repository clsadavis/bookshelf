(function () {
  var bookshelf = angular.module("bookshelf");

  bookshelf.controller("shelfController", function ($scope, $http, $location) {

    $scope.getAllBooks = function() {
      $http.get("http://localhost:8080/api/books")
      .then(function(response) {
        $scope.books = response.data;
        console.log("number of books: " + $scope.books.length);
      }, function(response) {
        console.log("error http GET books: " + response.status);
      });
    }

    $scope.getAllBooks();

    $scope.goToUpdateView = function(bookId){
      console.log('go to update view');
      console.log('bookId: ' + bookId);
      $location.path('/update/' + bookId);
    }

    $scope.goToCreateView = function(){
			console.log('go to create view');
			$location.path('/create/');
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

    // $scope.showPlayer = true;

    // $scope.playMusic = function(){
    //   if($scope.showPlayer){
    //     $scope.showPlayer  = false;
    //   } else {
    //     $scope.showPlayer = true;
    //   }
    // }
  

  });
})()
