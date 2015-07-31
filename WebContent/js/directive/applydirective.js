angular.module('apply.directive',[])
     .directive('apply.tab.directive',function(){
         var oDiv1,oDiv2,oA;
         function link(scope, element, attrs){
             oDiv1 = $('.applyForm');
             oDiv2 = $('.waitVerify ');
             oA = $("#applyNext");
             oA.click(function(){
                 oDiv1.animate({left:-1000},500,function(){
                     oDiv2.animate({left:100},500);
                 });
             });
         }
         return {
             link : link
         }
     });
