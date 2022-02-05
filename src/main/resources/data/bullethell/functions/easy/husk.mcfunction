execute as @a at @s run scoreboard players add @e[type=husk,distance=8..40] BulletTimer 1
execute as @e[type=husk,scores={BulletTimer=40..,Pattern=0}] at @s anchored eyes run summon bullethell:orb ^ ^-1 ^ {Tags:["motion_projectile"],Rotation:[0f,0f]}
execute as @e[type=husk,scores={BulletTimer=40..,Pattern=0}] at @s anchored eyes run summon bullethell:orb ^ ^-1 ^ {Tags:["motion_projectile"],Rotation:[90f,0f]}
execute as @e[type=husk,scores={BulletTimer=40..,Pattern=0}] at @s anchored eyes run summon bullethell:orb ^ ^-1 ^ {Tags:["motion_projectile"],Rotation:[180f,0f]}
execute as @e[type=husk,scores={BulletTimer=40..,Pattern=0}] at @s anchored eyes run summon bullethell:orb ^ ^-1 ^ {Tags:["motion_projectile"],Rotation:[270f,0f]}
execute as @e[type=husk,scores={BulletTimer=40..,Pattern=1}] at @s anchored eyes run summon bullethell:orb ^ ^-1 ^ {Tags:["motion_projectile"],Rotation:[45f,0f]}
execute as @e[type=husk,scores={BulletTimer=40..,Pattern=1}] at @s anchored eyes run summon bullethell:orb ^ ^-1 ^ {Tags:["motion_projectile"],Rotation:[135f,0f]}
execute as @e[type=husk,scores={BulletTimer=40..,Pattern=1}] at @s anchored eyes run summon bullethell:orb ^ ^-1 ^ {Tags:["motion_projectile"],Rotation:[225f,0f]}
execute as @e[type=husk,scores={BulletTimer=40..,Pattern=1}] at @s anchored eyes run summon bullethell:orb ^ ^-1 ^ {Tags:["motion_projectile"],Rotation:[315f,0f]}
scoreboard players add @e[type=husk,scores={BulletTimer=40..}] Pattern 1
scoreboard players set @e[type=husk,scores={BulletTimer=40..}] BulletTimer 0
scoreboard players set @e[type=husk,scores={Pattern=2..}] Pattern 0