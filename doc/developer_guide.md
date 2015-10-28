# Development Guide

This document is a development guide for the Wary Festival application.

## Requirements

For development the following software is required:

 - Git 2.x
 - Java Development Kit 8
 - Gradle 2.x
 - Payara 4.x or any other full Java EE 7 application server

The following software is recommended:

 - Eclipse 4.x Java EE edition or any other Java EE 7 IDE

## Installation

This section shows one way to install the required and recommended software and
run some simple commands.

### Git

Git can be download [here](https://git-scm.com/downloads).

To clone the wary festival project:

    $ git clone https://github.com/adilsoncabral0/waryFestival

### Java Development Kit

Java Development Kit 8 can be download
[here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
Simply follow the instructions of the installation file.

To test if Java is installed correctly execute:

    $ java --version
    openjdk version "1.8.0_65"
    OpenJDK Runtime Environment (build 1.8.0_65-b17)
    OpenJDK 64-Bit Server VM (build 25.65-b01, mixed mode)

### Payara

Download Payara 4.1 Full Java EE 7 application server
[here](http://www.payara.co.uk/downloads). The Payara is distributed as a zip
file. Simply unzip anywhere you like and the installation is complete. After
installing you should to add `PAYARA_HOME/bin` to your `PATH` variable so that
the `asadmin` binary is globaly accessible.

To start the Payara server execute the following command:

    $ asadmin start-domain
    Successfully started the domain : domain1
    domain  Location: PAYARA_HOME/glassfish/domains/domain1
    Log File: PAYARA_HOME/glassfish/domains/domain1/logs/server.log
    Admin Port: 4848

To start the built-in database:

    $ asadmin start-database
    Starting database in Network Server mode on host 0.0.0.0 and port 1527.
    (...)
    Starting database in the background.
    Log redirected to PAYARA_HOME/glassfish/databases/derby.log.
    Command start-database executed successfully.

Payara can be configured using the `asadmin` command but there's also a GUI
administration page. By default the page is located at: http://localhost:4848.

### Gradle

Gradle can be downloaded [here](http://gradle.org/gradle-download). Like
Payara, Gradle is also ditributed as a portable zip file. Unzip the file
anywhere you like and the installation is complete. After installing Gradle,
you should add `GRADLE_HOME/bin` to your `PATH` environment variable so that
the `gradle` binary is globaly accessible.

To test the installation run the following command:

    $ gradle --version
    
    ------------------------------------------------------------
    Gradle 2.8
    ------------------------------------------------------------
    
    Build time:   2015-10-20 03:46:36 UTC
    Build number: none
    Revision:     b463d7980c40d44c4657dc80025275b84a29e31f
    
    Groovy:       2.4.4
    Ant:          Apache Ant(TM) version 1.9.3 compiled on December 23 2013
    JVM:          1.8.0_65 (Oracle Corporation 25.65-b01)
    OS:           Linux 4.2.3-1-ARCH amd64

To create an compile:

    $ gradle compile

To create an EAR file:

    $ gradle ear

To rebuild an eclipse project:

    $ gradle eclipse

### Eclipse

Eclipse Java EE edition can be downloaded
[here](https://eclipse.org/downloads).

After building the eclipse project using gradle, the project can be imported by
executing the following steps:

 * Open `File` in the menu bat
 * Select `Import...`
 * In the `Select` window
  * Expand the `General` node
  * Select `Existing Project into Workspace`
  * Press the `Next` button
 * In the `Import Projects` window
  * Select the `Select root directory` option
  * Press the `Browse` button
  * Choose the project path
  * Press the 'Finish' button

## Configuration

After all sofware is installed, some additional configuration is required to
have wary festival up and running.

### Application Server Data Source

After installing the application server a new data source needs to be created.
In the Payara server a new JDBC connection pool and JDBC resource must be
created. Payara has a built-in `JavaDB` database, so that is the database we
will use in this example.

To create a new JDBC connection pool:

 * Open the administration page
 * Expand the `Resources` node
 * Expand the `JDBC` node
 * Select the `JDBC Connection Pools` node
 * In the `JDBC Connection Pools` page
  * Press the `New` button
 * In the `New JDBC Connection Pool (Step 1 of 2)` page
  * Input a pool name (e.g., `waryFestivalCP`)
  * Set `javax.sql.ConnectionPoolDataSource` resource type
  * Set `JavaDB` data driver vendor
  * Press the `Next` button
 * In the `New JDBC Connection Pool (Step 2 of 2)` page
  * In the `Transaction` section
   * Input the value of the `Databasename` property (e.g., `waryFestivalDB`)
   * Input the value of the `Username` property
   * Input the value of the `Password` property
  * Press the `Finish` button

To create a new JDBC resource:

 * Go to the administration page
 * Expand the `Resources` node
 * Expand the `JDBC` node
 * Select the `JDBC Resources` node
 * In the `JDBC Resources` page
  * Press the `New` button
 * In the `New JDBC Resource` page
  * Set `jdbc/waryFestival` in the JNDI name
  * Set the previously created JDBC connection pool as the pool name
  * Press the `OK` button

### Eclipse Application Server

Eclipse can be configured to run basic commands of an application server. To
add the Payara 4.1 server:

 * Select the `Servers` tab
 * Right click on the window
  * Move to `New`
  * Select `Server`
 * In the `Define a New Server` window
  * Expand `Glassfish`
  * Select `Glassfish 4`
  * Press the `Next` button
 * In the `Glassfish 4` window
  * Input the username (blank by default)
  * Input the password (blank by default)
  * Press the `Next` button
 * In the `Add and Remove` window
  * Select the `waryFestival` project
  * Press the `Add` button
  * Press the `Finish` button

To start the Payara server:

 * Select the `Servers` tab
 * Right click on the added server node
  * Select `Start`

To synchronize the wary festival project:

 * Select the `Servers` tab
 * Expand the added server node
 * Right click on `waryFestival`
  * Select `Full Publish`

## Test

There is only a SOAP web service in wary festival so far. After starting
Payara, the web service can be tested
[here](http://tsuki:8080/FestivalWSService/FestivalWS?Tester). The
administration page also provides a link to the webservice test as well.

