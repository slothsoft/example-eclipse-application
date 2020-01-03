# Example Eclipse Application

**TODO:**

- link https://blog.sandra-parsick.de/2017/09/22/generate-p2-repository-from-maven-artifacts-in-2017/
- pomless build (commit first)



------------------------------------------------------------------

This example project shows how to develop and build an Eclipse based application using Tycho. 

It shows how to:

- build a product with Tycho
- use a target platform both inside Tycho and Eclipse

**Content of this ReadMe:**

- [Maven Modules](#maven-modules)
- [Developer Guide](#developer-guide)
- [How to](#how-to)



## Maven Modules

- **[de.slothsoft.example.build](#de-slothsoft-example-build)** - parent of the reactor
    - **[de.slothsoft.example](#de-slothsoft-example)** - the plug-in with the usable code
    - **[de.slothsoft.example.it](#de-slothsoft-example-it)** - the integration tests for above plug-in
    - **[de.slothsoft.example.feature](#de-slothsoft-example-feature)** - a feature for a feature-based product
    - **[de.slothsoft.example.product](#de-slothsoft-example-product)** - the product file to start and build an application


### de.slothsoft.example.build
  
This project is the parent of the reactor and contains common resources and configurations.

- **_platform.target_** - all the dependencies in one handy file; can be used by both Tycho and Eclipse
- **_pom.xml_** - most of the Maven and Tycho configuration
- **_README.md_** - a landing page for the repository


### de.slothsoft.example

This project is the plug-in with the usable code. It just contains the Eclipse template for a new application and the template for a view.


### de.slothsoft.example.it

This project tests the project `de.slothsoft.example`. In this example, it's tested that the view `ExampleView` can be opened without problems.


### de.slothsoft.example.feature

This project contains a feature for a feature-based product.


### de.slothsoft.example.product

This project has the product file to start build an application from Eclipse and build it from Tycho.



## Developer Guide

To start this project in your Eclipse, do:

1. Clone this repository
1. To start the application from **Eclipse** do the following:
    1. Open the file _platform.target_ and click on _"Set as Active Target Platform"_
    1. _de.slothsoft.example.product/ExampleApp.product_ and click on _"1. Synchronize"_ and then _"2. Launch Eclipse Application"_
1. To build the application with **Tycho** 
     - Run `mvn clean install` on the repository root
     - Or in Eclipse right click on the _pom.xml_ and use _"Run as..."_ → _"Maven install"_
     - The resulting EXE file is in _de.slothsoft.example.product/target/products/de.slothsoft.example.product-<time>-<os>.zip_ and / or the folder next to the ZIP file



To use this example as a template for your Eclipse based application you need to do the following:

1. check out this project
1. rename my IDs to yours
    - "de.slothsoft" to your company's domain (including packages)
    - "example" to your project's name (the same for capitalized "Example")
    - "Slothsoft" to your company's name



## How to

### How to change Eclipse version? 

The Eclipse version is set inside the _platform.target_. Just change the repository location to your wanted Eclipse version and adjust the versions of the features (or use "0.0.0" to get the latest version).


### How to change the operating system? 

The file _platform.target_ should be able to accommodate every OS you could open it with. The _pom.xml_ file next to it however has information about the OS this application gets build for. Edit the `<environments>` tag of the `target-platform-configuration` plug-in to change this build to your liking, or add more environments to build the application for multiple OS.


### How to change Java version?

The file _pom.xml_ has a property `tycho.version` that can be changed easily.


### How to change the Java version?

The Java version is defined inside the _MANIFEST.MF_ for each plug-in (including the IT project). 