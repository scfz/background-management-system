<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/6/5
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/utils/tools.jsp" %>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
  <title>后台管理系统-商家列表</title>
  <link rel="icon" href="${ctx}/static/images/favicon.ico" type="image/ico">
  <meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
  <meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
  <meta name="author" content="yinqi">
  <link rel="stylesheet" href="https://www.jq22.com/jquery/bootstrap-3.3.4.css">
  <link href="${ctx}/static/bootstrap/css/materialdesignicons.min.css" rel="stylesheet">
  <link href="${ctx}/static/bootstrap/css/style.min.css" rel="stylesheet">
</head>

<body>
<div class="lyear-layout-web">
  <div class="lyear-layout-container">
    <!--左侧导航-->
    <aside class="lyear-layout-sidebar">

      <!-- logo -->
      <div id="logo" class="sidebar-header">
        <a href="index.html"><img src="${ctx}/static/bootstrap/images/logo-sidebar.png" title="LightYear"
                                  alt="LightYear"/></a>
      </div>
      <div class="lyear-layout-sidebar-scroll">

        <nav class="sidebar-main">
          <ul class="nav nav-drawer">

            <c:forEach var="menu" items="${menuList}">
              <li
                      class="nav-item open
                                        <c:if test="${not empty menu.list}">
                                        nav-item-has-subnav open
                                        </c:if>
                                        <c:if test="${menu.id==3}">
                                            active
                                        </c:if>"
              ><a href="${not empty menu.href?(ctx.concat(menu.href)):"#!"}"><i
                      class="${menu.icon}"></i>${menu.title}
              </a>
                <ul class=" nav nav-subnav">
                  <c:if test="${not empty menu.list}">
                    <c:forEach var="menuItem" items="${menu.list}">
                      <li><a href="${ctx}${menuItem.href}">${menuItem.title}</a></li>
                    </c:forEach>
                  </c:if>
                </ul>
              </li>
            </c:forEach>

          </ul>
        </nav>

        <div class="sidebar-footer">
        </div>
      </div>

    </aside>
    <!--End 左侧导航-->

    <!--头部信息-->
    <header class="lyear-layout-header">

      <nav class="navbar navbar-default">
        <div class="topbar">

          <div class="topbar-left">
            <div class="lyear-aside-toggler">
              <span class="lyear-toggler-bar"></span>
              <span class="lyear-toggler-bar"></span>
              <span class="lyear-toggler-bar"></span>
            </div>
            <span class="navbar-page-title"> 商家管理  : </span>
          </div>

          <ul class="topbar-right">
            <li class="dropdown dropdown-profile">
              <a href="javascript:void(0)" data-toggle="dropdown">
                <img class="img-avatar img-avatar-48 m-r-10"
                     src="${ctx}/static/bootstrap/images/users/avatar.jpg" alt="后台系统"/>
                <span>${userInfo.nickName}<span class="caret"></span></span>
              </a>
              <ul class="dropdown-menu dropdown-menu-right">
                <li><a href="lyear_pages_profile.html"><i class="mdi mdi-account"></i> 个人信息</a></li>
                <li><a href="lyear_pages_edit_pwd.html"><i class="mdi mdi-lock-outline"></i>
                  修改密码</a></li>
                <li><a href="javascript:void(0)"><i class="mdi mdi-delete"></i> 清空缓存</a></li>
                <li class="divider"></li>
                <li><a href="lyear_pages_login.html"><i class="mdi mdi-logout-variant"></i> 退出登录</a>
                </li>
              </ul>
            </li>
            <!--切换主题配色-->
            <li class="dropdown dropdown-skin">
              <span data-toggle="dropdown" class="icon-palette"><i class="mdi mdi-palette"></i></span>
              <ul class="dropdown-menu dropdown-menu-right" data-stopPropagation="true">
                <li class="drop-title"><p>主题</p></li>
                <li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="site_theme" value="default" id="site_theme_1" checked>
                    <label for="site_theme_1"></label>
                  </span>
                  <span>
                    <input type="radio" name="site_theme" value="dark" id="site_theme_2">
                    <label for="site_theme_2"></label>
                  </span>
                  <span>
                    <input type="radio" name="site_theme" value="translucent" id="site_theme_3">
                    <label for="site_theme_3"></label>
                  </span>
                </li>
                <li class="drop-title"><p>LOGO</p></li>
                <li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="logo_bg" value="default" id="logo_bg_1" checked>
                    <label for="logo_bg_1"></label>
                  </span>
                  <span>
                    <input type="radio" name="logo_bg" value="color_2" id="logo_bg_2">
                    <label for="logo_bg_2"></label>
                  </span>
                  <span>
                    <input type="radio" name="logo_bg" value="color_3" id="logo_bg_3">
                    <label for="logo_bg_3"></label>
                  </span>
                  <span>
                    <input type="radio" name="logo_bg" value="color_4" id="logo_bg_4">
                    <label for="logo_bg_4"></label>
                  </span>
                  <span>
                    <input type="radio" name="logo_bg" value="color_5" id="logo_bg_5">
                    <label for="logo_bg_5"></label>
                  </span>
                  <span>
                    <input type="radio" name="logo_bg" value="color_6" id="logo_bg_6">
                    <label for="logo_bg_6"></label>
                  </span>
                  <span>
                    <input type="radio" name="logo_bg" value="color_7" id="logo_bg_7">
                    <label for="logo_bg_7"></label>
                  </span>
                  <span>
                    <input type="radio" name="logo_bg" value="color_8" id="logo_bg_8">
                    <label for="logo_bg_8"></label>
                  </span>
                </li>
                <li class="drop-title"><p>头部</p></li>
                <li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="header_bg" value="default" id="header_bg_1" checked>
                    <label for="header_bg_1"></label>
                  </span>
                  <span>
                    <input type="radio" name="header_bg" value="color_2" id="header_bg_2">
                    <label for="header_bg_2"></label>
                  </span>
                  <span>
                    <input type="radio" name="header_bg" value="color_3" id="header_bg_3">
                    <label for="header_bg_3"></label>
                  </span>
                  <span>
                    <input type="radio" name="header_bg" value="color_4" id="header_bg_4">
                    <label for="header_bg_4"></label>
                  </span>
                  <span>
                    <input type="radio" name="header_bg" value="color_5" id="header_bg_5">
                    <label for="header_bg_5"></label>
                  </span>
                  <span>
                    <input type="radio" name="header_bg" value="color_6" id="header_bg_6">
                    <label for="header_bg_6"></label>
                  </span>
                  <span>
                    <input type="radio" name="header_bg" value="color_7" id="header_bg_7">
                    <label for="header_bg_7"></label>
                  </span>
                  <span>
                    <input type="radio" name="header_bg" value="color_8" id="header_bg_8">
                    <label for="header_bg_8"></label>
                  </span>
                </li>
                <li class="drop-title"><p>侧边栏</p></li>
                <li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="sidebar_bg" value="default" id="sidebar_bg_1" checked>
                    <label for="sidebar_bg_1"></label>
                  </span>
                  <span>
                    <input type="radio" name="sidebar_bg" value="color_2" id="sidebar_bg_2">
                    <label for="sidebar_bg_2"></label>
                  </span>
                  <span>
                    <input type="radio" name="sidebar_bg" value="color_3" id="sidebar_bg_3">
                    <label for="sidebar_bg_3"></label>
                  </span>
                  <span>
                    <input type="radio" name="sidebar_bg" value="color_4" id="sidebar_bg_4">
                    <label for="sidebar_bg_4"></label>
                  </span>
                  <span>
                    <input type="radio" name="sidebar_bg" value="color_5" id="sidebar_bg_5">
                    <label for="sidebar_bg_5"></label>
                  </span>
                  <span>
                    <input type="radio" name="sidebar_bg" value="color_6" id="sidebar_bg_6">
                    <label for="sidebar_bg_6"></label>
                  </span>
                  <span>
                    <input type="radio" name="sidebar_bg" value="color_7" id="sidebar_bg_7">
                    <label for="sidebar_bg_7"></label>
                  </span>
                  <span>
                    <input type="radio" name="sidebar_bg" value="color_8" id="sidebar_bg_8">
                    <label for="sidebar_bg_8"></label>
                  </span>
                </li>
              </ul>
            </li>
            <!--切换主题配色-->
          </ul>

        </div>
      </nav>

    </header>
    <!--End 头部信息-->

    <!--页面主要内容-->
    <main class="lyear-layout-content">

      <div class="container-fluid">

        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-toolbar clearfix">
                <form class="pull-right search-bar" method="get" action="#!" role="form">
                  <div class="input-group">
                    <div class="input-group-btn">
                      <input type="hidden" name="search_field" id="search-field" value="title">
                      <button class="btn btn-default dropdown-toggle" id="search-btn"
                              data-toggle="dropdown" type="button" aria-haspopup="true"
                              aria-expanded="false">
                        店名 <span class="caret"></span>
                      </button>
                    </div>
                    <input type="text" class="form-control" value="${keyword}" name="keyword"
                           placeholder="请输入名称">
                  </div>
                </form>
                <div class="toolbar-btn-action">
                  <a class="btn btn-primary m-r-5" href="#!"
                     data-toggle="modal" data-target="#editMenu"
                     onclick="addBusiness()"
                  ><i class="mdi mdi-plus"></i> 新增</a>
                  <a class="btn btn-success m-r-5" href="#!" onclick="enableBusiness()"><i
                          class="mdi mdi-check"></i> 启用</a>
                  <a class="btn btn-warning m-r-5" href="#!"><i class="mdi mdi-block-helper"></i> 禁用</a>
                  <a class="btn btn-danger" href="#!" onclick="batchDeleteBusiness()"><i
                          class="mdi mdi-window-close"></i> 删除</a>
                </div>
              </div>
              <div class="card-body">

                <div class="table-responsive">
                  <table class="table table-bordered">
                    <thead>
                    <tr>
                      <th>
                        <label class="lyear-checkbox checkbox-primary">
                          <input type="checkbox" id="check-all"><span></span>
                        </label>
                      </th>
                      <th>编号</th>
                      <th>账户名</th>
                      <th>头像</th>
                      <th>店名</th>
                      <th>地址</th>
                      <th>联系方式</th>
                      <th>创建时间</th>
                      <th>状态</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="business" items="${businessList}" varStatus="status">
                      <tr>
                        <td>
                          <label class="lyear-checkbox checkbox-primary">
                            <input type="checkbox" name="ids[]" value="${business.id}"
                            ><span></span>
                          </label>
                        </td>
                        <td>${status.index+1}</td>
                        <td>${business.user_name}</td>
                        <td>${business.avatar}</td>
                        <td>${business.shop_name}</td>
                        <td>${business.address}</td>
                        <td>${business.tel}</td>
                        <!--通过fmt标签格式化时间-->
                        <td><fmt:formatDate value="${business.create_time}" pattern="yyyy年MM月dd日 HH:mm:ss"></fmt:formatDate></td>
                        <td>
                          <c:if test="${business.status==1}">
                            <font class="text-success">营业中</font>
                          </c:if>
                          <c:if test="${business.status==2}">
                            <font class="text-error">打样</font>
                          </c:if>
                          <c:if test="${business.status==0 }">
                            <font class="text-error">无效</font>
                          </c:if>
                        </td>
                        <td>
                          <div class="btn-group">
                            <a data-toggle="modal" data-target="#editMenu"
                               class="btn btn-xs btn-default" href="#!" title="编辑"
                               data-toggle="tooltip"
                               onclick="editBusiness(${business.id})"
                            ><i class="mdi mdi-pencil"></i></a>
                            <c:if test="${business.status==1 || business.status==2}">
                              <a class="btn btn-xs btn-default" href="#!" title="删除"
                                 data-toggle="tooltip"
                                 onclick="deleteBusiness(${business.id})"
                              ><i class="mdi mdi-window-close"></i></a>
                            </c:if>
                          </div>
                        </td>
                      </tr>
                    </c:forEach>


                    </tbody>
                  </table>
                  <form id="menuForm">
                    <div class="modal fade" id="editMenu" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel">
                      <div class="modal-dialog" role="document">
                        <div class="modal-content">
                          <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"
                                    aria-label="Close"><span
                                    aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="newMenu">修改商家 : </h4>
                          </div>
                          <div class="modal-body">
                            <form>
                              <input type="hidden" id="id">
                              <div class="form-group">
                                <label for="accountName"
                                       class="control-label">账户名：</label>
                                <i id="accountName-prompt"></i>
                                <input type="text" class="form-control"
                                       id="accountName" onkeydown="judge(1)">
                              </div>
                              <div class="form-group" id="mm">
                                <label for="password"
                                       class="control-label">密码：</label>
                                <i id="password-prompt"></i>
                                <input type="text" class="form-control"
                                       id="password" onkeydown="judgeaaq(2)">
                              </div>
                              <div class="form-group">
                                <label for="avatar"
                                       class="control-label">头像：</label>
                                <i id="avatar-prompt"></i>
                                <input type="text" class="form-control"
                                       id="avatar" onkeydown="judge(3)">
                              </div>
                              <div class="form-group">
                                <label for="shopName" class="control-label">店名：</label>
                                <i id="shopName-prompt"></i>
                                <input type="text" class="form-control" id="shopName">
                              </div>
                              <div class="form-group">
                                <label for="href" class="control-label">地址：</label>
                                <i id="href-prompt"></i>
                                <input type="text" class="form-control" id="href">
                              </div>
                              <div class="form-group">
                                <label for="tel" class="control-label">tel：</label>
                                <i id="tel-prompt"></i>
                                <input type="text" class="form-control" id="tel">
                              </div>
                              <div class="form-group" id="state">
                                <label for="status" class="control-label">状态：</label>
                                <select class="form-control" id="status"
                                        name="example-select" size="1">
                                  <option value="-1" >请选择</option>
                                  <option value="0"
                                          <c:if test="${business.status==0}">
                                            selected
                                          </c:if>>注销</option>
                                  <option value="1"
                                          <c:if test="${business.status==1}">
                                            selected
                                          </c:if>>营业中</option>
                                  <option value="2"
                                          <c:if test="${business.status==2}">
                                            selected
                                          </c:if>>打样</option>
                                </select>
                              </div>
                            </form>
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-default"
                                    data-dismiss="modal">
                              关闭
                            </button>
                            <button type="button" class="btn btn-primary"
                                    onclick="saveBusiness()">
                              保存
                            </button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </form>
                </div>

              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
    <!--End 页面主要内容-->
  </div>
</div>

<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="https://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/js/main.min.js"></script>
<script type="text/javascript">
  var type;  // 1 新增  2 修改
  $(function () {
    $('.search-bar .dropdown-menu a').click(function () {
      var field = $(this).data('field') || '';
      $('#search-field').val(field);
      $('#search-btn').html($(this).text() + ' <span class="caret"></span>');
    });
  });

  // 点击新增按钮调用
  function addBusiness() {
    x();
    type = 1;
    document.getElementById("menuForm").reset();
    document.getElementById("newMenu").innerHTML = "新增商家";
    document.getElementById("mm").setAttribute("style","display: block");  // 密码框出现
    document.getElementById("state").setAttribute("style","display: none"); // 状态框消失
  }

  // 点击编辑按钮时,获取数据库内容
  function editBusiness(id) {
    x();
    type = 2;
    document.getElementById("newMenu").innerHTML = "修改商家";
    document.getElementById("menuForm").reset();  // 重置表单
    document.getElementById("mm").setAttribute("style","display: none");  // 密码框出现
    document.getElementById("state").setAttribute("style","display: block"); // 状态框出现
    $.ajax({
      url: "${ctx}/api/business/getBusiness",
      type: "get",
      dataType: "json",
      data: {
        id: id
      }, success(res) {
        if (res.code == 200) {
          document.getElementById("id").value = res.data.id;
          document.getElementById("accountName").value = res.data.userName;
          document.getElementById("password").value = res.data.password;
          document.getElementById("avatar").value = res.data.avatar;
          document.getElementById("shopName").value = res.data.shopName;
          document.getElementById("href").value = res.data.address;
          document.getElementById("tel").value = res.data.tel;
          document.getElementById("status").value = res.data.status;
        } else {
          alert(res.msg)
          //TODO 关闭模态框
        }
      }
    })
  }

  /**
   * 保存弹窗内的内容
   *     修改表单 和 新建表单 都调用此方法
   * */
  function saveBusiness() {
    if (checkBusiness()) {
      let id = document.getElementById("id").value;
      let accountName = document.getElementById("accountName").value;
      let passWord = document.getElementById("password").value;
      let avatar = document.getElementById("avatar").value;
      let shopName = document.getElementById("shopName").value;
      let href = document.getElementById("href").value;
      let tel = document.getElementById("tel").value;
      let status = document.getElementById("status").value;
      let url;
      if (type == 1) {
        url = "${ctx}/api/business/addBusiness"   // 新建菜单
      } else {
        url = "${ctx}/api/business/editBusiness"  // 修改菜单
      }
      $.ajax({
        url: url,
        type: "post",
        dataType: "json",
        data: {
          id: id,
          accountName: accountName,
          passWord: passWord,
          avatar: avatar,
          shopName:shopName,
          href: href,
          tel: tel,
          status:status
        }, success(res) {
          if (res.code == 200) {
            //成功
            location.reload();
          }
        }
      })
    } else {
      //错误提示
      alert("修改失败")
    }

  }

  /**
   * 判断输入内容是否是空值
   *    输入参数为1 只判断title
   * */
  function checkBusiness() {
    if (type != 1) {
      let id = document.getElementById("id").value;
      if (id == null || id == "") {
        return false;
      }
    }
    let title = document.getElementById("accountName").value;
    if (title == null || title == "") {
      return false;
    }
    return true;
  }

  /**
   * 批量删除菜单
   * */
  function batchDeleteBusiness() {
    let checkedIds1 = "";
    var ids1 = document.getElementsByName("ids[]");
    for (let item1 of ids1) {
      if (item1.checked) {
        checkedIds1 += item1.value + ","
      }
    }
    if (checkedIds1.length > 0) {
      if (confirm("确认删除吗？")) {
        $.ajax({
          url: "${ctx}/api/business/batchDeleteBusiness",
          type: "post",
          dataType: "json",
          data: {
            ids: checkedIds1
          }, success(res) {
            if (res.code == 200) {
              location.reload();
            } else {
              alert(res.msg);
            }
          }
        })
      }
    } else {
      alert("请选择数据")
    }
  }

  /**
   * 删除菜单
   * */
  function deleteBusiness(id) {
    if (confirm("确认删除吗？")) {
      $.ajax({
        url: "${ctx}/api/business/deleteBusiness",
        type: "post",
        dataType: "json",
        data: {
          id: id
        }, success(res) {
          if (res.code == 200) {
            location.reload();
          } else {
            alert(res.msg);
          }
        }
      })
    }
  }

  /**
   * 点击启用按钮
   * 启用
   * */
  function enableBusiness() {
    let checkedIds = "";
    var ids = document.getElementsByName("ids[]");
    for (let item of ids) {
      if (item.checked) {
        checkedIds += item.value + ","
      }
    }
    if (checkedIds.length > 0) {
      $.ajax({
        url: "${ctx}/api/business/enableBusiness",
        type: "post",
        dataType: "json",
        data: {
          ids: checkedIds
        }, success(res) {
          if (res.code == 200) {
            location.reload()
          } else {
            alert(res.msg)
          }
        }
      })
    } else {
      alert("请先选择数据")
    }
  }
  function x() {
    let ca = document.getElementsByTagName("i");
    for (let x of ca) {
       x.style.color="grey";
    }
    document.getElementById("accountName-prompt").innerText = "请输入3~15位字符";
    document.getElementById("password-prompt").innerText = "区分大小写,不能写特殊字符";
    document.getElementById("avatar-prompt").innerText = "支持GIF,PNG,JPG格式"
    document.getElementById("tel-prompt").innerText = "输入11位手机号";
    document.getElementById("href-prompt").innerText = "具体到省市区";
  }
  function judge(bd) {
    switch (bd) {
      case 1:
        let accountName = document.getElementById("accountName").value;
        if (accountName == null || accountName == "") {
          document.getElementById("accountName-input").innerText = "⚠ 账号不能为空";
        } else {
          let accountName1 = /^[a-zA-Z0-9_]{1,50}$/
          if (!accountName1.test(accountName)) {
            document.getElementById("accountName-prompt").setAttribute("style", "color: red");
            document.getElementById("accountName-prompt").innerText = "⚠ 账号格式不正确";
          } else {
            document.getElementById("accountName-prompt").setAttribute("style", "color: green");
            document.getElementById("accountName-prompt").innerText = "√ 账号格式正确";
          }
        }
        break;
      case 2:
        let password = document.getElementById("password-prompt");
        let passwordValue = password.value;
        if (passwordValue == null || passwordValue === "") {
          password.innerText = "⚠ 密码不能为空";
        } else {
          let password1 = /^\w{5,17}$/
          if (!password1.test(passwordValue)) {
            password.setAttribute("style", "color: red");
            password.innerText = "⚠ 密码格式不正确";
          } else {
            password.setAttribute("style", "color: green");
            password.innerText = "√ 密码格式正确";
          }
        }
        break;
      case 3:
        let avatar = document.getElementById("avatar-prompt").value;
        if (avatar == "*.jpg" || avatar == "*.png" || avatar == "*.gif") {
          avatar.setAttribute("style", "color: green");
          avatar.innerText = "√ 格式正确";
        } else {
          avatar.setAttribute("style", "color: red");
          avatar.innerText = "⚠ 格式不正确";
        }
        break;
      case 4:
        let href = document.getElementById("href-prompt").value;
    }
  }


</script>
</body>
</html>
