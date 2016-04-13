#############################################################################
#																			#
# PROJECT: CollectionManager case study basic								#
# AUTHORS: Hugo Arboleda (hfarboleda@icesi.edu.co)							#
#		   Andrés Paz (andres.paz@correo.icesi.edu.co)						#
#																			#
#############################################################################

-----------------------------------------------------------------------------
CONTENTS
-----------------------------------------------------------------------------

1. Overview
2. Structure
3. Starting the tutorial

-----------------------------------------------------------------------------
1. OVERVIEW
-----------------------------------------------------------------------------

The CollectionManager case study is a model-driven product line that enables
generative development of applications that manage entities. For example an
application that can be obtained is a music store which manages songs, which
have a title, artist and genre.

-----------------------------------------------------------------------------
2. STRUCTURE
-----------------------------------------------------------------------------

co.edu.unicesi.gendev.mde.collectionManager
	|
	|- src
	|- src-gen
	|- src-full
	|- metamodels
	|- models
	|- docs
	   |- reference
	|- lib

src :			This folder contains the base files that make up the product
				line. This files should be modified when doing the exercises
				specified in the tutorial.

src-gen :		This folder contains the generated source code for the
				application.

src-full :		This folder contains all the files that make up the product
				line. This files should not be modified unless the product
				line is extended. You should not look into this folder if you
				haven't worked on the tutorial exercises.

metamodels :	This folder contains the metamodels that represent the
				software product line (SPL).

models :		This folder contains the models that represent the
				application to be generated with the SPL.

docs :			This folder contains the case study documentation files.
                reference : This folder contains the oAW User Guide. Use this
                guide as a syntax reference while following the tutorial. 

lib :			This folder contains libraries and tools.

-----------------------------------------------------------------------------
3. STARTING THE TUTORIAL
-----------------------------------------------------------------------------

To begin this tutorial, expand the docs folder and open the file
1-Tutorial.pdf. Follow the instructions found in this tutorial to generate
the source code for the case study application.

-----------------------------------------------------------------------------