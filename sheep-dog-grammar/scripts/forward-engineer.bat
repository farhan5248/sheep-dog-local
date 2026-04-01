cd ..
call mvn clean org.farhan:sheep-dog-svc-maven-plugin:uml-to-cucumber-guice -Dtags="grammar" -Dhost="qa.sheepdog.io"
cd scripts 