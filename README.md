# VaxTodo:re

Cette application est un prototype fonctionnel de VaxTodo permettant de tester les fonctionnalités et d'explorer la
logique derrière le système. VaxTodo:re est une plateforme en Ligne de commandes pour des rendez-vous permettant de rendre la prise de
rendez-vous plus efficace pour les employés et les bénévoles de VaxTodo et Goodpeople.

Note: Les sauvegardes dans le CSV sont effectuées lorsqu'on quitte l'application.

## Fonctionnalités

- Se connecter en tant que bénévole ou employée de VaxTodo (Bénévole et employé)
- Consulter le calendrier (Bénévole et employé)
- Ajouter un rendez-vous/visite (Bénévole et employé)
- Consulter la liste des visiteurs (Bénévole et employé)
- Supprimer/modifier un rendez-vous (Employé)
- Créer/Modifier/Supprimer un compte visiteur (Employé)
- Consulter et modifier le profil de vaccination d'un visiteur (Employé)
- Consulter la liste des bénévoles (Employé)
- Créer/Modifier/Supprimer un compte bénévole (Employé)
- Remplir et sauvegarder un formulaire d'identification (Employé)
- Récupérer et imprimer un formulaire d'identification (Employé)
- Envoyer un rapport de vaccination (Employé)
- Envoyer une notification de rappel (Employé)

## Manuel d'utilisation

Pour utiliser l'application, il y a 2 manières plus simples.
1. On peut simplement aller dans le dossier release, d'y ouvrir son terminal et de entrer la commande:
   java -jar VaxToroRe.jar. L'application devrait être ouverte dans votre terminal! Si VaxTodoRe.jar 
   être mis à jour, dans intellij, il est possible de build l'application à l'aide du fichier de configuration ANT build.xml
2. Dans le IDE de votre choix (ici IntelliJ), il est possible de ouvrir le projet depuis l'intérieur du document Prototype et
   ensuite vous pouvez builder ou créer votre propre configuration et utiliser la classe VaxTodoMain pour
   lancer le code.

Étant un prototype, nous avons inclus un jeu de données afin de tester l'application.
À l'ouverture, vous devez vous connecter en tant qu'employé ou bénévole. Ceci vous donnera accès
au menu principal propre au rôle.

### Données incluses dans l'application

- Rendez-vous
  - 305537,big,boi,2021-07-20,11:00,1
  - 877900,darth,vader,2021-07-20,11:00,2
  - 305534,punch,in,2000-07-20,11:00,1
  - 305533,punch,out,1990-07-20,11:00,1
- Employés
  - 202004286910,123123123,Annapass1!,Anna,Belle,5146758765,annabelle12@gmail.com,1530 Henri-Bourassa,H3M3E2,Montreal,1992-02-23
  - 202004286919,120158220,KevinPass(1),Kevin,Peter,5147901057,kevin.peter@umontreal.ca,2900 Edouard-Montpetit Blvd,H3T1J4,Montreal,2000-12-17
- Fomulaires d'information
  - 202010250001,juan,cortez,1990-01-13,COXJ00027593,2021-07-25,true,false,false,false,Moderna,true,Moderna,294757398204837474
  - 485737394826,matcha,zanmai,1206-08-03,SDXA232738273,8545-11-01,false,false,true,true,Pfizer,true,Pfizer,72389473829473829
- Profile de vaccination
  - 202010250001,2000-05-31,1,Pfizer,7658375828372873
  - 202010250001,2021-07-24,2,Moderna,2865027562739573
  - 485737394826,2021-05-31,2,AstraZeneca,7658374822376873
- Visiteurs
  - 202010250001;cortez;juan;1990-01-13;juan.cortez@gmail.com;5147836802
  - 202004280010;hannoune;isabelle;1994-10-06;isa.hannoune@gmail.com;4382835821
- Volontaires
  - 202004123567,123123111,Mahmoudpass1!,Mahmoud,Ahmadinejad,5148752461,mahmoud12@gmail.com,1530 Henri-Bourassa,H3M3E2,Montreal,1994-01-23,Sun,Mon
  - 202082746185,123412341,Johnpass1!,John,Doe,5148630261,john23@gmail.com,1530 Henri-Bourassa,H3M3E2,Montreal,1994-01-23,Mon,Tue,Wed
  - 202004286919,120158221,KevinPass(2),Kevin,Peter,5147901057,kevin.peter@umontreal.ca,2900 Edouard-Montpetit Blvd,H3T1J4,Montreal,2000-12-17

### Connexion

Pour se connecter à l'application, veuillez utiliser un des identifiants suivants:

- Rôle de l'employé
  - username: 123123123 | password: Annapass1!
  - username: 120158220 | password: KevinPass(1)
- Rôle du bénévole
  - username: 123123111 | password: Mahmoudpass1!
  - username: 120158221 | password: KevinPass(2)

### Menu principal (Employé)

À partir du menu principal, dans le rôle de l'employé, vous pouvez choisir l'une des options suivantes en tapant le chiffre correspondant.
En tout tant vous pouvez taper 0 pour revenir au menu principal.

- [1] Gestion des rendez-vous: Accédez au caldendrier et à la liste des rendez-vous, envoyer des rappels et ajouter, modifier ou supprimer un rendez-vous.
- [2] Gestion formulaire: Accéder, créer ou imprimer un nouveau formulaire
- [3] Gestion des visiteurs: Accédez à la liste des visiteurs et ajouter, modifier ou supprimer un visiteur.
- [4] Gestion des bénévoles: Accédez à la liste des bénévoles et ajouter, modifier ou supprimer un bénévole.
- [0] Quitter l'application: déconnexion.

#### Gestion des rendez-vous

- [1] Afficher le calendrier
- [2] Ajouter un rendez-vous
- [3] Afficher rendez-vous existant
- [4] Envoyer notification de rappel
- [0] Retour au menu principal

#### Gestion des visiteurs

- [1] Ajouter un nouveau visiteur
- [2] Afficher visiteur existant
- [3] Gestion compte visiteur: permet de modifier ou supprimer un visiteur
- [4] Gestion profil vaccinal du visiteur
- [0] Retour au menu principal

#### Gestion des profiles de vaccination

- [1] Afficher le profil vaccinal: affiche les informations
- [2] Modifier un des vaccins
- [3] Envoyer un rapport de vaccination
- [0] Retour au menu principal

#### Gestion des bénévoles

- [1] Afficher la liste des bénévoles
- [2] Gestion des comptes bénévoles: Ajouter, modifier ou supprimer un bénévole
- [0] Retour au menu principal

### Menu principal (Bénévole)

- [1] Gestion des rendez-vous: Permet d'accéder à la liste des rendez-vous par date et ajouter des rendez-vous selon les instructions.
- [2] Gestion des visiteurs: Permet d'accéder à la liste des visiteurs directement en suivant les instructions.
- [0] Quitter l'application: déconnexion.

#### Gestion des rendez-vous (Bénévole)

- [1] Afficher le calendrier
- [2] Ajouter un nouveau rendez-vous: créer une nouvelle visite
- [3] Afficher un rendez-vous existant
- [0] Retour au menu principal

Ceci conclu notre application, j'espère que vous l'aimererez!

Auteurs:
- Antoine Ho
- Mendel Sun (responsable du projet)
- Kevin Lessard
