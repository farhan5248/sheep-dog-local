cd ..
call mvn clean org.farhan:sheep-dog-svc-maven-plugin:uml-to-cucumber-guice -Dtags="grammar" -Dhost="dev.sheepdog.io"
cd scripts 