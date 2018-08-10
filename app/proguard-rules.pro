# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-dontwarn javax.xml.stream.XMLInputFactory
-dontwarn javax.xml.stream.XMLEventReader
-dontwarn javax.xml.stream.events.XMLEvent
-dontwarn javax.xml.stream.events.Attribute
-dontwarn javax.xml.stream.Location
-dontwarn android.app.Notification
-dontwarn javax.xml.stream.events.StartElement
-dontwarn javax.xml.stream.events.Characters

-keep public class org.simpleframework.xml.*
-keep public class org.simpleframework.xml.convert.*
-keep public class org.simpleframework.xml.core.*
-keep public class org.simpleframework.xml.filter.*
-keep public class org.simpleframework.xml.strategy.*
-keep public class org.simpleframework.xml.stream.*
-keep public class org.simpleframework.xml.transform.*
-keep public class org.simpleframework.xml.util.*
-keep public class mafiaprojectpro.startgame.ContainerGamePresetLayout
-keep public class mafiaprojectpro.statistics.ContainerPlayerStatistic
-keep public class mafiaprojectpro.theme.ContainerThemeResources
-keep public class mafiaprojectpro.greendesk.ContainerGamerItems
-keep public class mafiaprojectpro.lwp.ContainerLWPState
-keep public class mafiaprojectpro.lwp.ContainerPositionOfVoting
-keep public class mafiaprojectpro.snar.ContainerSNARAdapterRoles
-keep public class mafiaprojectpro.snar.ContainerSNARItems
-keep public class mafiaprojectpro.startgame.GamePresetLayout