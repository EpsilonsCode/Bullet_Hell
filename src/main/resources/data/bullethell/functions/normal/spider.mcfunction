execute as @a at @s run scoreboard players add @e[type=spider,distance=8..40] BulletTimer 1
execute as @e[type=spider,scores={BulletTimer=20..,ShotCount=..9}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile_toward"]}
scoreboard players add @e[type=spider,scores={BulletTimer=20..,ShotCount=..9}] ShotCount 1
scoreboard players set @e[type=spider,scores={BulletTimer=20..,ShotCount=..9}] BulletTimer 0
scoreboard players set @e[type=spider,scores={BulletTimer=150..,ShotCount=10..}] ShotCount 0
scoreboard players set @e[type=spider,scores={BulletTimer=150..,ShotCount=10..}] BulletTimer 0
