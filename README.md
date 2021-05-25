# Delfinen

KamilleNikolajsen
Rasmus-Kibshede
MichalaNybroe

## Introduktion til program
Dette administrative system består af en hovedmenu der fører brugere til hhv. 3 undermenuer. Den første undermenu gør det muligt at administrere medlemmere herunder oprettelse, redigering og nedlæggelse af medlemskaber. Anden undermenu er hhv. adgangsgivende til klubbens økonomiske overblik og administrering af dårligt betalende medlemmere samt de af disse som er nedlagte grundet repetitiv manglende betalinger med hold i GDPR. Den tredje og sidte undermenu er den kompetitive administration. Her registres de løbende konkurrencer og træningstider som konkurrenterne skal tilskrives. Desuden er det i denne menu at der kan dannes et overblik over de forskellige hold og konkurrenternes kunnen.

## Opbygning af program
Dette administrtive program er bygget på command pattern således de fleste funktioner i programmet implementerer interfacen Command. Ligeledes nedarver alle menuer fra MenuCommand klassen, der implementerer Command.
Manager klassen har instanser af de forskellige andre klasser og er dermed den adgangsgivende force i programmet. Programmet benytter sig af filer til at gemme data. De forskellige filer er i FileHandler som oprettes i Manager, hvorfor det er her igennem de forskellige kalsser som implementere command får adgang til at gemme og loade informationer om medlemmere og folk i RKI.
