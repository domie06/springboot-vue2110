<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">


<head>
    <%@ include file="../../static/head.jsp" %>
    <!-- font-awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
</head>
<style>

</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">
                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">化妆品管理</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">化妆品管理</li>
                        <li class="breadcrumb-item active">化妆品列表</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">化妆品列表</h3>
                        <button onclick="purchase()" type="button" class="btn btn-success">下订单</button>
                        <div class="table-responsive mb-3">
                            <table id="tableId" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th class="no-sort" style="min-width: 35px;">
                                        <div class="custom-control custom-checkbox">
                                            <input class="custom-control-input" type="checkbox" id="select-all"
                                                   onclick="chooseAll()">
                                            <label class="custom-control-label" for="select-all"></label>
                                        </div>
                                    </th>

                                    <th >化妆品名称</th>
                                    <th >品牌</th>
                                    <th >类型</th>
                                    <th >工艺</th>
                                    <th >价格</th>
                                    <th >图片</th>
                                    <th>购买数量</th>
                                </tr>
                                </thead>
                                <tbody id="thisTbody">
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->

    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script language="javascript" type="text/javascript"
        src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>

<script>
    <%@ include file="../../utils/menu.jsp"%>
            <%@ include file="../../static/setMenu.js"%>
            <%@ include file="../../utils/baseUrl.jsp"%>
            <%@ include file="../../static/getRoleButtons.js"%>
            <%@ include file="../../static/crossBtnControl.js"%>
    var tableName = "huazhuangpin";
    var pageType = "list";
    var searchForm = {key: ""};
    var pageIndex = 1;
    var pageSize = 10;
    var totalPage = 0;
    var dataList = [];
    var sortColumn = '';
    var sortOrder = '';
    var ids = [];
    var checkAll = false;


    var pinpaiTypesOptions = [];
    var leixingTypesOptions = [];
    var gongyiTypesOptions = [];

    function init() {
        // 满足条件渲染提醒接口
    }

    // 改变每页记录条数
    function changePageSize() {
        var selection = document.getElementById('selectPageSize');
        var index = selection.selectedIndex;
        pageSize = selection.options[index].value;
        getDataList();
    }




    // 获取数据列表
    function getDataList() {
        http("huazhuangpin/page", "GET", {
            page: pageIndex,
            limit: pageSize,
            sort: sortColumn,
            order: sortOrder,
            //本表的
            kzpname: searchForm.kzpname,
            pinpaiTypes: searchForm.pinpaiTypes,
            leixingTypes: searchForm.leixingTypes,
            gongyiTypes: searchForm.gongyiTypes,
            //级联表的

        }, (res) => {
            if(res.code == 0) {
                clear();
                $("#thisTbody").html("");
                dataList = res.data.list;
                totalPage = res.data.totalPage;
                for (var i = 0; i < dataList.length; i++) { //遍历一下表格数据  
                    var trow = setDataRow(dataList[i], i); //定义一个方法,返回tr数据 
                    $('#thisTbody').append(trow);
                }
                getRoleButtons();// 权限按钮控制
            }
        });
    }

    // 渲染表格数据
    function setDataRow(item, number) {
        //创建行 
        var row = document.createElement('tr');
        row.setAttribute('class', 'useOnce');
        //创建勾选框
        var checkbox = document.createElement('td');
        var checkboxDiv = document.createElement('div');
        checkboxDiv.setAttribute("class", "custom-control custom-checkbox");
        var checkboxInput = document.createElement('input');
        checkboxInput.setAttribute("class", "custom-control-input");
        checkboxInput.setAttribute("type", "checkbox");
        checkboxInput.setAttribute('name', 'chk');
        checkboxInput.setAttribute('value', item.id);
        checkboxInput.setAttribute("id", number);
        checkboxDiv.appendChild(checkboxInput);
        var checkboxLabel = document.createElement('label');
        checkboxLabel.setAttribute("class", "custom-control-label");
        checkboxLabel.setAttribute("for", number);
        checkboxDiv.appendChild(checkboxLabel);
        checkbox.appendChild(checkboxDiv);
        row.appendChild(checkbox)



        //化妆品名称
        var kzpnameCell = document.createElement('td');
        kzpnameCell.innerHTML = item.kzpname;
        row.appendChild(kzpnameCell);


        //品牌
        var pinpaiTypesCell = document.createElement('td');
        pinpaiTypesCell.innerHTML = item.pinpaiValue;
        row.appendChild(pinpaiTypesCell);


        //类型
        var leixingTypesCell = document.createElement('td');
        leixingTypesCell.innerHTML = item.leixingValue;
        row.appendChild(leixingTypesCell);


        //工艺
        var gongyiTypesCell = document.createElement('td');
        gongyiTypesCell.innerHTML = item.gongyiValue;
        row.appendChild(gongyiTypesCell);


        //价格
        var expenseCell = document.createElement('td');
        expenseCell.innerHTML = item.expense;
        row.appendChild(expenseCell);

            //图片
        var imgPhotoCell = document.createElement('td');
        var imgPhotoImg = document.createElement('img');
        var imgPhotoImgValue = item.imgPhoto;
        if(imgPhotoImgValue !=null && imgPhotoImgValue !='' && imgPhotoImgValue !='null'){
            imgPhotoImg.setAttribute('src', imgPhotoImgValue);
            imgPhotoImg.setAttribute('height', 100);
            imgPhotoImg.setAttribute('width', 100);
            imgPhotoCell.appendChild(imgPhotoImg);
        }else{
            imgPhotoCell.innerHTML = "暂无图片";
        }
        row.appendChild(imgPhotoCell);



        //每行按钮
        var btnGroup = document.createElement('td');

        //删除按钮
        var deleteBtn = document.createElement('input');
        deleteBtn.setAttribute("type", "number");
        deleteBtn.setAttribute("class", "form-control");
        deleteBtn.setAttribute("style", "width: 150px;height: 50px;margin-left: 40px;margin-top: 20px");
        deleteBtn.setAttribute("id", "id"+item.id);
        deleteBtn.setAttribute("value", "1");
        btnGroup.appendChild(deleteBtn)

        row.appendChild(btnGroup)
        return row;
    }


    // 全选/全不选
    function chooseAll() {
        checkAll = !checkAll;
        var boxs = document.getElementsByName("chk");
        for (var i = 0; i < boxs.length; i++) {
            boxs[i].checked = checkAll;
        }
    }

    // 批量删除
    function purchase() {
        var paramArray = {}
        var boxs = document.getElementsByName("chk");
        for (var i = 0; i < boxs.length; i++) {
            if (boxs[i].checked) {
                if($("#id"+boxs[i].value).val() != null && $("#id"+boxs[i].value).val() != ""){
                    paramArray[boxs[i].value] = $("#id"+boxs[i].value).val()
                }
            }
        }
        if (paramArray.length == 0) {
            alert('请勾选要购买的化妆品');
        } else {
            var mymessage = confirm("您确定要提交订单吗？");
            if (mymessage == true) {
                httpJson("dingdan/purchase", "post", paramArray, (res) => {
                    if(res.code == 0 )
                {
                    getDataList();
                    alert('成功下单，请耐心等待哦');
                }
            }) ;
            }
            else {
                alert("已取消操作");
            }
        }
    }

    // 用户登出
    <%@ include file="../../static/logout.jsp"%>


    //清除会重复渲染的节点
    function clear() {
        var elements = document.getElementsByClassName('useOnce');
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }



        function pinpaiTypesSelectSearch() {
            var pinpaiTypesSelectSearch = document.getElementById('pinpaiTypesSelectSearch');
            if(pinpaiTypesSelectSearch != null) {
                pinpaiTypesSelectSearch.add(new Option('-请选择-',''));
                if (pinpaiTypesOptions != null && pinpaiTypesOptions.length > 0){
                    for (var i = 0; i < pinpaiTypesOptions.length; i++) {
                            pinpaiTypesSelectSearch.add(new Option(pinpaiTypesOptions[i].indexName,pinpaiTypesOptions[i].codeIndex));
                    }
                }
            }
        }
     
        function leixingTypesSelectSearch() {
            var leixingTypesSelectSearch = document.getElementById('leixingTypesSelectSearch');
            if(leixingTypesSelectSearch != null) {
                leixingTypesSelectSearch.add(new Option('-请选择-',''));
                if (leixingTypesOptions != null && leixingTypesOptions.length > 0){
                    for (var i = 0; i < leixingTypesOptions.length; i++) {
                            leixingTypesSelectSearch.add(new Option(leixingTypesOptions[i].indexName,leixingTypesOptions[i].codeIndex));
                    }
                }
            }
        }
     
        function gongyiTypesSelectSearch() {
            var gongyiTypesSelectSearch = document.getElementById('gongyiTypesSelectSearch');
            if(gongyiTypesSelectSearch != null) {
                gongyiTypesSelectSearch.add(new Option('-请选择-',''));
                if (gongyiTypesOptions != null && gongyiTypesOptions.length > 0){
                    for (var i = 0; i < gongyiTypesOptions.length; i++) {
                            gongyiTypesSelectSearch.add(new Option(gongyiTypesOptions[i].indexName,gongyiTypesOptions[i].codeIndex));
                    }
                }
            }
        }
            
    //查询级联表搜索条件所有列表

    //查询当前表搜索条件所有列表
        function pinpaiTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=pinpai_types", "GET", {}, (res) => {
                if(res.code == 0){
                    pinpaiTypesOptions = res.data.list;
                }
            });
        }
        function leixingTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=leixing_types", "GET", {}, (res) => {
                if(res.code == 0){
                    leixingTypesOptions = res.data.list;
                }
            });
        }
        function gongyiTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=gongyi_types", "GET", {}, (res) => {
                if(res.code == 0){
                    gongyiTypesOptions = res.data.list;
                }
            });
        }


    $(document).ready(function () {
        //激活翻页按钮
        $('#tableId_previous').attr('class', 'paginate_button page-item previous')
        $('#tableId_next').attr('class', 'paginate_button page-item next')
        //隐藏原生搜索框
        $('#tableId_filter').hide()
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        setMenu();
        init();

        //查询级联表的搜索下拉框

        //查询当前表的搜索下拉框
        pinpaiTypesSelect();
        leixingTypesSelect();
        gongyiTypesSelect();
        getDataList();


            pinpaiTypesSelectSearch();
             
            leixingTypesSelectSearch();
             
            gongyiTypesSelectSearch();
                                    
    <%@ include file="../../static/myInfo.js"%>
    });
</script>
</body>

</html>