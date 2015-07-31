angular.module('myService',[],['$provide',function($provide){
	//显示和隐藏loader icon 
	$provide.factory('loaderService',function(){
		var showLoader = function(){
			$(".modal-loader-opacity").fadeIn(500);
			$(".modal-loader").fadeIn(500);
		}
		var hideLoader = function(){
			$(".modal-loader-opacity").fadeOut(500);
			$(".modal-loader").fadeOut(500);
		}
		return {
			showLoader:showLoader,
			hideLoader:hideLoader
		}
	});
	//显示和隐藏模态框服务
	$provide.factory('modalService',function(){
		var showModal = function(){
			$($(".modal-opacity")[0]).fadeIn(500);
			$($(".modal-out")[0]).fadeIn(500);
		}
		var hideModal = function(){
			$($(".modal-opacity")[0]).fadeOut(500);
			$($(".modal-out")[0]).fadeOut(500);
		}
		return {
			showModal:showModal,
			hideModal:hideModal
		}
	});
	//显示和隐藏模态框服务
	$provide.factory('modalService2',function(){
		var showModal = function(){
			$($(".modal-opacity")[1]).fadeIn(500);
			$($(".modal-out")[1]).fadeIn(500);
		}
		var hideModal = function(){
			$($(".modal-opacity")[1]).fadeOut(500);
			$($(".modal-out")[1]).fadeOut(500);
		}
		return {
			showModal:showModal,
			hideModal:hideModal
		}
	});
	//显示和隐藏模态框服务--这个目前只在ybmhd中有
	$provide.factory('modalService3',function(){
		var showModal = function(){
			$($(".modal-opacity")[3]).fadeIn(500);
			$($(".modal-out")[3]).fadeIn(500);
		}
		var hideModal = function(){
			$($(".modal-opacity")[3]).fadeOut(500);
			$($(".modal-out")[3]).fadeOut(500);
		}
		return {
			showModal:showModal,
			hideModal:hideModal
		}
	});
	//显示和隐藏模态框服务
	$provide.factory('modalConfirm',function(){
		var showModal = function(){
			$($(".modal-opacity")[2]).fadeIn(500);
			$($(".modal-out")[2]).fadeIn(500);
		}
		var hideModal = function(){
			$($(".modal-opacity")[2]).fadeOut(500);
			$($(".modal-out")[2]).fadeOut(500);
		}
		return {
			showModal:showModal,
			hideModal:hideModal
		}
	});
	$provide.factory('modalSuccessService',function(){
		var showSuccessModal = function(){
			$(".modal-success-opacity").fadeIn(500);
			$(".modal-success").fadeIn(500);
		}
		var hideSuccessModal = function(){
			$(".modal-success-opacity").fadeOut(500);
			$(".modal-success").fadeOut(500);
		}
		return {
			showModal:showSuccessModal,
			hideModal:hideSuccessModal
		}
	});
	$provide.factory('modalSessionService',function(){
		var showSuccessModal = function(){
			$(".modal-session-opacity").fadeIn(500);
			$(".modal-session").fadeIn(500);
		}
		var hideSuccessModal = function(){
			$(".modal-session-opacity").fadeOut(500);
			$(".modal-session").fadeOut(500);
		}
		return {
			showModal:showSuccessModal,
			hideModal:hideSuccessModal
		}
	});
}]);
	