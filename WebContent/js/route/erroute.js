angular.module('myRoute',['ngRoute'])
    .config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.
                when('/fbzw', {
                    templateUrl: '../publication/add',
                    controller: 'employer.fbzw.ctrl'
                }).
                when('/yfbzw',{
                    templateUrl: '../publication/show/0',
                    controller:'employer.yfbzw.ctrl'
                }).
                when('/yqxzw',{
                    templateUrl: '../publication/show/3',
                    controller:'employer.yqxzw.ctrl'
                }).
                when('/applycancel/:publicationId',{
                    templateUrl: '../publication/applycancel',
                    controller:'employer.applycancel.ctrl'
                }).
                when('/ywjzw',{
                    templateUrl: '../publication/show/4',
                    controller:'employer.ywjzw.ctrl'
                }).
                when('/detail/:publicationId',{
                	templateUrl: '../publication/detail',
                    controller:'employer.detail.ctrl'
                }).
                when('/info',{
                    templateUrl: 'show',
                    controller:'employer.info.ctrl'
                }).
                when('/updatePass',{
                    templateUrl: '../employer/updatepwd',
                    controller:'employer.updatePass.ctrl'
                }).
                otherwise({
                    redirectTo: '/fbzw'
                });
        }]);