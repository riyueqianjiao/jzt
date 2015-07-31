angular.module('my.service.data',[])
    .factory('cityData',function(){
    return [
      /*   {
         label: '北京',
         cities: [
         {
         label: '北京',
         areas: [
         {label:"东城区"},{label:"西城区"},{label:"崇文区"},{label:"宣武区"},{label:"朝阳区"},{label:"海淀区"},{label:"丰台区"},{label:"石景山区"},{label:"房山区"},{label:"通州区"},{label:"顺义区"},{label:"昌平区"},{label:"大兴区"},{label:"怀柔区"},{label:"平谷区"},{label:"门头沟区"},{label:"密云县"},{label:"延庆县"}
         ]
         }
         ]
         },*/
        {
            label: '上海',
            cities: [
                {
                    label: '上海',
                    areas: [
                        {label:"黄浦区"},{label:"卢湾区"},{label:"徐汇区"},{label:"长宁区"},{label:"静安区"},{label:"普陀区"},{label:"闸北区"},{label:"虹口区"},{label:"杨浦区"},{label:"宝山区"},{label:"闵行区"},{label:"嘉定区"},{label:"松江区"},{label:"金山区"},{label:"青浦区"},{label:"南汇区"},{label:"奉贤区"},{label:"浦东新区"},{label:"崇明县"}
                    ]
                }
            ]
        },
         /*{
         label: '重庆',
         cities: [
         {
         label: '重庆',
         areas: [
         {label:"渝中区"},{label:"大渡口区"},{label:"江北区"},{label:"南岸区"},{label:"北碚区"},{label:"渝北区"},{label:"巴南区"},{label:"长寿区"},{label:"双桥区"},{label:"沙坪坝区"},{label:"万盛区"},{label:"万州区"},{label:"涪陵区"},{label:"黔江区"},{label:"永川区"},{label:"合川区"},{label:"江津区"},{label:"九龙坡区"},{label:"南川区"},{label:"綦江县"},{label:"潼南县"},{label:"荣昌县"},{label:"璧山县"},{label:"大足县"},{label:"铜梁县"},{label:"梁平县"},{label:"开县"},{label:"忠县"},{label:"城口县"},{label:"垫江县"},{label:"武隆县"},{label:"丰都县"},{label:"奉节县"},{label:"云阳县"},{label:"巫溪县"},{label:"巫山县"},{label:"石柱土家族自治县"},{label:"秀山土家族苗族自治县"},{label:"酉阳土家族苗族自治县"},{label:"彭水苗族土家族自治县"}
         ]
         }
         ]
         },
         {
         label: '天津',
         cities: [
         {
         label: '天津',
         areas: [
         {label:"和平区"},{label:"河东区"},{label:"河西区"},{label:"南开区"},{label:"河北区"},{label:"红桥区"},{label:"塘沽区"},{label:"汉沽区"},{label:"大港区"},{label:"东丽区"},{label:"西青区"},{label:"北辰区"},{label:"津南区"},{label:"武清区"},{label:"宝坻区"},{label:"静海县"},{label:"宁河县"},{label:"蓟县"}
         ]
         }
         ]
         },
         {
         label: '山东',
         cities: [
         {
         label: '青岛',
         areas: [
         {label:"市南区"},{label:"市北区"},{label:"城阳区"},{label:"四方区"},{label:"李沧区"},{label:"黄岛区"},{label:"崂山区"},{label:"胶南市"},{label:"胶州市"},{label:"平度市"},{label:"莱西市"},{label:"即墨市"}
         ]
         },
         {
         label: '济南',
         areas: [
         {label:"市中区"},{label:"历下区"},{label:"天桥区"},{label:"槐荫区"},{label:"历城区"},{label:"长清区"},{label:"章丘市"},{label:"平阴县"},{label:"济阳县"},{label:"商河县"}
         ]
         },
         {
         label: '烟台',
         areas: [
         {label:"芝罘区"},{label:"福山区"},{label:"牟平区"},{label:"莱山区"},{label:"龙口市"},{label:"莱阳市"},{label:"莱州市"},{label:"招远市"},{label:"蓬莱市"},{label:"栖霞市"},{label:"海阳市"},{label:"长岛县"}
         ]
         },
         {
         label: '潍坊',
         areas: [
         {label:"潍城区"},{label:"寒亭区"},{label:"坊子区"},{label:"奎文区"},{label:"青州市"},{label:"诸城市"},{label:"寿光市"},{label:"安丘市"},{label:"高密市"},{label:"昌邑市"},{label:"昌乐县"},{label:"临朐县"}
         ]
         },
         {
         label: '临沂',
         areas: [
         {label:"兰山区"},{label:"罗庄区"},{label:"河东区"},{label:"沂南县"},{label:"郯城县"},{label:"沂水县"},{label:"苍山县"},{label:"费县"},{label:"平邑县"},{label:"莒南县"},{label:"蒙阴县"},{label:"临沭县"}
         ]
         },
         {
         label: '淄博',
         areas: [
         {label:"张店区"},{label:"临淄区"},{label:"淄川区"},{label:"博山区"},{label:"周村区"},{label:"桓台县"},{label:"高青县"},{label:"沂源县"}
         ]
         },
         {
         label: '济宁',
         areas: [
         {label:"市中区"},{label:"任城区"},{label:"曲阜市"},{label:"兖州市"},{label:"邹城市"},{label:"鱼台县"},{label:"金乡县"},{label:"嘉祥县"},{label:"微山县"},{label:"汶上县"},{label:"泗水县"},{label:"梁山县"}
         ]
         },
         {
         label: '泰安',
         areas: [
         {label:"泰山区"},{label:"岱岳区"},{label:"新泰市"},{label:"肥城市"},{label:"宁阳县"},{label:"东平县"}
         ]
         },
         {
         label: '聊城',
         areas: [
         {label:"东昌府区"},{label:"临清市"},{label:"高唐县"},{label:"阳谷县"},{label:"茌平县"},{label:"莘县"},{label:"东阿县"},{label:"冠县"}
         ]
         },
         {
         label: '威海',
         areas: [
         {label:"环翠区"},{label:"乳山市"},{label:"文登市"},{label:"荣成市"}
         ]
         },
         {
         label: '枣庄',
         areas: [
         {label:"市中区"},{label:"山亭区"},{label:"峄城区"},{label:"台儿庄区"},{label:"薛城区"},{label:"滕州市"}
         ]
         },
         {
         label: '德州',
         areas: [
         {label:"德城区"},{label:"乐陵市"},{label:"禹城市"},{label:"陵县"},{label:"宁津县"},{label:"齐河县"},{label:"武城县"},{label:"庆云县"},{label:"平原县"},{label:"夏津县"},{label:"临邑县"}
         ]
         },
         {
         label: '日照',
         areas: [
         {label:"东港区"},{label:"岚山区"},{label:"五莲县"},{label:"莒县"}
         ]
         },
         {
         label: '东营',
         areas: [
         {label:"东营区"},{label:"河口区"},{label:"垦利县"},{label:"广饶县"},{label:"利津县"}
         ]
         },
         {
         label: '菏泽',
         areas: [
         {label:"牡丹区"},{label:"鄄城县"},{label:"单县"},{label:"郓城县"},{label:"曹县"},{label:"定陶县"},{label:"巨野县"},{label:"东明县"},{label:"成武县"}
         ]
         },
         {
         label: '滨州',
         areas: [
         {label:"滨城区"},{label:"邹平县"},{label:"沾化县"},{label:"惠民县"},{label:"博兴县"},{label:"阳信县"},{label:"无棣县"}
         ]
         },
         {
         label: '莱芜',
         areas: [
         {label:"莱城区"},{label:"钢城区"}
         ]
         },
         {
         label: '章丘',
         areas: [

         ]
         },
         {
         label: '垦利',
         areas: [

         ]
         },
         {
         label: '诸城',
         areas: [

         ]
         }
         ]
         },*/
         {
         label: '江苏',
         cities: [
         {
         label: '苏州',
         areas: [
         {label:"金阊区"},{label:"平江区"},{label:"沧浪区"},{label:"虎丘区"},{label:"吴中区"},{label:"相城区"},{label:"常熟市"},{label:"张家港市"},{label:"昆山市"},{label:"吴江市"},{label:"太仓市"}
         ]
         }/*,
         {
         label: '南京',
         areas: [
         {label:"玄武区"},{label:"白下区"},{label:"秦淮区"},{label:"建邺区"},{label:"鼓楼区"},{label:"下关区"},{label:"栖霞区"},{label:"雨花台区"},{label:"浦口区"},{label:"江宁区"},{label:"六合区"},{label:"溧水县"},{label:"高淳县"}
         ]
         },
         {
         label: '无锡',
         areas: [
         {label:"崇安区"},{label:"南长区"},{label:"北塘区"},{label:"滨湖区"},{label:"锡山区"},{label:"惠山区"},{label:"江阴市"},{label:"宜兴市"}
         ]
         },
         {
         label: '常州',
         areas: [
         {label:"钟楼区"},{label:"天宁区"},{label:"戚墅堰区"},{label:"新北区"},{label:"武进区"},{label:"金坛市"},{label:"溧阳市"}
         ]
         },
         {
         label: '徐州',
         areas: [
         {label:"云龙区"},{label:"鼓楼区"},{label:"九里区"},{label:"泉山区"},{label:"贾汪区"},{label:"邳州市"},{label:"新沂市"},{label:"铜山县"},{label:"睢宁县"},{label:"沛县"},{label:"丰县"}
         ]
         }*/,
         {
         label: '南通',
         areas: [
         {label:"崇川区"},{label:"港闸区"},{label:"通州市"},{label:"如皋市"},{label:"海门市"},{label:"启东市"},{label:"海安县"},{label:"如东县"}
         ]
         }/*,
         {
         label: '扬州',
         areas: [
         {label:"广陵区"},{label:"维扬区"},{label:"邗江区"},{label:"江都市"},{label:"仪征市"},{label:"高邮市"},{label:"宝应县"}
         ]
         },
         {
         label: '盐城',
         areas: [
         {label:"亭湖区"},{label:"盐都区"},{label:"大丰市"},{label:"东台市"},{label:"建湖县"},{label:"射阳县"},{label:"阜宁县"},{label:"滨海县"},{label:"响水县"}
         ]
         },
         {
         label: '淮安',
         areas: [
         {label:"清河区"},{label:"清浦区"},{label:"楚州区"},{label:"淮阴区"},{label:"涟水县"},{label:"洪泽县"},{label:"金湖县"},{label:"盱眙县"}
         ]
         },
         {
         label: '连云港',
         areas: [
         {label:"新浦区"},{label:"海州区"},{label:"连云区"},{label:"东海县"},{label:"灌云县"},{label:"赣榆县"},{label:"灌南县"}
         ]
         },
         {
         label: '泰州',
         areas: [
         {label:"海陵区"},{label:"高港区"},{label:"姜堰市"},{label:"泰兴市"},{label:"靖江市"},{label:"兴化市"}
         ]
         },
         {
         label: '宿迁',
         areas: [
         {label:"宿城区"},{label:"宿豫区"},{label:"沭阳县"},{label:"泗阳县"},{label:"泗洪县"}
         ]
         },
         {
         label: '镇江',
         areas: [
         {label:"京口区"},{label:"润州区"},{label:"丹徒区"},{label:"丹阳市"},{label:"扬中市"},{label:"句容市"}
         ]
         },
         {
         label: '沭阳',
         areas: [

         ]
         },
         {
         label: '大丰',
         areas: [

         ]
         }*/
         ]
         }/*,
         {
         label: '浙江',
         cities: [
         {
         label: '杭州',
         areas: [
         {label:"拱墅区"},{label:"西湖区"},{label:"上城区"},{label:"下城区"},{label:"江干区"},{label:"滨江区"},{label:"余杭区"},{label:"萧山区"},{label:"建德市"},{label:"富阳市"},{label:"临安市"},{label:"桐庐县"},{label:"淳安县"}
         ]
         },
         {
         label: '宁波',
         areas: [
         {label:"海曙区"},{label:"江东区"},{label:"江北区"},{label:"镇海区"},{label:"北仑区"},{label:"鄞州区"},{label:"余姚市"},{label:"慈溪市"},{label:"奉化市"},{label:"宁海县"},{label:"象山县"}
         ]
         },
         {
         label: '温州',
         areas: [
         {label:"鹿城区"},{label:"龙湾区"},{label:"瓯海区"},{label:"瑞安市"},{label:"乐清市"},{label:"永嘉县"},{label:"洞头县"},{label:"平阳县"},{label:"苍南县"},{label:"文成县"},{label:"泰顺县"}
         ]
         },
         {
         label: '金华',
         areas: [
         {label:"婺城区"},{label:"金东区"},{label:"兰溪市"},{label:"义乌市"},{label:"东阳市"},{label:"永康市"},{label:"武义县"},{label:"浦江县"},{label:"磐安县"}
         ]
         },
         {
         label: '嘉兴',
         areas: [
         {label:"秀城区"},{label:"秀洲区"},{label:"海宁市"},{label:"平湖市"},{label:"桐乡市"},{label:"嘉善县"},{label:"海盐县"}
         ]
         },
         {
         label: '台州',
         areas: [
         {label:"椒江区"},{label:"黄岩区"},{label:"路桥区"},{label:"临海市"},{label:"温岭市"},{label:"玉环县"},{label:"天台县"},{label:"仙居县"},{label:"三门县"}
         ]
         },
         {
         label: '绍兴',
         areas: [
         {label:"越城区"},{label:"诸暨市"},{label:"上虞市"},{label:"嵊州市"},{label:"绍兴县"},{label:"新昌县"}
         ]
         },
         {
         label: '湖州',
         areas: [
         {label:"吴兴区"},{label:"南浔区"},{label:"长兴县"},{label:"德清县"},{label:"安吉县"}
         ]
         },
         {
         label: '丽水',
         areas: [
         {label:"莲都区"},{label:"龙泉市"},{label:"缙云县"},{label:"青田县"},{label:"云和县"},{label:"遂昌县"},{label:"松阳县"},{label:"庆元县"},{label:"景宁畲族自治县"}
         ]
         },
         {
         label: '衢州',
         areas: [
         {label:"柯城区"},{label:"衢江区"},{label:"江山市"},{label:"龙游县"},{label:"常山县"},{label:"开化县"}
         ]
         },
         {
         label: '舟山',
         areas: [
         {label:"定海区"},{label:"普陀区"},{label:"岱山县"},{label:"嵊泗县"}
         ]
         },
         {
         label: '乐清',
         areas: [

         ]
         },
         {
         label: '瑞安',
         areas: [

         ]
         },
         {
         label: '义乌',
         areas: [

         ]
         }
         ]
         },
         {
         label: '安徽',
         cities: [
         {
         label: '合肥',
         areas: [
         {label:"庐阳区"},{label:"瑶海区"},{label:"蜀山区"},{label:"包河区"},{label:"长丰县"},{label:"肥东县"},{label:"肥西县"}
         ]
         },
         {
         label: '芜湖',
         areas: [
         {label:"镜湖区"},{label:"弋江区"},{label:"鸠江区"},{label:"三山区"},{label:"芜湖县"},{label:"南陵县"},{label:"繁昌县"}
         ]
         },
         {
         label: '蚌埠',
         areas: [
         {label:"蚌山区"},{label:"龙子湖区"},{label:"禹会区"},{label:"淮上区"},{label:"怀远县"},{label:"固镇县"},{label:"五河县"}
         ]
         },
         {
         label: '阜阳',
         areas: [
         {label:"颍州区"},{label:"颍东区"},{label:"颍泉区"},{label:"界首市"},{label:"临泉县"},{label:"颍上县"},{label:"阜南县"},{label:"太和县"}
         ]
         },
         {
         label: '淮南',
         areas: [
         {label:"田家庵区"},{label:"大通区"},{label:"谢家集区"},{label:"八公山区"},{label:"潘集区"},{label:"凤台县"}
         ]
         },
         {
         label: '安庆',
         areas: [
         {label:"迎江区"},{label:"大观区"},{label:"宜秀区"},{label:"桐城市"},{label:"宿松县"},{label:"枞阳县"},{label:"太湖县"},{label:"怀宁县"},{label:"岳西县"},{label:"望江县"},{label:"潜山县"}
         ]
         },
         {
         label: '宿州',
         areas: [
         {label:"埇桥区"},{label:"萧县"},{label:"泗县"},{label:"砀山县"},{label:"灵璧县"}
         ]
         },
         {
         label: '六安',
         areas: [
         {label:"金安区"},{label:"裕安区"},{label:"寿县"},{label:"霍山县"},{label:"霍邱县"},{label:"舒城县"},{label:"金寨县"}
         ]
         },
         {
         label: '淮北',
         areas: [
         {label:"相山区"},{label:"杜集区"},{label:"烈山区"},{label:"濉溪县"}
         ]
         },
         {
         label: '滁州',
         areas: [
         {label:"琅琊区"},{label:"南谯区"},{label:"天长市"},{label:"明光市"},{label:"全椒县"},{label:"来安县"},{label:"定远县"},{label:"凤阳县"}
         ]
         },
         {
         label: '马鞍山',
         areas: [
         {label:"雨山区"},{label:"花山区"},{label:"金家庄区"},{label:"当涂县"}
         ]
         },
         {
         label: '铜陵',
         areas: [
         {label:"铜官山区"},{label:"狮子山区"},{label:"郊区"},{label:"铜陵县"}
         ]
         },
         {
         label: '宣城',
         areas: [
         {label:"宣州区"},{label:"宁国市"},{label:"广德县"},{label:"郎溪县"},{label:"泾县"},{label:"旌德县"},{label:"绩溪县"}
         ]
         },
         {
         label: '亳州',
         areas: [
         {label:"谯城区"},{label:"利辛县"},{label:"涡阳县"},{label:"蒙城县"}
         ]
         },
         {
         label: '黄山',
         areas: [
         {label:"屯溪区"},{label:"黄山区"},{label:"徽州区"},{label:"休宁县"},{label:"歙县"},{label:"祁门县"},{label:"黟县"}
         ]
         },
         {
         label: '池州',
         areas: [
         {label:"贵池区"},{label:"东至县"},{label:"石台县"},{label:"青阳县"}
         ]
         },
         {
         label: '巢湖',
         areas: [
         {label:"居巢区"},{label:"含山县"},{label:"无为县"},{label:"庐江县"},{label:"和县"}
         ]
         },
         {
         label: '和县',
         areas: [

         ]
         },
         {
         label: '霍邱',
         areas: [

         ]
         },
         {
         label: '桐城',
         areas: [

         ]
         }
         ]
         },
         {
         label: '广东',
         cities: [
         {
         label: '深圳',
         areas: [
         {label:"福田区"},{label:"罗湖区"},{label:"南山区"},{label:"宝安区"},{label:"龙岗区"},{label:"盐田区"}
         ]
         },
         {
         label: '广州',
         areas: [
         {label:"越秀区"},{label:"荔湾区"},{label:"海珠区"},{label:"天河区"},{label:"白云区"},{label:"黄埔区"},{label:"番禺区"},{label:"花都区"},{label:"南沙区"},{label:"萝岗区"},{label:"增城市"},{label:"从化市"}
         ]
         },
         {
         label: '东莞',
         areas: [

         ]
         },
         {
         label: '佛山',
         areas: [
         {label:"禅城区"},{label:"南海区"},{label:"顺德区"},{label:"三水区"},{label:"高明区"}
         ]
         },
         {
         label: '中山',
         areas: [

         ]
         },
         {
         label: '珠海',
         areas: [
         {label:"香洲区"},{label:"斗门区"},{label:"金湾区"}
         ]
         },
         {
         label: '惠州',
         areas: [
         {label:"惠城区"},{label:"惠阳区"},{label:"博罗县"},{label:"惠东县"},{label:"龙门县"}
         ]
         },
         {
         label: '江门',
         areas: [
         {label:"蓬江区"},{label:"江海区"},{label:"新会区"},{label:"恩平市"},{label:"台山市"},{label:"开平市"},{label:"鹤山市"}
         ]
         },
         {
         label: '汕头',
         areas: [
         {label:"金平区"},{label:"濠江区"},{label:"龙湖区"},{label:"潮阳区"},{label:"潮南区"},{label:"澄海区"},{label:"南澳县"}
         ]
         },
         {
         label: '湛江',
         areas: [
         {label:"赤坎区"},{label:"霞山区"},{label:"坡头区"},{label:"麻章区"},{label:"吴川市"},{label:"廉江市"},{label:"雷州市"},{label:"遂溪县"},{label:"徐闻县"}
         ]
         },
         {
         label: '肇庆',
         areas: [
         {label:"端州区"},{label:"鼎湖区"},{label:"高要市"},{label:"四会市"},{label:"广宁县"},{label:"怀集县"},{label:"封开县"},{label:"德庆县"}
         ]
         },
         {
         label: '茂名',
         areas: [
         {label:"茂南区"},{label:"茂港区"},{label:"化州市"},{label:"信宜市"},{label:"高州市"},{label:"电白县"}
         ]
         },
         {
         label: '揭阳',
         areas: [
         {label:"榕城区"},{label:"普宁市"},{label:"揭东县"},{label:"揭西县"},{label:"惠来县"}
         ]
         },
         {
         label: '梅州',
         areas: [
         {label:"梅江区"},{label:"兴宁市"},{label:"梅县"},{label:"大埔县"},{label:"丰顺县"},{label:"五华县"},{label:"平远县"},{label:"蕉岭县"}
         ]
         },
         {
         label: '清远',
         areas: [
         {label:"清城区"},{label:"英德市"},{label:"连州市"},{label:"佛冈县"},{label:"阳山县"},{label:"清新县"},{label:"连山壮族瑶族自治县"},{label:"连南瑶族自治县"}
         ]
         },
         {
         label: '阳江',
         areas: [
         {label:"江城区"},{label:"阳春市"},{label:"阳西县"},{label:"阳东县"}
         ]
         },
         {
         label: '韶关',
         areas: [
         {label:"浈江区"},{label:"武江区"},{label:"曲江区"},{label:"乐昌市"},{label:"南雄市"},{label:"始兴县"},{label:"仁化县"},{label:"翁源县"},{label:"新丰县"},{label:"乳源瑶族自治县"}
         ]
         },
         {
         label: '河源',
         areas: [
         {label:"源城区"},{label:"紫金县"},{label:"龙川县"},{label:"连平县"},{label:"和平县"},{label:"东源县"}
         ]
         },
         {
         label: '云浮',
         areas: [
         {label:"云城区"},{label:"罗定市"},{label:"云安县"},{label:"新兴县"},{label:"郁南县"}
         ]
         },
         {
         label: '汕尾',
         areas: [
         {label:"城区"},{label:"陆丰市"},{label:"海丰县"},{label:"陆河县"}
         ]
         },
         {
         label: '潮州',
         areas: [
         {label:"湘桥区"},{label:"潮安县"},{label:"饶平县"}
         ]
         },
         {
         label: '台山',
         areas: [

         ]
         },
         {
         label: '阳春',
         areas: [

         ]
         },
         {
         label: '顺德',
         areas: [

         ]
         }
         ]
         },
         {
         label: '福建',
         cities: [
         {
         label: '福州',
         areas: [
         {label:"鼓楼区"},{label:"台江区"},{label:"仓山区"},{label:"马尾区"},{label:"晋安区"},{label:"福清市"},{label:"长乐市"},{label:"闽侯县"},{label:"闽清县"},{label:"永泰县"},{label:"连江县"},{label:"罗源县"},{label:"平潭县"}
         ]
         },
         {
         label: '厦门',
         areas: [
         {label:"思明区"},{label:"海沧区"},{label:"湖里区"},{label:"集美区"},{label:"同安区"},{label:"翔安区"}
         ]
         },
         {
         label: '泉州',
         areas: [
         {label:"鲤城区"},{label:"丰泽区"},{label:"洛江区"},{label:"泉港区"},{label:"石狮市"},{label:"晋江市"},{label:"南安市"},{label:"惠安县"},{label:"永春县"},{label:"安溪县"},{label:"德化县"},{label:"金门县"}
         ]
         },
         {
         label: '莆田',
         areas: [
         {label:"城厢区"},{label:"涵江区"},{label:"荔城区"},{label:"秀屿区"},{label:"仙游县"}
         ]
         },
         {
         label: '漳州',
         areas: [
         {label:"芗城区"},{label:"龙文区"},{label:"龙海市"},{label:"平和县"},{label:"南靖县"},{label:"诏安县"},{label:"漳浦县"},{label:"华安县"},{label:"东山县"},{label:"长泰县"},{label:"云霄县"}
         ]
         },
         {
         label: '宁德',
         areas: [
         {label:"蕉城区"},{label:"福安市"},{label:"福鼎市"},{label:"寿宁县"},{label:"霞浦县"},{label:"柘荣县"},{label:"屏南县"},{label:"古田县"},{label:"周宁县"}
         ]
         },
         {
         label: '三明',
         areas: [
         {label:"梅列区"},{label:"三元区"},{label:"永安市"},{label:"明溪县"},{label:"将乐县"},{label:"大田县"},{label:"宁化县"},{label:"建宁县"},{label:"沙县"},{label:"尤溪县"},{label:"清流县"},{label:"泰宁县"}
         ]
         },
         {
         label: '南平',
         areas: [
         {label:"延平区"},{label:"建瓯市"},{label:"邵武市"},{label:"武夷山市"},{label:"建阳市"},{label:"松溪县"},{label:"光泽县"},{label:"顺昌县"},{label:"浦城县"},{label:"政和县"}
         ]
         },
         {
         label: '龙岩',
         areas: [
         {label:"新罗区"},{label:"漳平市"},{label:"长汀县"},{label:"武平县"},{label:"上杭县"},{label:"永定县"},{label:"连城县"}
         ]
         },
         {
         label: '武夷山',
         areas: [

         ]
         }
         ]
         }*/

    ]
});