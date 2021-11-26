execute as @a at @s run scoreboard players add @e[type=zombie,distance=8..40] BulletTimer 1
execute as @e[type=minecraft:zombie,scores={BulletTimer=20..,ShotCount=..4}] at @s anchored eyes run summon bullethell:orb ^ ^-0.5 ^ {Tags:["motion_projectile"]}
scoreboard players add @e[type=zombie,scores={BulletTimer=20..,ShotCount=..4}] ShotCount 1
scoreboard players set @e[type=zombie,scores={BulletTimer=20..,ShotCount=..4}] BulletTimer 0
scoreboard players set @e[type=zombie,scores={BulletTimer=150..,ShotCount=5..}] ShotCount 0
scoreboard players set @e[type=zombie,scores={BulletTimer=150..,ShotCount=5..}] BulletTimer 0
