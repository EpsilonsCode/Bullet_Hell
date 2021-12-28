execute store result score @s rotation_xbase run data get entity @s Rotation[0] 1000
execute store result score @s rotation_ybase run data get entity @s Rotation[1] 1000

execute as @s[tag=phantom_1] at @s run function bullethell:deviation/phantom/phantom1
execute as @s[tag=phantom_2] at @s run function bullethell:deviation/phantom/phantom2
execute as @s[tag=phantom_3] at @s run function bullethell:deviation/phantom/phantom3
execute as @s[tag=phantom_4] at @s run function bullethell:deviation/phantom/phantom4

execute store result entity @s Rot[0] double 0.001 run scoreboard players operation @s rotation_xbase += @s rotation_x
execute store result entity @s Rot[1] double 0.001 run scoreboard players operation @s rotation_ybase += @s rotation_y