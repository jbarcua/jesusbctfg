<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* Gadle
* Docker
* npm
* Visual Studio Code (recommended)
* Intellij (recommended)
* Robo 3T (recommended)

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/sergiopb7/tfm.git
   ```
2. Package the plots application running the following commands in the root folder of plots project (/plots):
   ```sh
   ./gradlew bootJar
   ```
   
   ```sh
   ./gradlew dockerTag
   ```
3. Deploy the project using docker-compose (root folder):

   ```sh
   docker-compose -f docker-compose-base.yml up
   ```
4. Connect to mongo db (using an IDE like Robo 3T will make it easier) and execute the content of the file initmongodb.txt on the IDE's shell.

5. Install NPM packages (tfm-front-end folder)
   ```sh
   npm install
   ```
6. Run the front-end app:
   ```sh
   npm start
   ```
