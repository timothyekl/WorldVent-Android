# WorldVent - android

## Architecture and idea

The architecture is based on template project from Android Studio Navigation template. The idea is to use webView showing html bundled in the app inside assets/www folder
The www folder is not tracked by git and should be fetched from documentation repository, and copied into:
app/src/main/assets/www
### Documentation location
https://github.com/timothyekl/WorldVent-Documentation

This is later accessed like:
val url = "file:///android_asset/www/worldvent/index.html"

## HTML format
Absolute paths do not work in the WebView when referring to other files, such as CSS and JavaScript. All references must be relative, instead of absolute (for example, instead of "/invalid/link.html", use "./valid/link.html").

## Gradle
To build release version, set following environment variables, which will be used in build.gradle(:app)
export ANDROID_KEY_PATH="/path/to/key.jks"
export ANDROID_KEY_ALIAS="alias"
export ANDROID_KEY_PASSWORD="keypassword"
export ANDROID_STORE_PASSWORD="storepassword"

## Fastlane

I'm using fastlane to build and temploy, but it's not a requirement. To upload release build to specific server, set following environment variables if you want to deploy to your server using scp:

export FASTLANE_UPLOAD_HOST="xxx.xx"
export FASTLANE_UPLOAD_USER="user"
export FASTLANE_UPLOAD_HOST_FOLDER="/var/www/xxx.xx/html/"
