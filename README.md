# ScalaRasa
Generates similar sounding place names.

## Compilation and Test
Open powershell or cmd and navigate to project directory, then enter the following to compile and test
```
  ./activator.bat compile
  ./activator.bat test
```
This will download all dependencies, compile and then test the code

## To Run
In powershell or cmd, run the following ```./activator.bat run```. If you want to customise the run, add quotes around run, view the help to see what args exist
```
  ./activator.bat "run --help"
```

## How it works
The approach is loosly based off of [http://mewo2.com/notes/naming-language/](this blog post). There are some extra layers of customization built in and the software is in Scala over JS.

## Possible Future Features
 - Add option for file based output
 - Add reuse of components
 - Add ability to generate based off of an ancestoral language
