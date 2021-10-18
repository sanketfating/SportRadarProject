# SportRadarProject
SportRadarProject

As a part of this assignment created a simple console based Java application to manage Football world cup score board.

Following functionalities are available in this application:

**Manage Team**: There are in memory teams provided in the system to start with the league matches.
User can also add more teams which are not present in the existing list.

**Manage Matches**: League level matches can be managed for home and away teams, following operations can be performed-
a.Start match/matches
b.Update Score for match
c.End match/matches

**Display All Live Matches**

**Display All Live And Completed Matches** 

_**Workflows of functionalities :**_
1. Display available teams :
-----------------------------------------------
          Welcome to Football World Cup
-----------------------------------------------
-----------------------------------------------
Press 1 to display available Teams
Press 2 to add teams
Press 3 to start league matches
Press 4 to see live matches score, update score and end the game
Press 5 to see stats
-----------------------------------------------
1
Available Teams : Mexico,Canada,Spain,Brazil,Germany,France,Uruguay,Italy,Argentina,Australia

2. Add a team :
-----------------------------------------------
          Welcome to Football World Cup
-----------------------------------------------
-----------------------------------------------
Press 1 to display available Teams
Press 2 to add teams
Press 3 to start league matches
Press 4 to see live matches score, update score and end the game
Press 5 to see stats
-----------------------------------------------
2
Please enter country name
Norway
Available Teams : Mexico,Canada,Spain,Brazil,Germany,France,Uruguay,Italy,Argentina,Australia,Norway
Do you want to enter more teams ? (press Y/N)
Y
Please enter country name
Denmark
Available Teams : Mexico,Canada,Spain,Brazil,Germany,France,Uruguay,Italy,Argentina,Australia,Norway,Denmark
Do you want to enter more teams ? (press Y/N)
N

3. Start a league match
-----------------------------------------------
          Welcome to Football World Cup
-----------------------------------------------
-----------------------------------------------
Press 1 to display available Teams
Press 2 to add teams
Press 3 to start league matches
Press 4 to see live matches score, update score and end the game
Press 5 to see stats
-----------------------------------------------
3
Enter Home Team Country Name
Mexico
Enter Away Team Country Name
Brazil
Matches Started: Mexico - Brazil : 0 - 0
-----------------------------------------------
Press 1 to display available Teams
Press 2 to add teams
Press 3 to start league matches
Press 4 to see live matches score, update score and end the game
Press 5 to see stats
-----------------------------------------------

4. To see live matches score, update score and end the game
-----------------------------------------------
          Welcome to Football World Cup
-----------------------------------------------
-----------------------------------------------
Press 1 to display available Teams
Press 2 to add teams
Press 3 to start league matches
Press 4 to see live matches score, update score and end the game
Press 5 to see stats
-----------------------------------------------
3
Enter Home Team Country Name
Mexico
Enter Away Team Country Name
Brazil
Matches Started: Mexico - Brazil : 0 - 0
-----------------------------------------------
Press 1 to display available Teams
Press 2 to add teams
Press 3 to start league matches
Press 4 to see live matches score, update score and end the game
Press 5 to see stats
-----------------------------------------------
3
Enter Home Team Country Name
Italy
Enter Away Team Country Name
Germany
Matches Started: Italy - Germany : 0 - 0
-----------------------------------------------
Press 1 to display available Teams
Press 2 to add teams
Press 3 to start league matches
Press 4 to see live matches score, update score and end the game
Press 5 to see stats
-----------------------------------------------
4
Live Matches:
Match 1 : Mexico - Brazil : 0 - 0
Match 2 : Italy - Germany : 0 - 0
-----------------------------------------------
Press 1 to update score
Press 2 to end any one of the above games
Press 3 to end all games
Press 4 to go back to main menu
-----------------------------------------------
1
Live Matches:
Match 1 : Mexico - Brazil : 0 - 0
Match 2 : Italy - Germany : 0 - 0
Please enter match number from above list
1
Please enter Home - Away Team score eg. 1-3
1-3
Updated score for Match 1 : Mexico - Brazil : 1 - 3
Live Matches:
Match 1 : Mexico - Brazil : 1 - 3
Match 2 : Italy - Germany : 0 - 0
-----------------------------------------------
Press 1 to update score
Press 2 to end any one of the above games
Press 3 to end all games
Press 4 to go back to main menu
-----------------------------------------------
2
Live Matches:
Match 1 : Mexico - Brazil : 1 - 3
Match 2 : Italy - Germany : 0 - 0
Please select the match which will be ended
2
Do you want to end this match? Italy - Germany : 0 - 0
Please enter 'Y' to confirm, else 'N'
n
Live Matches:
Match 1 : Mexico - Brazil : 1 - 3
Match 2 : Italy - Germany : 0 - 0
-----------------------------------------------
Press 1 to update score
Press 2 to end any one of the above games
Press 3 to end all games
Press 4 to go back to main menu
-----------------------------------------------
1
Live Matches:
Match 1 : Mexico - Brazil : 1 - 3
Match 2 : Italy - Germany : 0 - 0
Please enter match number from above list
2
Please enter Home - Away Team score eg. 1-3
2-2
Updated score for Match 2 : Italy - Germany : 2 - 2
Live Matches:
Match 1 : Mexico - Brazil : 1 - 3
Match 2 : Italy - Germany : 2 - 2
-----------------------------------------------
Press 1 to update score
Press 2 to end any one of the above games
Press 3 to end all games
Press 4 to go back to main menu
-----------------------------------------------
3
Do you want to end all matches?
Please enter 'Y' to confirm, else 'N'
y
Completed Matches:
Italy 2 - Germany 2
Mexico 1 - Brazil 3



