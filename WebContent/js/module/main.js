angular.module('main',['main.directive','my.service.data'])
    .controller('main.areaCtrl',['$scope','cityData','$interval',function($scope,cityData,$interval){
        var vm = $scope.vm = {};
        //城市数据
        vm.cityData = cityData;
        vm.province = $("#province").val();
        vm.city =  $("#city").val();
        //工作类型，0：其他,1:，2：，3：,4:，5：，6：
        var workTypeObj = ['其他','传单派发','酒店服务员','促销','礼仪','营业员','工厂兼职'];
        vm.workTypeList = [];
        for(var i=6;i>=0;i--){
        	vm.workTypeList.push({
        		name:workTypeObj[i],
        		value:i
        	});
        	
        }
    }])
    .controller('main.ctrl',['$scope','$window','$document',function($scope,$window,$document){
    	
    	//给导航添加fixed样式
    	var logo = $("#logo");
    	var scrollTop = 0;
    	var iWidth = $(window).width();
    	$window.onscroll = function(){
    		scrollTop = $($document[0]).scrollTop();
    		if(scrollTop>34){
    			logo.addClass("logo-fixed-pos");
    			logo.css({
    				left:(iWidth-1000)/2
    			});
    		}else{
    			logo.removeClass("logo-fixed-pos");
    		}
    	}
    	//分页和加载数据
    	var vm = $scope.vm = {};
    	vm.searchKey = $("#searchKey").val()?'':$("#searchKey").val();
		vm.totalNum = parseInt($("#totalNum").val());
		vm.currPage = parseInt($("#pageNum").val());
		vm.pageList = [];
		if(vm.totalNum){
	    	vm.totalPage = vm.totalNum%10==0?vm.totalNum/10:Math.floor(vm.totalNum/10)+1;
	    	if(vm.totalPage<=9){
				for(var i=1;i<=vm.totalPage;i++){
					vm.pageList.push({name:i,value:i});
				}
			}else{
				getPageList();
			}
		}
    	function getPageList(){
    		console.log(vm.currPage)
			if(vm.currPage<=5){
				for(var i=1;i<=9;i++){
					vm.pageList.push({name:i,value:i});
    			}
				vm.pageList.push({name:'下一页',value:(vm.currPage+1)});
			}else if(vm.totalPage-vm.currPage>4&&vm.currPage>5){
				vm.pageList.push({name:'首页',value:1});
				for(var i=vm.currPage-4;i<=vm.currPage+4;i++){
					vm.pageList.push({name:i,value:i});
				}
				vm.pageList.push({name:'下一页',value:(vm.currPage+1)});
			}else if(vm.totalPage-vm.currPage<=4){
				vm.pageList.push({name:'首页',value:1});
				for(var i=vm.totalPage-8;i<=vm.totalPage;i++){
					vm.pageList.push({name:i,value:i});
				}
			}
    	}
    	/*
    	vm.changePage = function(list){
    		if(list=='下一页'){
    			vm.currPage++;
    		}else if(list=='首页'){
    			vm.currPage = 1;
    		}else{
    			vm.currPage = list;
    		}
    		if(vm.currPage<=vm.totalPage){
    			setData();
    			vm.getData();
    		}
    	}*/
    	
    	/*//加载数据
    	vm.getDataBtn = true;
    	vm.getData = function(){
    		if(vm.getDataBtn){
    			oLoader.show();
    			$.ajax({
    				url:'page',
    				method:'get',
    				type:'json',
    				data:vm.searchData,
    				success:function(data){
    					if('ok'==data.status){
    						console.log(data)
    						var publications = data.publications;
    						var oLis = '';
                            for(var i=0;i<publications.length;i++){
                            	var data = publications[i];
                            	oLis += '<li>'+
                	            '<i class="name-icon name-icon1">'+data.companyName+'</i>'+
                	            '<p class="employer-mess">'+data.companyName+'<i class="flag">认证</i><span>第<strong>'+data.recruitmentTime+'</strong>次招聘</span><span>&nbsp;&nbsp;发布时间：'+data.publicationTime.substring(0,19)+'</span></p>'+
                	            '<p class="detail">'+
                	                '<span class="detail-l"><a href="publication/'+data.publicationId+'" target="_blank" class="btn-default-link">'+data.title.substring(0,20)+'</a></span>'+
                	                '<span class="detail-c">工作时间：'+data.startDate+'&nbsp;|&nbsp;工作区域：'+data.workAddress.substring(0,3)+'...&nbsp;|&nbsp;薪资：'+data.salary+'/天</span>'+
                	            	'<span><a href="publication/'+data.publicationId+'" class="btn-default-link" target="_blank">查看详情</a></span>'+
                	            '</p>'+
                       		 	'</li>';
                            	var oUl = $("#content .content-list");
                            	oUl.empty().append(oLis);
                            }
    					}
    				},
    				complete:function(){
    					$($document[0]).scrollTop(240);
    					getPageList(vm.currPage);
    					oLoader.hide();
        				vm.getDataBtn = true;
    				},
    				error:function(){
    					//;
    				}
    			});
    		}
    		
    		
    	}
    	//搜索
    	vm.searchData = {};
    	vm.search = function(){
    		vm.currPage = 1;
    		vm.getData();
    	}
    	function setData(){
    		vm.searchData.content = vm.searchMatch?vm.searchMatch:'';
    		vm.searchData.p = $("#province").val();
    		vm.searchData.c = $("#city").val();
    		vm.searchData.d = $("#district").val();
    		vm.searchData.searchKey = vm.searchMatch?vm.searchMatch:'';
    		vm.searchData.workType = $("#workType").val();
    		vm.searchData.orderType = $("#orderType").val();
    		vm.searchData.pageNum = vm.currPage;
    	}*/
    	
    }])
    .controller('main.nav.ctrl',['$scope',function($scope){
    	var vm = $scope.vm = {};
    	var oChangeArea = $("#change-area");
    	oChangeArea.css({display:'block'});
    	vm.changeCity = function(){
    		oChangeArea.animate({
    			height:120
    		},300);
    	}
    }])
    .controller('main.changeArea.ctrl',['$scope','cityData',function($scope,cityData){
    	var vm = $scope.vm = {};
    	//城市数据
        vm.cityData = cityData;
        vm.province = $("#province").val();
        vm.city =  $("#city").val();
        var oChangeArea = $("#change-area");
        oChangeArea.css({display:'none'});
        vm.hideChangeArea = function(){
        	oChangeArea.animate({
    			height:0
    		},300);
        }
    }]);
