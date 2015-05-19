------ Lesson 1 ------
In today's lesson we will look at 3 things:
* An overview on the tools and how to use them
* An overview of Java and some basic concepts
* Build a very simple first Mod

We need to start slow and build on the concepts we learned previously.
This means that at first things will seem too slow, but by the end
it will be very quick and complex.

What kind of Mods to build? In order to properly plan, it will help
to know what kind of things you would like to do.

---- Tools ----
We will spend most of our time in eclipse. It is a powerful tool, with lots of features. We won't use most of the features.
Before we get to eclipse, we need to know a little about minecraft and minecraft forge.

Minecraft is the game that we all play. It is written in Java. That is a language that is meant to run on most every platform.
So they can mostly use the same code on mac, pc, and others.
Minecraft forge is a project where they break open the minecraft game. They look inside how it is built and create some classes
to interact with the game. This is all done in Java, the same lanuage as the game. There are two steps to cracking open minecraft.
First you have to decompile it. That takes the game and breaks it up into it's commands and builds the Java needed to run the app.
Then you have to deobfuscate the java. When the app is packaged for us to use, it is obfuscated. Names are shortened to as small as possible,
evrything is optomized and made nice and small. So when minecraft forge opens it up, all the names are crazy and meaningless.
They have to go through and create more meaningful names so we can know how to use it.
That means with a new version, this process has to be started all over. At first, you may not have as many features because they only
decoded part of the app, as time goes on, more and more become available.

We don't need to know much about Forge, just the APIs or functionality they give us to write our mods.

Eclipse is something we do need to know about. It has a crazy amount of features.
For example, all of the windows can be detached and moved to another section. If this becomes to crazy, we can always reset our environment.
In the top right is a button that says Java EE. You can right click and select reset to go back to the default (which you can change).

    The Project explorer is one of the panels we will use frequently. It is a list of all the files in our project. Very important is the first couple of folders
    with a square target icon. This is a list of all our code. There should be one that says github/[your name].
    This is where we will keep all the code we write for our mod. {Take A Look}
    
    The Console is a panel that can be very useful. The application writes out lots of information to this panel.
    We can use it to see what is going on with the application.
    We can even write code to send messages to the console. However, there is so much information there, we probably won't use it too much.
    You can hide this panel, but when we run minecraft it will keep popping up.
    
    Finally the man panel is the coding panel. It is where we write our code.
    We will spend a lot of time here. 

---- Java ----
Java is an easy and powerful language for programming. It is an Object Oriented Programming language.
That means you create objects. An Object may have properties and methods.
A property is an attribute for the object. For example, if we made a car object, it could have a color property.
This property would tell us what color the car is.
Objects also have methods (sometimes called functions). A method is an action the object makes. So a car
might have a drive methods. You could use this method to move around.
The idea is that objects are concepts of things that act like they might in the real world.

The easiest way to show this, is by creating an object.
Let's start by creating our first mod.  


---- First Mod ----
1. Creaet Package
2. Create Class 'MainMod'
3. Create mod properties
4. explain public
5. explain static
6. explain final
7. Add a constructor
8. Add FMLInitializationEvent event
9. Add @EventHandler annotation
10. Add @Mod(modid = MainMod.MODID, version = MainMod.VERSION) annotation.
11. Add imports {notice errors}

This mod doesn't do anything. Lets add some functionality.
This gives you a message everytime you break a block

1. Create Package
2. Create Class 'BlockBreakMessage'
3. Add BreakEvent event
4. Add code
5. Add Annotations
6. Add imports

We created the functionality, but minecraft doesn't know that it needs to call this.
We need to tell minecraft that everytime this event happens, to call this method.
Go back to the mod.

1. Register the mod

Questions.

> Run

---- Second Mod ----
Minecart explosions
1. Create Package
2. Create Class 'MinecartExplosion'
3. Create MinecartCollisionEvent event
4. Add Code
5. Add Annotations.
6. Add Imports

7. In mod class, register this event handler

> Run

