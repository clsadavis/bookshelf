(function () {
var bookshelf = angular.module("bookshelf", ["ngRoute"]);

bookshelf.config(function ($routeProvider) {
    $routeProvider
        .when("/about", {
            templateUrl: "about.html"
        })
        .when("/home", {
            templateUrl: "home.html"
        })
        .when("/quiz", {
            templateUrl: "quiz.html",
            controller: "quizController"
        })
        .when("/stack",{
            templateUrl: "stack.html"
        })
        .when("/resume",{
            templateUrl: "resume.html",
            controller: "resumeController"
        })
        .when("/shelf",{
            templateUrl: "shelf.html",
            controller: "shelfController"
        })
        .when("/update/:bookId",{
            templateUrl: "update.html", 
            controller: "updateController"
        })
        .when("/create", {
            templateUrl: "create.html",
            controller: "createController"
        })
        .when("/tbr",{
            templateUrl: "tbr.html",
            controller: "tbrController"
        })
        .when("/shelfmate",{
            templateUrl: "hometest.html"
        })
        .when("/guide",{
            templateUrl: "guide.html"
        })
        .when("/stats",{
            templateUrl: "stats.html"
        })
        .when("/updateHashtag",{
            templateUrl: "updateHashtag.html",
            controller: "hashtagController"
        })
        .when("/createTbr",{
            templateUrl: "createTbr.html",
            controller: "createTbrController"
        })
        .when("/updateTbr/:bookId",{
            templateUrl: "updateTbr.html",
            controller: "updateTbrController"
        })
        .when("/addQuizBookView/:quizBook",{
            templateUrl: "addQuizBookView.html",
            controller: "addQuizBookController"
        })
        .otherwise("/home", {
            templateUrl: "home.html"
        });
});
})()