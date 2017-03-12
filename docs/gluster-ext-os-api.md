Gluster Extension Object Storage API
======================================

API

* HTTP JSON RPC

Upload

* MIME: multipart/form-data

Download

* File server

API Details
----------------
    
### _Tenant_ Entry

__READ__ 

Note: tenant only get entry info himself

    GET  /v1/{account}

Example: `curl -i $publicURL?format=json -X GET -H "X-Auth-Token: $token"`

HTTP Response Status:

* OK (200), success
* No Content (204), success

HTTP Response Header:

    HTTP/1.1 200 OK
    Content-Length: 96
    X-Account-Object-Count: 1
    X-Timestamp: 1389453423.35964
    X-Account-Meta-Subject: Literature
    X-Account-Bytes-Used: 14
    X-Account-Container-Count: 2
    Content-Type: application/json; charset=utf-8
    Accept-Ranges: bytes
    X-Trans-Id: tx274a77a8975c4a66aeb24-0052d95365
    X-Openstack-Request-Id: tx274a77a8975c4a66aeb24-0052d95365
    Date: Fri, 17 Jan 2014 15:59:33 GMT
    
HTTP Response Body:

    [
        {
            "count": 0,
            "bytes": 0,
            "name": "janeausten",
            "last_modified": "2013-11-19T20:08:13.283452"
        },
        {
            "count": 1,
            "bytes": 14,
            "name": "marktwain",
            "last_modified": "2016-04-29T16:23:50.460230"
        }
    ]
    

__Create__

Note: admin role required

    PUT  /v1/{account}

__Update metadata__

Note: admin role required

    PUT  /v1/{account}

__Delete__

Note: admin role required

    DELETE  /v1/{account}


### _Catalogue_ Entry

__Read__

Note: tenant authorization only

    GET  /v1/{account}/{container}
    
HTTP Response

Header:

    HTTP/1.1 200 OK
    Content-Length: 341
    X-Container-Object-Count: 2
    Accept-Ranges: bytes
    X-Container-Meta-Book: TomSawyer
    X-Timestamp: 1389727543.65372
    X-Container-Bytes-Used: 26
    Content-Type: application/json; charset=utf-8
    X-Trans-Id: tx26377fe5fab74869825d1-0052d6bdff
    X-Openstack-Request-Id: tx26377fe5fab74869825d1-0052d6bdff
    Date: Wed, 15 Jan 2014 16:57:35 GMT

Body:

    [
        {
            "hash": "451e372e48e0f6b1114fa0724aa79fa1",
            "last_modified": "2014-01-15T16:41:49.390270",
            "bytes": 14,
            "name": "goodbye",
            "content_type": "application/octet-stream"
        },
        {
            "hash": "ed076287532e86365e841e92bfc50d8c",
            "last_modified": "2014-01-15T16:37:43.427570",
            "bytes": 12,
            "name": "helloworld",
            "content_type": "application/octet-stream"
        }
    ]
    

__Create__

Note: tenant authorization only

    PUT  /v1/{account}/{container}
    
Example: `curl -i $publicURL/steven -X PUT -H "Content-Length: 0" -H "X-Auth-Token: $token"`
    
HTTP Response

Header

    HTTP/1.1 201 Created
    Content-Length: 0
    Content-Type: text/html; charset=UTF-8
    X-Trans-Id: tx7f6b7fa09bc2443a94df0-0052d58b56
    X-Openstack-Request-Id: tx7f6b7fa09bc2443a94df0-0052d58b56
    Date: Tue, 14 Jan 2014 19:09:10 GMT
    
__Update metadata__

Note: tenant authorization only








vagrant@vagrant-ubuntu-trusty-64:/work/src/github.com/gluster/gluster-java-filesystem/os-ext$ mvn clean install spring-boot:repackage -e -D maven.test.skip=true
[INFO] Error stacktraces are turned on.
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building os-ext 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.6.1:clean (default-clean) @ os-ext ---
[INFO] Deleting /work/src/github.com/gluster/gluster-java-filesystem/os-ext/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ os-ext ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 8 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ os-ext ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 12 source files to /work/src/github.com/gluster/gluster-java-filesystem/os-ext/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ os-ext ---
[INFO] Not copying test resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ os-ext ---
[INFO] Not compiling test sources
[INFO] 
[INFO] --- maven-surefire-plugin:2.18.1:test (default-test) @ os-ext ---
[INFO] Tests are skipped.
[INFO] 
[INFO] --- maven-jar-plugin:2.6:jar (default-jar) @ os-ext ---
[INFO] Building jar: /work/src/github.com/gluster/gluster-java-filesystem/os-ext/target/os-ext.jar
[INFO] 
[INFO] --- spring-boot-maven-plugin:1.5.2.RELEASE:repackage (default) @ os-ext ---
[INFO] 
[INFO] --- spring-boot-maven-plugin:1.5.2.RELEASE:start (pre-integration-test) @ os-ext ---
[INFO] 
[INFO] --- maven-failsafe-plugin:2.18.1:integration-test (default) @ os-ext ---
[INFO] Tests are skipped.
[INFO] 
[INFO] --- spring-boot-maven-plugin:1.5.2.RELEASE:stop (post-integration-test) @ os-ext ---
[INFO] 
[INFO] --- maven-failsafe-plugin:2.18.1:verify (default) @ os-ext ---
[INFO] Tests are skipped.
[INFO] 
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ os-ext ---
[INFO] Installing /work/src/github.com/gluster/gluster-java-filesystem/os-ext/target/os-ext.jar to /home/vagrant/.m2/repository/github-dot-com/stackdocker/glusterfs/os-ext/0.0.1-SNAPSHOT/os-ext-0.0.1-SNAPSHOT.jar
[INFO] Installing /work/src/github.com/gluster/gluster-java-filesystem/os-ext/pom.xml to /home/vagrant/.m2/repository/github-dot-com/stackdocker/glusterfs/os-ext/0.0.1-SNAPSHOT/os-ext-0.0.1-SNAPSHOT.pom
[INFO] 
[INFO] --- spring-boot-maven-plugin:1.5.2.RELEASE:repackage (default-cli) @ os-ext ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 24.093 s
[INFO] Finished at: 2017-03-12T09:24:20+00:00
[INFO] Final Memory: 33M/86M
[INFO] ------------------------------------------------------------------------



vagrant@vagrant-ubuntu-trusty-64:/work/src/github.com/gluster/gluster-java-filesystem/os-ext$ mvn clean install spring-boot:repackage -e -D maven.test.skip=true --offline
[INFO] Error stacktraces are turned on.
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building os-ext 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.6.1:clean (default-clean) @ os-ext ---
[INFO] Deleting /work/src/github.com/gluster/gluster-java-filesystem/os-ext/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ os-ext ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 8 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ os-ext ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 12 source files to /work/src/github.com/gluster/gluster-java-filesystem/os-ext/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ os-ext ---
[INFO] Not copying test resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ os-ext ---
[INFO] Not compiling test sources
[INFO] 
[INFO] --- maven-surefire-plugin:2.18.1:test (default-test) @ os-ext ---
[INFO] Tests are skipped.
[INFO] 
[INFO] --- maven-jar-plugin:2.6:jar (default-jar) @ os-ext ---
[INFO] Building jar: /work/src/github.com/gluster/gluster-java-filesystem/os-ext/target/os-ext.jar
[INFO] 
[INFO] --- spring-boot-maven-plugin:1.5.2.RELEASE:repackage (default) @ os-ext ---
[INFO] 
[INFO] --- spring-boot-maven-plugin:1.5.2.RELEASE:start (pre-integration-test) @ os-ext ---
[INFO] 
[INFO] --- maven-failsafe-plugin:2.18.1:integration-test (default) @ os-ext ---
[INFO] Tests are skipped.
[INFO] 
[INFO] --- spring-boot-maven-plugin:1.5.2.RELEASE:stop (post-integration-test) @ os-ext ---
[INFO] 
[INFO] --- maven-failsafe-plugin:2.18.1:verify (default) @ os-ext ---
[INFO] Tests are skipped.
[INFO] 
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ os-ext ---
[INFO] Installing /work/src/github.com/gluster/gluster-java-filesystem/os-ext/target/os-ext.jar to /home/vagrant/.m2/repository/github-dot-com/stackdocker/glusterfs/os-ext/0.0.1-SNAPSHOT/os-ext-0.0.1-SNAPSHOT.jar
[INFO] Installing /work/src/github.com/gluster/gluster-java-filesystem/os-ext/pom.xml to /home/vagrant/.m2/repository/github-dot-com/stackdocker/glusterfs/os-ext/0.0.1-SNAPSHOT/os-ext-0.0.1-SNAPSHOT.pom
[INFO] 
[INFO] --- spring-boot-maven-plugin:1.5.2.RELEASE:repackage (default-cli) @ os-ext ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 26.008 s
[INFO] Finished at: 2017-03-12T09:25:58+00:00
[INFO] Final Memory: 33M/86M
[INFO] ------------------------------------------------------------------------


vagrant@vagrant-ubuntu-trusty-64:/work/src/github.com/gluster/gluster-java-filesystem/os-ext$ mvn spring-boot:run -e -D maven.test.skip=true --offline
vagrant@vagrant-ubuntu-trusty-64:/work/src/github.com/gluster/gluster-java-filesystem/os-ext$ mvn spring-boot:run -e -D maven.test.skip=true --offline
[INFO] Error stacktraces are turned on.
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building os-ext 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] >>> spring-boot-maven-plugin:1.5.2.RELEASE:run (default-cli) > test-compile @ os-ext >>>
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ os-ext ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 8 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ os-ext ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 12 source files to /work/src/github.com/gluster/gluster-java-filesystem/os-ext/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ os-ext ---
[INFO] Not copying test resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ os-ext ---
[INFO] Not compiling test sources
[INFO] 
[INFO] <<< spring-boot-maven-plugin:1.5.2.RELEASE:run (default-cli) < test-compile @ os-ext <<<
[INFO] 
[INFO] --- spring-boot-maven-plugin:1.5.2.RELEASE:run (default-cli) @ os-ext ---
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.2.RELEASE)

2017-03-12 15:59:41.304  INFO 6057 --- [  restartedMain] objectstack.App                          : Starting App on vagrant-ubuntu-trusty-64 with PID 6057 (/work/src/github.com/gluster/gluster-java-filesystem/os-ext/target/classes started by vagrant in /work/src/github.com/gluster/gluster-java-filesystem/os-ext)
2017-03-12 15:59:41.316  INFO 6057 --- [  restartedMain] objectstack.App                          : No active profile set, falling back to default profiles: default
2017-03-12 15:59:42.723  INFO 6057 --- [  restartedMain] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@1cf87224: startup date [Sun Mar 12 15:59:42 UTC 2017]; root of context hierarchy
2017-03-12 15:59:49.270  INFO 6057 --- [  restartedMain] o.s.b.f.s.DefaultListableBeanFactory     : Overriding bean definition for bean 'httpRequestHandlerAdapter' with a different definition: replacing [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration$EnableWebMvcConfiguration; factoryMethodName=httpRequestHandlerAdapter; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/autoconfigure/web/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]] with [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration; factoryMethodName=httpRequestHandlerAdapter; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/data/rest/webmvc/config/RepositoryRestMvcConfiguration.class]]
2017-03-12 15:59:49.531  INFO 6057 --- [  restartedMain] o.s.b.f.s.DefaultListableBeanFactory     : Overriding bean definition for bean 'managementServletContext' with a different definition: replacing [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.actuate.autoconfigure.EndpointWebMvcHypermediaManagementContextConfiguration; factoryMethodName=managementServletContext; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/actuate/autoconfigure/EndpointWebMvcHypermediaManagementContextConfiguration.class]] with [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.actuate.autoconfigure.EndpointWebMvcAutoConfiguration; factoryMethodName=managementServletContext; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/actuate/autoconfigure/EndpointWebMvcAutoConfiguration.class]]
2017-03-12 15:59:53.126  INFO 6057 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 9099 (http)
2017-03-12 15:59:53.210  INFO 6057 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service Tomcat
2017-03-12 15:59:53.214  INFO 6057 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.11
2017-03-12 15:59:53.533  INFO 6057 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2017-03-12 15:59:53.534  INFO 6057 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 10818 ms
2017-03-12 15:59:54.380  INFO 6057 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
2017-03-12 15:59:54.438  INFO 6057 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'metricsFilter' to: [/*]
2017-03-12 15:59:54.440  INFO 6057 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2017-03-12 15:59:54.442  INFO 6057 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2017-03-12 15:59:54.443  INFO 6057 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2017-03-12 15:59:54.444  INFO 6057 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2017-03-12 15:59:54.445  INFO 6057 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'webRequestLoggingFilter' to: [/*]
InMemoryMessageRepository.save[pre]: Message{id=null, text='Hello', summary='World', created=java.util.GregorianCalendar[time=1489334394742,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Etc/UTC",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2017,MONTH=2,WEEK_OF_YEAR=11,WEEK_OF_MONTH=3,DAY_OF_MONTH=12,DAY_OF_YEAR=71,DAY_OF_WEEK=1,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=3,HOUR_OF_DAY=15,MINUTE=59,SECOND=54,MILLISECOND=742,ZONE_OFFSET=0,DST_OFFSET=0]}
InMemoryMessageRepository.save[post]: Message{id=1, text='Hello', summary='World', created=java.util.GregorianCalendar[time=1489334394742,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Etc/UTC",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2017,MONTH=2,WEEK_OF_YEAR=11,WEEK_OF_MONTH=3,DAY_OF_MONTH=12,DAY_OF_YEAR=71,DAY_OF_WEEK=1,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=3,HOUR_OF_DAY=15,MINUTE=59,SECOND=54,MILLISECOND=742,ZONE_OFFSET=0,DST_OFFSET=0]}
InMemoryMessageRepository.save[pre]: Message{id=null, text='Hi', summary='Universe', created=java.util.GregorianCalendar[time=1489334394744,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Etc/UTC",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2017,MONTH=2,WEEK_OF_YEAR=11,WEEK_OF_MONTH=3,DAY_OF_MONTH=12,DAY_OF_YEAR=71,DAY_OF_WEEK=1,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=3,HOUR_OF_DAY=15,MINUTE=59,SECOND=54,MILLISECOND=744,ZONE_OFFSET=0,DST_OFFSET=0]}
InMemoryMessageRepository.save[post]: Message{id=2, text='Hi', summary='Universe', created=java.util.GregorianCalendar[time=1489334394744,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Etc/UTC",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2017,MONTH=2,WEEK_OF_YEAR=11,WEEK_OF_MONTH=3,DAY_OF_MONTH=12,DAY_OF_YEAR=71,DAY_OF_WEEK=1,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=3,HOUR_OF_DAY=15,MINUTE=59,SECOND=54,MILLISECOND=744,ZONE_OFFSET=0,DST_OFFSET=0]}
InMemoryMessageRepository.save[pre]: Message{id=null, text='Hola', summary='OpenShift', created=java.util.GregorianCalendar[time=1489334394745,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Etc/UTC",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2017,MONTH=2,WEEK_OF_YEAR=11,WEEK_OF_MONTH=3,DAY_OF_MONTH=12,DAY_OF_YEAR=71,DAY_OF_WEEK=1,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=3,HOUR_OF_DAY=15,MINUTE=59,SECOND=54,MILLISECOND=745,ZONE_OFFSET=0,DST_OFFSET=0]}
InMemoryMessageRepository.save[post]: Message{id=3, text='Hola', summary='OpenShift', created=java.util.GregorianCalendar[time=1489334394745,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Etc/UTC",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2017,MONTH=2,WEEK_OF_YEAR=11,WEEK_OF_MONTH=3,DAY_OF_MONTH=12,DAY_OF_YEAR=71,DAY_OF_WEEK=1,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=3,HOUR_OF_DAY=15,MINUTE=59,SECOND=54,MILLISECOND=745,ZONE_OFFSET=0,DST_OFFSET=0]}
2017-03-12 16:00:00.244  INFO 6057 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@1cf87224: startup date [Sun Mar 12 15:59:42 UTC 2017]; root of context hierarchy
2017-03-12 16:00:00.305  INFO 6057 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerAdapter : Detected ResponseBodyAdvice bean in org.springframework.boot.actuate.autoconfigure.EndpointWebMvcHypermediaManagementContextConfiguration$ActuatorEndpointLinksAdvice
2017-03-12 16:00:01.091  INFO 6057 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/apis/v1],methods=[GET]}" onto public java.lang.Iterable<objectstack.api.Message> objectstack.repository.rest.InMemoryRepositoryRestMessageController.getAll()
2017-03-12 16:00:01.093  INFO 6057 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/apis/v1/{id}],methods=[GET]}" onto public objectstack.api.Message objectstack.repository.rest.InMemoryRepositoryRestMessageController.getById(java.lang.Long)
2017-03-12 16:00:01.094  INFO 6057 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/apis/v1/{id}],methods=[PUT]}" onto public objectstack.api.Message objectstack.repository.rest.InMemoryRepositoryRestMessageController.update(java.lang.String,objectstack.api.Message)
2017-03-12 16:00:01.095  INFO 6057 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/apis/v1/{id}],methods=[DELETE]}" onto public void objectstack.repository.rest.InMemoryRepositoryRestMessageController.delete(java.lang.Long)
2017-03-12 16:00:01.096  INFO 6057 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/apis/v1],methods=[POST]}" onto public objectstack.api.Message objectstack.repository.rest.InMemoryRepositoryRestMessageController.create(objectstack.api.Message)
2017-03-12 16:00:01.101  INFO 6057 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/upload],methods=[GET]}" onto public java.lang.String objectstack.repository.web.FileUploadController.listUploadedFiles(org.springframework.ui.Model) throws java.io.IOException
2017-03-12 16:00:01.102  INFO 6057 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/files/{filename:.+}],methods=[GET]}" onto public org.springframework.http.ResponseEntity<org.springframework.core.io.Resource> objectstack.repository.web.FileUploadController.serveFile(java.lang.String)
2017-03-12 16:00:01.103  INFO 6057 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/upload],methods=[POST]}" onto public java.lang.String objectstack.repository.web.FileUploadController.handleFileUpload(org.springframework.web.multipart.MultipartFile,org.springframework.web.servlet.mvc.support.RedirectAttributes)
2017-03-12 16:00:01.108  INFO 6057 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2017-03-12 16:00:01.109  INFO 6057 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2017-03-12 16:00:02.009  INFO 6057 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-03-12 16:00:02.010  INFO 6057 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-03-12 16:00:02.188  INFO 6057 --- [  restartedMain] .m.m.a.ExceptionHandlerExceptionResolver : Detected @ExceptionHandler methods in repositoryRestExceptionHandler
2017-03-12 16:00:02.189  INFO 6057 --- [  restartedMain] .m.m.a.ExceptionHandlerExceptionResolver : Detected ResponseBodyAdvice implementation in org.springframework.boot.actuate.autoconfigure.EndpointWebMvcHypermediaManagementContextConfiguration$ActuatorEndpointLinksAdvice
2017-03-12 16:00:04.368  INFO 6057 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-03-12 16:00:09.902  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerAdapter   : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@1cf87224: startup date [Sun Mar 12 15:59:42 UTC 2017]; root of context hierarchy
2017-03-12 16:00:09.913  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerAdapter   : Detected ResponseBodyAdvice bean in org.springframework.boot.actuate.autoconfigure.EndpointWebMvcHypermediaManagementContextConfiguration$ActuatorEndpointLinksAdvice
2017-03-12 16:00:09.983  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/{id}/{property}],methods=[DELETE],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<? extends org.springframework.hateoas.ResourceSupport> org.springframework.data.rest.webmvc.RepositoryPropertyReferenceController.deletePropertyReference(org.springframework.data.rest.webmvc.RootResourceInformation,java.io.Serializable,java.lang.String) throws java.lang.Exception
2017-03-12 16:00:09.985  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/{id}/{property}],methods=[GET],produces=[application/x-spring-data-compact+json || text/uri-list]}" onto public org.springframework.http.ResponseEntity<org.springframework.hateoas.ResourceSupport> org.springframework.data.rest.webmvc.RepositoryPropertyReferenceController.followPropertyReferenceCompact(org.springframework.data.rest.webmvc.RootResourceInformation,java.io.Serializable,java.lang.String,org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler) throws java.lang.Exception
2017-03-12 16:00:09.993  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/{id}/{property}],methods=[PATCH || PUT || POST],consumes=[application/json || application/x-spring-data-compact+json || text/uri-list],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<? extends org.springframework.hateoas.ResourceSupport> org.springframework.data.rest.webmvc.RepositoryPropertyReferenceController.createPropertyReference(org.springframework.data.rest.webmvc.RootResourceInformation,org.springframework.http.HttpMethod,org.springframework.hateoas.Resources<java.lang.Object>,java.io.Serializable,java.lang.String) throws java.lang.Exception
2017-03-12 16:00:09.994  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/{id}/{property}/{propertyId}],methods=[DELETE],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<org.springframework.hateoas.ResourceSupport> org.springframework.data.rest.webmvc.RepositoryPropertyReferenceController.deletePropertyReferenceId(org.springframework.data.rest.webmvc.RootResourceInformation,java.io.Serializable,java.lang.String,java.lang.String) throws java.lang.Exception
2017-03-12 16:00:09.995  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/{id}/{property}/{propertyId}],methods=[GET],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<org.springframework.hateoas.ResourceSupport> org.springframework.data.rest.webmvc.RepositoryPropertyReferenceController.followPropertyReference(org.springframework.data.rest.webmvc.RootResourceInformation,java.io.Serializable,java.lang.String,java.lang.String,org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler) throws java.lang.Exception
2017-03-12 16:00:09.995  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/{id}/{property}],methods=[GET],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<org.springframework.hateoas.ResourceSupport> org.springframework.data.rest.webmvc.RepositoryPropertyReferenceController.followPropertyReference(org.springframework.data.rest.webmvc.RootResourceInformation,java.io.Serializable,java.lang.String,org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler) throws java.lang.Exception
2017-03-12 16:00:09.999  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/search/{search}],methods=[HEAD],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<java.lang.Object> org.springframework.data.rest.webmvc.RepositorySearchController.headForSearch(org.springframework.data.rest.webmvc.RootResourceInformation,java.lang.String)
2017-03-12 16:00:10.001  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/search],methods=[OPTIONS],produces=[application/hal+json || application/json]}" onto public org.springframework.http.HttpEntity<?> org.springframework.data.rest.webmvc.RepositorySearchController.optionsForSearches(org.springframework.data.rest.webmvc.RootResourceInformation)
2017-03-12 16:00:10.003  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/search],methods=[HEAD],produces=[application/hal+json || application/json]}" onto public org.springframework.http.HttpEntity<?> org.springframework.data.rest.webmvc.RepositorySearchController.headForSearches(org.springframework.data.rest.webmvc.RootResourceInformation)
2017-03-12 16:00:10.009  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/search],methods=[GET],produces=[application/hal+json || application/json]}" onto public org.springframework.data.rest.webmvc.RepositorySearchesResource org.springframework.data.rest.webmvc.RepositorySearchController.listSearches(org.springframework.data.rest.webmvc.RootResourceInformation)
2017-03-12 16:00:10.011  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/search/{search}],methods=[GET],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<?> org.springframework.data.rest.webmvc.RepositorySearchController.executeSearch(org.springframework.data.rest.webmvc.RootResourceInformation,org.springframework.util.MultiValueMap<java.lang.String, java.lang.Object>,java.lang.String,org.springframework.data.rest.webmvc.support.DefaultedPageable,org.springframework.data.domain.Sort,org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler,org.springframework.http.HttpHeaders)
2017-03-12 16:00:10.013  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/search/{search}],methods=[GET],produces=[application/x-spring-data-compact+json]}" onto public org.springframework.hateoas.ResourceSupport org.springframework.data.rest.webmvc.RepositorySearchController.executeSearchCompact(org.springframework.data.rest.webmvc.RootResourceInformation,org.springframework.http.HttpHeaders,org.springframework.util.MultiValueMap<java.lang.String, java.lang.Object>,java.lang.String,java.lang.String,org.springframework.data.rest.webmvc.support.DefaultedPageable,org.springframework.data.domain.Sort,org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler)
2017-03-12 16:00:10.014  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/search/{search}],methods=[OPTIONS],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<java.lang.Object> org.springframework.data.rest.webmvc.RepositorySearchController.optionsForSearch(org.springframework.data.rest.webmvc.RootResourceInformation,java.lang.String)
2017-03-12 16:00:10.016  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/ || ],methods=[OPTIONS],produces=[application/hal+json || application/json]}" onto public org.springframework.http.HttpEntity<?> org.springframework.data.rest.webmvc.RepositoryController.optionsForRepositories()
2017-03-12 16:00:10.017  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/ || ],methods=[HEAD],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<?> org.springframework.data.rest.webmvc.RepositoryController.headForRepositories()
2017-03-12 16:00:10.017  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/ || ],methods=[GET],produces=[application/hal+json || application/json]}" onto public org.springframework.http.HttpEntity<org.springframework.data.rest.webmvc.RepositoryLinksResource> org.springframework.data.rest.webmvc.RepositoryController.listRepositories()
2017-03-12 16:00:10.028  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}],methods=[POST],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<org.springframework.hateoas.ResourceSupport> org.springframework.data.rest.webmvc.RepositoryEntityController.postCollectionResource(org.springframework.data.rest.webmvc.RootResourceInformation,org.springframework.data.rest.webmvc.PersistentEntityResource,org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler,java.lang.String) throws org.springframework.web.HttpRequestMethodNotSupportedException
2017-03-12 16:00:10.029  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/{id}],methods=[OPTIONS],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<?> org.springframework.data.rest.webmvc.RepositoryEntityController.optionsForItemResource(org.springframework.data.rest.webmvc.RootResourceInformation)
2017-03-12 16:00:10.030  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/{id}],methods=[HEAD],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<?> org.springframework.data.rest.webmvc.RepositoryEntityController.headForItemResource(org.springframework.data.rest.webmvc.RootResourceInformation,java.io.Serializable,org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler) throws org.springframework.web.HttpRequestMethodNotSupportedException
2017-03-12 16:00:10.034  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/{id}],methods=[GET],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<org.springframework.hateoas.Resource<?>> org.springframework.data.rest.webmvc.RepositoryEntityController.getItemResource(org.springframework.data.rest.webmvc.RootResourceInformation,java.io.Serializable,org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler,org.springframework.http.HttpHeaders) throws org.springframework.web.HttpRequestMethodNotSupportedException
2017-03-12 16:00:10.034  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/{id}],methods=[PUT],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<? extends org.springframework.hateoas.ResourceSupport> org.springframework.data.rest.webmvc.RepositoryEntityController.putItemResource(org.springframework.data.rest.webmvc.RootResourceInformation,org.springframework.data.rest.webmvc.PersistentEntityResource,java.io.Serializable,org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler,org.springframework.data.rest.webmvc.support.ETag,java.lang.String) throws org.springframework.web.HttpRequestMethodNotSupportedException
2017-03-12 16:00:10.035  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/{id}],methods=[PATCH],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<org.springframework.hateoas.ResourceSupport> org.springframework.data.rest.webmvc.RepositoryEntityController.patchItemResource(org.springframework.data.rest.webmvc.RootResourceInformation,org.springframework.data.rest.webmvc.PersistentEntityResource,java.io.Serializable,org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler,org.springframework.data.rest.webmvc.support.ETag,java.lang.String) throws org.springframework.web.HttpRequestMethodNotSupportedException,org.springframework.data.rest.webmvc.ResourceNotFoundException
2017-03-12 16:00:10.036  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}/{id}],methods=[DELETE],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<?> org.springframework.data.rest.webmvc.RepositoryEntityController.deleteItemResource(org.springframework.data.rest.webmvc.RootResourceInformation,java.io.Serializable,org.springframework.data.rest.webmvc.support.ETag) throws org.springframework.data.rest.webmvc.ResourceNotFoundException,org.springframework.web.HttpRequestMethodNotSupportedException
2017-03-12 16:00:10.041  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}],methods=[OPTIONS],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<?> org.springframework.data.rest.webmvc.RepositoryEntityController.optionsForCollectionResource(org.springframework.data.rest.webmvc.RootResourceInformation)
2017-03-12 16:00:10.043  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}],methods=[HEAD],produces=[application/hal+json || application/json]}" onto public org.springframework.http.ResponseEntity<?> org.springframework.data.rest.webmvc.RepositoryEntityController.headCollectionResource(org.springframework.data.rest.webmvc.RootResourceInformation,org.springframework.data.rest.webmvc.support.DefaultedPageable) throws org.springframework.web.HttpRequestMethodNotSupportedException
2017-03-12 16:00:10.045  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}],methods=[GET],produces=[application/hal+json || application/json]}" onto public org.springframework.hateoas.Resources<?> org.springframework.data.rest.webmvc.RepositoryEntityController.getCollectionResource(org.springframework.data.rest.webmvc.RootResourceInformation,org.springframework.data.rest.webmvc.support.DefaultedPageable,org.springframework.data.domain.Sort,org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler) throws org.springframework.data.rest.webmvc.ResourceNotFoundException,org.springframework.web.HttpRequestMethodNotSupportedException
2017-03-12 16:00:10.053  INFO 6057 --- [  restartedMain] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/{repository}],methods=[GET],produces=[application/x-spring-data-compact+json || text/uri-list]}" onto public org.springframework.hateoas.Resources<?> org.springframework.data.rest.webmvc.RepositoryEntityController.getCollectionResourceCompact(org.springframework.data.rest.webmvc.RootResourceInformation,org.springframework.data.rest.webmvc.support.DefaultedPageable,org.springframework.data.domain.Sort,org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler) throws org.springframework.data.rest.webmvc.ResourceNotFoundException,org.springframework.web.HttpRequestMethodNotSupportedException
2017-03-12 16:00:10.056  INFO 6057 --- [  restartedMain] o.s.d.r.w.BasePathAwareHandlerMapping    : Mapped "{[/profile],methods=[OPTIONS]}" onto public org.springframework.http.HttpEntity<?> org.springframework.data.rest.webmvc.ProfileController.profileOptions()
2017-03-12 16:00:10.058  INFO 6057 --- [  restartedMain] o.s.d.r.w.BasePathAwareHandlerMapping    : Mapped "{[/profile],methods=[GET]}" onto org.springframework.http.HttpEntity<org.springframework.hateoas.ResourceSupport> org.springframework.data.rest.webmvc.ProfileController.listAllFormsOfMetadata()
2017-03-12 16:00:10.059  INFO 6057 --- [  restartedMain] o.s.d.r.w.BasePathAwareHandlerMapping    : Mapped "{[/profile/{repository}],methods=[GET],produces=[application/schema+json]}" onto public org.springframework.http.HttpEntity<org.springframework.data.rest.webmvc.json.JsonSchema> org.springframework.data.rest.webmvc.RepositorySchemaController.schema(org.springframework.data.rest.webmvc.RootResourceInformation)
2017-03-12 16:00:10.063  INFO 6057 --- [  restartedMain] o.s.d.r.w.BasePathAwareHandlerMapping    : Mapped "{[/profile/{repository}],methods=[OPTIONS],produces=[application/alps+json]}" onto org.springframework.http.HttpEntity<?> org.springframework.data.rest.webmvc.alps.AlpsController.alpsOptions()
2017-03-12 16:00:10.069  INFO 6057 --- [  restartedMain] o.s.d.r.w.BasePathAwareHandlerMapping    : Mapped "{[/profile/{repository}],methods=[GET],produces=[application/alps+json || */*]}" onto org.springframework.http.HttpEntity<org.springframework.data.rest.webmvc.RootResourceInformation> org.springframework.data.rest.webmvc.alps.AlpsController.descriptor(org.springframework.data.rest.webmvc.RootResourceInformation)
2017-03-12 16:00:10.528  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/health || /health.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint.invoke(javax.servlet.http.HttpServletRequest,java.security.Principal)
2017-03-12 16:00:10.530  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/beans || /beans.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2017-03-12 16:00:10.531  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/actuator || /actuator.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public org.springframework.hateoas.ResourceSupport org.springframework.boot.actuate.endpoint.mvc.HalJsonMvcEndpoint.links()
2017-03-12 16:00:10.533  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/configprops || /configprops.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2017-03-12 16:00:10.535  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/loggers/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.LoggersMvcEndpoint.get(java.lang.String)
2017-03-12 16:00:10.536  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/loggers/{name:.*}],methods=[POST],consumes=[application/vnd.spring-boot.actuator.v1+json || application/json],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.LoggersMvcEndpoint.set(java.lang.String,java.util.Map<java.lang.String, java.lang.String>)
2017-03-12 16:00:10.538  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/loggers || /loggers.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2017-03-12 16:00:10.540  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/trace || /trace.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2017-03-12 16:00:10.541  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EnvironmentMvcEndpoint.value(java.lang.String)
2017-03-12 16:00:10.544  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env || /env.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2017-03-12 16:00:10.549  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/heapdump || /heapdump.json],methods=[GET],produces=[application/octet-stream]}" onto public void org.springframework.boot.actuate.endpoint.mvc.HeapdumpMvcEndpoint.invoke(boolean,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse) throws java.io.IOException,javax.servlet.ServletException
2017-03-12 16:00:10.556  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/auditevents || /auditevents.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public org.springframework.http.ResponseEntity<?> org.springframework.boot.actuate.endpoint.mvc.AuditEventsMvcEndpoint.findByPrincipalAndAfterAndType(java.lang.String,java.util.Date,java.lang.String)
2017-03-12 16:00:10.557  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/metrics/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint.value(java.lang.String)
2017-03-12 16:00:10.558  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/metrics || /metrics.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2017-03-12 16:00:10.559  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/mappings || /mappings.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2017-03-12 16:00:10.560  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/autoconfig || /autoconfig.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2017-03-12 16:00:10.561  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/info || /info.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2017-03-12 16:00:10.562  INFO 6057 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/dump || /dump.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2017-03-12 16:00:11.074  INFO 6057 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2017-03-12 16:00:11.246  INFO 6057 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2017-03-12 16:00:11.381  INFO 6057 --- [  restartedMain] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 0
2017-03-12 16:00:12.098  INFO 6057 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 9099 (http)
2017-03-12 16:00:12.121  INFO 6057 --- [  restartedMain] objectstack.App                          : Started App in 31.922 seconds (JVM running for 33.478)


fanhonglingdeMacBook-Pro:Downloads fanhongling$ curl -ijkvSL -XPOST --form "file=@rust-lang-ci.md" --form "submit=Upload" http://172.17.4.200:9099/upload
* Hostname was NOT found in DNS cache
*   Trying 172.17.4.200...
* Connected to 172.17.4.200 (172.17.4.200) port 9099 (#0)
> POST /upload HTTP/1.1
> User-Agent: curl/7.37.1
> Host: 172.17.4.200:9099
> Accept: */*
> Content-Length: 88614
> Expect: 100-continue
> Content-Type: multipart/form-data; boundary=------------------------dafad1f8603f1c88
> 
< HTTP/1.1 100 Continue
HTTP/1.1 100 Continue

< HTTP/1.1 500 
HTTP/1.1 500 
< Content-Type: application/json;charset=UTF-8
Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 12 Mar 2017 16:01:15 GMT
Date: Sun, 12 Mar 2017 16:01:15 GMT
< Connection: close
Connection: close

< 
* Closing connection 0
{"timestamp":1489334475391,"status":500,"error":"Internal Server Error","exception":"java.lang.IllegalArgumentException","message":"Missing scheme","path":"/upload"}


2017-03-12 16:01:14.873  INFO 6057 --- [nio-9099-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
2017-03-12 16:01:14.876  INFO 6057 --- [nio-9099-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
2017-03-12 16:01:15.031  INFO 6057 --- [nio-9099-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 151 ms
2017-03-12 16:01:15.348  INFO 6057 --- [nio-9099-exec-1] objectstack.repository.impl.Glusterfs    : org.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile@5e3cfb4a
2017-03-12 16:01:15.370 ERROR 6057 --- [nio-9099-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.IllegalArgumentException: Missing scheme] with root cause

java.lang.IllegalArgumentException: Missing scheme
	at java.nio.file.Paths.get(Paths.java:134)
	at objectstack.repository.impl.Glusterfs.store(Glusterfs.java:120)
	at objectstack.repository.impl.StorageFactory.store(StorageFactory.java:136)
	at objectstack.repository.web.FileUploadController.handleFileUpload(FileUploadController.java:62)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:133)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:116)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:827)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:738)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:85)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:963)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:897)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:970)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:872)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:648)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:846)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:729)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:230)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165)
	at org.springframework.boot.actuate.trace.WebRequestTraceFilter.doFilterInternal(WebRequestTraceFilter.java:108)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:99)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165)
	at org.springframework.web.filter.HttpPutFormContentFilter.doFilterInternal(HttpPutFormContentFilter.java:105)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165)
	at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:81)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:197)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165)
	at org.springframework.boot.actuate.autoconfigure.MetricsFilter.doFilterInternal(MetricsFilter.java:106)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:198)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:474)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:140)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:79)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:87)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:349)
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:783)
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66)
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:798)
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1434)
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)

