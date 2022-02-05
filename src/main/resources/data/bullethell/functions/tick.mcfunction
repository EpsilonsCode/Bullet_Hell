execute as @e[tag=motion_projectile_toward,tag=!motion_added] at @s facing entity @p eyes run function bullethell:apply_motion

execute as @e[tag=motion_projectile,tag=!motion_added] at @s run function bullethell:apply_motion

scoreboard players add @e ShotCount 0
scoreboard players add @e Pattern 0