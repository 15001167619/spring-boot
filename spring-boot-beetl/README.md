# spring-boot-beetl 学习 

## 学习文档

- [spring-cloud-cluster-eureka(本机集群启动方式)](https://weibo.com/ttarticle/p/show?id=2309404230835917206231#_0)
https://blog.csdn.net/y19910825/article/details/78983113

## Beetl的核心是GroupTemplate，创建GroupTemplate需要俩个参数，一个是模板资源加载器，一个是配置类
### Beetl内置模板资源加载器
####StringTemplateResourceLoader：字符串模板加载器，用于加载字符串模板，如本例所示
####FileResourceLoader：文件模板加载器，需要一个根目录作为参数构造，传入getTemplate方法的String是模板文件相对于Root目录的相对路径
####ClasspathResourceLoader：文件模板加载器，模板文件位于Classpath里
####WebAppResourceLoader：用于webapp集成，假定模板根目录就是WebRoot目录
####MapResourceLoader : 可以动态存入模板
####CompositeResourceLoader 混合使用多种加载方式