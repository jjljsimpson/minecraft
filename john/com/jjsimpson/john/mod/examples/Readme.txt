-------- Info --------
This file has information on the minecraft mod project.
I'm starting by teaching a couple boys on how to make minecraft.
This will include setup. There will be another directory which contains
information about each lesson.

-------- Setup --------
There is a lot to setup. Here is a list of the software we need:
* Java SDK
* Minecraft Forge
* Eclipse
* Minecraft

Some nice to haves:
* Git (To save our files online)

Below is the info we need to get ourselves up and running.


----- Java SDK -----
This is all written in Java. So we need the software development kit.
Use a google search for java sdk, or the link below.
http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
After you install, you need to add the JAVA_HOME to your path.
[MAC]
Open up terminal (Use spotlight by pressing apple space. They type terminal and hit return)
type vi ~/.bash_profile
This will open up a terminal text editer.
Type i to get into insert mode.
use the arrows to get to the end of the file.
Type in
export JAVA_HOME=$(/usr/libexec/java_home)
Then press :wq
Then hit return


----- Minecraft Forge -----
Download (we are using version 1.8)
Goto http://files.minecraftforge.net/
Select the version. Then select source. Skip the add and download.
After it is downloaded unzip it and move it to where you want.
Rename the folder to forge (it is easier).
[MAC]
Open the terminal again (see above).
type cd
then drag the forge folder on top of the terminal. It should paste in the path onto teriminal.
Hit return.
Now lets get it setup for eclipse. This might take a while (several minutes) so be patient.
type in ./gradelw setupDecompWorkspace eclipse
hit return

----- Eclipse -----
Eclipse is the Java programming environment called an IDE (Integrated Development Environment).
It is free :)
http://eclipse.org/downloads/
Pick 'Eclipse IDE for Java Developers'
After the image download, install it.
Then launch it.
We are going to change the workspace for eclipse
Go to File>Switch Workspace>Other...
Browse to the forge folder and select the eclipse folder press OK.
Give it a few minutes to build and you have it basically setup.
Just for fun you can run the mod right now (it doesn't do much) by pressing the Run button (Green circle with a white play button)
Quit minecraft


----- GitHub -----
We use Github so that we can back up our files online. It is a good idea, plus we can share files this way too.
Every file will be online, and you can point people to them. For example this readme is found at
https://github.com/jjljsimpson/minecraft/blob/develop/john/com/jjsimpson/john/mod/examples/Readme.txt

You need to create a git account, and fork my repo
https://github.com/jjljsimpson/minecraft
and then clone it locally. I cloned mine in the forge folder and called it minecraft.
There is lots of info on how to use git.
Finally create a branch (called develop) then pull from the remote and get all the files.

Now that you have all the files, you need to add it to eclipse.
In eclipse, right click on the project and goto properties.
Goto Java Build Path.
Press the Add Folder... button on the source tab.
Browse to your folder (for me that is John) and select it.
Now all my code is in the project, and I can upload / download at will.

----- GitX -----
This makes things easier to work with git. Instead of having to do everything
through the command line, we can do it through a fancy UI.

