# RAMIRES- FIRST STEP WITH JAVA SPRING BOOT + JPA + EXCEL


## Basic Setup
* Java 1.8.
* SpringBoot 2.3.4.
* Mysql 8.0.15.
* Configure Lombok <https://dicasdejava.com.br/como-configurar-o-lombok-no-eclipse/>.
* Apache Maven 3.6.1+

 ** For more information verify file Step-Step in  src/main/resources/setupConfig.**

## Start a project
* Is necessary has  installed a MySQL in your machine, configure the connection in file application.properties.
* Execute the file  CREATE_TABLE.sql in your database  or create a schema heroes and change in the <b>application.properties</b> parameter spring.jpa.hibernate.ddl-auto  for  <b>create</b>.


## Swagger Links

* <http://localhost:8080/swagger-ui.html>  <i> Visual Interface </i> 

* <http://localhost:8080/v2/api-docs>      <i> JSON Docs</i>


## Configure Maven Build

* Run Configuration > Maven Build > Click Right > Create New Maven Build
* -> set workspace project : ${workspace_loc:/learns}
* -> goals : clean package install
* -> Checkbox :  [x] Update SnapShot  [X] SkipTest 




## Recommend Plugins (Eclipse/IntelliJ)

* Eclipe toolbar > Help > Eclipse MarketPlace (	<b> SonarLint </b> / <b> STS tools</b>)


