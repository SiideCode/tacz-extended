# TaCZ Extended

⚠️ **Keep in mind that the addon is very unfinished and there are no ETAs or promises on development. Report bugs to github issues, or** ⚠️

TaCZ Extended is an addon for the Tactical and Classics: Zero mod that, attempts to expand the configuration and scripting, as well as the feature set.

Based on the https://github.com/jaredlll08/MultiLoader-Template.

## Documentation

The documentation will be available after the first release, which will happen whenever the project has at least a couple more features, and better version and loader support.

## Support status

Backports/tweaks for the addon to work with everything earlier than the latest TaCZ version at the time of the addon release aren't currently planned, the addon MIGHT work with earlier TaCZ versions for the supported version.

**Assume that the table below refers to the latest TaCZ version.**

✅ - Supported\
⚠️ - Support planned or unfinished\
❌ - Support not planned, or the mod not available for this version and mod loader configuration

| Version | [Neoforge Port](https://github.com/MUKSC/TACZ-1.21.1) | Forge | [Fabric Port](https://github.com/Sh1roCu/TACZ-Refabricated) |
|:-------:|:-----------------------------------------------------:|:-----:|:-----------------------------------------------------------:|
| 1.21.1  |                          ⚠️                           |   ❌   |                              ✅                              |
| 1.20.1  |                           ❌                           |  ⚠️   |                             ⚠️                              |

## Planned Features

- A completely new scripting API with more convenient access to more of the Java side code, because the original API is a mess with very little features
- New modifiers/properties for attachments, such as magazine size, or the ammo type
- Improved gunsmith mechanics with more attachment slots and a better UI
- Multiple ammo types per gun with different properties (configurable inside the gun config)
- Better crafting UI with weapon stats, etc.
- Weapons emitting light when they're shot (configurable)
- Reimplementation of the advanced block penetration from [TaCZ Tweaks](https://github.com/MUKSC/TaCZTweaks) for the original mod and the ports
- Unloading ammo from weapons