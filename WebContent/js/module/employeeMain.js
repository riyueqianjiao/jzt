angular.module('employeeMain',['ngRoute','myRoute','employeeDirective','myService'])
    .controller('employee.ctrl',['$scope','$location',function($scope,$location){
        var vm = $scope.vm = {};
        var url = $location.url().substring(1);
        //console.log();
        if('ybmhd'==url){//已申请职位
            vm.iNow = 0;
        }else if('pjhd'==url){//评价工作
        	vm.iNow = 1;
        }else if('info'==url){//完善简历
            vm.iNow = 2;
        }else if('updatepass'==url){//修改密码
            vm.iNow = 3;
        }else{//默认进入已申请职位
            vm.iNow = 2;
        }
      //显示和隐藏折叠框
        vm.list = [true,false];//建立一个数组存储当前列表状态是显示还是隐藏
        $(".ul-inner").css({height:0});
        $(".ul-inner")[0].style.height = 3*40+'px';
        vm.unfoldBtn = true;
        vm.unfold = function(index){
        	if(vm.unfoldBtn){
				vm.unfoldBtn = false;
				var length = $($(".ul-inner")[0]).find('li').length;
	        	if(vm.list[index]){
	        		vm.list[index] = !vm.list[index];
	        		$($(".ul-inner")[index]).animate({
	            		height:0
	            	},500,function(){
	            		 vm.unfoldBtn = true;
	            	});
	        	}else{
	        		vm.list[index] = !vm.list[index];
	        		$($(".ul-inner")[index]).animate({
	            		height:40*length
	            	},500,function(){
	            		 vm.unfoldBtn = true;
	            	});
	        	}
        	}
        }
    }])
    .controller('employee.ybmhd.ctrl',['$scope','modalService','loaderService','modalSuccessService','$timeout','modalService2','modalSessionService','modalConfirm','$compile','modalService3',function($scope,modalService,loaderService,modalSuccessService,$timeout,modalService2,modalSessionService,modalConfirm,$compile,modalService3){
    	 //处理session 是否过期
    	var oSessionDiv = document.getElementById('session');
    	if(oSessionDiv){
    		modalSessionService.showModal();
    		$timeout(function(){
    			location.href = 'login';
    		},2000);
    		return ;
    	}
    	
    	//分页和加载数据
    	var vm = $scope.vm = {};
		vm.totalNum = parseInt($("#totalNum").val());
		if(vm.totalNum){
			vm.pageList = [];
			vm.currPage = 1;
	    	vm.totalPage = vm.totalNum%10==0?(vm.totalNum/10):Math.floor(vm.totalNum/10)+1;	    	
	    	if(vm.totalPage<=9){
				for(var i=1;i<=vm.totalPage;i++){
					vm.pageList.push(i);
				}
			}else{
				getPageList(vm.currPage);
			}
		}
    	function getPageList(currPage){
    		vm.pageList = [];
			if(currPage<=5){
				for(var i=1;i<=9;i++){
					if(i<=vm.totalPage){
						vm.pageList.push(i);
					}
    			}
			}else if(vm.totalPage-currPage>4&&currPage>5){
				vm.pageList.push('首页');
				for(var i=currPage-4;i<=currPage+4;i++){
					vm.pageList.push(i);
				}
				vm.pageList.push('下一页');
			}else if(vm.totalPage-currPage<=4){
				vm.pageList.push('首页');
				for(var i=vm.totalPage-8;i<=vm.totalPage;i++){
					vm.pageList.push(i);
				}
			}
    	}
    	
    	vm.changePage = function(list){
    		if(list=='下一页'){
    			vm.currPage++;
    		}else if(list=='首页'){
    			vm.currPage = 1;
    		}else{
    			vm.currPage = list;
    		}
    		if(vm.currPage<=vm.totalPage){
	    		vm.getData();
    		}
    	}
       //加载数据方法       
        vm.getDataBtn = true;
        vm.getData = function(){
        	if(vm.getDataBtn){
        		vm.getDataBtn = false;
        		loaderService.showLoader();
        		$.ajax({
        			method:'get',
        			url:'../signup/show/page/'+vm.currPage,
        			type:'json',
        			success:function(data){
        				if('ok'==data.status){
        					var data = data.publications;
        					var oTr = '';
        					for(var i=0;i<data.length;i++){
        						var type = '';
        						if(data[i].state==0){
        							type = '报名未截止';
        						}
        						else if(data[i].state==1){
        							type = '报名已结束';
        						}else if(data[i].state==2){
        							type = '商家申请取消中';
        						}else if(data[i].state==3){
        							type = '活动已取消';
        						}else{
        							type="活动已结束";
        						}
        						var operator = '';
        						if(data[i].state!=3&&data[i].state!=4){
        							operator = '取消报名';
        						}
        						var salaryWay = '/天';
        						if(data[i].isLong){
        							salaryWay = '/月';
        						}
        						console.log(data)
        						oTr += '<tr>'+        						
        						'<td><a href="../publication/'+data[i].publicationId+'" target="_blank">'+data[i].title.substring(0,11)+'</a></td>'+
        		  				'<td>'+data[i].startDate+'&nbsp;'+data[i].workTimeInfo+'</td>'+
        		  				'<td>'+data[i].salary+salaryWay+'</td>'+
        		  				'<td><abbr title='+data[i].workAddress+'>'+data[i].workAddress.substring(0,19)+'</abbr></td>'+
        		  				'<td>报名成功，'+type+'</td>'+
        		  				'<td><a ng-click="vm.getDetail('+data[i].publicationId+')">报名详情</a>&nbsp;<a ng-click="vm.showConfirmModal('+data[i].publicationId+')">'+operator+'</a></td>'+
        		  			'</tr>';
        					}
        					var oTbody = $(".center-r-content table tbody");
    			    		oTbody.empty().append($compile(oTr)($scope));
        				}else if('error'==data.status){
        					var error = '';
        					for(obj in data.error){
        						error += data.error[obj]+',';
        					}
        					$(".modal-tip-error .modal-confirm-content").text(error);
    	               		modalService.showModal();
        				}else{
        					modalSessionService.showModal();
            				$timeout(function(){
        						location.href="../employer/login";
            				},1500);
        				}
        			},
        			complete:function(){
        				getPageList(vm.currPage);
        				loaderService.hideLoader();
        				vm.getDataBtn = true;
        			},
        			error:function(){
        				//;
        			}
        		});
        	}
        }
        vm.closeModal = function(){
       		modalService.hideModal();
       		modalService2.hideModal();
       		modalService3.hideModal();
       		modalConfirm.hideModal();
        }
    	
    	//checkbox 全选和取消操作
    	vm.isSelectType = "全选";
    	vm.checked = false;
    	vm.selectAll = function(){
    		if(vm.isSelectType=='全选'){
    			vm.checked = true;
    			vm.isSelectType = "取消";
    		}else{
    			vm.checked = false;
    			vm.isSelectType = '全选';
    		}
    		
    	}
    	
    	//显示提示框
    	vm.publicationId = 0;
    	vm.showConfirmModal = function(id){
    		vm.publicationId = id;
    		modalConfirm.showModal();
    	}
    	vm.showDataModalBtn = true;
    	vm.showDataModal = function(){
    		modalConfirm.hideModal();
    		if(vm.showDataModalBtn){
    			vm.showDataModalBtn = false;
    			vm.isSelectType = "全选";
    			vm.acitivitiesList = [];//每次请求先制空
    			var data = {publicationId:vm.publicationId};
    			loaderService.showLoader();
    			$.ajax({
    				method:'get',
    				url:'../signup/showActivity',
    				data:data,
    				type:'json',
    				success:function(data){
    					if('ok'==data.status){
    						//f5
    						vm.activitiesNum = data.activities.length;
    						for(var i=0;i<data.activities.length;i++){
    							vm.acitivitiesList.push({
    								time:data.activities[i].workDate,
    								salary:data.activities[i].salary,
    								id:data.activities[i].activityId,
    								isCancle:judgeTime(data.activities[i].workDate)
    							});
    						}
    						
    					}else if('error'==data.status){
    						//;
    						var str = "";
                       		for(obj in data.error){
                       			str += data.error[obj]+'，';
                       		}
                       		$(".modal-tip-error .modal-confirm-content").text(str);
                       		modalService.showModal();
    					}else{
    						modalSessionService.showModal();
            				$timeout(function(){
        						location.href="login";
            				},1500);
    					}
    				},
    				complete:function(){
    					vm.showDataModalBtn = true;
    					loaderService.hideLoader();//关闭loader
    					$timeout(function(){
    						$(".modal-cancle-signUp").css({
            	        		height:136+vm.activitiesNum*40
            	        	});
                			modalService2.showModal();
    					},500);
    				},
    				error:function(){
    					//;
    				}
    			});
    		}
    		
    	}
    	//确认取消报名
    	vm.confirmCancleBtn = true;
    	vm.confirmCancle = function(){
    		var oCheckBox = $(".modal-cancle-signUp input[type=checkbox]:checked");
    		if(oCheckBox.length){
    			if(vm.confirmCancleBtn){
    				loaderService.showLoader();
        			vm.confirmCancleBtn = false;
        			var data = {};
        			data.activityIds = '';
        			var ids = '';
        			oCheckBox.each(function(index,obj){
        				if(index!=oCheckBox.length-1){
        					ids += obj.value+',';
        				}else{
        					ids += obj.value;
        				}    				
        			});
        			data.activityIds = ids;
        			data.publicationId = vm.publicationId;
        			loaderService.showLoader();
        			$.ajax({
        				method:'post',
        				url:'../signup/cancelSignup',
        				data:data,
        				type:'json',
        				success:function(data){
        					if('ok'==data.status){
        						//f5
        						modalSuccessService.showModal();
        						$timeout(function(){
        							location.reload(true);
        						},1500);
        					}else if('error'==data.status){
        						//;
        						var str = "";
                           		for(obj in data.error){
                           			str += data.error[obj]+'，';
                           		}
                           		$(".modal-tip-error .modal-confirm-content").text(str);
                           		modalService.showModal();
        					}else{
        						modalSessionService.showModal();
                				$timeout(function(){
            						location.href="login";
                				},1500);
        					}
        				},
        				complete:function(){
        					vm.confirmCancleBtn = true;
        					loaderService.hideLoader();//关闭loader
        					modalService2.hideModal();//关闭modal框
        				},
        				error:function(){
        					//;
        				}
        			});
        		}
    		}else{
    			alert('请至少选择一天进行取消！');
    		}
    	}
    	//判断时间是否符合取消
        function judgeTime(time){
        	var date = new Date();
        	var timeList = time.split('-');
        	var month = date.getMonth()+1;
        	var day = date.getDate();
        	if(parseInt(timeList[1])>month){
        		return true;
        	}else if(parseInt(timeList[1])===month){
        		if(parseInt(timeList[2])>day){
        			return true;
        		}
        	}
        	return false;
        }
       //显示报名详情
        vm.getDetailBtn = true;
        vm.getDetail = function(id){
        	if(vm.getDetailBtn){
        		vm.getDetailBtn = false;
        		vm.acitivitiesList = [];//每次请求先制空
    			var data = {publicationId:id};
    			loaderService.showLoader();
    			$.ajax({
    				method:'get',
    				url:'../signup/showActivity',
    				data:data,
    				type:'json',
    				success:function(data){
    					if('ok'==data.status){
    						//f5
    						vm.activitiesNum = data.activities.length;
    						for(var i=0;i<data.activities.length;i++){
    							vm.acitivitiesList.push({
    								time:data.activities[i].workDate,
    								salary:data.activities[i].salary,
    								id:data.activities[i].activityId,
    								isCancle:judgeTime(data.activities[i].workDate)
    							});
    						}
    						console.log(vm.acitivitiesList)
    					}else if('error'==data.status){
    						//;
    						var str = "";
                       		for(obj in data.error){
                       			str += data.error[obj]+'，';
                       		}
                       		$(".modal-tip-error .modal-confirm-content").text(str);
                       		modalService.showModal();
    					}else{
    						modalSessionService.showModal();
            				$timeout(function(){
        						location.href="login";
            				},1500);
    					}
    				},
    				complete:function(){
    					vm.getDetailBtn = true;
    					loaderService.hideLoader();//关闭loader
    					$timeout(function(){
    						$(".modal-detail-signUp").css({
            	        		height:136+vm.activitiesNum*40
            	        	});
                			modalService3.showModal();
    					},500);
    				},
    				error:function(){
    					//;
    				}
    			});
        	}
        }
    }])
     .controller('employee.pjhd.ctrl',['$scope','modalService','loaderService','$timeout','modalSessionService','$compile',function($scope,modalService,loaderService,$timeout,modalSessionService,$compile){
    	
        var oSessionDiv = document.getElementById('session');
    	if(oSessionDiv){
    		modalSessionService.showModal();
    		$timeout(function(){
    			location.href = 'login';
    		},2000);
    		return ;
    	}
		var vm = $scope.vm = {};
		vm.totalNum = parseInt($("#totalNum").val());
		if(vm.totalNum){
			vm.pageList = [];
			vm.currPage = 1;
	    	vm.totalPage = vm.totalNum%10==0?vm.totalNum/10:Math.floor(vm.totalNum/10)+1;
	    	if(vm.totalPage<=9){
				for(var i=1;i<=vm.totalPage;i++){
					vm.pageList.push(i);
				}
			}else{
				getPageList(vm.currPage);
			}
		}
    	function getPageList(currPage){
    		vm.pageList = [];
			if(currPage<=5){
				for(var i=1;i<=9;i++){
					if(i<=vm.totalPage){
						if(i<=vm.totalPage){
							vm.pageList.push(i);
						}
					}
    			}
			}else if(vm.totalPage-currPage>4&&currPage>5){
				vm.pageList.push('首页');
				for(var i=currPage-4;i<=currPage+4;i++){
					vm.pageList.push(i);
				}
				vm.pageList.push('下一页');
			}else if(vm.totalPage-currPage<=4){
				vm.pageList.push('首页');
				for(var i=vm.totalPage-8;i<=vm.totalPage;i++){
					vm.pageList.push(i);
				}
			}
    	}
    	
    	vm.changePage = function(list){
    		if(list=='下一页'){
    			vm.currPage++;
    		}else if(list=='首页'){
    			vm.currPage = 1;
    		}else{
    			vm.currPage = list;
    		}
    		if(vm.currPage<=vm.totalPage){
	    		vm.getData();
    		}
    	}
       //加载数据方法       
        vm.getDataBtn = true;
        vm.getData = function(){
        	if(vm.getDataBtn){
        		vm.getDataBtn = false;
        		loaderService.showLoader();
        		$.ajax({
        			method:'get',
        			url:'../signup/showRemarkable/page/'+vm.currPage,
        			type:'json',
        			success:function(data){
        				if('ok'==data.status){
        					var data = data.publications;
        					var oTr = '';
        					for(var i=0;i<data.length;i++){
        						oTr += '<tr>'+
        						'<td>'+data[i].title.substring(0,11)+'</td>'+
        						'<td>'+data[i].startDate+'&nbsp;'+data[i].workTimeInfo+'</td>'+		
        		  				'<td><abbr title='+data[i].workAddress+'>'+data[i].workAddress.substring(0,19)+'</abbr></td>'+
        		  				'<td>活动已结束</td>'+
        		  				'<td><a ng-href="#comment/'+data[i].publicationId+'">开始评价</a></td>'+
        		  			'</tr>';
        					}
        					var oTbody = $(".center-r-content table tbody");
        					oTbody.empty().append($compile(oTr)($scope));
        				}else if('error'==data.status){
        					var error = '';
        					for(obj in data.error){
        						error += data.error[obj]+',';
        					}
        					$(".modal-tip-error .modal-confirm-content").text(error);
    	               		modalService.showModal();
        				}else{
        					modalSessionService.showModal();
            				$timeout(function(){
        						location.href="../employer/login";
            				},1500);
        				}
        			},
        			complete:function(){
        				getPageList(vm.currPage);
        				loaderService.hideLoader();
        				vm.getDataBtn = true;
        			},
        			error:function(){
        				//;
        			}
        		});
        	}
        }
        vm.closeModa = function(){
       		modalService.hideModal();
        }
    }])
   .controller('employee.info.ctrl',['$scope','modalService','loaderService','modalSuccessService','$timeout','modalSessionService',function($scope,modalService,loaderService,modalSuccessService,$timeout,modalSessionService){
    	
        //处理session 是否过期
    	var oSessionDiv = document.getElementById('session');
    	if(oSessionDiv){
    		modalSessionService.showModal();
    		$timeout(function(){
    			location.href = 'login';
    		},2000);
    		return ;
    	}
    	
    	var vm = $scope.vm = {};
    	vm.isShow = false;//隐藏ul
    	vm.clickUpdate = '点击修改';
    	vm.changeType = function(){
    		if(vm.clickUpdate == '点击修改'){
    			vm.clickUpdate = '取消修改';
    			vm.isShow = true;
    		}else{
    			vm.clickUpdate = '点击修改';
    			vm.isShow = false;
    		}
    	}
    	//提交公司修改信息
    	
    	vm.updateInfoBtn = true;
    	vm.sex="M";
    	vm.updateInfo = function(){
    		if(vm.updateInfoBtn){
    			vm.updateInfoBtn = false;
            	var data = {employeeName:vm.name,gender:vm.sex};
            	loaderService.showLoader();//关闭loader
            	$.ajax({
            		url:'update',
            		method:'post',
            		data:data,
            		success:function(data){
            			if('ok'==data.status){
            				//f5
    						modalSuccessService.showModal();
    						$timeout(function(){
    							location.reload(true);
    						},1500);
            			}else if('error'==data.status){
            				//;
    						var str = "";
                       		for(obj in data.error){
                       			str += data.error[obj]+'，';
                       		}
                       		$(".modal-tip-error .modal-confirm-content").text(str);
                       		modalService.showModal();
            			}else{
            				modalSessionService.showModal();
            				$timeout(function(){
        						location.href="login";
            				},1500);
            			}
            		},
            		complete:function(){
            			vm.updateInfoBtn = true;
						loaderService.hideLoader();//关闭loader
            		},
            		error:function(){
            			
            		}
            	});
    		}
    	}
    	vm.closeModal = function(){
    		modalService.hideModal();
    	}
    }])
     .controller('employee.updatePass.ctrl',['$scope','modalService','loaderService','modalSuccessService','$timeout','modalSessionService',function($scope,modalService,loaderService,modalSuccessService,$timeout,modalSessionService){
    	
    	var oSessionDiv = document.getElementById('session');
    	if(oSessionDiv){
    		modalSessionService.showModal();
    		$timeout(function(){
    			location.href = 'login';
    		},2000);
    		return ;
    	}
    	
    	var vm = $scope.vm = {};
    	//使用密码修改密码
    	vm.updatePassBtn = true;
    	vm.updatePass = function(){
    		if(vm.updatePassBtn){
    			if(vm.password!=vm.oldPass&&vm.password.length>=6){
    				vm.updatePassBtn = false;
    				var data = {oldPassword:vm.oldPass,newPassword:vm.password};
    				$.ajax({
        				url:'updatepass',
        				method:'post',
        				data:data,
        				success:function(data){
        					if('ok'==data.status){
        						modalSuccessService.showModal();
        						$timeout(function(){
        							location.reload(true);
        						},500);
        					}else if('error'==data.status){
        						var str = "";
                           		for(obj in data.error){
                           			str += data.error[obj];
                           		}
                           		$(".modal-tip-error .modal-confirm-content").text(str);
                           		modalService.showModal();
        					}else{
        						modalSessionService.showModal();
                				$timeout(function(){
            						location.href="../employer/login";
                				},1500);
        					}
        				},
        				complete:function(){
        					vm.updatePassBtn = true;
        					loaderService.hideLoader();
        				},
        				error:function(){
        					//;
        				}
        			});
    			}else if(vm.password==vm.oldPass){
    				$(".modal-tip-error .modal-confirm-content").text('新旧密码不能一样，请更改新密码');
               		modalService.showModal();
    			}else{
    				$(".modal-tip-error .modal-confirm-content").text('密码长度应为6-20位');
               		modalService.showModal();
    			}
    		}
    	}
    	
    	vm.closeModal = function(){
    		modalService.hideModal();
    	}
    	
    }])
    //用户评论ctrl
    .controller('employee.comment.ctrl',['$scope','$location','loaderService','modalSuccessService','modalSessionService','modalService','$timeout',function($scope,$location,loaderService,modalSuccessService,modalSessionService,modalService,$timeout){
    	
    	var oSessionDiv = document.getElementById('session');
    	if(oSessionDiv){
    		modalSessionService.showModal();
    		$timeout(function(){
    			location.href = 'login';
    		},2000);
    		return ;
    	}
    	
    	var vm = $scope.vm = {};
    	var url = $location.url().substring(1);
    	vm.workExponent = 0;//工作指数
    	vm.salaryExponent = 0;//工资指数
    	vm.commentNum = 0;//评论数字总数
    	vm.content = '';
    	//提交评论
    	vm.sumbitCommentBtn = true;
    	vm.sumbitComment = function(){
    		if(vm.sumbitCommentBtn){
    				vm.sumbitCommentBtn = false;
    				var data = {publicationId:url.split('/')[1],workPoint:vm.workExponent,salaryPoint:vm.salaryExponent,other:vm.content};
    				loaderService.showLoader();
        			$.ajax({
        				url:'../comment/comment',
        				method:'post',
        				data:data,
        				success:function(data){
        					if('ok'==data.status){
        						modalSuccessService.showModal();
             					$timeout(function(){
             						modalSuccessService.hideModal();
             						history.go(-1);
             					},1500);
        					}else if('error'==data.status){
        						var error = '';
            					for(obj in data.error){
            						error += data.error[obj]+',';
            					}
            					$(".modal-tip-error .modal-confirm-content").text(error);
                           		modalService.showModal();
        					}else{
        						modalSessionService.showModal();
                				$timeout(function(){
            						location.href="../employee/login";
                				},1500);
        					}
        				},
        				complete:function(){
        					loaderService.hideLoader();
        					vm.sumbitCommentBtn = true;
        				},
        				error:function(){
        					//;
        				}
        				
        			});
    		}
    	}
    	
    	//关闭弹出框
    	vm.closeModal = function(){
    		modalService.hideModal();
    	}
    }]);


