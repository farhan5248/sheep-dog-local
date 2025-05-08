cd ..
call mvn clean
call mvn org.farhan:sheep-dog-dev-maven-plugin:1.26-SNAPSHOT:uml-to-cucumber-guice -Dtags="%1" -DrepoDir=../sheep-dog-specs/
cd scripts 