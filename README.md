# microservices
Repository for microservices demo projects
Creating a Simple Microservice
Step 1: Create a Maven project using Spring Initializr https://start.spring.io/

Step 2: Choose the Spring Boot version 2.2.0 M6 or higher version. Do not choose the snapshot version.

Step 3: Provide the Group name. In our case om.javatpoint

Step 4: Provide the Artifact id. We have provided limits-service.
Play Videox


Creating a Simple Microservice
Step 5: Add the following dependencies: Spring Web, Spring Boot DevTools, Spring Boot Actuator, Config Client.

Creating a Simple Microservice
Step 6: Click on Generate the project button. A zip file will download, extract it into the hard disk.

Step 7: Now, open the eclipse. Import the created maven project. It takes some time to download the required files.

Step 8: Once the project is downloaded, go to src/main/java. Open the LimitsServiceApplication.

Creating a Simple Microservice
Step 9: Now run the LimitsServiceApplication.java as Java Application.

It started the Tomcat on port(s) 8080 (http).

Now we will add couple of services in the above project. For this we will have to follow the following steps:

Step 1: Open application.properties file and write the following code:


spring.application.name=limits-service      //name of application  
Step 2: Create a class file with name LimitsConfigurationController.java in the folder src/main/java under the package com.javatpoint.microservices.limitsservice
Type the localhost:8080/limits in the browser and press enter, we get the JSON response as output.

Output

{
maximum: 1000,
minimum: 1
}
Adding services to the application.properties
In the previous program, we will modify the code according to the requirement.


Now we call the limits-service from the application.properties file. In this file, we are configuring a couple of values.

limits-service.minimum=99  
limits-service.maximum=9999  
There is a better approach in Spring Boot to read values from the configuration using the annotation @ConfigurationProperties.

Step 1: Create a class with name Configuration.java in the folder src/main/java under the package com.javatpoint.microservices.limitservice.


Step 2: Add the annotations @Component and @ConfigurationProperties.

Step 3: Declare two variables minimum and maximum.

Step 4: If we are using the Configuration file, we need to generate getters and setters.

The Configuration.java file look like this.

package com.javatpoint.microservices.limitsservice;  
import org.springframework.boot.context.properties.ConfigurationProperties;  
import org.springframework.stereotype.Component;  
@Component  
@ConfigurationProperties("limits-service")  
public class Configuration   
{  
private int maximum;  
private int minimum;  
public void setMaximum(int maximum)   
{  
this.maximum = maximum;  
}  
public void setMinimum(int minimum)   
{  
this.minimum = minimum;  
}  
public int getMaximum()   
{  
return maximum;  
}  
public int getMinimum()   
{  
return minimum;  
}  
}  
Step 5: Now move to LimitsConfigurationController.java file and modify the code. In this we will use Configuration.

package com.javatpoint.microservices.limitsservice;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.RestController;  
import com.javatpoint.microservices.limitsservice.bean.LimitConfiguration;  
@RestController  
public class LimitsConfigurationController   
{  
@Autowired    
private Configuration configuration;      
@GetMapping("/limits")  
public LimitConfiguration retriveLimitsFromConfigurations()  
{  
//getting values from the properties file  
return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());  
}  
}  
Now refresh the browser page. It shows the JSON format of the updated values which are configured in application .properties file.

Output

{
maximum: 999,
minimum: 99
