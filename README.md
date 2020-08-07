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
        <version>4.7.3</version>
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
    compileOnly "com.github.angeschossen:LandsAPI:4.7.3"
}
```


Alternatively you can download the jar file from here: https://github.com/Angeschossen/LandsAPI/releases


## Implementing Lands
Please make sure to add softdepend: [Lands] to your plugin.yml.

Example:

```
    private final LandsIntegration landsIntegration;

    public IntegrationExample(Plugin yourPlugin) {

        // You should save this instance somewhere.
        this.landsIntegration = new LandsIntegration(yourPlugin);
    }

    // Just a test
    void test(Location location) {

    // Get a land area from a location
    final Area area = landsIntegration.getAreaByLoc(location);
    }

```
