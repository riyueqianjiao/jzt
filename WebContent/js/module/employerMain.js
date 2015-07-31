angular.module('employerMain',['ie.select','ngRoute','myRoute','employer.directive','myService','my.service.data'])
    .controller('employer.ctrl',['$scope','$location',function($scope,$location){
        var vm = $scope.vm = {};
        var url = $location.url().substring(1);
        vm.iNow = 0;
        if(url=='fbzw'){
            vm.iNow = 0;
        }else if(url=='yfbzw'){
            vm.iNow = 1;
        }else if(url=='yqxzw'){
            vm.iNow = 2;
        }else if(url=='info'){
            vm.iNow = 3;
        }else if(url=='updatePass'){
            vm.iNow = 4;
        }else if(url=='ywjzw'){
        	vm.iNow = 5;
        }else if('applycancel'==url.split('/')[0]){
        	 vm.iNow = 10;
        }else if('detail'==url.split('/')[0]){
        	 vm.iNow = 11;
        }
        //显示和隐藏折叠框
        vm.list = [true,false];//建立一个数组存储当前列表状态是显示还是隐藏
        $(".ul-inner").css({height:0});
        $(".ul-inner")[0].style.height = 5*40+'px';
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
    .controller('employer.fbzw.ctrl',['$scope','$http','loaderService','modalService','cityData','modalSuccessService','modalService2','$timeout','modalSessionService',function($scope,$http,loaderService,modalService,cityData,modalSuccessService,modalService2,$timeout,modalSessionService){
        //session 处理
    	var oSessionDiv = document.getElementById('session');
    	if(oSessionDiv){
    		modalSessionService.showModal();
    		$timeout(function(){
    			location.href = 'login';
    		},1500);
    		return ;
    	}
    	//focus--
    	$("#title").focus();
    	$("#title").val('');
    	var vm = $scope.vm = {};
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
        
        //
        //end
        var myDate = new Date();
        vm.endHour = 17;
        vm.startHour = 9;
        vm.startMinute = '00';
        vm.endMinute = '00';
        vm.isLong = false;
        vm.hourObj = [
            '00','01','02','03',
            '04','05','06','07',
            '08','09','10','11',
            '12','13','14','15',
            '16','17','18','19',
            '20','21','22','23'
        ];
        vm.salaryWayObj = [
            '/天','/时'
        ];
        vm.jsWayObj = [
            '按日结',
            '按次结'
        ]
        vm.minuteOjb = [
            '00','10','20','30','40','50'
        ];
        vm.content = '    如：男生要求170以上，女生165以上。衣服颜色为深色。应聘者可以无经验但工作必须认真、仔细、负责。因为我们有专车接送，所以希望大家不要乱跑，由我们统一在某个地点来接等等...';
        vm.transport = '';
        vm.zhusu = '';
        vm.extraWelfare = '';
        vm.dinner = '不包工作餐';
        vm.time = myDate.getFullYear()+'-'+addZero(myDate.getMonth()+1)+'-'+addZero(myDate.getDate());
        vm.timeDetail = '中午有两小时午休等...';
        vm.address= '';
        vm.salary = 100;
        vm.salaryWay = '/天';
        vm.jsWay = '日结';
        vm.maleNumber = 10;
        vm.femaleNumber = 10;
        vm.payWay = '线下支付';
        vm.title = '';
        vm.name = '';
        vm.phone = '';
        vm.days = 1;
        $scope.$watch('vm.maleNumber',function(){
            vm.number = parseInt(vm.maleNumber) + parseInt(vm.femaleNumber);
        });
        $scope.$watch('vm.femaleNumber',function(){
            vm.number = parseInt(vm.maleNumber) + parseInt(vm.femaleNumber);
        });
        //屏蔽用户在时间表单中输入数据
        vm.forbidTimeInput  = function(){
            vm.time = myDate.getFullYear()+'-'+addZero(myDate.getMonth()+1)+'-'+addZero(myDate.getDate());
        }
       
        vm.isRate = 0;
        vm.showRate = true;
        vm.judgeRateType = function(){
            if(vm.isRate==1){
                vm.showRate = false;
            }else{
                vm.showRate = true;
            }
        }
        //调整某一天工作时间
        vm.updateJobList = [];
        vm.addRecordTimes = 0;//可以修改3条记录
        vm.oldJobList = {};
        var modalDialog = $(".modal-fbzw");
        vm.adjustJob = function(){
            vm.addRecordTimes = 0;
            vm.updateJobList = [];
            vm.updateJobListStr = [];
            modalDialog.css({
                height:140
            });
            modalService.showModal();
            //initOldData();
        }
        vm.hideDailog = function(){
        	modalService.hideModal();
        }
        
        vm.addRecordBtn = true;
        vm.addRecordTimes = 0;
        vm.addRecord = function(){
        	if(vm.addRecordBtn){
        		vm.addRecordBtn = false;
        		vm.addRecordTimes++;
        		if(vm.addRecordTimes<=7){
        			vm.updateJobList.push({
                        time:parseTime(vm.time),
                        jtTime:parseInt(vm.startHour)+':'+vm.startMinute+'至'+parseInt(vm.endHour)+':'+vm.endMinute,
                        salary:parseInt(vm.salary),
                        address:vm.address,
                        isRate:parseInt(vm.isRate),
                        totalNumber:vm.number,
                        maleNumber:vm.maleNumber,
                        femaleNumber:vm.femaleNumber
                    });
        			modalDialog.animate({
                        height:modalDialog.height()+42
                    },function(){
                    	vm.addRecordBtn = true;
                    });
        		}else{
        			alert("最多只能修改7天数据");
        		}
        	}
        }
        vm.delRecord = function(index){
            vm.addRecordTimes--;
            vm.updateJobList.splice(index,1);
            var modalDialog = $(".modal-fbzw");
            modalDialog.animate({
                height:modalDialog.height()-42
            });
        }
        vm.updateJobListStr = [];
        vm.confirmUpdate = function(){
            var oTime = $('.updateTime');
            var oUpdateJTTime = $('.updateJTTime');
            var oUpdateSalary = $('.updateSalary');
            var oUpdateAddress = $('.updateAddress');
            oTime.each(function(index,obj){
                vm.updateJobListStr[index] = {};
                vm.updateJobListStr[index].time = reverseParseTime(obj.value);
            });
            oUpdateJTTime.each(function(index,obj){
                vm.updateJobListStr[index].jtTime = obj.value;
            });
            oUpdateSalary.each(function(index,obj){
                vm.updateJobListStr[index].salary = obj.value;
            });
            oUpdateAddress.each(function(index,obj){
                vm.updateJobListStr[index].address = obj.value;
            });
            if(vm.isRate==1){
                //分男女比例
                var oUpdateMaleNumber = $('.updateMaleNumber');
                var oUpdateFeMaleNumber = $('.updateFemaleNumber');
                oUpdateMaleNumber.each(function(index,obj){
                    vm.updateJobListStr[index].totalNum = parseInt(obj.value)+parseInt(oUpdateFeMaleNumber[index].value);
                    vm.updateJobListStr[index].maleNumber = obj.value;
                });
            }else{
                //不分男女比例
                var oUpdateTotalNum = $('.updateTotalNum');
                oUpdateTotalNum.each(function(index,obj){
                    vm.updateJobListStr[index].totalNum = obj.value;
                    vm.updateJobListStr[index].maleNumber = 0;
                });
            }
            vm.hideDailog();
        }
        //提交表单
        vm.submitBtn = true;
        vm.submit = function(){
            if(vm.submitBtn){
                vm.submitBtn = false;
                var startHour = vm.startHour;
                var startMinuter = vm.startMinute;
                var endHour = vm.endHour;
                var endMinute = vm.endMinute;
                var dinner = vm.dinner;
                var transport = vm.transport?'，有车专车接送':'';
                var zhusu = vm.zhusu?'，包住宿':'';
                var detail = dinner + transport + zhusu;
                var payWay = 0;
                if(vm.payWay=='线下支付'){
                    payWay = 0;
                }else if(vm.payWay=='线上支付'){
                    payWay = 1;
                }
                var isLong = vm.isLong?1:0;
                var data = {
                    contactName:vm.name,
                    cellphone:vm.phone,
                    recruitNum:parseInt(vm.number),
                    workAddress:vm.province.label+vm.city.label+vm.area.label+vm.address,
                    startTime:$("#time").val(),
                    workTimeInfo:startHour +':'+ startMinuter +'至'+ endHour +':'+ endMinute,               
                    salary:vm.salary,
                    paymentWay:payWay,
                    title:vm.title,
                    detail:detail,
                    requirement:vm.content,
                    isLong:isLong,
                    isGenderRequired:vm.isRate,
                    workType:$("#workType").val()
                }
                if(!vm.isLong){
                	data.workDuration = vm.days;
                	var jsWay = 0;
                    if(vm.jsWay==vm.jsWayObj[0]){
                        jsWay = 0;
                    }else if(vm.jsWay==vm.jsWayObj[1]){
                        jsWay = 1;
                    }
                    data.settlementWay = jsWay;
                }
                if(vm.isRate==1){
                    data.maleNum = parseInt(vm.maleNumber);
                }else{
                    data.maleNum = 0;
                }
                if(vm.updateJobListStr.length!=0){
                    //data.mes = changeObjToStr(vm.updateJobListStr)
                    data.mes = vm.updateJobListStr;
                }
                loaderService.showLoader();
                $http.post('../publication/add',data,{
                    headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
                    transformRequest: transform
                })
                 .success(function(data){
                	 loaderService.hideLoader();
                	 if('ok'==data.status){
     					modalSuccessService.showModal();
     					$timeout(function(){
     						location.reload(true);
     					},1000);
     				}else if('error'==data.status){
     					var error = '';
     					for(obj in data.error){
     						error += data.error[obj]+',';
     					}
     					$(".modal-tip-error .modal-confirm-content").text(error);
                   		modalService2.showModal();
     				}else{
     					modalSessionService.showModal();
         				$timeout(function(){
     						location.href="../employer/login";
         				},1500);
 					}
                    vm.submitBtn = true;
                 })
                 .error(function(data){
                    vm.submitBtn = true;
                 });
            }

        }
        vm.closeModal = function(){
        	modalService2.hideModal();
        }
        //将数据存储形式时间转换成几月几号
        function parseTime(str){
            str = str.split('-');
            return parseInt(str[1])+'月'+parseInt(str[2])+'号';
        }
        //将几月几号转换成数据存储形式时间
        function reverseParseTime(str){
            var index = str.indexOf('月');
            var month = str.substring(0,index);
            var day = str.substring(index+1,str.length-1);
            return myDate.getFullYear()+'-'+addZero(month)+'-'+addZero(day);
        }
        function addZero(str){
            return parseInt(str)>9?str:'0'+str;
        }
        function changeObjToStr(obj){
            var str = '['
            for(var i=0;i<obj.length;i++){
                str += '{';
                str += '"time":"'+obj[i].time+'",'+'"jsTime":"'+obj[i].jtTime+'",'+'"address":"'+obj[i].address+
                    '",'+'"salary":'+obj[i].salary+','+'"maleNumber":'+obj[i].maleNumber+','+'"totalNum"'+':'+obj[i].totalNum;
                if(i!= obj.length-1){
                    str += '},';
                }else{
                    str += '}';
                }
            }
            str += ']';
            return str;
        }
        function transform(data){
            return $.param(data);
        }
    }])
    .controller('employer.yfbzw.ctrl',['$scope','modalService','loaderService','$timeout','modalSessionService','$compile',function($scope,modalService,loaderService,$timeout,modalSessionService,$compile){
    	
        var oSessionDiv = document.getElementById('session');
    	if(oSessionDiv){
    		modalSessionService.showModal();
    		$timeout(function(){
    			location.href = 'login';
    		},1500);
    		return ;
    	}
		var vm = $scope.vm = {};
		vm.totalNum = parseInt($("#totalNum").val());
		vm.totalPage = vm.totalNum%10==0?vm.totalNum/10:Math.floor(vm.totalNum/10)+1;
		vm.currPage = 1;
		/*if(vm.totalNum){
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
		}*/
		getPageList(vm.currPage);
    	function getPageList(currPage){
    		vm.pageList = [];
    		if(vm.totalNum){
    	    	if(vm.totalPage<=9){
    				for(var i=1;i<=vm.totalPage;i++){
    					vm.pageList.push(i);
    				}
    			}else{
    				if(currPage<=5){
    					for(var i=1;i<=9;i++){
    						vm.pageList.push(i);
    	    			}
    					vm.pageList.push('下一页');
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
        			url:'../publication/private/page/'+vm.currPage+'/0',
        			type:'json',
        			success:function(data){
        				if('ok'==data.status){
        					var data = data.publications;
        					var oTr = '';
        					for(var i=0;i<data.length;i++){
        						var type = '';
        						if(data[i].state==0){
        							type = '正在报名中'
        						}else if(data[i].state==2){
        							type="申请取消中";
        						}
        						var operator = '';
        						if(data[i].state==0){
        							operator = '申请取消'
        						}else if(data[i].state==1){
        							operator="报名结束";
        						}
        						oTr += '<tr>'+
        						'<td><a href="../publication/'+data[i].publicationId+'" target="_blank">'+data[i].title.substring(0,11)+'</a></td>'+
        		  				'<td>'+data[i].publicationTime.substring(0,19)+'</td>'+
        		  				'<td>'+data[i].recruitmentTime+'</td>'+
        		  				'<td>'+data[i].contactName+'（'+data[i].cellphone+'）</td>'+
        		  				'<td><abbr title='+data[i].workAddress+'>'+data[i].workAddress.substring(0,19)+'</abbr></td>'+
        		  				'<td>'+type+'</td>'+
        		  				'<td><a>'+operator+'</a></td>'+
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
        				$scope.$apply(function(){
        					getPageList(vm.currPage);
        				});
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
        //显示详情
        vm.showDetail = function(id){
        	
        }
    }])
    .controller('employer.detail.ctrl',['$scope','$location','modalSessionService','modalService',function($scope,$location,modalSessionService,modalService){
    	var oSessionDiv = document.getElementById('session');
    	if(oSessionDiv){
    		modalSessionService.showModal();
    		$timeout(function(){
    			location.href = 'login';
    		},1500);
    		return ;
    	}
    	var vm = $scope.vm = {};
    	var url = $location.url().substring(1);
    	vm.dataList = {};
    	vm.dataList.activities = [];
    	vm.publicationId = url.split('/')[1];
    	$.ajax({
    		url:'../publication/detail/'+vm.publicationId,
    		method:'get',
    		success:function(data){
    			console.log(data)
    			if('ok'==data.status){
    				vm.dataList.recruitmentTime = data.recruitmentTime;
    				vm.dataList.salary = data.salary;
    				vm.dataList.title = data.title;
    				vm.dataList.requirement = data.requirement;
    				vm.dataList.workAddress = data.workAddress;
    				vm.dataList.workDuration = data.workDuration;
    				vm.dataList.workTimeInfo = data.workTimeInfo;
    				vm.dataList.publicationTime = data.publicationTime.substring(0,19);
    				vm.dataList.isLong = data.isLong;
    				vm.dataList.startDate = data.startDate;
    				vm.dataList.activities = data.activities;
    				$scope.$apply(function(){
    					vm.dataList = vm.dataList;
    				});
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
    		}
    	});
    }])
    .controller('employer.applycancel.ctrl',['$scope','$location','modalSessionService','modalService','modalService2','loaderService','modalSuccessService','$timeout',function($scope,$location,modalSessionService,modalService,modalService2,loaderService,modalSuccessService,$timeout){
    	var oSessionDiv = document.getElementById('session');
    	if(oSessionDiv){
    		modalSessionService.showModal();
    		$timeout(function(){
    			location.href = 'login';
    		},1500);
    		return ;
    	}
    	
    	var url = $location.url().substring(1);
    	var vm = $scope.vm = {};
    	vm.publicationId = url.split('/')[1];
    	vm.activityList = [];
    	$.ajax({
    		url:'../publication/detail/'+vm.publicationId,
    		method:'get',
    		success:function(data){
    			console.log(data)
    			if('ok'==data.status){
    				for(var i=0;i<data.activities.length;i++){
    					vm.activityList.push({
    						id:data.activities[i].activityId,
    						time:data.activities[i].date,
    						number:data.activities[i].applyNum,
    						recruiteNum:data.activities[i].recruitNum,
    						isCancle:judgeTime(data.activities[i].date)
        				});
    				}
    				$scope.$apply(function(){
    					vm.activityList = vm.activityList;
    				});
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
    		}
    	});
    	vm.closeModal = function(){
    		modalService.hideModal();
    		modalService2.hideModal();
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
        
        //提交申请
   
        vm.submitApply = function(){
    		var oCheckBox = $("#apply-cancel input[type=checkbox]");
    		if(oCheckBox.length>0){
    			var oChecked = $("#apply-cancel input[type=checkbox]:checked");
    			if(oChecked.length){
    				modalService2.showModal();
    			}else{
    				$(".modal-tip-error .modal-confirm-content").text('请至少选择一天进行取消');
               		modalService.showModal();
    			}
    		}else{
    			$(".modal-tip-error .modal-confirm-content").text('没有可以取消的天数');
           		modalService.showModal();
    		}
        }
        vm.confirmCancleBtn = true;
        vm.confirmCancle = function(){
        	if(vm.confirmCancleBtn){
        		var oCheckBox = $("#apply-cancel input[type=checkbox]");
        		var oChecked = $("#apply-cancel input[type=checkbox]:checked");
        		vm.confirmCancleBtn = false;
        		var data = {};
    			data.id = vm.publicationId;
    			if(oChecked.length!=oCheckBox.length){
    				data.id += ',0';
    				oChecked.each(function(index,obj){
    					data.id += ','+obj.value
    				});
    			}else{
    				data.id += ',1';
    				oChecked.each(function(index,obj){
    					data.id += ','+obj.value
    				});
    			}
    			data.reason = vm.content;
    			loaderService.showLoader();
    			$.ajax({
    				url:'../publication/applycancel',
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
    					}
    				},
    				complete:function(){
    					modalService2.hideModal();
    					vm.confirmCancleBtn = true;
    					loaderService.hideLoader();
    				},
    				error:function(){
    					//;
    				}
    			});
        	}
        }
    }])
    .controller('employer.yqxzw.ctrl',['$scope','modalSessionService','$timeout','modalService','loaderService','$compile',function($scope,modalSessionService,$timeout,modalService,loaderService,$compile){

    	var oSessionDiv = document.getElementById('session');
    	if(oSessionDiv){
    		modalSessionService.showModal();
    		$timeout(function(){
    			location.href = 'login';
    		},1500);
    		return ;
    	}
    	var vm = $scope.vm = {};
		vm.totalNum = parseInt($("#totalNum").val());
		vm.totalPage = vm.totalNum%10==0?vm.totalNum/10:Math.floor(vm.totalNum/10)+1;
		vm.currPage = 1;
		getPageList(vm.currPage);
    	function getPageList(currPage){
    		vm.pageList = [];
    		if(vm.totalNum){
    	    	if(vm.totalPage<=9){
    				for(var i=1;i<=vm.totalPage;i++){
    					vm.pageList.push(i);
    				}
    			}else{
    				if(currPage<=5){
    					for(var i=1;i<=9;i++){
    						vm.pageList.push(i);
    	    			}
    					vm.pageList.push('下一页');
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
    	//get data
    	vm.getDataBtn = true;
    	vm.getData = function(){
    		if(vm.getDataBtn){
    			vm.getDataBtn = false;
    			loaderService.showLoader();
        		$.ajax({
        			method:'get',
        			url:'../publication/private/page/'+vm.currPage+'/3',
        			type:'json',
        			success:function(data){
        				if('ok'==data.status){
        					var data = data.publications;
        					var oTr = '';
        					for(var i=0;i<data.length;i++){
        						var type = '';
        						if(data[i].state==2){
        							type = '取消等待中'
        						}else if(data[i].state==3){
        							type="已取消";
        						}
        						oTr += '<tr>'+
        						'<td>'+data[i].title.substring(0,11)+'</td>'+
        		  				'<td>'+data[i].publicationTime.substring(0,19)+'</td>'+
        		  				'<td>'+data[i].startDate+'</td>'+
        		  				'<td>'+data[i].contactName+'（'+data[i].cellphone+'）</td>'+
        		  				'<td><abbr title='+data[i].workAddress+'>'+data[i].workAddress.substring(0,19)+'</abbr></td>'+
        		  				'<td>'+type+'</td>'+
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
        				$scope.$apply(function(){
        					getPageList(vm.currPage);
        				});
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
    	}
    }])
    .controller('employer.ywjzw.ctrl',['$scope','modalSessionService','$timeout','modalService','loaderService','$compile',function($scope,modalSessionService,$timeout,modalService,loaderService,$compile){
    	var oSessionDiv = document.getElementById('session');
    	if(oSessionDiv){
    		modalSessionService.showModal();
    		$timeout(function(){
    			location.href = 'login';
    		},1500);
    		return ;
    	}
    	var vm = $scope.vm = {};
		vm.totalNum = parseInt($("#totalNum").val());
		vm.totalPage = vm.totalNum%10==0?vm.totalNum/10:Math.floor(vm.totalNum/10)+1;
		vm.currPage = 1;
		getPageList(vm.currPage);
    	function getPageList(currPage){
    		vm.pageList = [];
    		if(vm.totalNum){
    	    	if(vm.totalPage<=9){
    				for(var i=1;i<=vm.totalPage;i++){
    					vm.pageList.push(i);
    				}
    			}else{
    				if(currPage<=5){
    					for(var i=1;i<=9;i++){
    						vm.pageList.push(i);
    	    			}
    					vm.pageList.push('下一页');
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
    	//get data
    	vm.getDataBtn = true;
    	vm.getData = function(){
    		if(vm.getDataBtn){
    			vm.getDataBtn = false;
    			loaderService.showLoader();
        		$.ajax({
        			method:'get',
        			url:'../publication/private/page/'+vm.currPage+'/4',
        			type:'json',
        			success:function(data){
        				if('ok'==data.status){
        					var data = data.publications;
        					var oTr = '';
        					for(var i=0;i<data.length;i++){
        						oTr += '<tr>'+
        						'<td>'+data[i].title.substring(0,11)+'</td>'+
        		  				'<td>'+data[i].publicationTime.substring(0,19)+'</td>'+
        		  				'<td>'+data[i].startDate+'</td>'+
        		  				'<td>'+data[i].contactName+'（'+data[i].cellphone+'）</td>'+
        		  				'<td><abbr title='+data[i].workAddress+'>'+data[i].workAddress.substring(0,19)+'</abbr></td>'+
        		  				'<td>活动已结束</td>'+
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
        				$scope.$apply(function(){
        					getPageList(vm.currPage);
        				});
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
    	}
    }])
    .controller('employer.info.ctrl',['$scope','modalService','loaderService','modalSuccessService','$timeout','modalSessionService',function($scope,modalService,loaderService,modalSuccessService,$timeout,modalSessionService){
    	
        //处理session 是否过期
    	var oSessionDiv = document.getElementById('session');
    	if(oSessionDiv){
    		modalSessionService.showModal();
    		$timeout(function(){
    			location.href = 'login';
    		},1500);
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
    	vm.updateInfo = function(){
    		if(vm.updateInfoBtn){
    			vm.updateInfoBtn = false;
            	var data = {cellphone:vm.phone,email:vm.email};
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
            	})
    		}
    	}
    	vm.closeModal = function(){
    		modalService.hideModal();
    	}
    }])
    .controller('employer.updatePass.ctrl',['$scope','modalService','loaderService','modalSuccessService','$timeout','modalSessionService',function($scope,modalService,loaderService,modalSuccessService,$timeout,modalSessionService){
    	
    	var oSessionDiv = document.getElementById('session');
    	if(oSessionDiv){
    		modalSessionService.showModal();
    		$timeout(function(){
    			location.href = 'login';
    		},1500);
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
        				url:'updatepwd',
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
    	
    }]);

