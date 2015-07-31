angular.module('employer.directive',[])
    .directive('employer.time.directive',function(){
        //时间选择插件指令
        function link(scope, element, attrs){
            function MyDate(oInput,oP){
                this.oInput = oInput;
                this.oParent = oP;
                this.date = new Date();
                this.year = this.date.getFullYear();
                this.month = this.date.getMonth()+1;//这个月份是会改变的
                this.oldMonth = this.month;//存储当前月份
                this.weekday = ['日','一','二','三','四','五','六'];
                this.flag = true;
            }
            MyDate.prototype = {
                init:function(){
                    this.showDate();
                },
                showDate:function(){
                    var This = this;
                    this.oInput.onclick = function(ev){
                        ev = ev||event;
                        This.showContainer();
                        This.createDate();
                        This.initBtn();
                        ev.cancelBubble = true;
                    }
                    document.onclick = function(){
                        This.oParent.style.display = 'none';
                    }
                },
                showContainer:function(){
                    this.oParent.style.display = 'block';
                },
                hideContainer:function(){
                    this.oParent.style.display = 'none';
                },
                createDate:function(){
                    if(this.flag){
                        var oTitle = document.createElement('div');
                        oTitle.className = 'title';
                        oTitle.innerHTML = '<div class="l"><span>上个月</span></div><div class="c"><span>'+this.year+'</span>年<span>'+this.month+'</span>月</div><div class="r"><span>下个月</span></div>';
                        this.oParent.appendChild(oTitle);
                        //create table
                        var oTable = document.createElement('table');
                        var oThead = document.createElement('thead');
                        var oThtr = document.createElement('tr');
                        for(var i=0;i<7;i++){
                            var oThth = document.createElement('th');
                            oThth.innerHTML = this.weekday[i];
                            oThtr.appendChild(oThth);
                        }
                        oThead.appendChild(oThtr);
                        oTable.appendChild(oThead);


                        var oTbody = document.createElement('tbody');
                        for(var i=0;i<6;i++){
                            var oTbtr = document.createElement('tr');
                            for(var j=0;j<7;j++){
                                var oTbtd = document.createElement('td');
                                oTbtr.appendChild(oTbtd);
                            }
                            oTbody.appendChild(oTbtr);
                        }
                        oTable.appendChild(oTbody);
                        this.oParent.appendChild(oTable);

                        this.flag = false;
                    }
                    this.insertDate();
                },
                insertDate:function(){
                    var oDate = new Date();
                    oDate.setFullYear(this.year);
                    oDate.setMonth(this.month-1);
                    oDate.setDate(1);
                    var firstDay = oDate.getDay();//第一天星期几
                    var dayNum = this.getDayNum(this.month);


                    var oTable = this.oParent.getElementsByTagName('table')[0];
                    var oTbody = oTable.getElementsByTagName('tbody')[0];
                    var otds = oTbody.getElementsByTagName('td');

                    for(var i=0;i<dayNum;i++){
                        otds[i+firstDay].innerHTML = (i+1);
                    }
                    //alert(this.month==this.oldMonth);
                    //alert(this.oldMonth);
                    if(this.month==this.oldMonth){
                        otds[firstDay+this.date.getDate()-1].className = 'red';
                    }
                    this.clearExtraSpace();
                },
                getDayNum:function(month){
                    if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
                        return 31;
                    }else if(month==4||month==6||month==9||month==11){
                        return 30;
                    }else{//month:2
                        if(this.year%4==0&&this.year%100!=0){
                            return 29;
                        }else{
                            if(this.year%400==0){
                                return 29;
                            }else{
                                return 28;
                            }
                        }
                    }
                },
                initBtn:function(){
                    var nextBtn = this.getClassByName(this.oParent,'r')[0];
                    var preBtn = this.getClassByName(this.oParent,'l')[0];
                    var This = this;
                    nextBtn.onclick = function(ev){
                        ev = ev||event;
                        This.nextMonth();
                        ev.cancelBubble = true;
                    }
                    preBtn.onclick = function(ev){
                        ev = ev||event;
                        This.preMonth();
                        ev.cancelBubble = true;
                    }
                    document.onclick = function(){
                        This.oParent.style.display = 'none';
                    }
                },
                nextMonth:function(){
                    if(this.month==12){
                        this.month = 1;
                        this.year++;
                    }else{
                        this.month++;
                    }
                    this.changeTitle();
                    this.clearDate();
                    this.createDate();
                },
                preMonth:function(){
                    if(this.month==1){
                        this.month = 12;
                        this.year--;
                    }else{
                        this.month--;
                    }
                    this.changeTitle();
                    this.clearDate();
                    this.createDate();
                },
                changeTitle:function(){
                    var oCenter = this.getClassByName(this.oParent,'c')[0];
                    var oSpans = oCenter.getElementsByTagName('span');
                    oSpans[0].innerHTML = this.year;
                    oSpans[1].innerHTML = this.month;
                },
                clearDate:function(){
                    var oTable = this.oParent.getElementsByTagName('table')[0];
                    var oTbody = oTable.getElementsByTagName('tbody')[0];
                    var oTrs = oTbody.getElementsByTagName('tr');
                    var oTds = oTbody.getElementsByTagName('td');

                    for(var i=0;i<oTds.length;i++){
                        oTds[i].innerHTML = '';
                        oTds[i].className = '';
                    }
                    oTrs[5].style.display = '';
                    oTrs[4].style.display = '';
                },
                clearExtraSpace:function(){
                    var oTable = this.oParent.getElementsByTagName('table')[0];
                    var oTbody = oTable.getElementsByTagName('tbody')[0];
                    var oTrs = oTbody.getElementsByTagName('tr');
                    var oTds = oTbody.getElementsByTagName('td');

                    if(oTds[35].innerHTML==''){

                        oTrs[5].style.display = 'none';

                    }
                    if(oTds[28].innerHTML==''){
                        oTrs[4].style.display = 'none';
                    }
                    this.addClick();
                },
                getClassByName:function(oParent,className){
                    var results = [];
                    var tags = oParent.getElementsByTagName('*');
                    for(var i=0;i<tags.length;i++){
                        if(tags[i].className==className){
                            results.push(tags[i]);
                        }
                    }
                    return results;

                },
                addClick:function(){
                    var This = this;
                    var oTable = this.oParent.getElementsByTagName('table')[0];
                    var oTbody = oTable.getElementsByTagName('tbody')[0];
                    var otds = oTbody.getElementsByTagName('td');
                    for(var i=0;i<otds.length;i++){
                        if(otds[i].innerHTML!=''){
                            otds[i].index = i;
                            otds[i].onclick = function(){
                                This.oInput.value = This.year+'-'+This.addZero(This.month)+'-'+This.addZero(this.innerHTML);
                                This.oParent.style.display = 'none';
                            }
                        }
                    }
                },
                addZero:function(value){
                    return value>9?value:'0'+value;
                }
            }
            var md = new MyDate(document.getElementById("time"),document.getElementById("time_container"));
            md.init();
        }
        return {
            link : link
        }
    });

