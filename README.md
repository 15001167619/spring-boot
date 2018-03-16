# spring-boot 系列学习 https://github.com/yidao620c/SpringBootBucket
jwt： http://blog.csdn.net/u011277123/article/details/78918390

## mybatis-plus  官方文档 http://mp.baomidou.com/#/quick-start

注意

 EntityWrapper<SysUser> ew = new EntityWrapper<SysUser>();
            ew.setEntity(new SysUser());
            ew.where("age<{0}",age)
                    .like("name",name).orderBy("age");
                    
其中，name若为则不执行



