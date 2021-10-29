execute as @a at @s run scoreboard players add @e[type=zombie,distance=..40] BulletTimer 1
execute as @e[type=zombie,scores={BulletTimer=20..}] at @s run summon bullethell:orb ~ ~ ~ {deviation:[0.0, 0.1, 0.0]}
