<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Channa Jayamuni</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>

            <!--start home-->
            <li class="active">
                <a href="#">
                    <i class="fa fa-th"></i> <span>Home</span>
                </a>
            </li>
            <!--end home-->

            <!--start control panels-->
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>Control Panel</span> <i class="fa fa-angle-left pull-right"></i>
                </a>
                
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/app/item-list"><i class="fa fa-circle-o"></i> Item Control Panel</a></li>
                    <li><a href="${pageContext.request.contextPath}/app/customer-list"><i class="fa fa-circle-o"></i> Customer Control Panel</a></li>
                    <li><a href="${pageContext.request.contextPath}/app/supplier-list"><i class="fa fa-circle-o"></i> Supplier Control Panel</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i> User Control Panel</a></li>
                </ul>
            </li>
            <!--end control panels-->
            
            <!--start approval-->
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-check"></i> <span>Approval</span> <i class="fa fa-angle-left pull-right"></i>
                </a>
                
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/app/customer-approval"><i class="fa fa-circle-o"></i> Customer Approval</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i> Order Approval</a></li>
                </ul>
            </li>
            <!--end approval-->
            
            <!--start reports-->
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-files-o"></i> <span>Reports</span> <i class="fa fa-angle-left pull-right"></i>
                </a>
                
                <ul class="treeview-menu">
                    <li><a href="#"><i class="fa fa-circle-o"></i> Order Summary</a></li>
                </ul>
            </li>
            <!--end reports-->
            
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>