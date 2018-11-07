# springcloud_test
springcloud整合多模块之间调用

### 创建spring cloud项目
  1. 创建maven父项目引入依赖信息，并将<packaging>修改为pom
  ```
  <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.13.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
        <spring-cloud.version>Edgware.SR3</spring-cloud.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
  ```
  2. 添加eureka-注册中心并添加依赖
  ```
  <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka-server</artifactId>
  </dependency>
  ```
  3. 在eureka模块配置启动类并配置注解
  ```
  @SpringBootApplication
  @EnableEurekaServer
  ```
  4. 添加配置文件application.yml
  ```
  server:
  port: 自定义

  #eureka注册中心配置
  eureka:
    instance.hostname: localhost #一般为域名
    client:
      register-with-eureka: false
      fetch-registry: false
    server:
      # 自我保护
      enable-self-preservation: false
      # 扫描失效服务间隔
      eviction-interval-timer-in-ms: 3000
  ```
  5. 启动Eureka，测试访问URL：域名:端口号
  ```
  http://localhost:8080
  ```
  6. 添加Eureka客户端模块
  7. 配置pom文件添加依赖
  ```
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-eureka-server</artifactId>
  </dependency>
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-feign</artifactId>
  </dependency>
  ```
  8. 客户端启动类添加注解
  ```
  @EnableEurekaClient // 开启客户端注解
  @EnableFeignClients // 开启服务之间调用  采用feign
  ```
  9. 客户端增加application.yml配置文件
  ```
  server:
  port: xxx

  spring:
    application:
      name: user-service #服务名
  #连接注册中心
  eureka:
    client:
      service-url:
        defaultZone: http://localhost:8080/eureka/
    instance:
      prefer-ip-address: true  #支持域名直接解析ip
   ```
####spring cloud项目大致创建完成，注意配置Eureka注册中心端口号与客户端端口号必须保持唯一性！！！

### springcloud跨模块方法调用
  1. 创建子项目api模块，并增加相对应的接口文件
  ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    /**
     *  
     * @param str  简单数据类型必须增加@RequestParam注解
     * @return
     */
    @RequestMapping("sayHello")
    String sayHello(@RequestParam("str") String str);
    ```
  2. 所操作的客户端模块依赖api，并service实现api中所对应的接口文件
  ```
  @RestController
  @Service
  public class UserServiceImpl implements UserService{

      @Override
      public String sayHello(String str) {
  //        throw new RuntimeException();
          return "hello,user1,"+str;
      }
  }
  ```
  3. 模块中创建client包，并增加调用模块的Client类文件，继承api模块对应的service类
  ```
  /**
   * FeignClient中value的值为调用服务的配置文件中的spring.application.name的值
   */
  @FeignClient(value = "user-service")
  public interface UserServiceClient extends UserService {
  }
  ```
  4. 调用的controller模块中注入Client文件并调用方法
  ```
  @Autowired
  private UserServiceClient userService;
  ```
