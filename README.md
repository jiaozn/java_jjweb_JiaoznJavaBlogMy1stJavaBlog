# JWeb
JiaoWeb Project Plan我的个人网站计划
-------------------
2016.9.23 星期五
本来决定终止这个练习的，但...
maven来了，ssh框架也换了个bug稍微少点的，尴尬....

------------------------------
2016.10.2   星期日
本来想再加上转发社交软件的功能，后来发现是需要跟网站绑定、接入申请的。除了这个，貌似这个项目基本就完成了吧哈哈


给自己留一个以后使用的备注：
1项目主页，下载zip包到桌面，解压；
2打开myeclipse，import引入-maven-已有的maven项目，选择解压后的文件夹；
3项目引入后，还需要进入WEB-INF/lib，把里面的jar包全选，右键-buildpath-add to build path；
  
  还有注意：已知jdk8是不行的，jdk7没问题，jdk版本不能选jdk8及以上；tomcat6是不行的，tomcat7可以，tomcat不能选择6及以下。
          数据库使用mysql，引擎innoDB，数据库用户名root，密码root（hibernate.cfg.xml中修改）。
          程序启动时会自动建表并初始化一部分数据，需要在mysql中手动新建名为jjweb的数据库create database jjweb;
          现在hibernate.cfg.xml的hbm2dll功能设为create，建议启动一次让程序自动建表后，修改为update，避免程序重启后数据库数据丢失。
          还有，系统默认的管理员用户名jiaozn,密码jiaozn,这个管理员有权限管理功能，在用户管理里面，选择用户，然后修改这个用户的权限数字就可以了。默认不登陆为游客，权限2,普通登录用户权限5,管理员权限7。只有管理员才大权在握，拥有网站的实际管理权限。
