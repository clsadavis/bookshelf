var myApp = angular.module('myApp', []);

//myApp.directive('myDirective', function() {});
//myApp.factory('myService', function() {});

function MyCtrl($scope) {

 $scope.search = "";

  $scope.tableData = [];
  for (i = 0; i < 100; i++) {
    $scope.tableData.push({
      id: i,
      name: generateRandomName(),
      street: generateRandomName(),
      number: generateRandomNumber()
    })
  }

  function generateRandomName() {
    var length = 4;
    var charset = "abcdefghjknpqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";

    var retVal = "";
    for (var i = 0, n = charset.length; i < length; ++i) {
      retVal += charset.charAt(Math.floor(Math.random() * n));
    }

    return retVal;
  }

  function generateRandomNumber() {
    return Math.floor(Math.random() * 10);
  }


}