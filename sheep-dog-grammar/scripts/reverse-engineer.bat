cd ..
call mvn clean
call mvn org.farhan:sheep-dog-svc-maven-plugin:cucumber-to-uml -Dtags="grammar" -Dhost="dev.sheepdog.io"
cd scripts 