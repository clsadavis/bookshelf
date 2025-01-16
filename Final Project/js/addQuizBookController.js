(function(){
    var bookshelf = angular.module('bookshelf');

    bookshelf.controller("addQuizBookController", function($scope, $http, $routeParams, $location){
        $scope.quizBook = $routeParams.quizBook;
        console.log("QuizBook: " + $scope.quizBook);

        $scope.author = "Shel Silverstein";
        $scope.release = 1964;
        $scope.forms = "Short Story";
        $scope.page = 64;
        $scope.audio = "Yes";
        $scope.age = "Picture Books";
        $scope.series = "n/a";
        $scope.k1 = "Classic";
        $scope.k2 = "Literary";
        $scope.k3 = "none";
        $scope.h1 = "Fable";
        $scope.h2 = "Relationships";
        $scope.h3 = "Anthropology";
        $scope.h4 = "Missing Persons";
        $scope.h5 = "Personal Development";


        $scope.createBookFromQuiz = function(){
            $scope.tbrBook.title = $scope.quizBook;
            $scope.tbrBook.author = $scope.author;
            $scope.tbrBook.releaseYear = $scope.release;
            $scope.tbrBook.bookFormat = $scope.forms;
            $scope.tbrBook.pageCount = $scope.page;
            $scope.tbrBook.audioBook = $scope.audio;
            $scope.tbrBook.ageRating = $scope.age;
            $scope.tbrBook.seriesNumber = $scope.series;
            $scope.tbrBook.keyword1 = $scope.k1;
            $scope.tbrBook.keyword2 = $scope.k2;
            $scope.tbrBook.keyword3 = $scope.k3;
            $scope.tbrBook.hashtag1 = $scope.h1;
            $scope.tbrBook.hashtag2 = $scope.h2;
            $scope.tbrBook.hashtag3 = $scope.h3;
            $scope.tbrBook.hashtag4 = $scope.h4;
            $scope.tbrBook.hashtag5 = $scope.h5;
            $scope.tbrBook.totalScore = $scope.tbrBook.authorScore + $scope.tbrBook.keywordScore + $scope.tbrBook.recScore;

            $http.post("http://localhost:8080/api/tbr", $scope.tbrBook)
            .then(function(response){
                $scope.createStatus = 'Create Successful';
                $scope.disableCreate = true;
            }, function(response){
                $scope.createStatus = 'error trying to create TBR book';
                console.log('error http POST TBR books: ' + response.status);
            });
        }

        $scope.bookFormats = ['Fiction','Non-Fiction','Poetry','Essays','Short Story',
            'Creative Non-Fic','Play','Graphic Novel'];
        $scope.ageRatings = ['Board Books','Picture Books','Early Readers','Chapter Books',
            'Middle Grade','Young Adult','Adult'];
        $scope.keywords = ['none','Action','Biography','Classic','Fantasy','Food','History','Horror',
            'Humor','Literary','Memoir/Autobiography','Mystery','Romance','Science','SciFi',
            'Self-Help','Social Sci','Spirituality','Thriller','Travel','True Crime',
            'Western'];  
        $scope.audioBooks = ['Yes','No'];

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

	
		$scope.hashtagCount = 1;
		$scope.selectHashtag = function(hashtagName){
			console.log('Hashtag Name: ' + hashtagName);
			if($scope.hashtagCount == 1){
				$scope.tbrBook.hashtag1 = hashtagName;
			} else if($scope.hashtagCount == 2){
				$scope.tbrBook.hashtag2 = hashtagName;
			} else if($scope.hashtagCount == 3){
				$scope.tbrBook.hashtag3 = hashtagName;
			} else if($scope.hashtagCount == 4){
				$scope.tbrBook.hashtag4 = hashtagName;
			} else {
				$scope.tbrBook.hashtag5 = hashtagName;
			}
			$scope.hashtagCount++;

			if($scope.hashtagCount > 5){
				$scope.hashtagCount = 1;
			}
		};

        $scope.goToTbrView = function() {
            console.log('go to tbr view');
            $location.path('/tbr');
        }
    
    });    
})()