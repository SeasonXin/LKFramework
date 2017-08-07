# 欢迎使用LKFramework框架

------

lichkin-springboot-starter-base是基于springboot实现了一些基础的架构功能。引入此项目并使用com.lichkin.LKMain来启动项目即可。

本项目实现了RollingFile的方式记录日志。
##1 在启动方法参数传入system_tag projectName（注：这是两个参数，具体请参见log4j2 http://logging.apache.org/log4j/2.x/ 的Main Arguments Lookup）以实现日志目录的定制化。
> * 日志文件将会存入/lichkin-logs目录中。
> * 以projectName.debug.log存放debug日志。
> * 以projectName.error.log存放error日志。
> * 以/lichkin-logs/projectName/yyyy/yyyy-MM/yyyy-MM-dd/yyyy-MM-dd-HH-debug-x.log.gz存放debug日志压缩包。
> * 以/lichkin-logs/projectName/yyyy/yyyy-MM/yyyy-MM-dd/yyyy-MM-dd-HH-mm-error-x.log.gz存放error日志压缩包。

##2 在启动参数传入system_name demo 以实现项目名称指定（此值将会在web页面展现等）。

##3 在启动参数传入system_loglevel warn（注：这是两个参数，具体请参见log4j2 http://logging.apache.org/log4j/2.x/ 的Main Arguments Lookup）以实现org、net包日志级别的定制化（默认值是warn）。

##4 在启动参数传入--spring.profiles.active=development以实现profile的定制化。（具体请参见springboot http://projects.spring.io/spring-boot/ ）

------
![苏州鑫宏利业信息科技有限公司](https://avatars2.githubusercontent.com/u/30554748?v=4&s=200=400x400)

苏州鑫宏利业信息科技有限公司

