cd ..
call git reset --hard HEAD
call git clean -fdx
call git pull
call mvn org.codehaus.mojo:versions-maven-plugin:update-properties -DallowSnapshots=false -DallowDowngrade=true
call mvn -B release:prepare -DcheckModificationExcludeList=pom.xml -DpreparationGoals=deploy -Darguments=-DskipTests
call git push
call git push --tags
call mvn org.codehaus.mojo:versions-maven-plugin:update-properties -DallowSnapshots=true
call git clean -fdx
call git add *
call git commit -m "Upgrading dependency versions"
call git push
call mvn clean deploy -DskipTests
cd scripts
