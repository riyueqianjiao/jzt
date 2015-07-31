angular.module('main.directive',['my.service.data'])
    .directive('main.directive.move',['$document','$interval',function($document,$interval){
        var oUl,oLi,timer,oBtn,iNow=0;
        return function(scope, element,attr) {
            oUl = element.find('ul');
            oLi = $(oUl).find('li');
            oBtn = $('#banner-btn-group').find('a');
            if(timer==undefined){
                timer = $interval(autoMove,4000);
            }
            function autoMove(){
                iNow++;
                if(iNow==oLi.length){
                    iNow = 0;
                }
                $(oBtn).each(function(index,obj){
                    $(obj).removeClass('active');
                });
                $(oBtn[iNow]).addClass('active');
                $(oUl).animate({top:-152*iNow},500);
            }
            element.on('mouseenter',function(){
                stopMove();
                return false;
            });
            element.on('mouseleave',function(){
                timer = $interval(autoMove,2500);
            });
            function stopMove(){
                $interval.cancel(timer);
            }
            $(oBtn).each(function(index,obj){
                obj.index = index;
                $(obj).on('click',function(ev){
                    iNow = this.index;
                    $(oBtn).each(function(index,obj){
                        $(obj).removeClass('active');
                    });
                    $(this).addClass('active');
                    $(oUl).animate({top:-152*this.index},500);
                    return false;
                });
            });
        }
    }])

