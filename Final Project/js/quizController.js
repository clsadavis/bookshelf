(function(){
    var bookshelf = angular.module('bookshelf');

    bookshelf.controller("quizController", function($scope, $http, $routeParams, $location){
        var bookId = $routeParams.bookId;
        $scope.quiz = {};

        $scope.getBooksById = function() {
            $http.get("http://localhost:8080/api/books/" + $routeParams.bookId)
            .then(function(response) {
                var books = response.data;
                if (books.length == 1) {
                    $scope.book = books[0];
                } else {
                    //TODO error message
                }
            }, function(response){
                console.log("Error http GET books by id: " + response.status);
            });
        }

        $scope.getBooksById();

        $scope.getAllTags = function() {
            $http.get("http://localhost:8080/api/books/hashtag")
            .then(function(response) {
              $scope.hashtags = response.data;
              console.log("number of hashtags: " + $scope.hashtags.length);
            }, function(response) {
              console.log("error http GET hashtags: " + response.status);
            });
          }

          $scope.getAllTags();


        $scope.updateBook = function() {
            $http.put("http://localhost:8080/api/books", $scope.book)
            .then(function(response){
                $scope.updateStatus = 'update successful';
            }, function(response){
                console.log('error http PUT books: ' + response.status);
            });
        }
    
        $scope.q1 = 'Adult';
        $scope.q2 = 'Fiction';
        $scope.q3 = 'Happy Flower';
        $scope.q4 = 'Yes';
        $scope.show1 = true;
        $scope.show2 = false;
        $scope.show3 = false;
        $scope.show4 = false;
        $scope.showBook = false;
        $scope.showArrows = true;
        $scope.showPicture = false;
        

        $scope.retake = function(){
            console.log('go to quiz start');
            $location.path('/quiz/');
        }

        $scope.next = function(){
            if ($scope.show1) {
                $scope.show1 = false;
                $scope.show2 = true;
            } else if ($scope.show2){
                $scope.show2 = false;
                $scope.show3 = true;
            } else if ($scope.show3){
                //time to find book
                //use 3 values to search for a book
                $scope.show3 = false;
                $scope.show4 = true;
            } else if($scope.show4){
                $scope.show4 = false;
                $scope.showBook = true;
                $scope.quizBook = 'The Giving Tree';
                $scope.showArrows = false;
                $scope.showPicture = true;
            }
        }

        $scope.back = function(){
            if ($scope.show2){
                $scope.show1 = true;
                $scope.show2 = false;
            } else if ($scope.show3){
                $scope.show2 = true;
                $scope.show3 = false;
            } else if ($scope.show4){
                $scope.show3 = true;
                $scope.show4 = false;
            } else if($scope.show1){
                $scope.show2 = false;
                $scope.show3 = false;
                $scope.show4 = false;
            }
        }



        $scope.goToAddQuizBookView = function(quizBook){
            console.log('go to update TBR view');
            console.log('quizBook: ' + quizBook);
            $location.path('/addQuizBookView/' + quizBook);
          }



    });    
})()