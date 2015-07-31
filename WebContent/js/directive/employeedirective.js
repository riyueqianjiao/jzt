angular.module('employeeDirective',[])
    .directive('employee.clip.directive',['$document','$window',function($document,$window){
        var oP,oImg1,oImg2,oClip,oDiv;
        function link(scope,element,attrs){
            var vm = scope.vm = {};
            vm.isPress = false;
            oP = $(element);
            oClip = $("#clip-border");
            oDiv = $('#pressDiv');
            oImg1 = $("#img1");
            oImg2 = $("#img2");
            oDiv.on('mousedown',function(){
                vm.isPress = true;
            });
            $window.onmouseup = function(){
                vm.isPress = false;
            }

            //$document.onselectstart=new Function('event.returnValue=false;');


            $window.onmousemove = function(e){
                if(vm.isPress){
                    var e = e||event;
                    var imouseX = e.clientX;
                    var oWidth = oClip.width();
                    var addWidth = imouseX-getPosition(oP[0]).left-oWidth;
                    oClip.css({
                        width:oWidth+addWidth,
                        height:oWidth+addWidth
                    });
                    oImg2.css({
                        clip:'rect(0 '+oWidth+'px '+oWidth+'px 0)'
                    });
                }
                e.preventDefault();
            }
            /*function moveLeft(e){
                console.log(1);


                *//*if(oDiv.offset().top-oImg2.offset().top+10>oImg2.height()){
                    vm.isPress = false;
                    oClip.css({
                        width:oWidth+addWidth,
                        height:oWidth+addWidth
                    });
                    oImg2.css({
                        clip:'rect(0 '+oWidth+'px '+oWidth+'px 0)'
                    });
                }*//*

            }*/
            setSize();
            function setSize(){
                var iHeight = oP.height();
                var iWidth = oP.width();
                var imgHeight = oImg1.height();
                var imgWidth = oImg1.width();
                if(imgWidth>imgHeight){
                    if(imgWidth>300){
                        var currHeight = iWidth/imgWidth*imgHeight;
                        oImg1.css({
                            width:iWidth,
                            height:currHeight,
                            marginTop:(iHeight-currHeight)/2
                        });
                        oImg2.css({
                            width:iWidth,
                            height:currHeight,
                            marginTop:(iHeight-currHeight)/2
                        });
                        oClip.css({
                            marginTop:(iHeight-currHeight)/2
                        });
                    }else{
                        //ju zhong
                    }
                }else{
                    if(imgHeight>300){
                        var currWidth = iHeight/imgHeight*imgWidth;
                        oImg1.css({
                            width:currWidth,
                            height:iHeight,
                            marginLeft:(iWidth-currWidth)/2
                        });
                        oImg2.css({
                            width:currWidth,
                            height:iHeight,
                            marginLeft:(iWidth-currWidth)/2
                        });
                        oClip.css({
                            marginLeft:(iWidth-currWidth)/2
                        });
                    }else{
                        //ju zhong
                    }

                }
            }
            function getPosition(node){
                var left = node.offsetLeft;
                var top = node.offsetTop;
                var current = node.offsetParent;
                while(current!=null){
                    left += current.offsetLeft;
                    top += current.offsetTop;
                    current = current.offsetParent;
                }
                return {"left":left,"top":top};
            }
        }
        return {
            link:link
        }
    }]);
