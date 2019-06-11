-verbose
-injars ../dist/TicTacToe.jar
-outjars ../dist/TicTacToe_pg.jar
-libraryjars  <java.home>/jmods/java.base.jmod(!**.jar;!module-info.class)
-libraryjars ../lib/junit4.jar
-libraryjars <java.home>/jmods/java.desktop.jmod

-adaptresourcefilecontents META-INF/MANIFEST.MF

-keep public class core.Driver {
	public static void main(java.lang.String[]);
}

