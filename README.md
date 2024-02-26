> # **UPDATE 26/2/2024**
> Since we all received our scores for this project (98, quite impressive), the ownership has been moved to @team-dut organization.
> Goodbye, and wish you a good year onwards, Mr. V.C.Thanh!

> As of 1/1/2024 12:00PM (UTC+7), I will cease all developments for this fork/repository, whatever you call it.
> 
> This fork existed because I was, at that time, dissatisfied with my team's progression in developing this project, so I took care of the code myself.  
> 
> Since the remaining time is *not even that much*, the end result of the game is nowhere to my satisfaction, even if I did most of the works. Very selfish, I know.
> 
> I have done all the regression testings I can do, polished the UI as much as "KISS principle". And now this project has reached the state that I can say
> "Well, I guess that's all" to it. Nonetheless, the team did their best to their heart's content to give me a starting point for the project, that's very grateful.
> If there is really a "Labor of Love" award, everyone in my team deserves it.  
> 
> One last thing, when the project presentation day is over (2/1/2024), this repository will be archived at the original place (`team-dut` organization).
> 
> Without further ado, thank you for reading, and wish you a good 2024.
> 
> From Tien Dat Pham with love.

-----------------------------------

# Maze Runner

- Per the title, this game is a cheap knock off of the `Maze Runner` movie title.
- Please don't expect any advanced code. This project serves as both my team's final project for the DSA course, and a small proof of concept of what [my own game engine](https://github.com/Swyreee/i-ran-out-of-name-help/tree/main/src/Engine) can do.
- Tags for this game: speedrun, maze.

> I took a lot of inspirations from [SuperHot](https://store.steampowered.com/app/322500), give it a try, it's a fun game.

# How to play

- Simple:
  - There are maps for you to play.
  - Each map will have a set of Keys, Knights (your enemy) and an incursion/extraction point (pink tile).
  - You must collect all keys on the map before being able to go to next map.
  - Once you have completed all maps, it's done.
  - If a knight touches you, it's an instant lose.
  - Your achievement is the total time taken to complete the maps.

- There are some keybinding to the game:
  - `Q`: quit the game - return to main screen.
  - `E`: see the knights' path to reach you. I initially used this for debugging, but it's a nice addition.
  - `C`: force the knights to get another step to reach you. I initially used this for debugging, but it's a nice addition.
  - `Alt + F4`: quit the game - *literally*.

# Is there anything fun in the code?

> TL;DR:
> - Algorithm: Pathfinding.
> - Data Structure: Array.
> - Design pattern: ECS, Builder.

- First of all, there is the engine! The entire project uses my own engine to do stuffs. As this engine is not matured enough, I decided to put the code in the same source as the game, for testing and improvements, obviously.
  - "The Engine" uses the [ECS model](https://en.wikipedia.org/wiki/Entity_component_system#:~:text=Entity%20component%20system%20(ECS)%20is,which%20operate%20on%20entities'%20components.). 
    - Everything can be rendered given coordinates is called an [`Entity`](https://github.com/Swyreee/i-ran-out-of-name-help/blob/main/src/Engine/Object/BaseEntity.java).
    - A [`Screen`](https://github.com/Swyreee/i-ran-out-of-name-help/blob/main/src/Engine/UI/Screen.java) is what an `Entity` will be rendered on. Think like a "borderless window".
    - A [`Window`](https://github.com/Swyreee/i-ran-out-of-name-help/blob/main/src/Engine/UI/Window.java) is what a `Screen` will be rendered on. Think like the border part of a window.

- You can see the [pathfinding on action with 2D array](https://github.com/Swyreee/i-ran-out-of-name-help/blob/main/src/Game/Core/Maze.java#L143).
  - The reason it's "home-made [A*](https://en.wikipedia.org/wiki/A*_search_algorithm)": I don't provide `f(node)` and `h(node)` implementation, that's why it will go to *every* neighbor.
  - The implementation itself is *"idempotent"* provided you haven't tampered with the matrix.

- A [game builder](https://github.com/Swyreee/i-ran-out-of-name-help/blob/main/src/Engine/GameController.java) is what defines a game instance, and it uses [Builder design pattern](https://refactoring.guru/design-patterns/builder).

- The "pathfinding algorithm" and the "array" is the only **notable** data structure and algorithm in the game.
