#!/bin/bash

#clean up final dir
rm final/*.* 2> /dev/null
rm -r final/* 2> /dev/null

#copy all files and artefacts
cp Dokumente\ AG/Ausschreibung/ausschreibung.pdf final/Ausschreibung.pdf
cp Dokumente\ AG/Firmenportraet/firmenportraet.pdf final/Firmenportraet_AG.pdf
cp Dokumente\ AG/Lastenheft/lastenheft.pdf final/Lastenheft.pdf
cp Dokumentenordner/Angebot/angebot.pdf final/Angebot.pdf
cp Dokumentenordner/Anwenderdoku/Anwenderdoku.pdf final/Anwenderdokumentation.pdf
cp Dokumentenordner/Entwicklungsumgebung/Entwicklungsumgebung.pdf final
cp Dokumentenordner/Firmenportraet/firmenportraet.pdf final/Firmenportraet_AN.pdf
cp Dokumentenordner/Kalkulation/Kostenaufstellung_extern.pdf final
cp Dokumentenordner/Kalkulation/Kostenaufstellung_intern.pdf final
cp Dokumentenordner/Kalkulation/Kalkulation_intern.pdf final
cp Dokumentenordner/Pflichtenheft/pflichtenheft.pdf final/Pflichtenheft.pdf
cp Dokumentenordner/projektbegleitender\ Bericht/bericht.pdf final/Projektbegleitender_Bericht.pdf
#obfuscated jar file becomes the used TicTacToe.jar !
cp Projektordner\ Java/TicTacToe/dist/TicTacToe_pg.jar final/TicTacToe.jar
cp -r Projektordner\ Java/TicTacToe/dist/resources final
cp -r Projektordner\ Java/TicTacToe/doc final/JavaDoc
cp -r Projektordner\ Prototyp/export final/Prototyp
mkdir final/UML
cp Projektordner\ UML/*.pdf final/UML

