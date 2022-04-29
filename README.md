# SAE2_01_02
    Project Terraria Groupe B
    Groupe :  {Nom Prenom}   | {pseudo}  
            - LIBERT Quentin | (Hychion)
            - KOCHBATI Haron | (Haronman)
            - FRANCK Marius  | (KussYT)
            - DU BOIS Eddy   | (ImAVanessaMain)

diagramme UML :
<img src="Diagramme/Diagram V1_.PNG"/>


diagramme UmL Version Marius:
<img src="Diagramme/Diagram V m.PNG"/>

Lors de ce projet, nous allons developper un jeu robot mineur :


Sujet :

    Il y aura dans ce monde des mines ; chaque mine contient un nombre (entre 50 et 100) 
    de minerais d’une seule nature : soit de nickel (1 ou 2 mines), soit d’or (1 ou 2 mines). 
    Deux entrepôts permettent de stocker les minerais récoltés : l’un permettant
    de stocker l’or, l’autre le nickel. Des robots (au moins un de chaque type et au plus 5),
    chacun étant spécialisés dans l’extraction de minerai soit de nickel ou d’or,
    exploreront le monde a1n d’aller dans les mines, extraire des minerais et les amener
    dans les entrepôts. Chaque robot a une capacité de stockage de minerais (entre 5 et 10) 
    qui lui est propre, et une capacité (entre 1 et 3) d’extraction de minerais (nombre
    de minerais récoltés en une seule action d’extraction).
    Le monde est décomposé en une matrice de 100 secteurs (10 x 10). Chaque secteur
    du monde sera soit un terrain (au moins 90), soit un plan d’eau.
    Les robots peuvent aller sur un terrain du moment qu’il n’est pas occupé par un autre robot.
     
    Les robots ne peuvent pas aller sur les plans d’eau.
    Sur les terrains il peut y avoir soit rien, soit un entrepôt, soit une mine. On ne peut pas
    avoir un entrepôt et une mine sur un même secteur.
    Les robots peuvent :
     Avancer dans une direction : Nord, Est, Sud ou Ouest,
     Récolter des minerais s’ils sont dans une mine de leur spécialité et s’il reste au
    moins un minerai. Le robot récolte, s’il y a su:samment de minerai, autant que
    sa capacité d’extraction, sinon il récolte ce qu’il reste.
     Déposer ses minerais s’il est dans l’entrepôt dédié au minerai dont il est spécialisé.
    
    Chaque robot a un numéro unique, chaque mine a un numéro unique, chaque entrepôt
    a un numéro unique.
    À chaque tour, chaque robot peut réaliser au plus une action valide.

        



Livrable 1.01 : Diagrammes des classes (deadline 1ère version 08/04, 2ème version
mise à jour après le code 1nal – 1n mai)

Livrable 1.02 : Création du projet sur git-hub. Rapport des premières commits.
(deadline 08/04/2022)

Livrable 1.03 : Maquettage des interactions pour la saisie des actions à réaliser par
l’utilisateur (deadline 1n mai)

Livrable 1.04 : Rapport de test automatisé JUnit pour au moins deux des principales
méthodes (1n mai). Le rapport doit contenir (a) le jeu de test (tableau de test tel que
réalisé dans R2.03) avec l'indication des critères de test qui ont été utilisés, (2) un
rapport du résultat du test de l'application (par exemple, une capture d'écran du
résultat de l'exécution). (deadline 1n mai)

Livrable 1.05 : Code java 1nal intégrant les interactions utilisateur graphiques.
(deadline 1n mai)

Livrable 1.06 : Rapport 1nal des commits réalisées. (deadline 1n mai)
Attention : Organisez-vous pour utiliser GIT tout au long du projet. Nous attendons
diOérents commits de la part de diOérentes personnes de l'équipe.

Nous vous conseillons d’avancer sur le projet avec cette organisation :
- 1ère séance en autonomie : création du modèle UML et Java (vous utiliserez les
  compétences acquises en R2.01)
- 2ème séance en autonomie : création du GIT et dépôt du code fait en séance 1 (à
  compléter au 1l des avancées) (R2.03) – création du maquettage (interaction de
  l’utilisateur avec une interface graphique pour indiquer les actions des robots à
  chaque tour).
- 3ème séance en autonomie : Codage de la partie commune et des interactions
  (R2.02 – programmation événementielle) (possible à partir de mi-avril)
- 4ème séance en autonomie : création des tests et mise en œuvre dans JUnit / code à
  debugger (R2.03) – 1nalisation du code et dépôt.
