# JustMinions

JustMinions is a collaborative project of Kiwi111 and Jogius (main developer is  Kiwi111). It is a Minecraft Plugin
whose goal it is to introduce functionality similar to the SkyBlock Minions on the Hypixel Minecraft Server.

## Installation

Create a Server using [Spigot](https://getbukkit.org/get/Fpt2yFn7HRTrot5uE1b8NFWtpQlYITgK) and either download the
precompiled jar file or compile it yourself using our source code.

## Usage

### Commands
**/inv**  
Opens the inventory used to craft minions (can also be opened using the Crafting Terminal Structure)

**/minion**

Works with 3 different arguments: place, remove and number. "place" places a minion with a
diamond block as helmet. "Remove" removes all the minions ins a 1 block range 
of the player. "Number" returns the number of all the minions on the server.
### Recipes
All the recipes are crafted in the crafting terminal.  

**Minion Recipes**

Recipes for all the things a minion needs including the "MinionPlacer" and the "Minion"

**Compressed Blocks**

Compressed blocks aren't available for every block just for the ores, wood, stone and slime. They are always
crafted with the block form of the item. Their usage is to define the type of a minion.

###Minions   
**Requirements**

To place a minion, a "Minionplacer", a "Minion" and a compressed block are needed.

**Placing**

To place a minion just have a "Minion" in your inventory, a compressed block in you off hand
and the "MinionsPlacer" in the main hand. The "Minionplacer" has infinite uses while the "Minions" and
the compressed block will be consumed (just 1 if a stack is used).

**Working**

The minion will start working right after placing, if a 5*5 area below him is free or has the same blocks
as his head. The block the minion stands on can be another block. At first the minion will start placing
blocks in the area below him. When the area is full of blocks with the right type, it will destroy a random
block within the area. Then the minion will fill up the space again. Different minions have different amounts
of time needed for an action. The items will be just dropped so you have do build with hoppers or things like
this.

**Removing**

To remove a minion just right click it and click the red wool. Another was is to use the minion command.
Don't destroy it with attack move in creative mode!
### Structures
**Crafting Terminal**  
![just-minions-crafting-structure](https://themakowskis.de/content/just-minions-crafting-structure.png)

## Contributing
Pull requests are welcome but will probably be processed slowly. If you find major bugs or have a great idea to add,
please open an issue to discuss the problems or changes.

## License
None