(function(){
    var bookshelf = angular.module('bookshelf');

    bookshelf.controller("updateController", function($scope, $http, $routeParams, $location){
        var bookId = $routeParams.bookId;

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
            $http.get("http://localhost:8080/api/hashtags/hashtags")
            .then(function(response) {
              $scope.hashtags = response.data;
              console.log("number of hashtags: " + $scope.hashtags.length);
            }, function(response) {
              console.log("error http GET hashtags: " + response.status);
            });
          }

          $scope.getAllTags();

          
    

        $scope.bookFormats = ['Fiction','Non-Fiction','Poetry','Essays','Short Story',
            'Creative Non-Fic','Play','Graphic Novel'];
        $scope.ageRatings = ['Board Books','Picture Books','Early Readers','Chapter Books',
            'Middle Grade','Young Adult','Adult'];
        $scope.keywords = ['none','Action','Biography','Classic','Fantasy','Food','History','Horror',
            'Humor','Literary','Memoir/ Autobiography','Mystery','Romance','Science','SciFi',
            'Self-Help','Social Sci','Spirituality','Thriller','Travel','True Crime',
            'Western'];  
        $scope.audioBooks = ['Yes','No'];

        $scope.updateBook = function() {
            $http.put("http://localhost:8080/api/books", $scope.book)
            .then(function(response){
                $scope.updateStatus = 'update successful';
            }, function(response){
                console.log('error http PUT books: ' + response.status);
            });
        }

        
    
        

        $scope.deleteBook = function(){
            var result = confirm("Are you sure you want to delete this book?");
            if (result){
                $http.delete("http://localhost:8080/api/books/" + $scope.book.id)
                .then(function(response){
                    $scope.updateStatus = "Delete Successful";
                    $scope.disableUpdate = true;
                }, function(response){
                    $scope.updateStatus = "Error trying to delete book";
                    console.log('error http DELETE books: ' + response.status);
                });
            
            } 
        }

        $scope.goToShelfView = function() {
            console.log('go to shelf view');
            $location.path('/shelf');
        }



    });    
})()