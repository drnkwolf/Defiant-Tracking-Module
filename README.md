# Defiant Package Tracking Module

Sample Spring Boot REST API to track a package by customers whose locations can be updated by a package carrier

The project was created during my summer 2021 intership as Java Back-end developer at [Foxmula Private LTD](https://foxmula.com/).

## NOTE
This project was done as the part of the learning process during the internship and as a proof of concept.

## Technologies Used

* Java Spring Boot
* JPA
* Hibernate
* SQL

## Description

The project comprises of three actors :-

* __Customer__ - Defined under model package as Customer.java is used to represent end-users of the application. Who intend to get the location status of packages. It has a One-to-Many relationship with the below discussed Package model.

* __Package__ - Defined under model package as Package.java is used to represent the package/order which need to be delived. It comprise of a Many-to-One relationship with both Customer and Carrier model.

* __Carrier__ - Defined under model package Carrier.java is used to represent as the actor who is carring the order/package and can update the status and location of the packages/orders they are carring. It has a One-to-Many relationship with Package model.

The four exposed API end-points are used to interact with the application :-

* The CarrierController class under Controller package manages two end-points which are used to Update the status of individual package or a set of packages.

* The CustomerController class under Controller package manages the other two end-point where customers can get current status of packages or a set of packages.

JPA is used has the ORM framework and the Hibernate is used has a temorary in memory database.