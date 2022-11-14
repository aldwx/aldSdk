# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-ignorewarnings #是否忽略警告
-optimizationpasses 5 #指定代码的压缩级别(在0~7之间，默认为5)
-dontusemixedcaseclassnames #是否使用大小写混合(windows大小写不敏感，建议加入)
-dontskipnonpubliclibraryclasses #是否混淆非公共的库的类
-dontpreverify #混淆时是否做预校验(Android不需要预校验，去掉可以加快混淆速度)
-dontshrink#混淆jar的时候一定要配置，不然会把没有用到的代码全部remove
-verbose #混淆时是否记录日志(混淆后会生成映射文件)

-keepattributes Signature #过滤泛型 用到发射，泛型等要添加这个
-keepattributes EnclosingMethod #保持反射不被混淆
-keepattributes Exceptions#保持异常不被混淆
-renamesourcefileattribute SourceFile#将文件来源重命名为“SourceFile”字符串

  -keep public class com.aldwx.aldsdk.AldDataAPI{
    <fields>;
    <methods>;
   }

