#QD-SPL

**Quality-Driven Software Product Lines project repository**

QD-SPL complements automated software development by enabling quality attributes variability and their relationships with functionalities at the quality levels they are desired. Instead of designing and developing additional architectural elements to support multiple quality attributes, it is focused on creating an initial Reference Architecture and adapting that architecture according to a selection of quality levels.

##Repository structure

###CaseStudy

This folder contains the code base for a case study illustrating the use of QD-SPL. The case study develops a software prodcut line (SPL) of enterprise software applications for project management systems. A project management system is preconfigured in the source code with both functional and quality variability. This case study serves as an exemplification of the kind of SPLs that can be obtained by using QD-SPL.

###Generation

This folder contains a domain metamodel to define the functional scope of product line members. It also contains a QAs variability model to indicate the quality attributes (only performance and security for now) that are going to be addressed when configuring products, specifying the quality scope of product line members. Relationships between elements from both the domain metamodel and the QAs variability model can be defined using a coarse-grained approach, indicating that each desired quality level on a target product has to be promoted by every component of such product. Software design patterns promote the configured quality levels and are documented through the reference architecture. The automated derivation of products is supported once a domain model and a configuration of quality attributes have been created. The reference architecture is mapped onto several templates that contain the logic needed to implement possible configuration decisions. Quality domain metamodel and transformations to derive products can be reused in several SPLs that share the same interests (e.g. enterprise applications).
