# Maze Runner(s)

*ft The Maze Runner (2014)*

Offline - 1 player with 3 allies (mobs) - 1 aggresive (mobs)

Idea:
- Maps: [Pacman](https://github.com/team-dut/pacman-from-wish-and-walmart) (old OOP project) 
- Movie: The Maze Runner (https://www.imdb.com/title/tt1790864/)

About Game Engine:
- 3 mazes (Pacman project + 2 more)
	+ 4 keys each map at each corner
	+ enter new map: bring 4 keys into boss spawn point
	+ entrance, exits in map : no dead ends
	+ 1 connector between parts near the centre map(boss spawn point) (1 map is devided into 4 parts)
	+ power-ups(each map): speed boost(Dut?)(70%), shock trap(stun boss when boss get into it for 15s(decrease by 5 each time)(30%)): 10
	+ Boss spawn point: (3x3) reduce player speed by 40%, has 4 entrances, center point will be the gate into next map
  + Leaderboard: Recorded as top 10 fastest players (base on time consume to win the game).
	
- Boss (illustrated with Rajang):
	+ Speed(default): 1.1 -> 1.15 - 1.2
	+ One-hit player/mobs without temporal
	+ Get alert when player takes keys/enters boss spawn point (except player using ghillie mantles)
		speed up by .025 each alert is made
	+ Search for nearest runner:
		if player is the nearest, mobs will return closer boss then player.
	+ DFS

- Mobs (3 NPC that have no use except being bait or lure boss away from player)
  + 1st piority: Try to get closer to boss when player is targeted
  + 2nd piority: Move to corner of the map
  + Power-up gathered by mobs -> Shock trap(100%)
  + Can not respawn when get caught by boss, but still appear in next map if player clear that map

- Player (UI interact)
  + One life only
  + Able to collect power-ups around map
  + Q/E to use temporal(5 times to escape when get caught)/gillie(camouflage for 10 seconds) mantle. Each is used once per map
- That's all for now, IDK
