angular.module('myRoute',['ngRoute'])
    .config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.
                when('/ybmhd',{
                    templateUrl: '../signup/show',
                    controller:'employee.ybmhd.ctrl'
                }).
                when('/pjhd',{
                    templateUrl: '../signup/showRemarkable',
                    controller:'employee.pjhd.ctrl'
                }).
                when('/info',{
                    templateUrl: 'update',
                    controller:'employee.info.ctrl'
                }).
                when('/comment/:publicationId',{
                    templateUrl: '../comment/comment',
                    controller:'employee.comment.ctrl'
                }).
                when('/updatepass',{
                    templateUrl: 'updatepass',
                    controller:'employee.updatePass.ctrl'
                }).
                otherwise({
                    redirectTo: '/ybmhd'
                });
        }]);