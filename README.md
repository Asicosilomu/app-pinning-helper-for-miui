# app-pinning-helper-for-miui
### A simple Android app I wrote in about an hour to bring app pinning functionality to MIUI.

As you may know, Xiaomi did a good job at removing features from Android, including screen pinning. The Settings page is gone, so is the option in Recents. For the Settings page, I did try opening it with QuickShortcutMaker but there was no such activity. The underlying API is still there (startLockTask and stopLockTask). After messing a bit with freeform windows and the Lock screen feature in [Baby Dots](https://f-droid.org/en/packages/com.serwylo.babydots), I discovered that MIUI's freeform windows sit on top of apps even when pinned, and floating apps can pin themselves. Now, discovering more of the API as I went, creating my own app just for that purpose. You can download the source code (spoiler: really messy) and see how it works (it's dead simple tho) or just download the prebuilt APK and get right to work. Follow the instructions in the app to pin basically anything, but it's still quite buggy.

# enjoy
