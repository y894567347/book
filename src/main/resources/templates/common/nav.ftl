<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li class="sidebar-brand">
            <a href="#">
                后台管理
            </a>
        </li>

        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 图书管理 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header">操作</li>
                <li><a href="/book/admin/book/booklist">书籍列表</a></li>
                <li><a href="/book/admin/book/addindex">增添书籍</a></li>
            </ul>
        </li>
        <li class="dropdown open">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 类目管理 <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <li class="dropdown-header">操作</li>
                <li><a href="/book/admin/category/list">类目列表</a></li>
                <li><a href="/book/admin/category/addindex">添加类目</a></li>
            </ul>
        </li>

        <li>
            <a href="/book/loginout"><i class="fa fa-fw fa-list-alt"></i> 登出</a>
        </li>
    </ul>
</nav>
<script src="/book/js/nav.js"></script>