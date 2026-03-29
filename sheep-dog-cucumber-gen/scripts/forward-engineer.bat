cd ..
call mvn clean
call mvn org.farhan:sheep-dog-dev-svc-maven-plugin:uml-to-cucumber-guice -Dtags="gen" -Dhost="dev.sheepdog.io"
cd scripts