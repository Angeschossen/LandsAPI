# LandsAPI - Integrate Lands into your Plugin
[![](https://jitpack.io/v/Angeschossen/LandsAPI.svg)](https://jitpack.io/#Angeschossen/LandsAPI)


How to include the API with Maven: 
```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.Angeschossen</groupId>
        <artifactId>LandsAPI</artifactId>
        <version>4.5.9.9</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

How to include the API with Gradle:
```groovy
repositories {
	maven { url 'https://jitpack.io' }
}
dependencies {
    compileOnly "com.github.Angeschossen:LandsAPI:4.5.2.0"
}
```


You can also download the jar file from here: https://github.com/Angeschossen/LandsAPI/releases


## Implementing Lands
Examble:

```public class IntegrationExample {

    private final LandsIntegration landsAddon;

    private IntegrationExample(Plugin yourPlugin) {

        /*
        Initialize LandsAddon
        Set isPulic to false, if you want
        to prevent that other developers can
        access your addon.
         */
        landsAddon = new LandsIntegration(yourPlugin, false);
    }

    //Just a test
    private void test(Location location) {
   	//Get a land area from a location
        final LandArea landArea = landsAddon.getArea(location);
	
	//Get a land from a location
	final Land land = landsAddon.getLand(location);
	
	
        //Do some stuff.
    }
}
```
