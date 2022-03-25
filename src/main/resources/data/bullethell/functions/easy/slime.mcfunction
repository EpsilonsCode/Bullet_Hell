#demonstrates nbt based attack

execute as @a at @s run scoreboard players add @e[type=slime,distance=8..40,nbt={Size:0}] BulletTimer 1
execute as @e[type=slime,scores={BulletTimer=20..,ShotCount=..4},nbt={Size:0}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile_toward"]}
scoreboard players add @e[type=slime,scores={BulletTimer=20..,ShotCount=..4},nbt={Size:0}] ShotCount 1
scoreboard players set @e[type=slime,scores={BulletTimer=20..,ShotCount=..4},nbt={Size:0}] BulletTimer 0
scoreboard players set @e[type=slime,scores={BulletTimer=150..,ShotCount=5..},nbt={Size:0}] ShotCount 0
scoreboard players set @e[type=slime,scores={BulletTimer=150..,ShotCount=5..},nbt={Size:0}] BulletTimer 0