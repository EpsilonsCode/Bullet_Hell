execute as @a at @s run scoreboard players add @e[type=zombie,distance=8..40] BulletTimer 2
execute as @e[type=zombie,scores={BulletTimer=20..,ShotCount=..9}] at @s anchored eyes run summon bullethell:orb ^ ^-1 ^ {Tags:["motion_projectile_toward"]}
scoreboard players add @e[type=zombie,scores={BulletTimer=20..,ShotCount=..9}] ShotCount 1
scoreboard players set @e[type=zombie,scores={BulletTimer=20..,ShotCount=..9}] BulletTimer 0
scoreboard players set @e[type=zombie,scores={BulletTimer=150..,ShotCount=10..}] ShotCount 0
scoreboard players set @e[type=zombie,scores={BulletTimer=150..,ShotCount=10..}] BulletTimer 0
