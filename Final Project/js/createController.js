//createController creates new Books but operates as shelfController for hashtags

(function() {
	var bookshelf = angular.module('bookshelf');

	bookshelf.controller('createController', function($scope, $http, $location){	
		$scope.book = {};
		
		$scope.bookFormats = ['Fiction','Non-Fiction','Poetry','Essays','Short Story',
            'Creative Non-Fic','Play','Graphic Novel'];
        $scope.ageRatings = ['Board Books','Picture Books','Early Readers','Chapter Books',
            'Middle Grade','Young Adult','Adult'];
        $scope.keywords = ['none','Action','Biography','Classic','Fantasy','Food','History','Horror',
            'Humor','Literary','Memoir/ Autobiography','Mystery','Romance','Science','SciFi',
            'Self-Help','Social Sci','Spirituality','Thriller','Travel','True Crime',
            'Western'];  
        $scope.audioBooks = ['Yes','No'];

		$scope.createBook = function(){
			$http.post("http://localhost:8080/api/books", $scope.book)
			.then(function(response){
				$scope.createStatus = 'Create Successful';
				$scope.disableCreate = true;
			}, function(response){
				$scope.createStatus = 'error trying to create book';
				console.log('error http POST books: ' + response.status);
			});
		}

		$scope.clear = function() {
			$scope.book.title = '';
			$scope.book.author = '';
			$scope.book.releaseYear = '';
			$scope.book.bookFormat = '';
			$scope.book.pageCount = '';
			$scope.book.audioBook = '';
			$scope.book.ageRating = '';
			$scope.book.seriesNumber = '';
			$scope.book.keyword1 = '';
			$scope.book.keyword2 = '';
			$scope.book.keyword3 = '';
			$scope.book.hashtag1 = '';
			$scope.book.hashtag2 = '';
			$scope.book.hashtag3 = '';
			$scope.book.hashtag4 = '';
			$scope.book.hashtag5 = '';
			$scope.disableCreate = false;
		}

		$scope.goToShelfView = function() {
            console.log('go to shelf view');
            $location.path('/shelf');
        }

		//hashtag Shelf below

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
				$scope.book.hashtag1 = hashtagName;
			} else if($scope.hashtagCount == 2){
				$scope.book.hashtag2 = hashtagName;
			} else if($scope.hashtagCount == 3){
				$scope.book.hashtag3 = hashtagName;
			} else if($scope.hashtagCount == 4){
				$scope.book.hashtag4 = hashtagName;
			} else {
				$scope.book.hashtag5 = hashtagName;
			}
			$scope.hashtagCount++;

			if($scope.hashtagCount > 5){
				$scope.hashtagCount = 1;
			}
		};

		$scope.goToUpdateHashtagView = function(){
			console.log('go to update view');
			$location.path('/updateHashtag/');
		}

		// $scope.allowDrop = function(ev){
		// 	ev.preventDefault();
	    // }

    //   $scope.drag = function(ev) {
    //     	ev.dataTransfer.setData("text", ev.target.id);
    //   	}
	
    //   $scope.drop =function (ev){
    //     ev.preventDefault();
    //     var data = ev.dataTransfer.getData("text");
    //     ev.target.appendChild(document.getElementById(data));   
    //   } 

	$scope.hashtag1change = function(){
		alert('hashtag 1 changed: ' + ht);
	}




	});
})()