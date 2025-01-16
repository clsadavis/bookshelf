//createController creates new Books but operates as shelfController for hashtags

(function() {
	var bookshelf = angular.module('bookshelf');

	bookshelf.controller('createTbrController', function($scope, $http, $location){	
		$scope.Tbrbook = {};
		
		$scope.bookFormats = ['Fiction','Non-Fiction','Poetry','Essays','Short Story',
            'Creative Non-Fic','Play','Graphic Novel'];
        $scope.ageRatings = ['Board Books','Picture Books','Early Readers','Chapter Books',
            'Middle Grade','Young Adult','Adult'];
        $scope.keywords = ['none','Action','Biography','Classic','Fantasy','Food','History','Horror',
            'Humor','Literary','Memoir/ Autobiography','Mystery','Romance','Science','SciFi',
            'Self-Help','Social Sci','Spirituality','Thriller','Travel','True Crime',
            'Western'];  
        $scope.audioBooks = ['Yes','No'];

		$scope.createTbrBook = function(){
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

		$scope.clear = function() {
			$scope.tbrBook.title = '';
			$scope.tbrBook.author = '';
			$scope.tbrBook.releaseYear = '';
			$scope.tbrBook.bookFormat = '';
			$scope.tbrBook.pageCount = '';
			$scope.tbrBook.audioBook = '';
			$scope.tbrBook.ageRating = '';
			$scope.tbrBook.seriesNumber = '';
			$scope.tbrBook.keyword1 = '';
			$scope.tbrBook.keyword2 = '';
			$scope.tbrBook.keyword3 = '';
			$scope.tbrBook.hashtag1 = '';
			$scope.tbrBook.hashtag2 = '';
			$scope.tbrBook.hashtag3 = '';
			$scope.tbrBook.hashtag4 = '';
			$scope.tbrBook.hashtag5 = '';
			$scope.tbrBook.recScore = '';
			$scope.tbrBook.keywordScore = '';
			$scope.tbrBook.authorScore = '';
			$scope.tbrBook.totalScore = '';
			$scope.disableCreate = false;
		}

		$scope.goToTbrView = function() {
            console.log('go to TBR view');
            $location.path('/tbr');
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

	// var slider = document.getElementById("recScore");
	// var output = document.getElementById("demo");
	// output.innerHTML = slider.value;

	// slider.oninput = function(){
	// 	output.innerHTML = this.value;
	// }

	// var recSlider = document.getElementById("recScore");
	// var recOutput = document.getElementById("recNum");
	// recOutput.innerHTML = recSlider.value;
   


	// recSlider.oninput = function(){
	// 	recOutput.innerHTML = this.value;
	// }

    // var keySlider = document.getElementById("keywordScore");
    // var keyOutput = document.getElementById("keyNum");
    // keyOutput.innerHTML = keySlider.value;
    // var keyTotal = keySlider.value;

    // keySlider.oninput = function(){
    //     keyOutput.innerHTML = keyOutput.value;
    //     keyTotal = keyOutput.innerHTML;
    // }

    // var authSlider = document.getElementById("authorScore");
    // var authOutput = document.getElementById("authNum");
    // authOutput.innerHTML = authSlider.value;
    // var authorTotal = authSlider.value;

    // authSlider.oninput = function(){
    //     authOutput.innerHTML = authOutput.value;
    //     authorTotal = authOutput.innerHTML;
    // }


	});
})()