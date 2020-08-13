# LandsAPI - Integrate Lands into your Plugin
[![](https://jitpack.io/v/Angeschossen/LandsAPI.svg)](https://jitpack.io/#Angeschossen/LandsAPI)


Include the API with Maven: 
```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.angeschossen</groupId>
        <artifactId>LandsAPI</artifactId>
        <version>INSERT VERSION HERE</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

Include the API with Gradle:
```groovy
repositories {
	maven { url 'https://jitpack.io' }
}
dependencies {
    compileOnly "com.github.angeschossen:LandsAPI:INSERT VERSION HERE"
}
```


Alternatively you can download the jar file from here: https://github.com/Angeschossen/LandsAPI/releases


## Implementing Lands
Please make sure to add softdepend: [Lands] to your plugin.yml.

Example:

```
    private final LandsIntegration landsIntegration;

    public IntegrationExample(Plugin yourPlugin) {

        // you should save this instance somewhere.
        this.landsIntegration = new LandsIntegration(yourPlugin);
    }

    // just a test
    void test(Location location) {

    // get a land area from a location
    final Area area = landsIntegration.getAreaByLoc(location);
    
    // check is a location claimed
    final boolean isClaimed = landsIntegration.isClaimed(location);
    
    }

```
