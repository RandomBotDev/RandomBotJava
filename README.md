# About
RandomBot, but I wrote it in Java. I made this because I wanted to learn Java, so I can mod Minecraft and stuff.

# Self Hosting
First, you must have a JDK that's at least Java 8, and the JDK is in the PATH environment variable. After you have a JDK clone the repo and change your directory to it. Then what you need to do is go to `src/main/resources/config.json` and you need to modify the following:
- token
    - your bot's token goes here
- prefix
    - the set of characters that go before every message that trigger a command.


Then your config.json should look like this:
```json
{
    "token": "<your token>",
    "prefix": "<your prefix>"
}
```

Then you're going to need to compile the bot. You can do this by running `./gradlew build` (for linux/mac) or `gradlew build` (for windows) in a terminal. The jar will be in the `build/libs` folder, and the jar name should be `RandomBotJava-(version).jar`. The version of the bot will be `(version)`.

Then to run the bot you will run `java -jar RandomBotJava-(version).jar` and `(version)` is still the version. now you're self-hosting the bot! If you want it 24/7, put it on a VPS/hosting service, or put the jar on a Raspberry Pi, or a device lying around that you don't really use anymore.
