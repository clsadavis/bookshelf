(function() {
	var bookshelf = angular.module('bookshelf');

	bookshelf.controller('hashtagController', function($scope, $http, $location){	
        // $scope.hashtags = {};
        // var hashtagId = $routeParams.hashtagId;
        

        // $scope.getHashtagsById = function() {
        //     $http.get("http://localhost:8080/api/hashtags/hashtags/" + $routeParams.hashtag)
        //     .then(function(response) {
        //         var hashtags = response.data;
        //         if (hashtags.length == 1) {
        //             $scope.hashtags = hashtags[0];
        //         } else {
        //             //TODO error message
        //         }
        //     }, function(response){
        //         console.log("Error http GET hashtags by id: " + response.status);
        //     });
        // }

        // $scope.getHashtagsById();

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

          

        $scope.updateHashtag = function() {
            $http.put("http://localhost:8080/api/hashtags/hashtags", $scope.hashtags)
            .then(function(response){
                $scope.updateStatus = 'update successful';
            }, function(response){
                console.log('error http PUT hashtags: ' + response.status);
            });
        }

        
    
        

        $scope.deleteHashtag = function(){
            var result = confirm("Are you sure you want to delete this hashtag?");
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
		$scope.book = {};
		
	

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


// (function() {

//     var demo = angular.module('demo');

//     demo.controller("NestedListsDemoController", function($scope) {

//     $scope.models = {
//         selected: null,
//         templates: [
//             {type: "item", id: 2},
//             {type: "container", id: 1, columns: [[], []]}
//         ],
//         dropzones: {
//             "A": [
//                 {
//                     "type": "container",
//                     "id": 1,
//                     "columns": [
//                         [
//                             {
//                                 "type": "item",
//                                 "id": "1"
//                             },
//                             {
//                                 "type": "item",
//                                 "id": "2"
//                             }
//                         ],
//                         [
//                             {
//                                 "type": "item",
//                                 "id": "3"
//                             }
//                         ]
//                     ]
//                 },
//                 {
//                     "type": "item",
//                     "id": "4"
//                 },
//                 {
//                     "type": "item",
//                     "id": "5"
//                 },
//                 {
//                     "type": "item",
//                     "id": "6"
//                 }
//             ],
//             "B": [
//                 {
//                     "type": "item",
//                     "id": 7
//                 },
//                 {
//                     "type": "item",
//                     "id": "8"
//                 },
//                 {
//                     "type": "container",
//                     "id": "2",
//                     "columns": [
//                         [
//                             {
//                                 "type": "item",
//                                 "id": "9"
//                             },
//                             {
//                                 "type": "item",
//                                 "id": "10"
//                             },
//                             {
//                                 "type": "item",
//                                 "id": "11"
//                             }
//                         ],
//                         [
//                             {
//                                 "type": "item",
//                                 "id": "12"
//                             },
//                             {
//                                 "type": "container",
//                                 "id": "3",
//                                 "columns": [
//                                     [
//                                         {
//                                             "type": "item",
//                                             "id": "13"
//                                         }
//                                     ],
//                                     [
//                                         {
//                                             "type": "item",
//                                             "id": "14"
//                                         }
//                                     ]
//                                 ]
//                             },
//                             {
//                                 "type": "item",
//                                 "id": "15"
//                             },
//                             {
//                                 "type": "item",
//                                 "id": "16"
//                             }
//                         ]
//                     ]
//                 },
//                 {
//                     "type": "item",
//                     "id": 16
//                 }
//             ]
//         }
//     };
// });
// })()

// (function() {
// 	var bookshelf = angular.module('bookshelf',['ngDndLists']);

//     bookshelf.controller('dndLists',['$scope','dndLists', function($scope, dndLists){
//         $scope.models = {
//             selected: null,
//             lists: {"A": [], "B": []}
//         };
        
//         for (var i = 1; i <= 3; i++){
//             $scope.models.lists.A.push({label: "Item A" + i});
//             $scope.models.lists.B.push({label: "Item B" + i});
//         }
        
//         // $scope.$watch('models', function(model){
//         //     $scope.modelAsJson(model,true);
//         // }, true);

//     }]);
// })()
