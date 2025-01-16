(function(){
    var bookshelf = angular.module('bookshelf');

    bookshelf.controller("updateTbrController", function($scope, $http, $routeParams, $location){
        var bookId = $routeParams.bookId;

        $scope.getBooksByTbrId = function() {
            $http.get("http://localhost:8080/api/tbr/" + $routeParams.bookId)
            .then(function(response) {
                var tbrBooks = response.data;

                if (tbrBooks.length == 1) {
                    $scope.tbrBook = tbrBooks[0];
                } else {
                    //TODO error message
                }
                $scope.totalNum = $scope.tbrBook.authorScore + $scope.tbrBook.keywordScore + $scope.tbrBook.recScore;
            }, function(response){
                console.log("Error http GET TBR books by id: " + response.status);
            });
        }

        $scope.getBooksByTbrId();

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
        

        $scope.updateTbrBook = function() {
            $scope.tbrBook.totalScore = $scope.tbrBook.authorScore + $scope.tbrBook.keywordScore + $scope.tbrBook.recScore;
            // $scope.tbrBook.totalScore = $scope.totalNum;
            console.log("tbrBook.totalScore: " + $scope.tbrBook.totalScore);
            $http.put("http://localhost:8080/api/tbr", $scope.tbrBook)
            .then(function(response){
                $scope.updateStatus = 'update successful';
            }, function(response){
                console.log('error http PUT TBR books: ' + response.status);
            });
        }

        
    
        

        $scope.deleteTbrBook = function(){
            var result = confirm("Are you sure you want to delete this book from your TBR?");
            if (result){
                $http.delete("http://localhost:8080/api/tbr/" + $scope.tbrBook.id)
                .then(function(response){
                    $scope.updateStatus = "Delete Successful";
                    $scope.disableUpdate = true;
                }, function(response){
                    $scope.updateStatus = "Error trying to delete tbr book";
                    console.log('error http DELETE TBR books: ' + response.status);
                });
            
            } 
        }

        $scope.goToTbrView = function() {
            console.log('go to tbr view');
            $location.path('/tbr');
        }

    

    var recSlider = document.getElementById("recScore");
	var recOutput = document.getElementById("recNum");
	recOutput.innerHTML = recSlider.value;
   


	recSlider.oninput = function(){
		recOutput.innerHTML = this.value;
	}

    

    var keySlider = document.getElementById("keywordScore");
    var keyOutput = document.getElementById("keyNum");
    keyOutput.innerHTML = keySlider.value;
    var keyTotal = keySlider.value;

    keySlider.oninput = function(){
        keyOutput.innerHTML = keyOutput.value;
        keyTotal = keyOutput.innerHTML;
    }

    var authSlider = document.getElementById("authorScore");
    var authOutput = document.getElementById("authNum");
    authOutput.innerHTML = authSlider.value;
    var authorTotal = authSlider.value;

    authSlider.oninput = function(){
        authOutput.innerHTML = authOutput.value;
        authorTotal = authOutput.innerHTML;
    }



    

    });    
})()