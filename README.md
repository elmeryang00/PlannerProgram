# Planner Project

## Setup (using Eclipse)
1. Clone the Git Repository
	
	For people who are beginners to git, it is recomended to use the GitHub Desktop application to clone the repository. On github.com, navigate to the repository webpage and click the green button that says "Clone or download". Next, select "Open in Desktop".
	
	This will open up GitHub Desktop, prompting to select a location to clone the repository. Select any location. The default location should work.
	
2. Import the Eclipse Project
	
	In Eclipse, click File > Import... > Maven > Existing Maven Projects... > Next. From there, browse for the directory into which you clone the git repository. Select ```pom.xml``` and click Finish. Now, use the Maven project like an Eclipse project.
	
3. Making Changes, Committing, and Synchronizing with Git (using GitHub Desktop)

	When a change is made to the source in the repository, the changes are tracked by GitHub Desktop. Whenever a "stopping point" is reached in the code, a commit should be made. This bundles together changes made to the repository as a discrete object. After committing changes, the repository needs to be synchronized with the remote server in order to upload the changes to github.com. Within GitHub Desktop, this is easy. To commit changes, navigate to the Changes tab, select the relevant files, write a summary, and press the "Commit to" button. To synchronize the changes by clicking the Sync button in the top right corner. Now, the changes are visible on github.com.
	
## Using Maven for Dependencies

Most projects in Java rely on dependencies, which are libraries of code written by others that are referenced by the application. Normally, a developer can download a ```.jar``` file and reference it in Eclipse by attaching it to the project, but updating and managing several jars can be difficult. Maven simplifies dependencies (and other things) by allowing the user to state only the necessary dependencies while letting Maven handle the rest.

In order to use a dependency, first find it on [MVN Repository](https://www.mvnrepository.com/). Then navigate to the specific version number that is desired. Then copy the associated code snippet. Next, open up ```pom.xml``` and select the pom.xml tab on the bottom. Then, paste the snippet into the ```<dependencies>``` XML element. Now the library can be referenced within the project.