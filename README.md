# example-spring-hibernate
Examples for connecting MySQL interjecting with Spring, Hibernate, JPA, JTA, Atomikos standalone or in Tomcat

# Important dependency versions

|#| dependency | version
|---|-------|---
|1|`SpringFramework`|4.3.2.RELEASE
|2|`Hibernate`|5.2.2.Final
|3|`Atomikos`|4.0.4
|4|`JPA`|2.1

# Example Discription
|  #  | project name | Spring | Hibernate | JPA | Distributed Transaction | Tested |           Remarks            |
|:---:|:-------------|:------:|:---------:|:---:|:-----------------------:|:------:|:------------------------------|
|1|[hibernate standalone][h]|:x:|:white_check_mark:|:x:|:x:|:white_check_mark:|Standalone Hibernate example with hibernate.cfg.xml|
|2|[hibernate jpa][hj]|:x:|:white_check_mark:|:white_check_mark:|:x:|:white_check_mark:|Using persistence.xml to config JPA|
|3|[spring hibernate][sh]|:white_check_mark:|:white_check_mark:|:x:|:x:|:white_check_mark:|Using c3p0 datasource and hibernate session factory.|
|4|[spring hibernate jpa][shj]|:white_check_mark:|:white_check_mark:|:white_check_mark:|:x:|:white_check_mark:|Using none persistence.xml, all JPA configuration is managed by spring.|
|5|[spring hibernate atomikos][sha]|:white_check_mark:|:white_check_mark:|:white_check_mark:|:white_check_mark:|:white_check_mark:|Using hibernate session facotry with Atomikos Transaction manager, Annotation drived TX.|
|6|[spring hibernate jpa atomikos][shja]|:white_check_mark:|:white_check_mark:|:white_check_mark:|:white_check_mark:|:white_check_mark:|Using JPA with atomikos transaction as JTA, and self-defined AtomikosJtaPlatform.|

[h]:https://github.com/jimmyblylee/example-spring-hibernate/tree/master/src/hibernate
[hj]:https://github.com/jimmyblylee/example-spring-hibernate/tree/master/src/hibernate-jpa
[sh]:https://github.com/jimmyblylee/example-spring-hibernate/tree/master/src/spring-hibernate
[shj]:https://github.com/jimmyblylee/example-spring-hibernate/tree/master/src/spring-hibernate-jpa
[sha]:https://github.com/jimmyblylee/example-spring-hibernate/tree/master/src/spring-hibernate-atomikos
[shja]:https://github.com/jimmyblylee/example-spring-hibernate/tree/master/src/spring-hibernate-jpa-atomikos
