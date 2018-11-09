springboot,springcloud都是微服务框架，Spring Boot 的核心思想就是约定大于配置，Spring Boot 应用只需要很少的 Spring 配置，采用 Spring Boot 可以大大的简化你的开发模式，所有你想集成的常用框架，它都有对应的组件支持。他默认支持模板的是html，数据需要通过thymeleaf来渲染。
在和mybatis整合时，sql语句有三种写法，常见的接口和xml，注解式（不建议使用），注解+类，这三种方式，我们在项目中使用的一个mybatis-plus这个插件，这个插件没有任何侵入，只需要在对应的层继承相关的东西就能完成单表的CRUD。
 
Spring Cloud 是完全基于 Spring Boot 而开发，像springcloud就是跟dubbo一样的都是实现分布式服务，模块主要分为eureka（注册中心）、熔断器（hystrix）、配置中心（config）、路由（zuul），我们在项目中使用的模块，每个模块都需要依赖注册中心，服务模块之间的调用都是通过feign实现的。
还有一些就是在操作的时候需要注意的：使用fegin调用服务时请求方式默认都是post，简单数据类型需要加@RequertParm注解才能接收到，fegin使用@RepsonseBady默认返回的数据格式为xml，在PostMapping里添加属性即可返回json。
注册中心没啥说的，模块都需要依赖他。
熔断器，其实就是在Feign中来配置的，主要是解决分布式系统交互时超时处理和容错的类库，使用熔断器预防服务雪崩，我在项目配置的熔断器是20个请求，错误百分比50%以上，3秒内如果还没有返回则进入到熔断器处理，在熔断器中记录日志
配置中心就是配置一些公共的配置。其实除了配置中心以及注册中心的配置在本地，其他几乎都在配置中心也就是gitlab上，但是要注意，如果使用配置中心，一般情况我们会把配置文件的名称改为boostrap.yml，让项目启动时先去加载
路由就是同一个端口可以调用他配置信息里不同模块的提供的url。如果没有他，调用我的人就需要记录我每个服务器的url，很麻烦，这时路由的好处就出现了，只需要访问我的路由，由我的路由去转发请求，请求我 不同的服务

常用注解：
@springbootapplication、@EnableEurekaServer、@EnableEurekaClient、@EnableFeignClients、@EnableZuulProxy
