cd ..
call mvn clean
call mvn org.farhan:sheep-dog-svc-maven-plugin:uml-to-cucumber-guice -Dtags="cucumber-gen" -Dhost="qa.sheepdog.io"
cd scripts