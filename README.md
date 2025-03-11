# InsideOut - The WebSite version



InsideOut is a website made for two main putposes which are : Compression and Decompression files. Using it the user can provide a file at maximum length of 100MB (sat by me but can be changes in the Application.properties file).

This website is mainly used for DIY learning purposes so feel free to critisize.



## Features

- **Interactive & easy to use web interface .**

- **Supposts various compression and decompression types. (Note: can be modified; add new types)**

- **Supported types :**
  
  - zip
  
  - gz
  
  - tar
  
  - xz
  
  - lz4
  
  - lzma
  
  - bzip2

- **Supports Nginx.**

- **Supports both Dark & Light Modes.**

- **Custom error pages for handling status codes :**
  
  - *400 BAD REQUEST*
  
  - 404 NOT FOUND*.
  
  - *405 METHOD NOT ALLOWED.*
  
  - **500 INTERNAL SERVER ERROR.*
  
  - *502 BAD GATEWAY.*

- **Provide links for the developer in-case of malfunctionning. (linkedin, github & discord)**



## Used Technologies

- **Spring-boot : Used in API building**.

- **Thymeleaf : Since using spring boot it's better to use thymeleaf as template engine for rendering webpages.**

- **Nginx : Used as reverse proxy to mapp the http://localhost:8080 to http://localhost (Pretty creative right ? LOL).**

- **Pure Java : For Compression & Decompression Backend.**

- **HTML + CSS + vanilla JS : Used for the frontend.**



# Only If You Wanna Run This WebSite Locally



## Requirements

- **Spring boot with java version 17 as mininum installed locally.**

- **Nginx**.

- **An IDE (Obviously).**

- **Web-Browser (I recommend firefox since it has good dev tools setup espcially for the contributors).**

- **HTML + CSS + JS**.



## Usage

if you just installed Nginx please open your teminal and type this command to avoid conflicts.

```bash
$ sudo ufw allow 'Nginx Full' 
```

> The command above is ued to tell the firewall to not intercept any nginx request (if u want to run it usingf nginx not tomcat)

```bash
$ sudo rm /etc/nginx/sites-enabled/default
$ sudo ln -s /etc/nginx/sites-available/insideout-nginx-config /etc/nginx/sites-enabled/
$ sudo nginx -t
$ sudo systemctl reload nginx
```

> The commands above are used tespectively for :
> 
> - Deleting the default Nginx condiguration because it may interfere with the WebSite configuration.
> 
> - Adding the website configuration file into the ngix default configuration folder because otherwise it won't pick it up.
> 
> - Test the configuration file (not actually needed but nevermind it coasts nothing to be cautious).
> 
> - Reloading the nginx service (assuming you're using linux).



## Web Pages

### index.html (HOME page)

> Light mode

![](/home/ignorant05/.config/marktext/images/2025-03-11-23-47-12-Screenshot%20from%202025-03-11%2023-44-18.png)

> Dark mode

![](/home/ignorant05/.config/marktext/images/2025-03-11-23-48-14-Screenshot%20from%202025-03-11%2023-44-36.png)



### tasks.html (when u do the Compression & Decompression as the User)

> Light mode

![](/home/ignorant05/.config/marktext/images/2025-03-11-23-51-00-image.png)

> Dark mode

![](/home/ignorant05/.config/marktext/images/2025-03-11-23-49-10-Screenshot%20from%202025-03-11%2023-45-09.png)



### about.html (Just a notice)

> Light mode

![](/home/ignorant05/.config/marktext/images/2025-03-11-23-51-12-Screenshot%20from%202025-03-11%2023-49-58.png)

> Dark mode

![](/home/ignorant05/.config/marktext/images/2025-03-11-23-49-45-Screenshot%20from%202025-03-11%2023-45-51.png)



## Usage Process

In the tasks webpage: initially ou have two options :

- #### if You chose compression
  
  You'll get this displayed :
  
  ![](/home/ignorant05/.config/marktext/images/2025-03-11-23-53-06-image.png)

        You just need to select the type you want from the dropdown list, then upload your file and finally press submit and it'll automatically compress and downlod the new file to your *downloads* folder.

- #### If you chose decompression
  
  You'll get this displayed : 
  
  ![](/home/ignorant05/.config/marktext/images/2025-03-11-23-56-24-Screenshot%20from%202025-03-11%2023-56-11.png)
  
   Now you need just to upload the file and press submit and it'll automatically hanfle the decompression process if the type is available otherwise it'll drop an alert window.



## *Note*

- The Compression & Decompression source code is located in the *external-source* folder .
  
  - Change it only if you have a compression type to add and don't forget to modify the *types* drop-down list.
  
  - Don't forget to package it into jar file, you can use this command after navigating into the *extenal-source* folder :
    
    ```bash
    $ mvn clean package && mvn install
    ```

         

- The nginx configuration file is in the *nginx-config* folder.
