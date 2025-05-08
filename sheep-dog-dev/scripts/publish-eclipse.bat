cd ..
call mvn clean
call mvn dependency:copy-dependencies -DoutputDirectory=target/dependency
call mvn deploy:deploy-file -Dfile=target/dependency/runtime-3.29.0.v20230726-0617.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.eclipse.core -DartifactId=runtime -Dversion=3.29.0.v20230726-0617 
call mvn deploy:deploy-file -Dfile=target/dependency/ecore-2.35.0.v20230829-0934.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.eclipse.emf -DartifactId=ecore -Dversion=2.35.0.v20230829-0934 
call mvn deploy:deploy-file -Dfile=target/dependency/ecore.xmi-2.35.0.v20230801-1141.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.eclipse.emf -DartifactId=ecore.xmi -Dversion=2.35.0.v20230801-1141 
call mvn deploy:deploy-file -Dfile=target/dependency/mapping.ecore2xml-2.12.0.v20230211-1150.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.eclipse.emf -DartifactId=mapping.ecore2xml -Dversion=2.12.0.v20230211-1150 
call mvn deploy:deploy-file -Dfile=target/dependency/common-2.29.0.v20230916-0637.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.eclipse.emf -DartifactId=common -Dversion=2.29.0.v20230916-0637 
call mvn deploy:deploy-file -Dfile=target/dependency/common-3.18.100.v20230730-1117.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.eclipse.equinox -DartifactId=common -Dversion=3.18.100.v20230730-1117 
call mvn deploy:deploy-file -Dfile=target/dependency/runtime-3.2.0.v20220404-1927.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.antlr -DartifactId=runtime -Dversion=3.2.0.v20220404-1927 
call mvn deploy:deploy-file -Dfile=target/dependency/xtext-2.32.0.v20230827-1315.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.eclipse.xtext -DartifactId=xtext -Dversion=2.32.0.v20230827-1315 
call mvn deploy:deploy-file -Dfile=target/dependency/util-2.32.0.v20230827-1315.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.eclipse.xtext -DartifactId=util -Dversion=2.32.0.v20230827-1315 
call mvn deploy:deploy-file -Dfile=target/dependency/xbase.lib-2.33.0.v20231121-0955.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.eclipse.xtext -DartifactId=xbase.lib -Dversion=2.33.0.v20231121-0955 
call mvn deploy:deploy-file -Dfile=target/dependency/uml.profile.standard-1.5.0.v20221116-1811.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.eclipse.uml2 -DartifactId=uml.profile.standard -Dversion=1.5.0.v20221116-1811 
call mvn deploy:deploy-file -Dfile=target/dependency/common-2.5.0.v20221116-1811.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.eclipse.uml2 -DartifactId=common -Dversion=2.5.0.v20221116-1811 
call mvn deploy:deploy-file -Dfile=target/dependency/types-2.5.0.v20221116-1811.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.eclipse.uml2 -DartifactId=types -Dversion=2.5.0.v20221116-1811 
call mvn deploy:deploy-file -Dfile=target/dependency/uml.resources-5.5.0.v20221116-1811.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.eclipse.uml2 -DartifactId=uml.resources -Dversion=5.5.0.v20221116-1811 
call mvn deploy:deploy-file -Dfile=target/dependency/uml-5.5.0.v20210228-1829.jar -Durl=https://maven.pkg.github.com/sheep-dog-local -DrepositoryId=github -DgroupId=org.eclipse.uml2 -DartifactId=uml -Dversion=5.5.0.v20210228-1829 
cd scripts

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 