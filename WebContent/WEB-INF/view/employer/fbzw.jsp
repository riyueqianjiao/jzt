<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="center-r-content col-md-12">
 	<div class="title"><h4>发布新职位<span style="color:#cc0000;">（ps:点击调整需求按钮可以对短期兼职进行适当调整）</span></h4></div>
 	<form class="form-inline fbjz-form" name="fbjzForm" novalidate>
  		<div class="form-group" ng-class="{'has-error':fbjzForm.title.$invalid&&fbjzForm.title.$dirty}">
		    <label for="title">工作标题：</label>
		    <input type="text" class="form-control" name="title" id="title" ng-model="vm.title" autocomplete="off" ng-minlength="4" maxlength="12" placeholder="大于等于4个汉字" required>
  		</div>
  		<div class="form-group">
		    <label for="name">称呼：</label>
		   	<input type="text" class="form-control" name="name" id="name" ng-model="vm.name" autocomplete="off" style="width:80px;">
  		</div>
  		<div class="form-group" ng-class="{'has-error':fbjzForm.phone.$invalid&&fbjzForm.phone.$dirty}">
		    <label for="phone">联系方式：</label>
		   	<input type="text" class="form-control" name="phone" id="phone" ng-model="vm.phone" autocomplete="off" ng-pattern="/^[0-9]{11}/" maxlength="11" required>
  		</div>
  		<div class="form-group">
  			<label></label>
  		</div>
  		<div class="rows" style="height:10px;"></div>
  		<div class="form-group">
  			<label for="time">工作时间：</label>
		   	<input type="text" class="form-control" name="time" id="time" ng-model="vm.time" autocomplete="off" ng-keyup="vm.forbidTimeInput()" employer.time.directive>
  			<div class="time_container" id="time_container"></div>
  		</div>
  		<div class="form-group">
  			<label for="workType">工作类型：</label>
  			<select id="workType">
  				<option value="1">传单派发</option>
  				<option value="2">酒店服务员</option>
  				<option value="3">促销</option>
  				<option value="4">礼仪</option>
  				<option value="5">营业员</option>
  				<option value="6">工厂兼职</option>
  				<option value="0">其它</option>
  			</select>
  		</div>
  		<div class="form-group">
  			<label for="days" ng-hide="vm.isLong">工作天数：</label>
  			<select ng-hide="vm.isLong" class="form-control" name="days" ng-model="vm.days" ng-disabled="vm.isLong">
			  <option>1</option>
			  <option>2</option>
			  <option>3</option>
			  <option>4</option>
			  <option>5</option>
			  <option>6</option>
			  <option>7</option>
			</select>
			<label class="checkbox-inline">
			  	<input type="checkbox" id="isLong" ng-click="vm.isLong=!vm.isLong"/>长期兼职
			</label>
  		</div>
  		<div class="rows" style="height:10px;"></div>
  		<div class="form-group">
  			<label for="days">起始时间：</label>
  			<select class="form-control" name="startHour" ng-model="vm.startHour">
                <option ng-repeat="hour in vm.hourObj" ng-selected="$index==9">{{hour}}</option>
            </select>
            <span>:</span>
            <select class="form-control" name="startMinute" ng-model="vm.startMinute">
                <option ng-repeat="minute in vm.minuteOjb">{{minute}}</option>
            </select>
            <span>到</span>
            <select class="form-control" name="endHour" ng-model="vm.endHour">
                <option ng-repeat="hour in vm.hourObj" ng-selected="$index==17">{{hour}}</option>
            </select>
            <span>:</span>
            <select class="form-control" name="endMinute" ng-model="vm.endMinute">
                <option ng-repeat="minute in vm.minuteOjb">{{minute}}</option>
            </select>
  		</div>
  		<div class="rows" style="height:10px;"></div>
  		<div class="form-group">
  			<label>选择省市：</label>
  			<select class="form-control" ng-model="vm.province" name="province" ng-options="province.label for province in vm.provinces" ie-select-fix="options" required>
                    <option value="">-- 请选择省 --</option>
                </select>
                <select class="form-control" ng-if="vm.province.cities" ng-model="vm.city" name="city"
                        ng-options="city.label for city in vm.province.cities" required>
                    <option value="">-- 请选择市 --</option>
                </select>
                <select class="form-control" ng-if="vm.city.areas" ng-model="vm.area" name="area" ng-options="area.label for area in vm.city.areas" required>
                    <option value="">-- 请选择区 --</option>
                </select>
  		</div>
  		<div class="rows" style="height:10px;"></div>
  		<div class="form-group" ng-class="{'has-error':fbjzForm.address.$invalid&&fbjzForm.address.$dirty}">
  			<label for="address">工作地点：</label>
  			<input type="text" name="address" class="form-control" id="address" ng-model="vm.address" autocomplete="off" ng-minlength="2" required/>
  		</div>
  		<div class="rows" style="height:10px;"></div>
  		<div class="form-group" ng-class="{'has-error':fbjzForm.salary.$invalid&&fbjzForm.salary.$dirty}">
  			<label for="salary">薪资说明：</label>
  			<input type="text" name="salary" id="salary" class="form-control" ng-model="vm.salary" style="width:80px" ng-pattern="/^[0-9]{1,5}/" maxlength="5" required/>
  			<span ng-hide="vm.isLong">/天</span>
  			<span ng-show="vm.isLong">/月</span>
            <label>结算方式：</label>
            <select name="jsWay" ng-model="vm.jsWay" class="form-control">
                <option ng-repeat="data in vm.jsWayObj" ng-selected="$index==0">{{data}}</option>
            </select>
  		</div>
        <div class="rows" style="height:10px;"></div>
        <div class="form-group">
        	<label>是否包餐：</label>
        	<label class="radio-inline">
				<input type="radio" value="不包工作餐" name="dinner" id="nodinner" ng-model="vm.dinner" ng-checked="true">
				不包工作餐
			</label>
			<label class="radio-inline">
			  	<input type="radio" value="包工作餐(一餐)" name="dinner" id="onedinner" ng-model="vm.dinner">包工作餐(一餐)
			</label>
			<label class="radio-inline">
			  	<input type="radio" value="包工作餐(两餐)" name="dinner" id="twodinner" ng-model="vm.dinner">包工作餐(两餐)
			</label>
			<label class="checkbox-inline">
			  	<input type="checkbox" name="transport" ng-model="vm.transport" id="transport"/>有车接送
			</label>
			<label class="checkbox-inline">
			  	<input type="checkbox" name="zhusu" id="zhusu" ng-model="vm.zhusu"/>包住宿
			</label>
        </div>
        <div class="rows" style="height:10px;"></div>
        <div class="form-group">
            <label>性别要求：</label>
            <select class="form-control" name="isRate" ng-model="vm.isRate" ng-change="vm.judgeRateType()">
                <option value=0 ng-selected=true>不分男女比列</option>
                <option value=1>分男女比列</option>
                <option value=2>限招女生</option>
                <option value=3>限招男生</option>
            </select>
            <div class="form-group" ng-hide="vm.showRate">
                <label for="maleNumber">男生</label>
                <input type="text" class="form-control" name="maleNumber" id="maleNumber" ng-model="vm.maleNumber" style="width:80px;"/>
                <span>+</span>
                <label for="femaleNumber">女生</label>
                <input type="text" class="form-control" name="femaleNumber" id="femaleNumber" ng-model="vm.femaleNumber" style="width:80px;"/>
                <span>=</span>
                <input type="text" value="" class="form-control" name="number" ng-model="vm.number" ng-disabled="true" style="width:80px;"/>
                <span>人</span>
            </div>
            <div class="form-group" ng-show="vm.showRate">
                <span>需</span>
                <input type="text" name="number" ng-model="vm.number" class="form-control" style="width:80px;">
                <span>人</span>
            </div>
        </div>
        <div class="rows" style="height:10px;"></div>
        <div class="form-group">
            <label>其他要求：</label>
            <textarea cols="60" ng-init="vm.rows=3" rows="{{vm.rows}}" class="form-control" ng-minlength="1" name="content" ng-model="vm.content" ng-focus="vm.rows=6" required>{{vm.content}}</textarea>
        </div>
        <div class="rows" style="height:10px;"></div>
<!--         <div class="form-group">
            <label>支付方式：</label>
            <select name="payWay" ng-model="vm.payWay" class="form-control">
                <option ng-selected="true">线下支付</option>
                <option>线上支付</option>
            </select>
        </div> -->
        <div class="rows" style="height:10px;"></div>
        <div class="form-group">
        	<label style="color:#fff;">提交表单：</label>
        	<button class="btn btn-primary" ng-disabled="fbjzForm.$invalid" ng-click="vm.submit()">确定提交</button>
        	<button ng-hide="vm.isLong" class="btn btn-primary" ng-disabled="fbjzForm.$invalid" ng-click="vm.adjustJob()">调整需求</button>
        </div>
 	</form>
</div>
<div class="modal-opacity"></div>
<div class="modal-out">
	<div class="my-modal modal-fbzw">
		<h1>修改具体某一天活动条件(直接在输入框中对应位置修改)</h1>
		<button class="add-record btn btn-default" ng-click="vm.addRecord()">增加一条记录</button>
		<div class="my-modal-content">
			<table>
            <thead>
            <tr>
                <td width="80" class="first">工作日期</td>
                <td width="80">具体时间</td>
                <td width="80">工资/天</td>
                <td width="170">工作地点</td>
                <td>人数</td>
                <td width="80">操作栏</td>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="list in vm.updateJobList">
                <td class="first">
                    <div class="input-out-style">
                        <input type="text" value="{{list.time}}" class="min updateTime"/>
                    </div>
                </td>
                <td>
                    <div class="input-out-style">
                        <input type="text" value="{{list.jtTime}}" class="min1 updateJTTime"/>
                    </div>
                </td>
                <td>
                    <div class="input-out-style">
                        <input type="text" class="min updateSalary" value="{{list.salary}}"/>
                    </div>
                </td>
                <td>
                    <div class="input-out-style">
                        <input type="text" class="short updateAddress" value="{{list.address}}"/>
                    </div>
                </td>
                <td ng-if="list.isRate==1">
                    <div class="input-out-style">
                        <span>男</span>
                        <input type="text" value="{{vm.maleNumber}}" class="min updateMaleNumber"/>
                        <span>+女</span>
                        <input type="text" value="{{vm.femaleNumber}}" class="min updateFemaleNumber"/>
                    </div>
                </td>
                <td ng-if="list.isRate!=1">
                    <div class="input-out-style">
                        <span>需</span>
                        <input type="text" value="{{vm.number}}" class="min updateTotalNum"/>
                    </div>
                </td>
                <td>
                    <div class="input-out-style">
                        <a class="btn" ng-click="vm.delRecord($index)">删除</a>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
		</div>
		<div class="my-modal-bottom">
			 <a class="btn closeBtn" ng-click="vm.hideDailog()">关闭</a>
             <a class="btn confirmBtn" ng-click="vm.confirmUpdate()">确认修改</a>
		</div>
	</div>
</div>
<div class="modal-opacity"></div>
<div class="modal-out">
	<div class="my-modal modal-tip-error">
		<h1>错误提示</h1>
		<div class="my-modal-content">
			<p class="modal-confirm-content"></p>
		</div>
		<div class="my-modal-bottom">
            <a class="btn confirmBtn" ng-click="vm.closeModal()">确定</a>
		</div>
	</div>
</div>