This is a simple servlet application created using Quarkus.
Use "mvn clean package" command to generate the runner jar.

web.xml file with servlet mapping and filter mapping can be located in the quarkus-servlet\src\main\resources\META-INF folder.
Static resources such as index.html file can be located in the quarkus-servlet\src\main\resources\META-INF\resources folder.

Natively built binary file can be located in the quarkus-servlet\native-build folder. Dockerfile.native2 can be used to deploy this file.
HotSpot built can be located in quarkus-servlet\target folder. Dockerfile.hotspot2 can be used to deploy this file.
Dockerfiles can be located in quarkus-servlet\src\main\docker folder. 

Packaging the project inside OpenJDK HotSpot container can be done using Dockerfile.hotspot file.
Building the native image and deploying it inside red hat universal base image can be done using Dockerfile.multistage file.




