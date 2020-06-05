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
        <version>4.6.7</version>
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
    compileOnly "com.github.Angeschossen:LandsAPI:4.6.7"
}
```


You can also download the jar file from here: https://github.com/Angeschossen/LandsAPI/releases


## Implementing Lands
Examble:

```
    private final LandsIntegration landsIntegration;

    public IntegrationExample(Plugin yourPlugin) {

        // init
        this.landsIntegration = new LandsIntegration(yourPlugin);
    }

    // Just a test
    void test(Location location) {

   	// Get a land area from a location
        final Area area = landsIntegration.getAreaByLoc(location);
	
	// Get a land from a location
	final Land land = landsIntegration.getLand(location);
    }

```
