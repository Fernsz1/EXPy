#!/bin/bash

echo "Installing dependencies..."
cd frontend
npm install

echo "Building React..."
npm run build

echo "Copying build to Spring Boot static folder..."
rm -rf ../src/main/resources/static/*
cp -r build/* ../src/main/resources/static/

echo "Done! You can now run Spring Boot and access the React app at http://localhost:8080"
