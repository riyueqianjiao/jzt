angular.module('applyMain',['ie.select','my.service.data','apply.directive'])
    .controller('apply.ctrl',['$scope','cityData','$interval','$document',function($scope,cityData,$interval,$document){
        //选取div
        var oDiv1 = $('.applyForm');
        var oDiv2 = $('.waitVerify ');
        var vm = $scope.vm = {};
        vm.showTip = true;
        vm.bz2Active = '';
        vm.line2Active = '';
        function changebz2Active(){
            vm.bz2Active = 'active';
            vm.line2Active = 'active';
        }
        $("#phone").val('');
        //地址联动
        vm.provinces = cityData;
        // 更换省时清空
        $scope.$watch('vm.province', function () {
            vm.city = null;
        });
        // 更换城市时清空
        $scope.$watch('vm.city', function () {
            vm.area = null;
        });
        //submit form
        vm.applyBtn = true;
        vm.submitApply = function(){
          if($scope.applyForm.$valid){
        	   if(vm.applyBtn){
        		   vm.applyBtn = false;
                   var data = {companyName:vm.company,contactName:vm.name,
                       cellphone:vm.phone,companyPhone:vm.telHeader+'-'+vm.telTail,
                       city:vm.province.label+''+vm.city.label+''+vm.area.label,
                       companyAddress:vm.detail,companyInfo:vm.summary,checkCode:vm.validCode};                 	
                   $.ajax({
                   			url:'apply',
                   			method:'post',
                   			type:'json',
                   			data:data,
                   			success:function(data){
                   				$($document[0]).scrollTop(0);
                   				if('ok'==data.status){
                   					changebz2Active();
        	                        oDiv1.animate({left:-1000},500,function(){
        	                              oDiv2.animate({left:100},500);
        	                         });
                   				}else{
                   					var error = '';
                					for(obj in data.error){
                						error += data.error[obj]+',';
                					}
                					alert(error);
                   				}
                   				
                   			},
                   			complete:function(data){
                   				vm.applyBtn = true;
                   			},
                   			error:function(){
                   				//;
                   			}
                   		});
        	   }
           }else{
               if($scope.applyForm.company.$invalid){
            	   $scope.applyForm.company.$dirty = true;
               }else if($scope.applyForm.name.$invalid){
            	   $scope.applyForm.name.$dirty = true;
               }else if($scope.applyForm.phone.$invalid){
            	   $scope.applyForm.phone.$dirty = true;
               }else if($scope.applyForm.validCode.$invalid){
            	   $scope.applyForm.validCode.$dirty = true;
               }else if($scope.applyForm.telHeader.$invalid){
            	   $scope.applyForm.telHeader.$dirty = true;
               }else if($scope.applyForm.telTail.$invalid){
            	   $scope.applyForm.telTail.$dirty = true;
               }else if($scope.applyForm.province.$invalid){
            	   $scope.applyForm.province.$dirty = true;
               }else if($scope.applyForm.city.$invalid){
            	   $scope.applyForm.city.$dirty = true;
               }else if($scope.applyForm.area.$invalid){
            	   $scope.applyForm.area.$dirty = true;
               }if($scope.applyForm.detail.$invalid){
            	   $scope.applyForm.detail.$dirty = true;
               }else if($scope.applyForm.summary.$invalid){
            	   $scope.applyForm.summary.$dirty = true;
               }
               
           }
        }
        //send MSM verifyCode    
        vm.keyBtn = true;
        var sendMessBtn = $("#sendMessBtn");
        var Countdown = $("#Countdown");
        vm.CountdownTip = 60;
        Countdown.hide();
        vm.getSMSVerify = function(){
            if($scope.applyForm.phone.$valid){
               if(vm.keyBtn){
                   vm.keyBtn = false;
                   sendMessBtn.hide();
                   Countdown.show();
                   vm.timer = $interval(function(){
                	   if(vm.CountdownTip==1){
                		   sendMessBtn.show();
                           Countdown.hide();
                           vm.CountdownTip = 60;
                           $interval.cancel(vm.timer);
                           vm.keyBtn = true;
                	   }
                	   vm.CountdownTip--;
                   },1000);
                   //var data = {cellphone:vm.phone};
                 $.ajax({
                	  url:'../sendCheckCode',
                	  method:'post',
                	  data:{cellphone:vm.phone},
                	  success:function(){
                		  
                	  },
                	  error:function(){
                		  
                	  }
                  });
               }
            }else{
                $scope.$watch('$scope.applyForm.phone.$dirty',function(){
                    $scope.applyForm.phone.$dirty = true;
                });
            }
        }
    }]);

