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

        // view methods of this class: https://github.com/Angeschossen/LandsAPI/blob/master/src/main/java/me/angeschossen/lands/api/integration/LandsIntegrator.java
        this.landsIntegration = new LandsIntegration(yourPlugin);
	
	// registering a flag
	Flag flag = new RoleFlag(ChestProtect.getPlugin(), Flag.Target.ADMIN, RoleFlag.Category.ACTION, "chestprotect_open", true, false, role -> false)
                .setWarState(true);
        landsIntegration.registerFlag(flag);
    }

    // example
    public void test(Location location, Player player) {
        // get an area from a location
        final @Nullable Area area = landsIntegration.getAreaByLoc(location);

        if (area != null) {
            // check flag status for a player
            final boolean canAttackPlayer = area.hasFlag(player, Flags.ATTACK_PLAYER, false);

            // alternatively UUID instead of Player (does not check war state)
            final boolean canAttackPlayerFromUUID = area.hasFlag(player.getUniqueId(), Flags.ATTACK_PLAYER);
        }
    }

```
