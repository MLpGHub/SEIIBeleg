del /s /f /Q final\*.*
rd /s /f final\*
dir final\

xcopy "Dokumente AG\Ausschreibung\ausschreibung.pdf" final\
ren final\ausschreibung.pdf Ausschreibung.pdf
xcopy "Dokumente AG\Firmenportraet\firmenportraet.pdf" final\
ren final\firmenportraet.pdf Firmenportraet_AG.pdf
xcopy "Dokumente AG\Lastenheft\lastenheft.pdf" final\
ren final\lastenheft.pdf Lastenheft.pdf
xcopy "Dokumentenordner\Angebot\angebot.pdf" final\
ren final\angebot.pdf Angebot.pdf
xcopy "Dokumentenordner\Anwenderdoku\Anwenderdoku.pdf" final\
ren final\Anwenderdoku.pdf Anwenderdokumentation.pdf
xcopy "Dokumentenordner\Entwicklungsumgebung\Entwicklungsumgebung.pdf" final\
xcopy "Dokumentenordner\Firmenportraet\firmenportraet.pdf" final\
ren final\firmenportraet.pdf Firmenportraet_AN.pdf
xcopy "Dokumentenordner\Kalkulation\Kostenaufstellung_extern.pdf" final\
xcopy "Dokumentenordner\Kalkulation\Kostenaufstellung_intern.pdf" final\
xcopy "Dokumentenordner\Kalkulation\Kalkulation_intern.pdf" final\
xcopy "Dokumentenordner\Pflichtenheft\pflichtenheft.pdf" final\
ren final\pflichtenheft.pdf Pflichtenheft.pdf
xcopy "Dokumentenordner\projektbegleitender Bericht\bericht.pdf" final\
ren final\bericht.pdf Projektbegleitender_Bericht.pdf
xcopy "Projektordner Java\TicTacToe\dist\TicTacToe_pg.jar" final\
ren final\TicTacToe_pg.jar TicTacToe.jar
xcopy /s "Projektordner Java\TicTacToe\dist\resources" final\resources
xcopy /s "Projektordner Java\TicTacToe\doc" final\JavaDoc
xcopy /s "Projektordner Prototyp\export" final\Prototyp
xcopy "Projektordner UML\*.pdf" final\UML
