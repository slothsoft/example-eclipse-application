# Example Eclipse Application

**TODO:**

- short explanation
- link https://blog.sandra-parsick.de/2017/09/22/generate-p2-repository-from-maven-artifacts-in-2017/
- How to change Eclipse version?
- How to change Tycho version
- how to change OS
- where to find product
- SLICER
- examples of
	- build product with Maven / tycho
	- start from product
	- p2 repo from maven central
- pomless build (commit first)


------------------------------------------------------------------

## Maven Modules

- [de.slothsoft.example.build](#de-slothsoft-example-build) - parent of the reactor
    - [de.slothsoft.example](#de-slothsoft-example) - the plug-in with the usable code
    - [de.slothsoft.example.it](#de-slothsoft-example-it) - the integration tests for above plug-in

### de.slothsoft.example.build
  
This project is the parent of the reactor and contains common resources and configurations.

- **_platform.target_** - all the dependencies in one handy file; can be used by both Tycho and Eclipse
- **_pom.xml_** - most of the Maven and Tycho configuration
- **README.md_** - a landing page for the repository


### de.slothsoft.example

This project is the plug-in with the usable code. It just contains the template for a new application and the template for a view.

### de.slothsoft.example.it



## Developer Guide

To start this project in your Eclipse, do:

1. Clone this repository
1. Open the file _"platform.target"_ and click on _"Set as Active Target Platform"_


To use this example as a template for your Eclipse based application you need to do the following:

1. check out this project
1. rename my naming to yours
    - "de.slothsoft" to your company's domain (including packages)
    - "example" to your project's name (the same for capitalized "Example")
    - "Slothsoft" to your company's name