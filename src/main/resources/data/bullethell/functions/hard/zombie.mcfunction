execute as @a at @s run scoreboard players add @e[type=zombie,distance=..40] BulletTimer 1
execute as @e[type=minecraft:zombie,scores={BulletTimer=20..}] at @s anchored eyes run summon bullethell:orb ^ ^ ^0.8 {Tags:["motion_projectile"]}
scoreboard players set @e[type=zombie,scores={BulletTimer=20..}] BulletTimer 0