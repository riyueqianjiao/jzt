angular.module('registerMain',['myService'])
    .controller('employee.register.ctrl',['$scope','$interval','$http','modalService','modalSuccessService','$timeout',function($scope,$interval,$http,modalService,modalSuccessService,$timeout){
        var vm = $scope.vm = {};
       // send msmcode value
        vm.keyBtn = true;
        var sendMessBtn = $("#sendMessBtn");
        var Countdown = $("#Countdown");
        vm.CountdownTip = 60;
        Countdown.hide();
        vm.getSMSVerify = function(){
            if($scope.registerForm.phone.$valid){
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
                   var data = {cellphone:vm.phone};
                  $.ajax({
                	  url:'../sendCheckCode',
                	  method:'post',
                	  data:data,
                	  success:function(){
                		  
                	  },
                	  error:function(){
                		  
                	  }
                  });
               }
            }else{
                $scope.$watch('$scope.registerForm.phone.$dirty',function(){
                    $scope.registerForm.phone.$dirty = true;
                });
            }
        }
        //submit form
        vm.submitBtn = true;
        vm.submitForm = function(){
            if($scope.registerForm.$valid){
                if(vm.submitBtn&&vm.password===vm.confirmPass){
                    vm.submitBtn = false;
                    var data = {cellphone:vm.phone,password:vm.password,gender:vm.sex,employeeName:vm.name,checkCode:vm.smsVerify};
                    $http.post('register',data,{
	                    headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
	                    transformRequest: transform
	                 })
                     .success(function(data){
                    	 if('ok'==data.status){
                    		 modalSuccessService.showModal();
                    		 $timeout(function(){
                    			 location.href="login";
                    		 },1500);
                    	 }else{
                    		 var str = "";
                    		 for(obj in data.error){
                    			 str += data.error[obj];
                    		 }
                    		 $(".modal-tip-error .modal-confirm-content").text(str);
                        	 modalService.showModal();
                    	 }
                        vm.submitBtn = true;
                     })
                     .error(function(data){
                        vm.submitBtn = true;
                     });
                    function transform(data){
                        return $.param(data);
                    }
                }else{
                	$scope.registerForm.confirmPass.$dirty = true;
                }
            }else{
            	if($scope.registerForm.phone.$invalid){
            		$scope.registerForm.phone.$dirty = true;
            	}else if($scope.registerForm.smsVerify.$invalid){
            		$scope.registerForm.smsVerify.$dirty = true;
            	}else if($scope.registerForm.name.$invalid){
            		$scope.registerForm.name.$dirty = true;
            	}else if($scope.registerForm.password.$invalid){
            		$scope.registerForm.password.$dirty = true;
            	}else if($scope.registerForm.confirmPass.$invalid){
            		$scope.registerForm.confirmPass.$dirty = true;
            	}
            }
        }
        vm.closeModal = function(){
        	 modalService.hideModal();
        }
        //
      
        vm.varifyPhone = function(){    	
    		if($scope.registerForm.phone.$valid){
        		$.ajax({
        			url:'isExisted',
        			method:'get',
        			data:{cellphone:vm.phone},
        			success:function(data){
        				console.log(data)
        				if('ok'==data.status){
        					$("#phone-is-userful").hide();
        				}else{
        					$("#phone-is-userful").show();
        				}
        			}
        		});
        	}else{
        		$("#phone-is-userful").hide();
        	}
        	
        }
    }])
    .controller('employer.register.ctrl',['$scope','$http','$timeout','modalService','modalSuccessService','$document',function($scope,$http,$timeout,modalService,modalSuccessService,$document){
        //alert(1);
    	var oDiv1 = $('.employer');
        var oDiv2 = $('.waitVerify ');
        var vm = $scope.vm = {};
        vm.hideForm = false;//form hiden
        vm.showTip = true;
        vm.showFormList = false;//显示隐藏的表单
        vm.bz2Active = '';
        vm.line2Active = '';
        function changebz2Active(){
            vm.bz2Active = 'active';
            vm.line2Active = 'active';
            vm.showTip = false;
        }
        vm.keyBtn = true;
        vm.sendKey = function(){
            if($scope.registerForm.key.$valid&&$scope.registerForm.phone.$valid){
               if(vm.keyBtn){
                    vm.keyBtn = false;
                    var data = {licenseNum:vm.key,cellphone:vm.phone};
                    $.ajax({
                    	type:'json',
                    	url:'../license/'+vm.key+"/"+vm.phone,
                    	method:'get',
                    	success:function(data){
                    		if(data.status=='ok'){
                    			var data = data.license;
                    			vm.companyInfo = data.companyInfo;
                    			vm.licenseNum = data.licenseNum;
                    			vm.phone = data.cellphone;
                    			vm.company = data.companyName;
                    			vm.name = data.contactName;
                    			vm.tel = data.companyPhone;
                    			vm.address = data.city;
                    			vm.detail = data.companyAddress;
                    			$scope.$apply(function(){vm.showFormList = true});
                    		}else{
             					$(".modal-tip-error .modal-confirm-content").text(data.error);
                           		modalService.showModal();
                    		}
                    	},
                    	complete:function(tx,err){
                    		//;
                    		 vm.keyBtn = true;
                    	},
                    	error:function(){
                    		//;
                    	}
                    });
                }
            }else{
            	if($scope.registerForm.phone.$invalid){
            		$scope.registerForm.phone.$dirty = true;
            	}else if($scope.registerForm.key.$invalid){
            		$scope.registerForm.key.$dirty = true;
            	}
            }
        }
        vm.closeModal = function(){
        	modalService.hideModal();
        }
        //submit employer register form
        vm.submitFormBtn = true;
        vm.submitForm = function(){
         if($scope.registerForm.$valid&&vm.password==vm.confirmPass){
                if(vm.submitFormBtn){
                    vm.submitFormBtn = false;
                    var data = {};
                    data.companyInfo = vm.companyInfo;
        			data.licenseNum = vm.licenseNum;
        			data.cellphone = vm.phone;;
        			data.companyName = vm.company;;
        			data.contactName = vm.name;;
        			data.companyPhone = vm.tel;;
        			data.city = vm.address;;
        			data.companyAddress = vm.detail;
        			data.employerName = vm.username;
        			data.password = vm.password;
                    $.ajax({
                    	url:'register',
                    	method:'post',
                    	type:'json',
                    	data:data,
                    	success:function(data){
                    		if('ok'==data.status){
                    			$($document[0]).scrollTop(0);
                    			changebz2Active();
                    	        oDiv1.animate({left:-1000},500,function(){
                    	              oDiv2.animate({left:200},500);
                    	         });
                    		}else{
                    			var error = '';
             					for(obj in data.error){
             						error += data.error[obj]+',';
             					}
             					$(".modal-tip-error .modal-confirm-content").text(error);
                           		modalService.showModal();
                    		}
                    	},
                    	complete:function(){
                    		 vm.hideForm = true;
                    	},
                    	error:function(){
                    		//;
                    	}
                    });
                }

         }
        }
    }]);
