#!/bin/bash

mkdir -p res/drawable-mdpi
mkdir -p res/drawable-hdpi
mkdir -p res/drawable-xhdpi
mkdir -p res/drawable-xxhdpi
mkdir -p res/drawable-xxxhdpi

for file in ./*.svg
 do
	filename="${file%.*}"
	inkscape --file "$file" --export-png "res/drawable-mdpi/$filename.png" --export-width 24
	inkscape --file "$file" --export-png "res/drawable-hdpi/$filename.png" --export-width 36
	inkscape --file "$file" --export-png "res/drawable-xhdpi/$filename.png" --export-width 48
	inkscape --file "$file" --export-png "res/drawable-xxhdpi/$filename.png" --export-width 72
	inkscape --file "$file" --export-png "res/drawable-xxxhdpi/$filename.png" --export-width 92
done
