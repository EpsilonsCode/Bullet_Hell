#demonstrates spread attacks

execute as @a at @s run scoreboard players add @e[type=creeper,distance=8..16] BulletTimer 1
execute as @e[type=creeper,scores={BulletTimer=60..}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile"],Rotation:[0f,0f]}
execute as @e[type=creeper,scores={BulletTimer=60..}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile"],Rotation:[45f,0f]}
execute as @e[type=creeper,scores={BulletTimer=60..}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile"],Rotation:[90f,0f]}
execute as @e[type=creeper,scores={BulletTimer=60..}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile"],Rotation:[135f,0f]}
execute as @e[type=creeper,scores={BulletTimer=60..}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile"],Rotation:[180f,0f]}
execute as @e[type=creeper,scores={BulletTimer=60..}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile"],Rotation:[225f,0f]}
execute as @e[type=creeper,scores={BulletTimer=60..}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile"],Rotation:[270f,0f]}
execute as @e[type=creeper,scores={BulletTimer=60..}] at @s anchored eyes run summon bullethell:orb ^ ^ ^ {Tags:["motion_projectile"],Rotation:[315f,0f]}
scoreboard players set @e[type=creeper,scores={BulletTimer=60..}] BulletTimer 0