execute as @a at @s run scoreboard players add @e[type=phantom,distance=8..40] BulletTimer 1
execute as @e[type=phantom,scores={BulletTimer=40..,ShotCount=..4}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile_toward"]}
execute as @e[type=phantom,scores={BulletTimer=40..,ShotCount=..4}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile_deviate","phantom_1"]}
execute as @e[type=phantom,scores={BulletTimer=40..,ShotCount=..4}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile_deviate","phantom_2"]}
execute as @e[type=phantom,scores={BulletTimer=40..,ShotCount=..4}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile_deviate","phantom_3"]}
execute as @e[type=phantom,scores={BulletTimer=40..,ShotCount=..4}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile_deviate","phantom_4"]}
scoreboard players add @e[type=phantom,scores={BulletTimer=40..,ShotCount=..4}] ShotCount 1
scoreboard players set @e[type=phantom,scores={BulletTimer=40..,ShotCount=..4}] BulletTimer 0
scoreboard players set @e[type=phantom,scores={BulletTimer=150..,ShotCount=5..}] ShotCount 0
scoreboard players set @e[type=phantom,scores={BulletTimer=150..,ShotCount=5..}] BulletTimer 0

