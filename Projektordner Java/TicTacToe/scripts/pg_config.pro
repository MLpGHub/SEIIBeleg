-verbose
-injars ../dist/TicTacToe.jar
-outjars ../dist/TicTacToe_pg.jar
-libraryjars  <java.home>/jmods/java.base.jmod(!**.jar;!module-info.class)
-libraryjars ../lib/junit4.jar
-dontwarn java.awt.**
-ignorewarnings
-keep public class core.Driver {
	public static void main(java.lang.String[]);
}
//processing native methods
-keepclasseswithmembernames,includedescriptorclasses class * {
	native void repaint();
}