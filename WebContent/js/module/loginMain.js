angular.module('loginMain',['myService'])
    .controller('login.employer.ctrl',['$scope','modalService',function($scope,modalService){
    	var vm = $scope.vm = {};
    	vm.account = '';
    	vm.password = '';
    	vm.oBtn = true;
    	vm.login = function(){
    		if($scope.loginForm.$valid){
    			if(vm.oBtn){
    				vm.oBtn = false;
        			var data = {id:vm.account,password:vm.password,imagecode:vm.verifyCode};
        			$.ajax({
        				type:'json',
        				url:'login',
        				data:data,
        				method:'post',
        				success:function(data){
        					if('ok'==data.status){
        						//跳转进商家个人中心
        						location.href= 'center';
        					}else{
        						var str = "";
                           		for(obj in data.error){
                           			str += data.error[obj];
                           		}
                           		 //alert(str);
                           		$(".modal-tip-error .modal-confirm-content").text(str);
                           		modalService.showModal();
        					}
        				},
        				complete:function(){
        					vm.oBtn = true;
        				},
        				error:function(){
        					alert('网络出现异常，请刷新页面重试！');
        				}
        			});
    			}
    		}else{
    			if($scope.loginForm.account.$invalid){
    				$(".modal-tip-error .modal-confirm-content").text('请输入用户名');
               		modalService.showModal();
    			}else if($scope.loginForm.password.$invalid){
    				$(".modal-tip-error .modal-confirm-content").text('密码长度应为6-20位');
               		modalService.showModal();
    			}else if($scope.loginForm.verifyCode.$invalid){
    				$(".modal-tip-error .modal-confirm-content").text('请输入验证码');
               		modalService.showModal();
    			}
    		}
    	}
    	vm.keyUp = function(ev){
    		if(ev.keyCode==13){
    			vm.login();
    		}
    	}
    	vm.closeModal = function(){
    		modalService.hideModal();
    	}
    }])
    .controller('employee.login.ctrl',['$scope','modalService',function($scope,modalService){
    	var vm = $scope.vm = {};
    	vm.submitBtn = true;
    	vm.submit = function(){
    		if($scope.loginForm.$valid){
    			if(vm.submitBtn){
    				vm.submitBtn = false;
    				var data = {cellphone:vm.phone,password:vm.password,imagecode:vm.verifyCode};
    				console.log(data)
    				$.ajax({
    					url:'login',
    					method:'post',
    					type:'json',
    					data:data,
    					success:function(data){
    						if('ok'==data.status){
    							location.href="../index";
    						}else{
    							var str = "";
	                       		for(obj in data.error){
	                       			str += data.error[obj];
	                       		}
	                       		 //alert(str);
	                       		$(".modal-tip-error .modal-confirm-content").text(str);
	                       		modalService.showModal();
    						}
    						
    					},
    					complete:function(){
    						vm.submitBtn = true;
    					},
    					error:function(){
    						//;
    					}
    				});
    			}
    		}else{
    			if($scope.loginForm.phone.$invalid){
    				$(".modal-tip-error .modal-confirm-content").text('请输入手机号');
               		modalService.showModal();
    			}else if($scope.loginForm.password.$invalid){
    				$(".modal-tip-error .modal-confirm-content").text('密码长度应为6-20位');
               		modalService.showModal();
    			}else if($scope.loginForm.verifyCode.$invalid){
    				$(".modal-tip-error .modal-confirm-content").text('请输入验证码');
               		modalService.showModal();
    			}
    		}
    	}
    	
    	vm.keyUp = function(ev){
    		if(ev.keyCode==13){
    			vm.submit();
    		}
    	}
    	vm.closeModal = function(){
    		modalService.hideModal();
    	}
    }]);


