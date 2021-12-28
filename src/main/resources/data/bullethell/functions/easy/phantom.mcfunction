execute as @a at @s run scoreboard players add @e[type=phantom,distance=8..40] BulletTimer 1
execute as @e[type=phantom,scores={BulletTimer=40..,ShotCount=..2}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile_toward"]}
execute as @e[type=phantom,scores={BulletTimer=40..,ShotCount=..2}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile"],Rotation:[0f,67.5f]]}
execute as @e[type=phantom,scores={BulletTimer=40..,ShotCount=..2}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile"],Rotation:[90f,67.5f]]}
execute as @e[type=phantom,scores={BulletTimer=40..,ShotCount=..2}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile"],Rotation:[180f,67.5f]]}
execute as @e[type=phantom,scores={BulletTimer=40..,ShotCount=..2}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile"],Rotation:[270f,67.5f]]}
scoreboard players add @e[type=phantom,scores={BulletTimer=40..,ShotCount=..2}] ShotCount 1
scoreboard players set @e[type=phantom,scores={BulletTimer=40..,ShotCount=..2}] BulletTimer 0
scoreboard players set @e[type=phantom,scores={BulletTimer=200..,ShotCount=3..}] ShotCount 0
scoreboard players set @e[type=phantom,scores={BulletTimer=200..,ShotCount=3..}] BulletTimer 0

