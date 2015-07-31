angular.module('detailMain',['myService'])
    .controller('detail.signUp.ctrl',['$scope','modalService','modalSessionService','modalConfirm',function($scope,modalService,modalSessionService,modalConfirm){
        var vm = $scope.vm = {};
        vm.showConfirm = function(){
        	modalConfirm.showModal();
        }
        
        //弹出选择某一天报名框
        vm.chooseSignUpDay = function(){
        	var oCheckBox = $('.modal-signUp input[type=checkbox]');
            var oModal = $(".modal-signUp");
            oModal.css({
                height:136+oCheckBox.length*40
            });
            //高度是要动态修改的
        	modalService.showModal();
        }
    }])
    .controller('detail.confirmAllDay.ctrl',['$scope','modalService','modalService2','loaderService','modalSuccessService','modalSessionService','$timeout','modalConfirm',function($scope,modalService,modalService2,loaderService,modalSuccessService,modalSessionService,$timeout,modalConfirm){
    	var vm = $scope.vm = {};
    	vm.closeModal = function(){
    		modalConfirm.hideModal();
        }
    	vm.signUpBtn = true;
        vm.signUpAllDay = function(){
        	modalConfirm.hideModal();
        	if(vm.signUpBtn ){
        		vm.signUpBtn = false;
        		var oCheckBox = $('.modal-signUp input[type=checkbox]');
        		var data = {};
        		data.activityIds = '';
        		var ids = '';
        		oCheckBox.each(function(index,obj){
        			if(index<oCheckBox.length-1){
        				ids += obj.value+',';
        			}else{
        				ids += obj.value;
        			}
        		});
        		var oTimes = $('.modal-signUp tbody .first');
        		var times = '';
        		oTimes.each(function(index,obj){
        			if(index<oCheckBox.length-1){
        				times += obj.innerHTML+',';
        			}else{
        				times += obj.innerHTML;
        			}
        		});
        		data.workDates = times;
        		data.activityIds = ids;
        		data.publicationId = $("#publicationId").val();
        		loaderService.showLoader();
            	$.ajax({
            		method:'post',
            		url:'../signup/signup',
            		data:data,
            		type:'json',
            		success:function(data){
            			if('ok'==data.status){
            				modalSuccessService.showModal();
        					$timeout(function(){
        						location.href = '../employee/center';
        					},1000);
            			}else if('error'==data.status){
            				var error = '';
        					for(obj in data.error){
        						error += data.error[obj]+',';
        					}
        					$(".modal-tip-error .modal-confirm-content").text(error);
                       		modalService2.showModal();
            			}else{
            				$(".modal-tip-error .modal-confirm-content").text("您还未登陆，请先登陆！");
                       		modalService2.showModal();
            			}
            		},
            		complete:function(){
            			vm.signUpBtn = true;
            			loaderService.hideLoader();
            		},
            		error:function(){
            			//;
            		}
            	});
        	}else{
        		//;
        	}
        }
    }])
    .controller('detail.error.ctrl',['$scope','modalService2',function($scope,modalService2){
    	var vm = $scope.vm = {}; 
    	vm.closeModal = function(){
     		modalService2.hideModal();
     	}
    }])
    .controller('detail.confirmModal.ctrl',['$scope','modalService','modalService2','loaderService','modalSuccessService','modalSessionService','$timeout',function($scope,modalService,modalService2,loaderService,modalSuccessService,modalSessionService,$timeout){
        var vm = $scope.vm = {};
        vm.hideDailog = function(){
        	modalService.hideModal();
        }
        //确认报名
        vm.confirmUpdateBtn = true;
        vm.confirmUpdate = function(){
        	if(vm.confirmUpdateBtn){
        		var oCheckBox = $('.modal-signUp input[type=checkbox]:checked');
                if(oCheckBox.length){
                	vm.confirmUpdateBtn = false;
                	var data = {};
            		data.activityIds = '';
            		var ids = '';
            		oCheckBox.each(function(index,obj){
            			if(index<oCheckBox.length-1){
            				ids += obj.value+',';
            			}else{
            				ids += obj.value;
            			}
            		});
            		var oTimes = $('.modal-signUp tbody .first');
            		var times = '';
            		oTimes.each(function(index,obj){
            			if(index<oCheckBox.length-1){
            				times += obj.innerHTML+',';
            			}else{
            				times += obj.innerHTML;
            			}
            		});
            		data.workDates = times;
            		data.activityIds = ids+'';
            		data.publicationId = $("#publicationId").val();
            		modalService.hideModal();
            		$.ajax({
                		method:'post',
                		url:'../signup/signup',
                		data:data,
                		type:'json',
                		success:function(data){
                			if('ok'==data.status){
                				modalSuccessService.showModal();
            					$timeout(function(){
            						location.href = '../employee/center';
            					},1000);
                			}else if('error'==data.status){
                				var error = '';
            					for(obj in data.error){
            						error += data.error[obj]+',';
            					}
            					$(".modal-tip-error .modal-confirm-content").text(error);
                           		modalService2.showModal();
                			}else{
                				$(".modal-tip-error .modal-confirm-content").text("您还未登陆，请先登陆！");
                           		modalService2.showModal();
                			}
                		},
                		complete:function(){
                			vm.confirmUpdateBtn = true;
                			vm.signUpBtn = true;
                			loaderService.hideLoader();
                		},
                		error:function(){
                			//;
                		}
                	});
                }else{
                    alert("请至少选择一天进行报名！");
                }
        	}
        }
    }])
    .controller('detail.loaderMess.ctrl',['$scope','modalService2','$timeout',function($scope,modalService2,$timeout){
    	var vm = $scope.vm = {};
    	vm.type = 1;
    	vm.clickTimes = 1;
    	var oLoader = $("#loading");
    	vm.dataList = [];
    	vm.flag = true;
    	vm.id = 0;
    	vm.currPage = 1;
    	vm.totalNum = 0;
    	vm.totalPage = 0;
    	vm.changeType = function(type,id){
    		vm.type = type;
    		vm.id = id;
    		if(vm.clickTimes==1){
    			vm.clickTimes++;
    			oLoader.show();
    			vm.getData();
    		}else{
    			if(vm.type==1){
        			$("#comment .bm-mess").show(500);
        			$("#comment .comment-list").hide(500);
        		}else if(vm.type==2){
        			$("#comment .bm-mess").hide(500);
        			$("#comment .comment-list").show(500);
        		}
    		}
    	}
    	vm.getData = function(){
    		$.ajax({
				url:'../comment/viewComments',
				method:'get',
				data:{employerId:vm.id,flag:vm.flag,pageNum:vm.currPage},
				success:function(data){
					if('ok'==data.status){
						if(data.comments.length){
							for(var i=0;i<data.comments.length;i++){
								vm.dataList.push({
									phone:data.comments[i].cellphone,
									pointer:'工作环境指数：'+data.comments[i].workPoint+'分，工资发放速度：'+data.comments[i].salaryPoint+'分',
									content:data.comments[i].other,
									time:data.comments[i].time
								});
							}
						}else{
							//;没有数据
							vm.dataList = [];
						}
						if(vm.flag){
							vm.totalNum = parseInt(data.totalNum);
							$scope.$apply(function(){
								vm.totalPage = vm.totalNum/10==0?vm.totalNum/10:Math.floor(vm.totalNum/10)+1;
							});
							vm.flag = false;
						}
					}else if('error'==data.status){
						//;没有数据
						vm.dataList = [];
					}
				},
				complete:function(){
					$timeout(function(){
						oLoader.hide();
					},500);
					$("#comment .bm-mess").hide(500);
					$("#comment .comment-list").show(500);
				},
				error:function(){
					//;
				}
			});
    		vm.changePage = function(flag){
    			if(flag){
    				vm.currPage--;
    			}else{
    				vm.currPage++;
    			}
    			vm.dataList = [];
    			vm.getData();
    		}
    	}
    }]);
