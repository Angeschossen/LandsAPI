[![](https://jitpack.io/v/Angeschossen/LandsAPI.svg)](https://jitpack.io/#Angeschossen/LandsAPI)

### Javadoc
https://jitpack.io/com/github/angeschossen/LandsAPI/latest/javadoc/

### API Usage Explained
Include the API using Gradle:
```groovy
repositories {
	maven { url 'https://jitpack.io' }
}
dependencies {
    compileOnly "com.github.angeschossen:LandsAPI:version"
}
```

Include the API using Maven:
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
        <version>version</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

The API is accessible through an implementation of the ``LandsIntegration`` interface.
It is recommended to bind this instance to a class variable, if possible.
````
LandsIntegration api = LandsIntegration.of(plugin);
````

#### Common Use-Cases
1. Checking Role-Flag States for Players\
   Using ``LandWorld`` to check flag states has the benefit that it also checks wilderness flags. Some use cases might not intent that. In this case you can use `api.getArea(location)` and check the flag state of the area instead.
    ````
    LandWorld world = api.getWorld(world);
    if (world != null) { // Lands is enabled in this world
        if (world.hasFlag(player, location, material, Flags.BLOCK_BREAK, false)) {
            // the player is allowed to break blocks with the given material at the given location
        } else {
            // the player isn't allowed to break this block in wilderness or a claimed land at this position
        }
    }
    ````

2. Checking Natural-Flag States\
   ``LandWorld`` does check wilderness and claimed land if applicable. If you want to
   limit the check to claimed land, use ``api.getArea(location)`` instead of getting the world.
    ````
    LandWorld world = api.getWorld(world);
    if (world != null) { // Lands is enabled in this world
        if (world.hasNaturalFlag(location, Flags.MONSTER_SPAWN)) {
            // monsters are allowed to spawn at this location
        } else {
            // they aren't allowed to spawn at this location
        }
    }
    ````
3. Registering your own Flags\
   This one is simple as well. Just use the factory methods of the needed flag type's interface: RoleFlag.of(...), NaturalFlag.of(...) etc.

    ````
    RoleFlag flag = RoleFlag.of(api, FlagTarget.PLAYER, RoleFlagCategory.ACTION, "flag_name");
    ````
   It is recommended to set further attributes.
    ````
    flag.setDisplayName("Name")
        .setIcon(itemstack)
        .setDescription(description);
    ````
